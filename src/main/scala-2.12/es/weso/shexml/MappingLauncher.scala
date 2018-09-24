package es.weso.shexml

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import es.weso.antlr.{ShExMLLexer, ShExMLParser}
import es.weso.ast.{AST, VarResult, Variable}
import es.weso.parser.ASTCreatorVisitor
import es.weso.visitor.{RDFGeneratorVisitor, SetBuilderVisitor, VarTableBuilderVisitor}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.apache.jena.rdf.model.{Model, ModelFactory}

import scala.collection.mutable

/**
  * Created by herminio on 15/2/18.
  */
class MappingLauncher {

  def launchMapping(mappingCode: String, lang: String): String = {
    val model = launchMapping(mappingCode)
    val outputStream = new ByteArrayOutputStream()
    model.write(outputStream, lang)
    outputStream.toString
  }

  def launchMapping(mappingCode: String): Model = {
    val lexer = createLexer(mappingCode)
    val parser = createParser(lexer)
    val ast = createAST(parser)
    val varTable = createVarTable(ast)
    generateSetExpressions(ast, varTable)
    generateResultingRDF(ast, varTable)
  }

  private def createLexer(mappingCode: String): ShExMLLexer = {
    new ShExMLLexer(CharStreams.fromString(mappingCode))
  }

  private def createParser(lexer: ShExMLLexer): ShExMLParser = {
    new ShExMLParser(new CommonTokenStream(lexer))
  }

  private def createAST(parser: ShExMLParser): AST = {
    new ASTCreatorVisitor().visitShExML(parser.shExML())
  }

  private def createVarTable(ast: AST): mutable.HashMap[Variable, VarResult] = {
    val varTable = mutable.HashMap[Variable, VarResult]()
    new VarTableBuilderVisitor(varTable).visit(ast)
    varTable
  }

  private def generateSetExpressions(ast: AST, varTable: mutable.HashMap[Variable, VarResult]) = {
    new SetBuilderVisitor(varTable).visit(ast, null)
  }

  private def generateResultingRDF(ast: AST, varTable: mutable.HashMap[Variable, VarResult]): Model = {
    val output = ModelFactory.createDefaultModel()
    new RDFGeneratorVisitor(output, varTable).visit(ast, null)
    //val in = new ByteArrayInputStream(output.toString().getBytes)
    //val model = ModelFactory.createDefaultModel()
    //model.read(in, null, "TURTLE")
    output
  }

}
