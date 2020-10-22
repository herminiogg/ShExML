package es.weso.shexml.visitor

import es.weso.shexml.ast.{JsonPath, QueryClause, SqlQuery, URL, Var, VarResult, Variable, XmlPath}
import es.weso.shexml.helper.SourceHelper

import scala.collection.mutable

class QuerySearcher(val varTable: mutable.HashMap[Variable, VarResult]) {

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
    val parts = u.url.split('.')
    val extension = parts(parts.length - 1)
    val fileContent = new SourceHelper().getURLContent(u.url)
    if(extension == "xpath") {
      XmlPath(fileContent)
    } else if(extension == "jsonpath") {
      JsonPath(fileContent)
    } else if(extension == "sql") {
      SqlQuery(fileContent)
    } else throw new Exception("File extension " + extension + " is not supported for queries")
  }

}
