package com.herminiogarcia.shexml

import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import com.herminiogarcia.shexml.antlr.{ShExMLLexer, ShExMLParser}
import com.herminiogarcia.shexml.ast._
import com.herminiogarcia.shexml.helper.{OrphanBNodeRemover, ParallelExecutionConfigurator, SourceHelper}
import com.herminiogarcia.shexml.parser.ASTCreatorVisitor
import com.herminiogarcia.shexml.shex._
import com.herminiogarcia.shexml.visitor.{PushedOrPoppedValueSearchVisitor, RDFGeneratorVisitor, RMLGeneratorVisitor, VarTableBuilderVisitor}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.apache.jena.query.{Dataset, DatasetFactory}
import org.apache.jena.riot.{RDFDataMgr, RDFFormat, RDFLanguages}
import com.typesafe.scalalogging.Logger
import java.io.{ByteArrayInputStream, ByteArrayOutputStream}
import scala.collection.JavaConverters._
import java.util.concurrent.ConcurrentLinkedQueue
import scala.collection.mutable

/**
  * Created by herminio on 15/2/18.
  */
class MappingLauncher(val username: String = "", val password: String = "", drivers: String = "",
                      val inferenceDatatype: Boolean = false,
                      val normaliseURIs: Boolean = false,
                      val parallelCollectionConfigurator: ParallelExecutionConfigurator = new ParallelExecutionConfigurator(Map(), None)) {

  private val logger = Logger[MappingLauncher]

  def launchMapping(mappingCode: String, lang: String): String = {
    val startTime = System.currentTimeMillis()
    val dataset = launchMapping(mappingCode)
    val endTime = System.currentTimeMillis()
    logger.info(s"Execution time: ${endTime - startTime}ms")
    logger.info(s"Converting output to $lang")
    val outputStream = new ByteArrayOutputStream()
    val langValue = RDFLanguages.nameToLang(lang)
    if(RDFLanguages.isQuads(langValue))
      RDFDataMgr.write(outputStream, dataset, langValue)
    else RDFDataMgr.write(outputStream, dataset.getDefaultModel, langValue)

    outputStream.toString
  }

  def launchMapping(mappingCode: String): Dataset = {
    logger.info(s"Launching mapping")
    logger.debug(s"Mapping rules $mappingCode")
    val lexer = createLexer(mappingCode)
    val parser = createParser(lexer)
    val ast = createAST(parser)
    val varTable = createVarTable(ast)
    generateResultingRDF(ast, varTable)
  }

  def launchMappingFromJsonData(mappingCode: String, data: JsonNode): Dataset = {
    logger.info(s"Launching mapping with data")
    logger.debug(s"Mapping rules $mappingCode")
    val lexer = createLexer(mappingCode)
    val parser = createParser(lexer)
    val ast = createAST(parser)
    val varTable = createVarTable(ast)
    try {
      val bytes = new ObjectMapper().writeValueAsBytes(data)
      logger.trace(s"Data: ${data.toString}")
      val inputBytes = new ByteArrayInputStream(bytes)
      System.setIn(inputBytes)
      generateResultingRDF(ast, varTable)
    } finally {
      System.setIn(System.in)
    }
  }

  def launchRMLTranslation(mappingCode: String, prettify: Boolean = false): String = {
    logger.info(s"Launching ShExML to RML translation with prettify option to $prettify")
    logger.debug(s"Mapping rules $mappingCode")
    val lexer = createLexer(mappingCode)
    val parser = createParser(lexer)
    val ast = createAST(parser)
    val varTable = createVarTable(ast)
    val dataset = generateResultingRML(ast, varTable, prettify)
    val outputStream = new ByteArrayOutputStream()
    if(prettify) new OrphanBNodeRemover().removeOrphanBNodes(dataset.getDefaultModel)
    RDFDataMgr.write(outputStream, dataset.getDefaultModel, RDFFormat.TURTLE_PRETTY)
    outputStream.toString
  }

  def launchShExGeneration(mappingCode: String): String = {
    logger.info(s"Launching ShEx generation from mapping rules")
    logger.debug(s"Mapping rules $mappingCode")
    val lexer = createLexer(mappingCode)
    val parser = createParser(lexer)
    val ast = createAST(parser)
    val varTable = createVarTable(ast)
    val inferencesTable = new ConcurrentLinkedQueue[ShExMLInferredCardinalitiesAndDatatypes]()
    generateInferencesFromShExML(ast, varTable, inferencesTable)
    val shex = new ShExGeneratorVisitor(inferencesTable.asScala.toList).doVisit(ast, null)
    new ShExPrinter().print(shex)
  }

  def launchShapeMapGeneration(mappingCode: String): String = {
    logger.info(s"Launching Shape Map generation from mapping rules")
    logger.debug(s"Mapping rules $mappingCode")
    val lexer = createLexer(mappingCode)
    val parser = createParser(lexer)
    val ast = createAST(parser)
    val varTable = createVarTable(ast)
    val shapeMaps = generateShapeMaps(ast, varTable)
    new ShapeMapPrinter().print(shapeMaps)
  }

  def launchSHACLGeneration(mappingCode: String, closed: Boolean = false): String = {
    logger.info(s"Launching SHACL generation from mapping rules")
    logger.debug(s"Mapping rules $mappingCode")
    val lexer = createLexer(mappingCode)
    val parser = createParser(lexer)
    val ast = createAST(parser)
    val varTable = createVarTable(ast)
    val inferencesTable = new ConcurrentLinkedQueue[ShExMLInferredCardinalitiesAndDatatypes]()
    generateInferencesFromShExML(ast, varTable, inferencesTable)
    logger.info(s"Executing ShEx extraction process as base for the SHACL conversion")
    val shex = new ShExGeneratorVisitor(inferencesTable.asScala.toList).doVisit(ast, null)
    val dataset = DatasetFactory.create()
    new SHACLGenerator(dataset, closed).generate(shex)
    val outputStream = new ByteArrayOutputStream()
    dataset.getDefaultModel.write(outputStream, "TURTLE")
    outputStream.toString
  }

  def precompile(mappingCode: String): String = {
    logger.info(s"Launching precompilation of mapping rules")
    logger.debug(s"Mapping rules $mappingCode")
    val precompiledMappingRules = resolveImports(mappingCode)
    logger.debug(s"Precompiled mapping rules $precompiledMappingRules")
    try {
      val lexer = createLexer(mappingCode)
      val parser = createParser(lexer)
      val ast = createAST(parser)
      precompiledMappingRules
    } catch {
      case e: Exception =>
        logger.error("Error while parsing the mapping rules, check the syntax of your input!", e)
        precompiledMappingRules
    }
  }

  private def createLexer(mappingCode: String): ShExMLLexer = {
    val finalMappingRules = resolveImports(mappingCode)
    logger.info("Applying lexer to tokenize input mapping rules")
    new ShExMLLexer(CharStreams.fromString(finalMappingRules))
  }

  private def createParser(lexer: ShExMLLexer): ShExMLParser = {
    logger.info("Parsing tokens from the lexer")
    new ShExMLParser(new CommonTokenStream(lexer))
  }

  private def createAST(parser: ShExMLParser): AST = {
    logger.info("Creating the AST for the input mapping rules")
    new ASTCreatorVisitor().visitShExML(parser.shExML())
  }

  private def createVarTable(ast: AST): mutable.HashMap[Variable, VarResult] = {
    logger.info(s"Building var table")
    val varTable = mutable.HashMap[Variable, VarResult]()
    varTable += ((Var("rdf:"), URL("http://www.w3.org/1999/02/22-rdf-syntax-ns#")))
    val optionalArgument = Map("variable" -> "", "query" -> "")
    new VarTableBuilderVisitor(varTable).visit(ast, optionalArgument)
    logger.debug(s"Var table contents:")
    varTable.foreach {case (v, vr) => logger.debug(s"$v -> $vr")}
    varTable
  }

  private def generateResultingRDF(ast: AST, varTable: mutable.HashMap[Variable, VarResult]): Dataset = {

    val dataset = DatasetFactory.create()
    val pushedOrPoppedFields = searchForPushedOrPoppedFields(ast)
    new RDFGeneratorVisitor(dataset, varTable.toMap, username, password, generateDriversMap(),
      pushedOrPoppedFieldsPresent = pushedOrPoppedFields,
      inferenceDatatype = inferenceDatatype,
      normaliseURIs = normaliseURIs,
      parallelCollectionConfigurator = parallelCollectionConfigurator).doVisit(ast, null)
    //val in = new ByteArrayInputStream(output.toString().getBytes)
    //val model = ModelFactory.createDefaultModel()
    //model.read(in, null, "TURTLE")
    dataset
  }

  private def generateResultingRML(ast: AST, varTable: mutable.HashMap[Variable, VarResult], prettify: Boolean): Dataset = {
    val output = DatasetFactory.create()
    new RMLGeneratorVisitor(output, varTable.toMap, prettify, username, password).doVisit(ast, null)
    output
  }

  private def generateInferencesFromShExML(ast: AST, varTable: mutable.HashMap[Variable, VarResult],
                                           inferences: ConcurrentLinkedQueue[ShExMLInferredCardinalitiesAndDatatypes]): Unit = {
    logger.info("Executing RDF Generator to get more accurate inferences")
    val dataset = DatasetFactory.create()
    new RDFGeneratorVisitor(dataset, varTable.toMap, username, password, generateDriversMap(), Some(inferences),
      pushedOrPoppedFieldsPresent = searchForPushedOrPoppedFields(ast),
      inferenceDatatype = inferenceDatatype,
      normaliseURIs = normaliseURIs,
      parallelCollectionConfigurator = parallelCollectionConfigurator).doVisit(ast, null)
  }

  private def generateShapeMaps(ast: AST, varTable: mutable.HashMap[Variable, VarResult]): List[ShapeMapInference] = {
    val shapeMapTable = new ConcurrentLinkedQueue[ShapeMapInference]()
    val inferences = new ConcurrentLinkedQueue[ShExMLInferredCardinalitiesAndDatatypes]()
    val dataset = DatasetFactory.create()
    logger.info("Executing RDF Generator to get more accurate inferences")
    new RDFGeneratorVisitor(dataset, varTable.toMap, username, password, generateDriversMap(), Some(inferences), Some(shapeMapTable),
      pushedOrPoppedFieldsPresent = searchForPushedOrPoppedFields(ast),
      inferenceDatatype = inferenceDatatype,
      normaliseURIs = normaliseURIs,
      parallelCollectionConfigurator = parallelCollectionConfigurator).doVisit(ast, null)
    shapeMapTable.asScala.toList
  }

  private def generateDriversMap(): Map[String, String] = {
    drivers.split(";").flatMap(d => {
      val driverTuple = d.split("%")
      if(driverTuple.size > 1) List(driverTuple(0) -> driverTuple(1))
      else Nil
    }).toMap
  }

  private def searchForPushedOrPoppedFields(ast: AST): Boolean = new PushedOrPoppedValueSearchVisitor().doVisit(ast, null)

  private def resolveImports(mappingRules: String): String = {
    val sourceHelper = new SourceHelper()
    val regex = "[Ii][Mm][Pp][Oo][Rr][Tt]\\s*<(.+)>".r
    regex.replaceAllIn(mappingRules, matchedPart => {
      val importSource = matchedPart.group(1)
      val loadedSource =
        if(importSource.contains("://")) sourceHelper.getURLContent(importSource)
        else sourceHelper.getContentFromRelativePath(importSource)
      java.util.regex.Matcher.quoteReplacement(loadedSource.fileContent)
    })
  }

}
