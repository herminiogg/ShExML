package com.herminiogarcia.shexml

import org.apache.jena.rdf.model.Model
import org.scalatest.ConfigMap
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class TwoNestedIteratorWithoutFieldInBetween extends AnyFunSuite
  with Matchers with RDFStatementCreator
  with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE file <https://raw.githubusercontent.com/herminiogg/ShExML/bug-%23173/src/test/resources/pushedValueWithMultipleEntities.json>
      |ITERATOR it <jsonpath: $> {
      |    ITERATOR nested <nestedEntities[*]> {
      |        FIELD name <name>
      |    }
      |}
      |EXPRESSION exp <file.it>
      |
      |:Test :[exp.nested.name] {
      |    :type :Test ;
      |}
    """.stripMargin

  private var output: Model = _
  private val prefix = "http://example.com/"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    output = mappingLauncher.launchMapping(example).getDefaultModel
  }

  test("Shape 1 is translated correctly") {
    assert(output.contains(createStatement(prefix, "one", "type", "Test")))
  }

  test("Shape 2 is translated correctly") {
    assert(output.contains(createStatement(prefix, "two", "type", "Test")))
  }

  test("Shape 3 is translated correctly") {
    assert(output.contains(createStatement(prefix, "three", "type", "Test")))
  }

  test("No additional triples are generated") {
    val triplesCount = 3
    assert(output.size() == triplesCount)
  }

}
