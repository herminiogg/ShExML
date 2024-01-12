package com.herminiogarcia.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.ResourceFactory
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class FilmsWithNullsTest extends AnyFunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE films_xml_file <https://raw.githubusercontent.com/herminiogg/ShExML/bug-%23107/src/test/resources/filmsWithNulls.xml>
      |SOURCE films_json_file <https://raw.githubusercontent.com/herminiogg/ShExML/bug-%23107/src/test/resources/filmsWithNulls.json>
      |SOURCE films_csv_file <https://raw.githubusercontent.com/herminiogg/ShExML/bug-%23107/src/test/resources/filmsWithNulls.csv>
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

  private val mappingLauncher = new MappingLauncher(inferenceDatatype = true, normaliseURIs = true)
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://example.com/"

  test("Shape 1 is translated correctly") {
    assert(output.contains(createStatement(prefix, "1", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "name", "Dunkirk", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "year", "null", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 2 is translated correctly") {
    assert(output.contains(createStatement(prefix, "2", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "name", "Interstellar", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "year", "2014", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "country", "null", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 3 is translated correctly") {
    assert(output.contains(createStatement(prefix, "3", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "name", "Inception", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 4 is translated correctly") {
    assert(output.contains(createStatement(prefix, "4", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "name", "The Prestige", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "year", "2006", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 5 is translated correctly") {
    assert(output.contains(createStatement(prefix, "4", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "5", "name", "Memento", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "5", "year", "null", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "5", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "5", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 6 is translated correctly") {
    assert(output.contains(createStatement(prefix, "4", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "6", "name", "Insomnia", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "6", "year", "2002", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "6", "country", "null", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "6", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Null values are not generated from JSON") {
    assert(output.listResourcesWithProperty(ResourceFactory.createProperty(prefix, "year")).toList.size() == 5)
    assert(output.listResourcesWithProperty(ResourceFactory.createProperty(prefix, "country")).toList.size() == 5)
  }

  test("No additional triples are generated") {
    val triplesCount = 30
    assert(output.size() == triplesCount)
  }

}
