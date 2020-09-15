package es.weso.shexml

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import es.weso.antlr.{ShExMLLexer, ShExMLParser}
import es.weso.ast._
import es.weso.parser.ASTCreatorVisitor
import es.weso.visitor.{RDFGeneratorVisitor, RMLGeneratorVisitor, VarTableBuilderVisitor}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.apache.jena.query.{Dataset, DatasetFactory}
import org.apache.jena.rdf.model.{Model, ModelFactory}
import org.apache.jena.riot.{Lang, RDFDataMgr, RDFLanguages}

import collection.JavaConverters._
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

}
