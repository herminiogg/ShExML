package com.herminiogarcia.shexml.datatype

import com.herminiogarcia.shexml.{ParallelConfigInferenceDatatypesNormaliseURIsFixture, RDFStatementCreator}
import org.apache.jena.datatypes.TypeMapper
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.Model
import org.scalatest.ConfigMap
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

/**
  * Created by herminio on 21/2/18.
  */
class DataTypeGenerationWithoutPrefixNoXSD extends AnyFunSuite
  with Matchers with RDFStatementCreator
  with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

  private val example =
    """
      PREFIX ex: <http://example.com/>
      |PREFIX exPerson: <http://example.com/person/>
      |PREFIX schema: <http://schema.org/>
      |SOURCE input <src/test/resources/datatypes/inputWithoutPrefixAndXSD.json>
      |ITERATOR persons <jsonpath: $.persons[*]> {
      |    FIELD firstname <firstname>
      |    FIELD lastname <lastname>
      |    FIELD lang <lang>
      |    FIELD num <num>
      |    FIELD dt <dt>
      |}
      |
      |EXPRESSION person <input.persons>
      |
      |ex:Person ex:[person.firstname] {
      |    ex:num [person.num] schema:[person.dt] ;
      |}
    """.stripMargin

  private var output: Model = _
  private val prefix = "http://example.com/"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    output = mappingLauncher.launchMapping(example).getDefaultModel
  }

  test("Numbers and datatypes translated correctly") {
    val schemaNumberDataType = TypeMapper.getInstance().getSafeTypeByName("http://schema.org/Number")
    assert(output.contains(createStatementWithLiteral(prefix, "Jane", "num", "3.14", schemaNumberDataType)))
    assert(output.contains(createStatementWithLiteral(prefix, "John", "num", "3", schemaNumberDataType)))
  }

  test("No additional triples are generated") {
    val triplesCount = 2
    assert(output.size() == triplesCount)
  }

}
