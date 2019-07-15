package es.weso.visitor
import es.weso.ast._
import org.apache.jena.rdf.model.{Model, Statement}

import scala.collection.mutable

class RMLGeneratorVisitor(output: Model, varTable: mutable.HashMap[Variable, VarResult]) extends RDFGeneratorVisitor(output, varTable) {

  private val mapPrefix = "http://mapping.example.com/"
  private val rmlPrefix = "http://semweb.mmlab.be/ns/rml#"
  private val qlPrefix = "http://semweb.mmlab.be/ns/ql#"
  private val rrPrefix = "http://www.w3.org/ns/r2rml#"
  private val rdfPrefix = "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
  private val subjectIndex = (1 to Int.MaxValue).iterator
  private val predicateIndex = (1 to Int.MaxValue).iterator
  private val objectIndex = (1 to Int.MaxValue).iterator
  private val predicateObjectIndex = (1 to Int.MaxValue).iterator
  private val mappingIndex = (1 to Int.MaxValue).iterator
  private val joinIndex = (1 to Int.MaxValue).iterator

  override def doVisit(ast: AST, optionalArgument: Any): Any = ast match {

    case Shape(shapeName, shapePrefix, action, predicateObjects) => {
      output.setNsPrefix("map", mapPrefix)
      output.setNsPrefix("rml", rmlPrefix)
      output.setNsPrefix("ql", qlPrefix)
      output.setNsPrefix("rr", rrPrefix)
      val actionTriples = doVisit(action, Map("rmlType" -> "subject", "prefix" -> shapePrefix)).asInstanceOf[List[RMLMap]].filter(_.logicalSource.nonEmpty)
      val predicateObjectTriples = predicateObjects.map(po => doVisit(po, optionalArgument).asInstanceOf[List[RMLMap]])
      actionTriples.map(at => {
        val sourceID = at.logicalSource.head.getSubject.getURI
        val source = at.logicalSource(1).getObject.asLiteral().getString
        val filteredPredicateObjects = predicateObjectTriples.flatMap(pot =>
          pot.filter(rm => rm.logicalSource.isEmpty || rm.logicalSource.head.getSubject.getURI == sourceID || rm.logicalSource(1).getObject.asLiteral.getString == source))
        filteredPredicateObjects.foreach(rm => {
          output.add(rm.logicalSource.toArray)
          output.add(rm.objectMap.toArray)
          output.add(rm.predicateMap.toArray)
          output.add(rm.predicateObjectMap.toArray)
          output.add(at.objectMap.toArray)
        })
        output.add(at.logicalSource.toArray)
        val mapID = mapPrefix + "m_" + mappingIndex.next
        output.add(createStatement(mapID, rdfPrefix + "type", rmlPrefix + "TriplesMap"))
        output.add(createStatement(mapID, rmlPrefix + "logicalSource", at.logicalSource.head.getSubject.getURI))
        output.add(createStatement(mapID, rrPrefix + "subjectMap", at.objectMap.head.getSubject.getURI))
        filteredPredicateObjects.foreach(_.predicateObjectMap.foreach(s => {
          val subject = s.getSubject.getURI
          output.add(createStatement(mapID, rrPrefix + "predicateObjectMap", subject))
        }))
        (mapID, RMLMap(at.logicalSource, Nil, Nil, Nil))
      })
    }

    case IteratorQuery(firstVar, composedVar) => {
      val receivedArguments = if(optionalArgument != null) optionalArgument.asInstanceOf[Map[String, Any]] else Map[String, Any]()
      val arguments = if(receivedArguments.isDefinedAt("rmlType")) receivedArguments else receivedArguments.+("rmlType" -> "object")
      varTable(firstVar) match {
        case u: Union => doVisit(u, arguments + ("composedVar" -> composedVar))
        case i: IteratorQuery => List(doVisit(i, arguments + ("composedVar" -> composedVar)))
        case source: URL => {
          val iterator = composedVar match {
            case IteratorQuery(iteratorVar, _) =>
              if(varTable.get(iteratorVar).isDefined) transformNestedIterator(varTable(iteratorVar).asInstanceOf[QueryClause], iteratorVar)
              else return RMLMap(Nil, Nil, Nil, Nil)
            case v: Var => transformNestedIterator(varTable(v).asInstanceOf[QueryClause], v)
          }
          val logicalSourceName = mapPrefix + composedVar.hashCode.abs
          val referenceFormulation = iterator match {
            case JsonPath(_) => "JSONPath"
            case XmlPath(_) => "XPath"
          }
          val logicalSource = List(
            createStatement(logicalSourceName, rdfPrefix + "type", rmlPrefix + "LogicalSource"),
            createStatementWithLiteral(logicalSourceName, rmlPrefix + "source", source.url),
            createStatementWithLiteral(logicalSourceName, rmlPrefix + "iterator", iterator.query),
            createStatement(logicalSourceName, rmlPrefix + "referenceFormulation", qlPrefix + referenceFormulation)
          )
          val fieldQuery = composedVar match {
            case v: Var => varTable(v) match {
              case f: FieldQuery => f
              case _ => arguments("composedVar") match {
                case cv: Var => varTable(Var(v.name + "." + cv.name)).asInstanceOf[FieldQuery]
                case i: IteratorQuery =>
                  return doVisit(IteratorQuery(firstVar, IteratorQuery(Var(composedVar.asInstanceOf[Var].name + "." + i.firstVar.name), i.composedVar)), optionalArgument)
                  /*getNestedIteratorFieldQuery(i, Var(v.name + "." + i.firstVar.name), iterator) match {
                  case Some(value) => value
                  case None => return RMLMap(Nil, Nil, Nil, Nil)
                } */
                  //return doVisit(IteratorQuery(Var(v.name + "." + localFirstVar.name), localComposedVar), optionalArgument)
              }

            }
            case i: IteratorQuery => getFieldQuery(i, i.firstVar).orNull
          }
          if(arguments("rmlType").asInstanceOf[String] != "subject" && fieldQuery != null) {
            val objectMapID = mapPrefix + "o_" + objectIndex.next
            if(arguments.isDefinedAt("prefix")) {
              val prefix = prefixTable(arguments("prefix").asInstanceOf[String])
              val objectMap = List(
                createStatement(objectMapID, rdfPrefix + "type", rrPrefix + "ObjectMap"),
                createStatementWithLiteral(objectMapID, rrPrefix + "template", prefix + "{" + fieldQuery.query + "}"),
                createStatement(objectMapID, rrPrefix + "termType", rrPrefix + "IRI")
              )
              RMLMap(logicalSource, objectMap, Nil, Nil)
            } else {
              val objectMap = List(
                createStatement(objectMapID, rdfPrefix + "type", rrPrefix + "ObjectMap"),
                createStatementWithLiteral(objectMapID, rrPrefix + "template", "{" + fieldQuery.query + "}"),
                createStatement(objectMapID, rrPrefix + "termType", rrPrefix + "Literal")
              )
              RMLMap(logicalSource, objectMap, Nil, Nil)
            }
          } else if(fieldQuery != null) {
            val subjectMapID = mapPrefix + "s_" + subjectIndex.next
            val prefix = arguments.get("prefix").map(_.asInstanceOf[String]).map(prefixTable(_)).getOrElse("http://example.com")
            val subjectMap = List(
              createStatement(subjectMapID, rdfPrefix + "type", rrPrefix + "SubjectMap"),
              createStatementWithLiteral(subjectMapID, rrPrefix + "template", prefix + "{" + fieldQuery.query + "}")
            )
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
      val leftTemplate = leftMap.objectMap(1).getObject.asLiteral().getString
      val rightTemplate = rightMap.objectMap(1).getObject.asLiteral().getString
      val leftDiff = leftTemplate.split('{')(1).dropRight(1)
      val rightDiff = rightTemplate.split('{')(1).dropRight(1)
      val intersection = leftTemplate.intersect(rightTemplate).split('{')(0)
      val newTemplate =
        intersection + "{" + leftDiff + "}" + unionString + "{" + rightDiff + "}"
      val newStatement = createStatementWithLiteral(leftMap.objectMap(1).getSubject.getURI, leftMap.objectMap(1).getPredicate.getURI, newTemplate)
      val objectMap = leftMap.objectMap.updated(1, newStatement)
      List(
        RMLMap(leftMap.logicalSource, objectMap, leftMap.predicateObjectMap, leftMap.predicateMap),
        RMLMap(rightMap.logicalSource, objectMap, rightMap.predicateObjectMap, rightMap.predicateMap)
      )
    }

    case Join(left, right, join) => {
      val leftMap = doVisit(left, optionalArgument).asInstanceOf[RMLMap]
      val rightMap = doVisit(right, optionalArgument).asInstanceOf[RMLMap]
      val joinMap = doVisit(join, optionalArgument).asInstanceOf[RMLMap]
      val mappingID = mapPrefix + "m_" + mappingIndex.next
      val subjectID = mapPrefix + "s_" + subjectIndex.next
      val mapping = List(
        createStatement(mappingID, rdfPrefix + "type", rmlPrefix + "TriplesMap"),
        createStatement(mappingID, rmlPrefix + "logicalSource", leftMap.logicalSource.head.getSubject.getURI),
        createStatement(mappingID, rrPrefix + "subjectMap", subjectID)
      )
      val subject = List(
        createStatement(subjectID, rdfPrefix + "type", rrPrefix + "SubjectMap"),
        createStatementWithLiteral(subjectID, rrPrefix + "template", leftMap.objectMap(1).getObject.asLiteral().getString)
      )
      output.add(mapping.toArray)
      output.add(subject.toArray)
      output.add(leftMap.logicalSource.toArray)
      val joinID = mapPrefix + "j_" + joinIndex.next
      val joinMapping = List(
        createStatementWithLiteral(joinID, rrPrefix + "parent",
          joinMap.objectMap(1).getObject.asLiteral().getString.split('{')(1).replace('}', ' ').trim),
        createStatementWithLiteral(joinID, rrPrefix + "child",
          rightMap.objectMap(1).getObject.asLiteral().getString.split('{')(1).replace('}', ' ').trim)
      )
      output.add(joinMapping.toArray)
      val objectID = mapPrefix + "o_" + objectIndex.next
      val objectMap = List(
        createStatement(objectID, rdfPrefix + "type", rrPrefix + "ObjectMap"),
        createStatement(objectID, rrPrefix + "parentTriplesMap", mappingID),
        createStatement(objectID, rrPrefix + "joinCondition", joinID)
      )
      val objectLeftID = mapPrefix + "o_" + objectIndex.next
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
      val predicateStatements = doVisit(predicate, optionalArgument).asInstanceOf[List[Statement]]
      objectMap.map(om => {
        val objectStatements = om.objectMap
        val logicalSource = om.logicalSource
        val predicateID = predicateStatements.head.getSubject.getLocalName
        if(objectStatements.isEmpty) None
        else {
          val objectID = objectStatements.head.getSubject.getLocalName
          val predicateObjectID = mapPrefix + "po_" + predicateObjectIndex.next
          val predicateObjectStatements = List(
            createStatement(predicateObjectID, rdfPrefix + "type", rrPrefix + "PredicateObjectMap"),
            createStatement(predicateObjectID, rrPrefix + "predicateMap", mapPrefix + predicateID),
            createStatement(predicateObjectID, rrPrefix + "objectMap", mapPrefix + objectID)
          )
          Some(RMLMap(logicalSource, objectStatements, predicateStatements, predicateObjectStatements))
        }
      }).filter(_.isDefined).map {case Some(v) => v}
    }

    case Predicate(prefix, extension) => {
      val predicateID = mapPrefix + "p_" + predicateIndex.next
      List(
        createStatement(predicateID, rdfPrefix + "type", rrPrefix + "predicateMap"),
        createStatement(predicateID, rrPrefix + "constant", prefixTable(prefix) + extension)
      )
    }

    case ObjectElement(prefix, action, matcher) => {
      val arguments = if(optionalArgument != null) optionalArgument.asInstanceOf[Map[String, Any]] else Map[String, Any]()
      val finalArguments = if(prefix.nonEmpty) arguments.+("prefix" -> prefix) else arguments
      doVisit(action, finalArguments)
    }

    case LiteralObject(prefix, value) => {
      val fullPrefix = prefixTable(prefix.name)
      val objectMapID = mapPrefix + "o_" + objectIndex.next
      val objectMap = List(
        createStatement(objectMapID, rdfPrefix + "type", rrPrefix + "ObjectMap"),
        createStatementWithLiteral(objectMapID, rrPrefix + "template", fullPrefix + value),
        createStatement(objectMapID, rrPrefix + "termType", rrPrefix + "Constant")
      )
      List(RMLMap(Nil, objectMap, Nil, Nil))
    }

    case sv: ShapeVar => {
      val shapeResult = doVisit(varTable(sv), optionalArgument).asInstanceOf[List[Tuple2[String, RMLMap]]]
      shapeResult.map(sr => {
        val objectMapID = mapPrefix + "o_" + objectIndex.next
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
    case FieldQuery(query) => varTable(Var(v.name.split('.').head)) match {
      case JsonPath(jsonQuery) => JsonPath(jsonQuery + "." + query)
      case XmlPath(xpathQuery) => XmlPath(xpathQuery + "/" + query)
    }
    case j: JsonPath => j
    case x: XmlPath => x
  }

  private def getNestedIteratorFieldQuery(iteratorQuery: IteratorQuery, precedentVar: Var, iteratorQueryClause: QueryClause): Option[FieldQuery] = {
    iteratorQuery.composedVar match {
      case i: IteratorQuery => {
        val accIteratorQueryClause = iteratorQueryClause match {
          case JsonPath(_) => JsonPath(varTable(Var(precedentVar.name + "." + i.firstVar.name)).asInstanceOf[QueryClause].query + ".")
          case XmlPath(_) => XmlPath(varTable(Var(precedentVar.name + "." + i.firstVar.name)).asInstanceOf[QueryClause].query + "/")
        }
        getNestedIteratorFieldQuery(i, Var(precedentVar.name + "." + i.firstVar.name), accIteratorQueryClause)
      }
      case v: Var => varTable.get(Var(precedentVar.name + "." + v.name)) match {
        case Some(value) => value match {
          case fq: FieldQuery => iteratorQueryClause match {
            case JsonPath(_) => Some(FieldQuery(varTable(precedentVar).asInstanceOf[QueryClause].query + "." + fq.query))
            case XmlPath(_) => Some(FieldQuery(varTable(precedentVar).asInstanceOf[QueryClause].query + "/" + fq.query))
          }
          case _ => None
        }
        case None => None
      }
    }
  }

}

case class RMLMap(logicalSource: List[Statement], objectMap: List[Statement],
                  predicateMap: List[Statement], predicateObjectMap: List[Statement])
