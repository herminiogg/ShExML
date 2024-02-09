package com.herminiogarcia.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class PushedValueWithMultipleEntities extends AnyFunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE file <https://raw.githubusercontent.com/herminiogg/ShExML/bug-%23173/src/test/resources/pushedValueWithMultipleEntities.json>
      |ITERATOR it <jsonpath: $> {
      |    PUSHED_FIELD id <identifier>
      |    ITERATOR nested <nestedEntities[*]> {
      |        FIELD name <name>
      |        POPPED_FIELD parent <id>
      |    }
      |}
      |EXPRESSION exp <file.it>
      |
      |:Test :[exp.nested.name] {
      |    :under :[exp.nested.parent] ;
      |}
    """.stripMargin

  private val mappingLauncher = new MappingLauncher(inferenceDatatype = true, normaliseURIs = true)
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://example.com/"

  test("Shape 1 is translated correctly") {
    assert(output.contains(createStatement(prefix, "one", "under", "1")))
  }

  test("Shape 2 is translated correctly") {
    assert(output.contains(createStatement(prefix, "two", "under", "1")))
  }

  test("Shape 3 is translated correctly") {
    assert(output.contains(createStatement(prefix, "three", "under", "1")))
  }

  test("No additional triples are generated") {
    val triplesCount = 3
    assert(output.size() == triplesCount)
  }

}
