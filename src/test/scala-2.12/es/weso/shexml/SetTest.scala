package es.weso.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.{FunSuite, Matchers}

class SetTest extends FunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |SOURCE films_xml <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.xml>
      |SOURCE films_json <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.json>
      |QUERY_SET films_queries_xml <//film/, @id, name, year, country, directors/director>
      |QUERY_SET films_queries_json <$.films[*]., id, name, year, country, director>
      |EXPRESSION_SET film(ids, names, years, countries, directors) <$films_xml.films_queries_xml UNION $films_json.films_queries_json>
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

  test("Film shape 1 is translated correctly using query sets and expression sets") {
    assert(output.contains(createStatementWithLiteral(prefix, "1", "name", "Dunkirk", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "year", "2017", XSDDatatype.XSDinteger)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Film shape 2 is translated correctly using query sets and expression sets") {
    assert(output.contains(createStatementWithLiteral(prefix, "2", "name", "Interstellar", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "year", "2014", XSDDatatype.XSDinteger)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

  test("Film shape 3 is translated correctly using query sets and expression sets") {
    assert(output.contains(createStatementWithLiteral(prefix, "3", "name", "Inception", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "year", "2010", XSDDatatype.XSDinteger)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Film shape 4 is translated correctly using query sets and expression sets") {
    assert(output.contains(createStatementWithLiteral(prefix, "4", "name", "The Prestige", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "year", "2006", XSDDatatype.XSDinteger)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

}
