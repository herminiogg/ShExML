package es.weso.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.{FunSuite, Matchers}

class GraphMultipleElementIteratorExpressionTest extends FunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE films_xml_file <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.xml>
      |SOURCE films_json_file <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.json>
      |AUTOINCREMENT my_code <1 to 20 by 2>
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
      |EXPRESSION films <films_xml_file.film_xml UNION films_json_file.film_json>
      |
      |:MyFilms [[
      |    :Films :[films.id] {
      |       :type :Film ;
      |       :internalId :[my_code] ;
      |       :name [films.name] ;
      |       :year [films.year] xs:gYear ;
      |       :country [films.country] ;
      |       :director [films.directors] ;
      |     }
      |]]
      |
      |:Films :[films.id] {
      |    :type :Film ;
      |    :internalId :[my_code] ;
      |    :name [films.name] ;
      |    :year [films.year] xs:gYear ;
      |    :country [films.country] ;
      |    :director [films.directors] ;
      |}
    """.stripMargin

  private val prefix = "http://example.com/"
  private val mappingLauncher = new MappingLauncher()
  private val dataset = mappingLauncher.launchMapping(example)
  private val output = dataset.getDefaultModel
  private val myFilmsGraph = dataset.getNamedModel(prefix + "MyFilms")

  test("Shape 1 is translated correctly") {
    assert(output.contains(createStatement(prefix, "1", "type", "Film")))
    assert(output.contains(createStatement(prefix, "1", "internalId", "9")))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "name", "Dunkirk", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "year", "2017", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 1 is translated correctly inside graph :MyFilms") {
    assert(myFilmsGraph.contains(createStatement(prefix, "1", "type", "Film")))
    assert(myFilmsGraph.contains(createStatement(prefix, "1", "internalId", "1")))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "1", "name", "Dunkirk", XSDDatatype.XSDstring)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "1", "year", "2017", XSDDatatype.XSDgYear)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "1", "country", "USA", XSDDatatype.XSDstring)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "1", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 2 is translated correctly") {
    assert(output.contains(createStatement(prefix, "2", "type", "Film")))
    assert(output.contains(createStatement(prefix, "2", "internalId", "11")))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "name", "Interstellar", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "year", "2014", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 2 is translated correctly inside graph :MyFilms") {
    assert(myFilmsGraph.contains(createStatement(prefix, "2", "type", "Film")))
    assert(myFilmsGraph.contains(createStatement(prefix, "2", "internalId", "3")))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "2", "name", "Interstellar", XSDDatatype.XSDstring)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "2", "year", "2014", XSDDatatype.XSDgYear)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "2", "country", "USA", XSDDatatype.XSDstring)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "2", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "2", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 3 is translated correctly") {
    assert(output.contains(createStatement(prefix, "3", "type", "Film")))
    assert(output.contains(createStatement(prefix, "3", "internalId", "13")))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "name", "Inception", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "year", "2010", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 3 is translated correctly inside graph :MyFilms") {
    assert(myFilmsGraph.contains(createStatement(prefix, "3", "type", "Film")))
    assert(myFilmsGraph.contains(createStatement(prefix, "3", "internalId", "5")))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "3", "name", "Inception", XSDDatatype.XSDstring)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "3", "year", "2010", XSDDatatype.XSDgYear)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "3", "country", "USA", XSDDatatype.XSDstring)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "3", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 4 is translated correctly") {
    assert(output.contains(createStatement(prefix, "4", "type", "Film")))
    assert(output.contains(createStatement(prefix, "4", "internalId", "15")))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "name", "The Prestige", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "year", "2006", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 4 is translated correctly inside graph :MyFilms") {
    assert(myFilmsGraph.contains(createStatement(prefix, "4", "type", "Film")))
    assert(myFilmsGraph.contains(createStatement(prefix, "4", "internalId", "7")))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "4", "name", "The Prestige", XSDDatatype.XSDstring)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "4", "year", "2006", XSDDatatype.XSDgYear)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "4", "country", "USA", XSDDatatype.XSDstring)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "4", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(myFilmsGraph.contains(createStatementWithLiteral(prefix, "4", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

}
