package com.herminiogarcia.shexml.runtimeErrors

import com.herminiogarcia.shexml.ParallelConfigInferenceDatatypesNormaliseURIsFixture
import com.herminiogarcia.shexml.helper.XPathQueryError
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class XPathQueryErrorTest extends AnyFunSuite
  with Matchers with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

  private val example =
    """
      PREFIX : <http://example.com/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |SOURCE films_xml_file <https://shexml.herminiogarcia.com/files/films.xml>
      |SOURCE films_json_file <https://shexml.herminiogarcia.com/files/films.json>
      |ITERATOR film_xml <xpath: //film> {
      |    FIELD id <@id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <crew/directors/director>
      |    FIELD screenwritters <crew//screenwritter>
      |    FIELD music <crew/music>
      |    FIELD photography <crew/photography>
      |    ITERATOR actors <cast/*> {
      |        FIELD name <name>
      |        FIELD role <role>
      |        FIELD film <../../@id>
      |    }
      |}
      |ITERATOR film_json <jsonpath: $.films[*]> {
      |    FIELD id <id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <crew.director>
      |    FIELD screenwritters <crew.screenwritter>
      |    FIELD music <crew.music>
      |    FIELD photography <crew.cinematography>
      |    ITERATOR actors <cast[*]> {
      |        FIELD name <name>
      |        FIELD role <role>
      |    }
      |}
      |EXPRESSION films <films_xml_file.film_xml UNION films_json_file.film_json>
      |
      |:Films :[films.id] {
      |    :name [films.name] ;
      |    :year [films.year] ;
      |    :country [films.country] ;
      |    :director [films.directors] ;
      |    :actor @:Actor ;
      |}
      |
      |:Actor :[films.actors.name] {
      |    :name [films.actors.name] ;
      |    :appear_on :[films.actors.film] ;
      |}
    """.stripMargin

  test("Invalid XPath query is detected and reported by the XPath engine") {
    val error = intercept[XPathQueryError] {
      mappingLauncher.launchMapping(example)
    }
    assert(error.message.startsWith("Error while executing the composed XPath query"))
    assert(error.message.contains("//film[1]/cast/1[*]/role"))
    assert(error.getEnrichedErrorMessage(example).contains(
      """
        |7: ITERATOR film_xml <xpath: [1m[4m//film> {[22m[24m
        |8: [1m[4m    FIELD id <@id>[22m[24m
        |9: [1m[4m    FIELD name <name>[22m[24m
        |10: [1m[4m    FIELD year <year>[22m[24m
        |11: [1m[4m    FIELD country <country>[22m[24m
        |12: [1m[4m    FIELD directors <crew/directors/director>[22m[24m
        |13: [1m[4m    FIELD screenwritters <crew//screenwritter>[22m[24m
        |14: [1m[4m    FIELD music <crew/music>[22m[24m
        |15: [1m[4m    FIELD photography <crew/photography>[22m[24m
        |16: [1m[4m    ITERATOR actors <cast/*> {[22m[24m
        |17: [1m[4m        FIELD name <name>[22m[24m
        |18: [1m[4m        FIELD role <role[22m[24m>
        |""".stripMargin))
  }

}
