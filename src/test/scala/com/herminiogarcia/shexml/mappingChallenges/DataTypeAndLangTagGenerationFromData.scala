package com.herminiogarcia.shexml.mappingChallenges

import com.herminiogarcia.shexml.{MappingLauncher, RDFStatementCreator}
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

/**
  * Created by herminio on 21/2/18.
  */
class DataTypeAndLangTagGenerationFromData extends AnyFunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX exPerson: <http://example.com/person/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE people <https://raw.githubusercontent.com/herminiogg/mapping-challenges/main/challenges/language-map/input-1/input.json>
      |ITERATOR person_iterator <jsonpath: $.persons[*]> {
      |    FIELD firstname <firstname>
      |    FIELD lastname <lastname>
      |    FIELD lang <lang>
      |    FIELD num <num>
      |    FIELD dt <dt>
      |}
      |
      |EXPRESSION values <people.person_iterator>
      |
      |:Person :[values.firstname] {
      |    :lastname [values.lastname] @[values.lang] ;
      |    :num [values.num] [values.dt] ;
      |}
    """.stripMargin
  private val mappingLauncher = new MappingLauncher()
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://example.com/"

  test("Numbers and datatypes translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "Jane", "num", "3.14", XSDDatatype.XSDdecimal)))
    assert(output.contains(createStatementWithLiteral(prefix, "John", "num", "3", XSDDatatype.XSDinteger)))
  }

  test("Lang tags translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "Jane", "lastname", "Smith", "fr")))
    assert(output.contains(createStatementWithLiteral(prefix, "John", "lastname", "Doe", "en")))
  }

  test("No additional triples are generated") {
    val triplesCount = 4
    assert(output.size() == triplesCount)
  }

}
