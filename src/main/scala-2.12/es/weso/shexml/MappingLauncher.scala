package es.weso.shexml

import java.io.ByteArrayOutputStream

import es.weso.shexml.antlr.{ShExMLLexer, ShExMLParser}
import es.weso.shexml.ast._
import es.weso.shexml.parser.ASTCreatorVisitor
import es.weso.shexml.shex.{ShExGeneratorVisitor, ShExMLInferredCardinalitiesAndDatatypes, ShExPrinter}
import es.weso.shexml.visitor.{RDFGeneratorVisitor, RMLGeneratorVisitor, VarTableBuilderVisitor}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.apache.jena.query.{Dataset, DatasetFactory}
import org.apache.jena.riot.{RDFDataMgr, RDFLanguages}

import scala.collection.mutable

/**
  * Created by herminio on 15/2/18.
  */
class MappingLauncher(val username: String = "", val password: String = "") {

  def launchMapping(mappingCode: String, lang: String): String = {
    org.apache.jena.query.ARQ.init()
    val dataset = launchMapping(mappingCode)
    val outputStream = new ByteArrayOutputStream()
    val langValue = RDFLanguages.nameToLang(lang)
    if(RDFLanguages.isQuads(langValue))
      RDFDataMgr.write(outputStream, dataset, langValue)
    else RDFDataMgr.write(outputStream, dataset.getDefaultModel, langValue)
    outputStream.toString
  }

  def launchMapping(mappingCode: String): Dataset = {
    val lexer = createLexer(mappingCode)
    val parser = createParser(lexer)
    val ast = createAST(parser)
    val varTable = createVarTable(ast)
    generateResultingRDF(ast, varTable)
  }

  def launchRMLTranslation(mappingCode: String): String = {
    val lexer = createLexer(mappingCode)
    val parser = createParser(lexer)
    val ast = createAST(parser)
    val varTable = createVarTable(ast)
    val dataset = generateResultingRML(ast, varTable)
    val outputStream = new ByteArrayOutputStream()
    dataset.getDefaultModel.write(outputStream, "TURTLE")
    outputStream.toString
  }

  def launchShExGeneration(mappingCode: String): String = {
    val lexer = createLexer(mappingCode)
    val parser = createParser(lexer)
    val ast = createAST(parser)
    val varTable = createVarTable(ast)
    val inferencesTable = mutable.ListBuffer.empty[ShExMLInferredCardinalitiesAndDatatypes]
    generateInferencesFromShExML(ast, varTable, inferencesTable)
    val shex = new ShExGeneratorVisitor(inferencesTable.toList).doVisit(ast, null)
    new ShExPrinter().print(shex)
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
    varTable += ((Var("rdf:"), URL("http://www.w3.org/1999/02/22-rdf-syntax-ns#")))
    val optionalArgument = Map("variable" -> "", "query" -> "")
    new VarTableBuilderVisitor(varTable).visit(ast, optionalArgument)
    varTable
  }

  private def generateResultingRDF(ast: AST, varTable: mutable.HashMap[Variable, VarResult]): Dataset = {
    val dataset = DatasetFactory.create()
    new RDFGeneratorVisitor(dataset, varTable, username, password).doVisit(ast, null)
    //val in = new ByteArrayInputStream(output.toString().getBytes)
    //val model = ModelFactory.createDefaultModel()
    //model.read(in, null, "TURTLE")
    dataset
  }

  private def generateResultingRML(ast: AST, varTable: mutable.HashMap[Variable, VarResult]): Dataset = {
    val output = DatasetFactory.create()
    new RMLGeneratorVisitor(output, varTable, username, password).visit(ast, null)
    output
  }

  private def generateInferencesFromShExML(ast: AST, varTable: mutable.HashMap[Variable, VarResult],
                                           inferences: mutable.ListBuffer[ShExMLInferredCardinalitiesAndDatatypes]): Unit = {
    val dataset = DatasetFactory.create()
    new RDFGeneratorVisitor(dataset, varTable, username, password, inferences).doVisit(ast, null)
  }

}
