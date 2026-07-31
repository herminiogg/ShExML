package com.herminiogarcia.shexml.runtimeErrors

import com.herminiogarcia.shexml.ParallelConfigInferenceDatatypesNormaliseURIsFixture
import com.herminiogarcia.shexml.helper.SPARQLExtractionError
import org.apache.jena.query.QueryParseException
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class SparqlFieldErrorTest extends AnyFunSuite
  with Matchers with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |QUERY query_film <https://raw.githubusercontent.com/herminiogg/ShExML/enhancement-%23240/src/test/resources/filmDbpediaQuery.sparql>
      |SOURCE films_database <https://raw.githubusercontent.com/herminiogg/ShExML/enhancement-%23240/src/test/resources/films.nt>
      |ITERATOR films_iterator <query_film> {
      |    FIELD id <item>
      |    FIELD name <name>
      |    FIELD director <directorX>
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

  test("Invalid field for extraction of SPARQL query results is detected and reported by the engine") {
    val error = intercept[SPARQLExtractionError] {
      mappingLauncher.launchMapping(example)
    }
    assert(error.message == "Field directorX is not present in the SPARQL result set")
    assert(error.getEnrichedErrorMessage(example).contains("11:     [1m[4mFIELD director <directorX[22m[24m>"))
  }

}
