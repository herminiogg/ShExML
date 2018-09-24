package es.weso.visitor
import es.weso.ast._

import scala.collection.mutable

class SetBuilderVisitor(val variableMap: mutable.HashMap[Variable, VarResult]) extends DefaultVisitor[List[Var], List[AST]] {

  val queriesMap: mutable.HashMap[Variable, List[QueryClause]] = mutable.HashMap[Variable, List[QueryClause]]()

  override def doVisit(ast: AST, optionalArgument: List[Var]): List[AST] = ast match {
    case ExpressionSet(name, variables, exp) => {
      val finalVariables = variables.variables.map(name.name + "_" + _).map(Var)
      val expressions = doVisit(exp, finalVariables)
      expressions.asInstanceOf[List[Exp]].zip(finalVariables).map({
        case (expression, varName) => {
          variableMap += ((varName, expression))
          expression
        }
      })
    }

    case _: Expression => doVisitDefault()

    case _: Query => doVisitDefault()

    case QuerySet(name, queryClauses) => {
      queriesMap += ((name, queryClauses))
      queryClauses
    }

    case Union(left, right) => {
      val lefts = doVisit(left, optionalArgument)
      val rights = doVisit(right, optionalArgument)
      lefts.zip(rights).map({
        case (l, r) => Union(l.asInstanceOf[SourceQuery], r.asInstanceOf[SourceQuery])
      })
    }

    //continue with other expressions, i.e., join, string operation, etc.

    case SourceQuery(fileVar, expressionVar) => {
      queriesMap(expressionVar).map(queryClause => {
        val varName = Var(queryClause.hashCode().toString)
        variableMap += ((varName, queryClause))
        SourceQuery(fileVar, varName)
      })
    }

    case default => visit(default, optionalArgument)

  }

  override def doVisitDefault(): List[AST] = Nil

}
