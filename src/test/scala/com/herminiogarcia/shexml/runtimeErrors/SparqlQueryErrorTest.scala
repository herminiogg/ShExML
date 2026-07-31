package com.herminiogarcia.shexml.runtimeErrors

import com.herminiogarcia.shexml.ParallelConfigInferenceDatatypesNormaliseURIsFixture
import org.apache.jena.query.QueryParseException
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class SparqlQueryErrorTest extends AnyFunSuite
  with Matchers with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |QUERY query_film <https://raw.githubusercontent.com/herminiogg/ShExML/enhancement-%23240/src/test/resources/invalidFilmDbpediaQuery.sparql>
      |SOURCE films_database <https://raw.githubusercontent.com/herminiogg/ShExML/enhancement-%23240/src/test/resources/films.nt>
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

  test("Invalid SPARQL query is detected and reported by the SPARQL engine") {
    intercept[QueryParseException] {
      mappingLauncher.launchMapping(example)
    }
  }

}
