package com.herminiogarcia.shexml.runtimeErrors

import com.herminiogarcia.shexml.ParallelConfigInferenceDatatypesNormaliseURIsFixture
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers
import org.sqlite.SQLiteException

import java.sql.SQLException

class SqlQueryErrorTest extends AnyFunSuite
  with Matchers with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE films_db_connection <jdbc:sqlite:src/test/resources/films.sqlite>
      |ITERATOR film_db <sql: SELECT * FORM films;> {
      |    FIELD id <id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <director>
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

  test("Invalid SQL query is detected and reported by the SQL engine") {
    intercept[SQLiteException] {
      mappingLauncher.launchMapping(example)
    }
  }

}
