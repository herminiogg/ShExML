package es.weso.shexml.datatype

import es.weso.shexml.{MappingLauncher, RDFStatementCreator}
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by herminio on 21/2/18.
  */
class DataTypeGenerationWithoutPrefix extends FunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      PREFIX ex: <http://example.com/>
      |PREFIX exPerson: <http://example.com/person/>
      |PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE input <https://raw.githubusercontent.com/herminiogg/mapping-challenges/main/challenges/datatype-map/input-2/input.json>
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
      |    ex:num [person.num] xsd:[person.dt] ;
      |}
    """.stripMargin
  private val mappingLauncher = new MappingLauncher()
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://example.com/"

  test("Numbers and datatypes translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "Jane", "num", "3.14", XSDDatatype.XSDdecimal)))
    assert(output.contains(createStatementWithLiteral(prefix, "John", "num", "3", XSDDatatype.XSDinteger)))
  }

  test("No additional triples are generated") {
    val triplesCount = 2
    assert(output.size() == triplesCount)
  }

}
