package com.herminiogarcia.shexml.runtimeErrors

import com.herminiogarcia.shexml.ParallelConfigInferenceDatatypesNormaliseURIsFixture
import com.herminiogarcia.shexml.helper.CSVExtractionError
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class CsvQueryErrorTest extends AnyFunSuite
  with Matchers with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE films_csv_file <src/test/resources/films.csv>
      |ITERATOR film_csv <csvPerRow> {
      |    FIELD id <id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <directorX>
      |}
      |EXPRESSION films <films_csv_file.film_csv>
      |
      |:Films :[films.id] {
      |    :type :Film ;
      |    :name [films.name] @en ;
      |    :year [films.year] xs:gYear ;
      |    :country [films.country] ;
      |    :director [films.directors] ;
      |}
    """.stripMargin

  test("Invalid column name in a CSV query is detected and reported by the CSV engine") {
    val error = intercept[CSVExtractionError] {
      mappingLauncher.launchMapping(example)
    }
    assert(error.message == "Field directorX not present in CSV file")
    assert(error.getEnrichedErrorMessage(example).contains("10:     [1m[4mFIELD directors <directorX[22m[24m>"))
  }

}
