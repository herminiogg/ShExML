package com.herminiogarcia.shexml.visitor

import com.herminiogarcia.shexml.ast._
import com.typesafe.scalalogging.Logger
import org.apache.jena.query.Dataset
import org.apache.jena.rdf.model.{AnonId, Resource, ResourceFactory, Statement}

import scala.collection.mutable

class RMLGeneratorVisitor(dataset: Dataset, varTable: mutable.HashMap[Variable, VarResult], prettify: Boolean ,username: String, password: String)
  extends RDFGeneratorVisitor(dataset, varTable, username, password) with JdbcDriverRegistry {

  private val mapPrefix = "http://mapping.example.com/"
  private val rmlPrefix = "http://semweb.mmlab.be/ns/rml#"
  private val qlPrefix = "http://semweb.mmlab.be/ns/ql#"
  private val rrPrefix = "http://www.w3.org/ns/r2rml#"
  private val rdfPrefix = "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
  private val d2rqPrefix = "http://www.wiwiss.fu-berlin.de/suhl/bizer/D2RQ/0.1#"
  private val subjectIndex = (1 to Int.MaxValue).iterator
  private val predicateIndex = (1 to Int.MaxValue).iterator
  private val objectIndex = (1 to Int.MaxValue).iterator
  private val predicateObjectIndex = (1 to Int.MaxValue).iterator
  private val mappingIndex = (1 to Int.MaxValue).iterator
  private val joinIndex = (1 to Int.MaxValue).iterator
  private val mapGraphIndex = (1 to Int.MaxValue).iterator
  private val dbIndex = (1 to Int.MaxValue).iterator
  private val languageMapIndex = (1 to Int.MaxValue).iterator
  private val bNodeCount = (1 to Int.MaxValue).iterator //allows not sharing bnodes and getting a better pretty print

  private def mapPrefixOrBNode = if(prettify) "_:b_" + bNodeCount.next() + "_" else mapPrefix

  val output = dataset.getDefaultModel

  private val logger = Logger[RMLGeneratorVisitor]

  override def doVisit(ast: AST, optionalArgument: Any): Any = ast match {

    case Shape(shapeName, action, predicateObjects, holdingGraph) => {
      logger.info(s"Converting shape ${shapeName.name} with ${predicateObjects.size} predicate-object statements under the graph " +
        s"${holdingGraph.map(g => g.graphName.prefix + g.graphName.name).getOrElse("default")}")
      val shapePrefix = getShapePrefix(action)
      output.setNsPrefix("map", mapPrefix)
      output.setNsPrefix("rml", rmlPrefix)
      output.setNsPrefix("ql", qlPrefix)
      output.setNsPrefix("rr", rrPrefix)
      output.setNsPrefix("d2rq", d2rqPrefix)
      val arguments = if(holdingGraph.isEmpty)
        Map("rmlType" -> "subject", "prefix" -> shapePrefix)
      else Map("rmlType" -> "subject", "prefix" -> shapePrefix, "graph" -> holdingGraph.get)
      val actionTriples = doVisit(action, arguments).asInstanceOf[List[RMLMap]]
      val predicateObjectTriples = predicateObjects.map(po => doVisit(po, optionalArgument).asInstanceOf[List[RMLMap]])
      actionTriples.map(at => {
        val filteredPredicateObjects = action match {
          case _: LiteralSubject => predicateObjectTriples.flatten
          case _: Action => {
            val sourceID = getURIOrBNode(at.logicalSource.head.getSubject)
            val source = at.logicalSource(1).getObject.asLiteral().getString
            predicateObjectTriples.flatMap(pot =>
              pot.filter(rm => rm.logicalSource.isEmpty || getURIOrBNode(rm.logicalSource.head.getSubject) == sourceID || rm.logicalSource(1).getObject.asLiteral.getString == source))
          }
        }
        filteredPredicateObjects.foreach(rm => {
          output.add(rm.logicalSource.toArray)
          output.add(rm.objectMap.toArray)
          output.add(rm.predicateMap.toArray)
          output.add(rm.predicateObjectMap.toArray)
          output.add(at.objectMap.toArray)
        })
        output.add(at.logicalSource.toArray)
        val mapID = mapPrefix + "m_" + mappingIndex.next
        output.add(createStatement(mapID, rdfPrefix + "type", rrPrefix + "TriplesMap"))
        if(at.logicalSource.isEmpty) {
          filteredPredicateObjects.foreach(fpo => {
            output.add(createStatement(mapID, rmlPrefix + "logicalSource", getURIOrBNode(fpo.logicalSource.head.getSubject)))
          })
        } else {
          output.add(createStatement(mapID, rmlPrefix + "logicalSource", getURIOrBNode(at.logicalSource.head.getSubject)))
        }
        output.add(createStatement(mapID, rrPrefix + "subjectMap", getURIOrBNode(at.objectMap.head.getSubject)))
        filteredPredicateObjects.foreach(_.predicateObjectMap.foreach(s => {
          val subject = getURIOrBNode(s.getSubject)
          output.add(createStatement(mapID, rrPrefix + "predicateObjectMap", subject))
        }))
        (mapID, RMLMap(at.logicalSource, Nil, Nil, Nil))
      })
    }

    case Action(shapePrefix: String, action: ExpOrVar, _) => {
      doVisit(action, optionalArgument).asInstanceOf[List[RMLMap]].filter(_.logicalSource.nonEmpty)
    }

    case IteratorQuery(firstVar, composedVar) => {
      val receivedArguments = if(optionalArgument != null) optionalArgument.asInstanceOf[Map[String, Any]] else Map[String, Any]()
      val arguments = if(receivedArguments.isDefinedAt("rmlType")) receivedArguments else receivedArguments.+("rmlType" -> "object")
      varTable(firstVar) match {
        case u: Union => doVisit(u, arguments + ("composedVar" -> composedVar))
        case i: IteratorQuery => List(doVisit(i, arguments + ("composedVar" -> composedVar)))
        case source: IRI => {
          val iterator = composedVar match {
            case IteratorQuery(iteratorVar, _) =>
              if(varTable.get(iteratorVar).isDefined && iteratorVar.name.contains(".")) {
                val query = transformNestedIterator(getQueryFromVarTable(iteratorVar), iteratorVar)
                val rootQuery = getQueryFromVarTable(Var(iteratorVar.name.splitAt(iteratorVar.name.lastIndexOf("."))._1))
                mergeQueries(rootQuery, query)
              } else if(varTable.get(iteratorVar).isDefined)
                transformNestedIterator(getQueryFromVarTable(iteratorVar), iteratorVar)
              else return RMLMap(Nil, Nil, Nil, Nil)
            case v: Var => transformNestedIterator(getQueryFromVarTable(v), v)
          }
          val logicalSourceName = mapPrefixOrBNode + "l_" + (source.toString + iterator.query).hashCode.abs
          val logicalSource = iterator match {
            case SqlQuery(query) => {
              val dbSubjectID = mapPrefixOrBNode + "db_" + dbIndex.next()
              val datasource = List(
                createStatementWithLiteral(dbSubjectID, rdfPrefix + "type", d2rqPrefix + "Database"),
                createStatementWithLiteral(dbSubjectID, d2rqPrefix + "jdbcDriver", lookForJdbcDriver(source.asInstanceOf[JdbcURL].url)),
                createStatementWithLiteral(dbSubjectID, d2rqPrefix + "jdbcDSN", source.asInstanceOf[JdbcURL].url),
                createStatementWithLiteral(dbSubjectID, d2rqPrefix + "username", username),
                createStatementWithLiteral(dbSubjectID, d2rqPrefix + "password", password)
                // user and password to be inputted here
              )
              val logicalSource = List(
                createStatement(logicalSourceName, rdfPrefix + "type", rmlPrefix + "LogicalSource"),
                createStatementWithLiteral(logicalSourceName, rmlPrefix + "query", query),
                createStatement(logicalSourceName, rmlPrefix + "source", dbSubjectID),
                createStatement(logicalSourceName, rmlPrefix + "referenceFormulation", qlPrefix + "CSV"),
                createStatement(logicalSourceName, rrPrefix + "sqlVersion", rrPrefix + "SQL2008")
              )
              logicalSource ::: datasource
            }
            case _ => {
              val referenceFormulation = iterator match {
                case JsonPath(_) => "JSONPath"
                case XmlPath(_) => "XPath"
                case CSVPerRow(_) => "CSV"
              }
              val iteratorStatement = if(iterator.isInstanceOf[JsonPath] | iterator.isInstanceOf[XmlPath])
                List(createStatementWithLiteral(logicalSourceName, rmlPrefix + "iterator", iterator.query))
              else Nil
              List(
                createStatement(logicalSourceName, rdfPrefix + "type", rmlPrefix + "LogicalSource"),
                createStatementWithLiteral(logicalSourceName, rmlPrefix + "source", source.asInstanceOf[URL].url),
                createStatement(logicalSourceName, rmlPrefix + "referenceFormulation", qlPrefix + referenceFormulation)
              ) ::: iteratorStatement
            }
          }

          val fieldQuery = composedVar match {
            case v: Var => varTable(v) match {
              case f: FieldQuery => f
              case _ => arguments("composedVar") match {
                case cv: Var => varTable(Var(v.name + "." + cv.name)).asInstanceOf[FieldQuery]
                case i: IteratorQuery =>
                  return doVisit(IteratorQuery(firstVar, IteratorQuery(Var(composedVar.asInstanceOf[Var].name + "." + i.firstVar.name), i.composedVar)), optionalArgument)
              }

            }
            case i: IteratorQuery => getFieldQuery(i, i.firstVar).orNull
          }
          if(arguments("rmlType").asInstanceOf[String] != "subject" && fieldQuery != null) {
            val objectMapID = mapPrefixOrBNode + "o_" + objectIndex.next
            if(arguments.isDefinedAt("prefix")) {
              val prefix = if(arguments("prefix") == "_:") arguments("prefix")
                else prefixTable(arguments("prefix").asInstanceOf[String])
              val termType = if(prefix == "_:")
                List(createStatement(objectMapID, rrPrefix + "termType", rrPrefix + "BlankNode"),
                  createStatementWithLiteral(objectMapID, rrPrefix + "template", s"$prefix{" + fieldQuery.query + "}"))
                else List(createStatement(objectMapID, rrPrefix + "termType", rrPrefix + "IRI"),
                  createStatementWithLiteral(objectMapID, rrPrefix + "template", s"$prefix{" + fieldQuery.query + "}"))
              val objectMap = List(
                createStatement(objectMapID, rdfPrefix + "type", rrPrefix + "ObjectMap")
              ) ::: termType
              RMLMap(logicalSource, objectMap, Nil, Nil)
            } else {
              val datatypePrefix = arguments.get("dataType").map({
                case dt: DataTypeLiteral => prefixTable(dt.value.split(":")(0) + ":")
                case _: DataTypeGeneration => throw new Exception("DataType generation from data not supported in RML")
              })
              val datatype = arguments.get("dataType").map({
                case dt: DataTypeLiteral => dt.value.split(":")(1)
                case _: DataTypeGeneration => throw new Exception("DataType generation from data not supported in RML")
              })
              val datatypeURI = datatypePrefix.map(_ + datatype.get)
              val langTagStatement = arguments.get("langTag").map({
                case lt: LangTagLiteral => List(createStatementWithLiteral(objectMapID, rrPrefix + "language", lt.value))
                case ltg: LangTagGeneration => {
                  val statements = doVisit(ltg.action, null).asInstanceOf[List[RMLMap]]
                  val reference = statements.find(_.objectMap.exists(_.getPredicate.getLocalName == "template"))
                    .flatMap(_.objectMap.find(_.getPredicate.getLocalName == "template").map(_.getObject.asLiteral().getString))
                    .map(_.replaceAll("[{}]", ""))
                  val languageMapId = mapPrefixOrBNode + languageMapIndex.next()
                  reference match {
                    case Some(value) =>
                      List(
                        createStatement(objectMapID, rmlPrefix + "languageMap", languageMapId),
                        createStatement(languageMapId, rdfPrefix + "type", rmlPrefix + "LanguageMap"),
                        createStatementWithLiteral(languageMapId, rmlPrefix + "reference", value),
                      )
                    case None => List()
                  }
                }
              }).getOrElse(List())
              val datatypeStatement =
                if(datatypeURI.isDefined) List(createStatement(objectMapID, rrPrefix + "datatype", datatypeURI.get))
                else List()
              val objectMap = List(
                createStatement(objectMapID, rdfPrefix + "type", rrPrefix + "ObjectMap"),
                createStatementWithLiteral(objectMapID, rrPrefix + "template", "{" + fieldQuery.query + "}"),
                createStatement(objectMapID, rrPrefix + "termType", rrPrefix + "Literal")
              ) ::: datatypeStatement ::: langTagStatement
              RMLMap(logicalSource, objectMap, Nil, Nil)
            }
          } else if(fieldQuery != null) {
            val subjectMapID = mapPrefixOrBNode + "s_" + subjectIndex.next
            val prefix = arguments.get("prefix").filterNot(_ == "_:").map(_.asInstanceOf[String]).map(prefixTable(_)).getOrElse("_:")
            val holdingGraph = arguments.get("graph").map(_.asInstanceOf[Graph].graphName)
            val bnode = if(arguments.getOrElse("prefix", "").equals("_:"))
              List(createStatement(subjectMapID, rrPrefix + "termType", rrPrefix + "BlankNode"),
                createStatementWithLiteral(subjectMapID, rrPrefix + "template", "{" + fieldQuery.query + "}"))
            else if(holdingGraph.isEmpty)
              List(createStatementWithLiteral(subjectMapID, rrPrefix + "template", prefix + "{" + fieldQuery.query + "}"))
            else {
              val graphMapIndexID = mapPrefixOrBNode + mapGraphIndex.next
              output.add(createStatement(graphMapIndexID, rdfPrefix + "type", rrPrefix + "GraphMap"))
              output.add(createStatement(graphMapIndexID, rrPrefix + "constant", prefixTable(holdingGraph.get.prefix) + holdingGraph.get.name))
              List(
                createStatementWithLiteral(subjectMapID, rrPrefix + "template", prefix + "{" + fieldQuery.query + "}"),
                createStatement(subjectMapID, rrPrefix + "graphMap", graphMapIndexID))
            }
            val subjectMap = List(
              createStatement(subjectMapID, rdfPrefix + "type", rrPrefix + "SubjectMap")
            ) ::: bnode
            RMLMap(logicalSource, subjectMap, Nil, Nil)
          } else RMLMap(Nil, Nil, Nil, Nil)
        }
      }
    }

    case Union(left, right) => {
      val leftMap = doVisit(left, optionalArgument) match {
        case l: List[RMLMap] => l
        case r: RMLMap => List(r)
      }
      val rightMap = doVisit(right, optionalArgument) match {
        case l: List[RMLMap] => l
        case r: RMLMap => List(r)
      }
      leftMap.union(rightMap)
    }

    case StringOperation(left, right, unionString) => {
      val leftMap = doVisit(left, optionalArgument).asInstanceOf[RMLMap]
      val rightMap = doVisit(right, optionalArgument).asInstanceOf[RMLMap]
      val leftTemplate = leftMap.objectMap.filter(s => s.getPredicate.getLocalName == "template").head.getObject.asLiteral().getString
      val rightTemplate = rightMap.objectMap.filter(s => s.getPredicate.getLocalName == "template").head.getObject.asLiteral().getString
      val leftDiff = leftTemplate.split('{')(1).dropRight(1)
      val rightDiff = rightTemplate.split('{')(1).dropRight(1)
      val intersection = leftTemplate.intersect(rightTemplate).split('{')(0)
      val newTemplate =
        intersection + "{" + leftDiff + "}" + unionString + "{" + rightDiff + "}"
      val newStatement = createStatementWithLiteral(
        getURIOrBNode(leftMap.objectMap.filter(s => s.getPredicate.getLocalName == "template").head.getSubject),
        leftMap.objectMap.filter(s => s.getPredicate.getLocalName == "template").head.getPredicate.getURI,
        newTemplate)
      val index = leftMap.objectMap.indexOf(leftMap.objectMap.filter(s => s.getPredicate.getLocalName == "template").head)
      val objectMap = leftMap.objectMap.updated(index, newStatement)
      List(
        RMLMap(leftMap.logicalSource, objectMap, leftMap.predicateObjectMap, leftMap.predicateMap),
        RMLMap(rightMap.logicalSource, objectMap, rightMap.predicateObjectMap, rightMap.predicateMap)
      )
    }

    case Join(left, right, join) => {
      val leftMap = doVisit(left, optionalArgument).asInstanceOf[RMLMap]
      val rightMap = doVisit(right, optionalArgument).asInstanceOf[RMLMap]
      val joinMap = doVisit(join, optionalArgument).asInstanceOf[RMLMap]
      val mappingID = mapPrefixOrBNode + "m_" + mappingIndex.next
      val subjectID = mapPrefixOrBNode + "s_" + subjectIndex.next
      val mapping = List(
        createStatement(mappingID, rdfPrefix + "type", rrPrefix + "TriplesMap"),
        createStatement(mappingID, rmlPrefix + "logicalSource", getURIOrBNode(leftMap.logicalSource.head.getSubject)),
        createStatement(mappingID, rrPrefix + "subjectMap", subjectID)
      )
      val subject = List(
        createStatement(subjectID, rdfPrefix + "type", rrPrefix + "SubjectMap"),
        createStatementWithLiteral(subjectID, rrPrefix + "template",
          leftMap.objectMap.filter(s => s.getPredicate.getLocalName == "template").head.getObject.asLiteral().getString)
      )
      output.add(mapping.toArray)
      output.add(subject.toArray)
      output.add(leftMap.logicalSource.toArray)
      val joinID = mapPrefixOrBNode + "j_" + joinIndex.next
      val joinMapping = List(
        createStatementWithLiteral(joinID, rrPrefix + "parent",
          joinMap.objectMap.filter(s => s.getPredicate.getLocalName == "template").head
            .getObject.asLiteral().getString.split('{')(1).replace('}', ' ').trim),
        createStatementWithLiteral(joinID, rrPrefix + "child",
          rightMap.objectMap.filter(s => s.getPredicate.getLocalName == "template").head
            .getObject.asLiteral().getString.split('{')(1).replace('}', ' ').trim)
      )
      output.add(joinMapping.toArray)
      val objectID = mapPrefixOrBNode + "o_" + objectIndex.next
      val objectMap = List(
        createStatement(objectID, rdfPrefix + "type", rrPrefix + "ObjectMap"),
        createStatement(objectID, rrPrefix + "parentTriplesMap", mappingID),
        createStatement(objectID, rrPrefix + "joinCondition", joinID)
      )
      val objectLeftID = mapPrefixOrBNode + "o_" + objectIndex.next
      val objectLeftMap = List(
        createStatement(objectLeftID, rdfPrefix + "type", rrPrefix + "ObjectMap"),
        createStatement(objectLeftID, rrPrefix + "parentTriplesMap", mappingID)
      )
      List(
        RMLMap(rightMap.logicalSource, objectMap, Nil, Nil),
        RMLMap(leftMap.logicalSource, objectLeftMap, Nil, Nil)
      )
    }

    case PredicateObject(predicate, objectOrShapeLink) => {
      val objectMap = doVisit(objectOrShapeLink, optionalArgument).asInstanceOf[List[RMLMap]]
      objectMap.map(om => {
        val predicateStatements = doVisit(predicate, optionalArgument).asInstanceOf[List[Statement]]
        val objectStatements = om.objectMap
        val logicalSource = om.logicalSource
        val predicateID = getURIOrBNode(predicateStatements.head.getSubject)
        if(objectStatements.isEmpty) None
        else {
          val objectID = getURIOrBNode(objectStatements.head.getSubject)
          val predicateObjectID = mapPrefixOrBNode + "po_" + predicateObjectIndex.next
          val predicateObjectStatements = List(
            createStatement(predicateObjectID, rdfPrefix + "type", rrPrefix + "PredicateObjectMap"),
            createStatement(predicateObjectID, rrPrefix + "predicateMap", predicateID),
            createStatement(predicateObjectID, rrPrefix + "objectMap", objectID)
          )
          Some(RMLMap(logicalSource, objectStatements, predicateStatements, predicateObjectStatements))
        }
      }).filter(_.isDefined).map {case Some(v) => v}
    }

    case Predicate(prefix, extension) => {
      val predicateID = mapPrefixOrBNode + "p_" + predicateIndex.next
      List(
        createStatement(predicateID, rdfPrefix + "type", rrPrefix + "predicateMap"),
        createStatement(predicateID, rrPrefix + "constant", prefixTable(prefix) + extension)
      )
    }

    case ObjectElement(prefix, action, literalValue, matcher, condition, dataType, langTag, rdfCollection) => {
      val arguments = if(optionalArgument != null) optionalArgument.asInstanceOf[Map[String, Any]] else Map[String, Any]()
      val prefixArguments = if(prefix.nonEmpty) arguments.+("prefix" -> prefix) else arguments
      val dataTypeArguments = if(dataType.isDefined) prefixArguments.+("dataType" -> dataType.getOrElse(None)) else prefixArguments
      val finalArguments = if(langTag.isDefined) dataTypeArguments.+("langTag" -> langTag.getOrElse(None)) else dataTypeArguments
      action match {
        case Some(value) => doVisit(value, finalArguments)
        case None => literalValue match {
          case Some(literal) => doVisit(literal, finalArguments)
          case None => throw new Exception("No generation clause given.")
        }
      }
    }

    case LiteralObject(prefix, value) => {
      val fullPrefix = prefixTable(prefix.name)
      val objectMapID = mapPrefixOrBNode + "o_" + objectIndex.next
      val objectMap = List(
        createStatement(objectMapID, rdfPrefix + "type", rrPrefix + "ObjectMap"),
        createStatementWithLiteral(objectMapID, rrPrefix + "template", fullPrefix + value),
        createStatement(objectMapID, rrPrefix + "termType", rrPrefix + "IRI")
      )
      List(RMLMap(Nil, objectMap, Nil, Nil))
    }

    case LiteralSubject(prefix, value) => {
      val fullPrefix = prefixTable(prefix.name)
      val subjectMapID = mapPrefixOrBNode + "s_" + objectIndex.next
      val objectMap = List(
        createStatement(subjectMapID, rdfPrefix + "type", rrPrefix + "SubjectMap"),
        createStatementWithLiteral(subjectMapID, rrPrefix + "template", fullPrefix + value),
        //createStatement(subjectMapID, rrPrefix + "termType", rrPrefix + "IRI")
      )
      List(RMLMap(Nil, objectMap, Nil, Nil))
    }

    case LiteralObjectValue(value) => {
      val arguments = optionalArgument.asInstanceOf[Map[String, Any]]
      val datatypePrefix = arguments.get("dataType").map(d => prefixTable(d.toString.split(":")(0) + ":"))
      val datatype = arguments.get("dataType").map(d => d.toString.split(":")(1))
      val datatypeURI = datatypePrefix.map(_ + datatype.get)
      val langTag = arguments.get("langTag").map(_.asInstanceOf[String])
      val objectMapID = mapPrefixOrBNode + "o_" + objectIndex.next
      val datatypeStatement =
        if(datatype.isDefined) List(createStatement(objectMapID, rrPrefix + "datatype", datatypeURI.get))
        else List()
      val langTagStatement =
        if(langTag.isDefined) List(createStatementWithLiteral(objectMapID, rrPrefix + "language", langTag.get))
        else List()
      val objectMap = List(
        createStatement(objectMapID, rdfPrefix + "type", rrPrefix + "ObjectMap"),
        createStatementWithLiteral(objectMapID, rrPrefix + "template", value),
        createStatement(objectMapID, rrPrefix + "termType", rrPrefix + "Literal")
      ) ::: datatypeStatement ::: langTagStatement
      List(RMLMap(Nil, objectMap, Nil, Nil))
    }

    case sv: ShapeVar => {
      val shapeResult = doVisit(varTable(sv), optionalArgument).asInstanceOf[List[Tuple2[String, RMLMap]]]
      shapeResult.map(sr => {
        val objectMapID = mapPrefixOrBNode + "o_" + objectIndex.next
        val objectMap = List(
          createStatement(objectMapID, rdfPrefix + "type", rrPrefix + "ObjectMap"),
          createStatement(objectMapID, rrPrefix + "parentTriplesMap", sr._1)
        )
        RMLMap(sr._2.logicalSource, objectMap, Nil, Nil)
      })
    }

    case v: Var => doVisit(varTable(v), optionalArgument)

    case default => super.doVisit(default, optionalArgument)

  }

  private def getFieldQuery(iteratorQuery: IteratorQuery, precedentVar: Var): Option[FieldQuery] = {
    iteratorQuery.composedVar match {
      case i: IteratorQuery => getFieldQuery(i, Var(precedentVar.name + "." + i.firstVar.name))
      case v: Var => varTable.get(Var(precedentVar.name + "." + v.name)) match {
        case Some(value) => value match {
          case fq: FieldQuery => Some(fq)
          case _ => None
        }
        case None => None
      }
    }
  }

  private def transformNestedIterator(queryClause: QueryClause, v: Var): QueryClause = queryClause match {
    case FieldQuery(query, _, _) => getQueryFromVarTable(Var(v.name.split('.').head)) match {
      case JsonPath(jsonQuery) => JsonPath(jsonQuery + "." + query)
      case XmlPath(xpathQuery) => XmlPath(xpathQuery + "/" + query)
      case CSVPerRow(_) => CSVPerRow(query)
      case SqlQuery(_) => SqlQuery(query)
    }
    case j: JsonPath => j
    case x: XmlPath => x
    case c: CSVPerRow => c
    case s: SqlQuery => s
  }

  private def mergeQueries(leftQuery: QueryClause, rightQuery: QueryClause): QueryClause = rightQuery match {
    case XmlPath(query) => XmlPath(leftQuery.query + "/" + query)
    case JsonPath(query) => JsonPath(leftQuery.query + "." + query)
  }

  private def getNestedIteratorFieldQuery(iteratorQuery: IteratorQuery, precedentVar: Var, iteratorQueryClause: QueryClause): Option[FieldQuery] = {
    iteratorQuery.composedVar match {
      case i: IteratorQuery => {
        val accIteratorQueryClause = iteratorQueryClause match {
          case JsonPath(_) => JsonPath(getQueryFromVarTable(Var(precedentVar.name + "." + i.firstVar.name)).query + ".")
          case XmlPath(_) => XmlPath(getQueryFromVarTable(Var(precedentVar.name + "." + i.firstVar.name)).query + "/")
        }
        getNestedIteratorFieldQuery(i, Var(precedentVar.name + "." + i.firstVar.name), accIteratorQueryClause)
      }
      case v: Var => varTable.get(Var(precedentVar.name + "." + v.name)) match {
        case Some(value) => value match {
          case fq: FieldQuery => iteratorQueryClause match {
            case JsonPath(_) => Some(FieldQuery(getQueryFromVarTable(precedentVar).query + "." + fq.query))
            case XmlPath(_) => Some(FieldQuery(getQueryFromVarTable(precedentVar).query + "/" + fq.query))
          }
          case _ => None
        }
        case None => None
      }
    }
  }

  private def getQueryFromVarTable(variable: Var): QueryClause = {
    new QuerySearcher(varTable).getQueryFromVarTable(variable)
  }

  private def getURIOrBNode(resource: Resource): String = {
    if(resource.asNode().isBlank) "_:" + resource.asNode().toString
    else resource.getURI
  }

  override protected def createStatement(s: String, p: String, o: String): Statement = {
    if(s.contains("_:")) createBNodeStatement(s.replaceFirst("_:", ""), p, o)
    else super.createStatement(s, p, o)
  }

  override protected def createStatementWithLiteral(s: String, p: String, o: String, dataType: Option[String] = None, langTag: Option[String] = None): Statement = {
    if(s.contains("_:")) createBNodeStatementWithLiteral(s.replaceFirst("_:", ""), p, o, dataType, langTag)
    else super.createStatementWithLiteral(s, p, o, dataType, langTag)
  }

}

case class RMLMap(logicalSource: List[Statement], objectMap: List[Statement],
                  predicateMap: List[Statement], predicateObjectMap: List[Statement])