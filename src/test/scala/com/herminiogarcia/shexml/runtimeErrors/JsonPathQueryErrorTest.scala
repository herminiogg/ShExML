package com.herminiogarcia.shexml.runtimeErrors

import com.herminiogarcia.shexml.ParallelConfigInferenceDatatypesNormaliseURIsFixture
import com.herminiogarcia.shexml.helper.JsonPathQueryError
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class JsonPathQueryErrorTest extends AnyFunSuite
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
      |    ITERATOR actors <cast/actor> {
      |        FIELD name <name>
      |        FIELD role <role>
      |        FIELD film <../../@id>
      |    }
      |    ITERATOR actresses <cast/actress> {
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
      |    FIELD directors <crew.director[]>
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
      |    :actor @:Actress ;
      |}
      |
      |:Actor :[films.actors.name] {
      |    :name [films.actors.name] ;
      |    :appear_on :[films.actors.film] ;
      |}
      |
      |:Actress :[films.actresses.name] {
      |    :name [films.actresses.name] ;
      |    :appear_on :[films.actresses.film] ;
      |}
    """.stripMargin

  test("Invalid JsonPath query is detected and reported by the JsonPath engine") {
    val error = intercept[JsonPathQueryError] {
      mappingLauncher.launchMapping(example)
    }
    assert(error.message.startsWith("Error while executing the composed JsonPath query"))
    assert(error.message.contains("$.films[0].crew.director[]"))
    assert(error.getEnrichedErrorMessage(example).contains(
      """
        |27: ITERATOR film_json <jsonpath: [1m[4m$.films[*]> {[22m[24m
        |28: [1m[4m    FIELD id <id>[22m[24m
        |29: [1m[4m    FIELD name <name>[22m[24m
        |30: [1m[4m    FIELD year <year>[22m[24m
        |31: [1m[4m    FIELD country <country>[22m[24m
        |32: [1m[4m    FIELD directors <crew.director[][22m[24m>
        |""".stripMargin))
  }

}