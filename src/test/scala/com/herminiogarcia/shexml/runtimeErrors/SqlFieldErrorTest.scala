package com.herminiogarcia.shexml.runtimeErrors

import com.herminiogarcia.shexml.ParallelConfigInferenceDatatypesNormaliseURIsFixture
import com.herminiogarcia.shexml.helper.SQLExtractionError
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers
import org.sqlite.SQLiteException

class SqlFieldErrorTest extends AnyFunSuite
  with Matchers with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE films_db_connection <jdbc:sqlite:src/test/resources/films.sqlite>
      |ITERATOR film_db <sql: SELECT * FROM films;> {
      |    FIELD id <id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <directorX>
      |}
      |EXPRESSION films <films_db_connection.film_db>
      |
      |:Films :[films.id] {
      |    :type :Film ;
      |    :name [films.name] @en ;
      |    :year [films.year] xs:gYear ;
      |    :country [films.country] ;
      |    :director [films.directors] ;
      |}
    """.stripMargin

  test("Invalid field for extraction of SQL query results is detected and reported by the engine") {
    val error = intercept[SQLExtractionError] {
      mappingLauncher.launchMapping(example)
    }
    assert(error.message == "Field directorX is not present in the SQL result set")
    assert(error.getEnrichedErrorMessage(example).contains("10:     [1m[4mFIELD directors <directorX[22m[24m>"))
  }

}
