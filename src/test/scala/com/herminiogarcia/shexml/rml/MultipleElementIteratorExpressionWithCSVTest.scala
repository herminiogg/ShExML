package com.herminiogarcia.shexml.rml

import com.herminiogarcia.shexml.{ParallelConfigInferenceDatatypesNormaliseURIsFixture, RDFStatementCreator}
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.Model
import org.scalatest.ConfigMap
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class MultipleElementIteratorExpressionWithCSVTest extends AnyFunSuite
  with Matchers with RDFStatementCreator
  with ParallelConfigInferenceDatatypesNormaliseURIsFixture with RMLTestConversion {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE films_xml_file <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.xml>
      |SOURCE films_json_file <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.json>
      |SOURCE films_csv_file <https://rawgit.com/herminiogg/ShExML/enhancement-%239/src/test/resources/films.csv>
      |ITERATOR film_xml <xpath: //film> {
      |    FIELD id <@id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <directors/director>
      |}
      |ITERATOR film_json <jsonpath: $.films[*]> {
      |    FIELD id <id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <director>
      |}
      |ITERATOR film_csv <csvPerRow> {
      |    FIELD id <id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <director>
      |}
      |EXPRESSION films <films_xml_file.film_xml UNION films_json_file.film_json UNION films_csv_file.film_csv>
      |
      |:Films :[films.id] {
      |    :type :Film ;
      |    :name [films.name] @en ;
      |    :year [films.year] xs:gYear ;
      |    :country [films.country] ;
      |    :director [films.directors] ;
      |}
    """.stripMargin

  private var output: Model = _
  private val prefix = "http://example.com/"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    val result = mappingLauncher.launchRMLTranslation(example)
    output = doTranslation(result, prefix).getDefaultModel
  }

  test("Shape 1 is translated correctly") {
    assert(output.contains(createStatement(prefix, "1", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "name", "Dunkirk", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "year", "2017", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 2 is translated correctly") {
    assert(output.contains(createStatement(prefix, "2", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "name", "Interstellar", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "year", "2014", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 3 is translated correctly") {
    assert(output.contains(createStatement(prefix, "3", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "name", "Inception", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "year", "2010", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 4 is translated correctly") {
    assert(output.contains(createStatement(prefix, "4", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "name", "The Prestige", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "year", "2006", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 5 is translated correctly") {
    assert(output.contains(createStatement(prefix, "4", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "5", "name", "Memento", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "5", "year", "2000", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "5", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "5", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 6 is translated correctly") {
    assert(output.contains(createStatement(prefix, "4", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "6", "name", "Insomnia", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "6", "year", "2002", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "6", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "6", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

}
