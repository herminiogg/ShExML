package com.herminiogarcia.shexml.visitor

import com.herminiogarcia.shexml.ast._
import com.herminiogarcia.shexml.helper.{FileError, QueryError, SourceHelper, VarError}


class QuerySearcher(val varTable: Map[Variable, VarResult]) {

  def getQueryFromVarTable(variable: Var): QueryClause = {
    varTable.get(variable) match {
      case Some(value) => value match {
        case q: QueryClause => q
        case u: URL => getURLContents(u)
        case v: Var => varTable.get(v) match {
          case Some(result) => result match {
            case qv: QueryClause => qv
            case u: URL => getURLContents(u)
            case _ => throw QueryError("Result of variable " + v.name + " not suitable as a query", variable.parserInfo)
          }
          case None => throw VarError("Variable " + v.name + " not defined", variable.parserInfo)
        }

      }
      case None => throw VarError("Variable " + variable.name + " not found", variable.parserInfo)
    }
  }

  private def getURLContents(u: URL): QueryClause = {
    val parts = u.value.split('.')
    val extension = parts(parts.length - 1)
    val file = new SourceHelper().getURLContent(u.value)
    if(extension == "xpath") {
      XmlPath(file.fileContent, u.parserInfo)
    } else if(extension == "jsonpath") {
      JsonPath(file.fileContent, u.parserInfo)
    } else if(extension == "sql") {
      SqlQuery(file.fileContent, u.parserInfo)
    } else if(extension == "sparql") {
      SparqlQuery(file.fileContent, u.parserInfo)
    } else throw FileError("File extension " + extension + " is not supported for queries", u.parserInfo)
  }

}
