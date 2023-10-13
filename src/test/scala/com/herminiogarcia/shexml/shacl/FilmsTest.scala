package com.herminiogarcia.shexml.shacl

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class FilmsTest extends AnyFunSuite with SHACLValidation {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
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
      |    PUSHED_FIELD id <id>
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
      |        POPPED_FIELD film <id>
      |    }
      |}
      |EXPRESSION films <films_xml_file.film_xml UNION films_json_file.film_json>
      |
      |:Films :[films.id] {
      |    schema:name [films.name] @en ;
      |    :year dbr:[films.year] ;
      |    schema:countryOfOrigin dbr:[films.country] ;
      |    schema:director dbr:[films.directors] ;
      |    :screenwritter dbr:[films.screenwritters] ;
      |    schema:musicBy dbr:[films.music] ;
      |    :cinematographer dbr:[films.photography] ;
      |    schema:actor @:Actor ;
      |    schema:actor @:Actress ;
      |}
      |
      |:Actor dbr:[films.actors.name] {
      |    :name [films.actors.name] ;
      |    :appear_on :[films.actors.film] ;
      |}
      |
      |:Actress dbr:[films.actresses.name] {
      |    :name [films.actresses.name] ;
      |    :appear_on :[films.actresses.film] ;
      |}
    """.stripMargin

  test("Films validate against generated schema") {
    assert(this.validate(example))
  }

  test("Films validate against generated schema with closed shapes") {
    assert(this.validate(example, true))
  }

}
