package com.herminiogarcia.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.{FunSuite, Matchers}

class FilmsSparqlTest extends FunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |QUERY query_film <https://raw.githubusercontent.com/herminiogg/ShExML/enhancement-%2349/src/test/resources/filmQuery.sparql>
      |SOURCE films_database <https://query.wikidata.org/sparql>
      |ITERATOR films_iterator <query_film> {
      |    FIELD id <item>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <countryLabel>
      |    FIELD director <directorLabel>
      |}
      |
      |EXPRESSION films <films_database.films_iterator>
      |
      |:Films :[films.id] {
      |    :type :Film ;
      |    :name [films.name] @en ;
      |    :year [films.year] xs:gYear ;
      |    :country [films.country] ;
      |    :director [films.director] ;
      |}
    """.stripMargin

  private val mappingLauncher = new MappingLauncher("root")
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://example.com/"

  test("Entity Q63985561 is translated correctly") {
    assert(output.contains(createStatement(prefix, "Q63985561", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "Q63985561", "name", "Tenet", "en")))
    //assert(output.contains(createStatementWithLiteral(prefix, "8", "year", "2020", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "Q63985561", "country", "United Kingdom", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Q63985561", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Entity Q166262 is translated correctly") {
    assert(output.contains(createStatement(prefix, "Q166262", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "Q166262", "name", "Batman Begins", "en")))
    //assert(output.contains(createStatementWithLiteral(prefix, "9", "year", "2005", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "Q166262", "country", "United States of America", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Q166262", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

}
