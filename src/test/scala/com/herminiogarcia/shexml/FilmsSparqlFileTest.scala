package com.herminiogarcia.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.{FunSuite, Matchers}

class FilmsSparqlFileTest extends FunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |QUERY query_film <https://raw.githubusercontent.com/herminiogg/ShExML/enhancement-%2349/src/test/resources/filmDbpediaQuery.sparql>
      |SOURCE films_database <https://raw.githubusercontent.com/herminiogg/ShExML/enhancement-%2349/src/test/resources/films.nt>
      |ITERATOR films_iterator <query_film> {
      |    FIELD id <item>
      |    FIELD name <name>
      |    FIELD director <director>
      |}
      |
      |EXPRESSION films <films_database.films_iterator>
      |
      |:Films :[films.id] {
      |    :type :Film ;
      |    :name [films.name] ;
      |    :director [films.director] ;
      |}
    """.stripMargin

  private val mappingLauncher = new MappingLauncher("root")
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://example.com/"

  test("Memento__film_ is translated correctly") {
    assert(output.contains(createStatement(prefix, "Memento__film_", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "Memento__film_", "name", "Memento", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Memento__film_", "director", "Christopher_Nolan", XSDDatatype.XSDstring)))
  }

  test("Interstellar__film_ is translated correctly") {
    assert(output.contains(createStatement(prefix, "Interstellar__film_", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "Interstellar__film_", "name", "Interstellar", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Interstellar__film_", "director", "Christopher_Nolan", XSDDatatype.XSDstring)))
  }

  test("No additional triples are generated") {
    val triplesCount = 18
    assert(output.size() == triplesCount)
  }

}
