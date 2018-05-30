package es.weso.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.{FunSuite, Matchers}

class MultipleElementTest extends FunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |SOURCE films_xml <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.xml>
      |SOURCE films_json <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.json>
      |QUERY film_ids_xml <//film/@id>
      |QUERY film_names_xml <//film/name>
      |QUERY film_years_xml <//film/year>
      |QUERY film_countries_xml <//film/country>
      |QUERY film_directors_xml <//film/directors/director>
      |QUERY film_ids_json <$.films[*].id>
      |QUERY film_names_json <$.films[*].name>
      |QUERY film_years_json <$.films[*].year>
      |QUERY film_countries_json <$.films[*].country>
      |QUERY film_directors_json <$.films[*].director>
      |EXPRESSION film_ids <$films_xml.film_ids_xml UNION $films_json.film_ids_json>
      |EXPRESSION film_names <$films_xml.film_names_xml UNION $films_json.film_names_json>
      |EXPRESSION film_years <$films_xml.film_years_xml UNION $films_json.film_years_json>
      |EXPRESSION film_countries <$films_xml.film_countries_xml UNION $films_json.film_countries_json>
      |EXPRESSION film_directors <$films_xml.film_directors_xml UNION $films_json.film_directors_json>
      |
      |:Films :[film_ids] {
      |    :name [film_names] ;
      |    :year [film_years] ;
      |    :country [film_countries] ;
      |    :director [film_directors] ;
      |}
    """.stripMargin

  private val mappingLauncher = new MappingLauncher()
  private val output = mappingLauncher.launchMapping(example)
  private val prefix = "http://example.com/"

  test("Shape 1 is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "1", "name", "Dunkirk", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "year", "2017", XSDDatatype.XSDinteger)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 2 is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "2", "name", "Interstellar", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "year", "2014", XSDDatatype.XSDinteger)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 3 is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "3", "name", "Inception", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "year", "2010", XSDDatatype.XSDinteger)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 4 is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "4", "name", "The Prestige", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "year", "2006", XSDDatatype.XSDinteger)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

}
