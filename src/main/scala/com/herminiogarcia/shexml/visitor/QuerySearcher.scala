package com.herminiogarcia.shexml.visitor

import com.herminiogarcia.shexml.ast._
import com.herminiogarcia.shexml.helper.SourceHelper


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
            case _ => throw new Exception("Result of variable " + v.name + " not suitable as a query")
          }
          case None => throw new Exception("Variable " + v.name + " not defined")
        }

      }
      case None => throw new Exception("Variable " + variable.name + " not found")
    }
  }

  private def getURLContents(u: URL): QueryClause = {
    val parts = u.value.split('.')
    val extension = parts(parts.length - 1)
    val file = new SourceHelper().getURLContent(u.value)
    if(extension == "xpath") {
      XmlPath(file.fileContent)
    } else if(extension == "jsonpath") {
      JsonPath(file.fileContent)
    } else if(extension == "sql") {
      SqlQuery(file.fileContent)
    } else if(extension == "sparql") {
      SparqlQuery(file.fileContent)
    } else throw new Exception("File extension " + extension + " is not supported for queries")
  }

}
