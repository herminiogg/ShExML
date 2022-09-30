package com.herminiogarcia.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.{FunSuite, Matchers}

class ExternalFunctionsTest extends FunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |SOURCE films_xml_file <http://shexml.herminiogarcia.com/files/films.xml>
      |SOURCE films_json_file <http://shexml.herminiogarcia.com/files/films.json>
      |FUNCTIONS helper <scala: https://raw.githubusercontent.com/herminiogg/ShExML/enhancement-%23121/src/test/resources/functions.scala>
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
      |    :name [helper.allCapitals(films.name)] ;
      |    :year [helper.addOne(films.year)] ;
      |    :countryOfOrigin dbr:[films.country] ;
      |    :director dbr:[films.directors] ;
      |    :screenwritter dbr:[films.screenwritters] ;
      |    :screenwritterName [helper.getName(films.screenwritters)] ;
      |    :titleYear [helper.nameAndYear(films.name, films.year)] ;
      |    :musicBy dbr:[films.music] ;
      |    :cinematographer dbr:[films.photography] ;
      |    :actor @:Actor ;
      |    :actor @:Actress ;
      |}
      |
      |:Actor :[films.actors.name] {
      |    :name [helper.getName(films.actors.name)] ;
      |    :surname [helper.getSurname(films.actors.name)] ;
      |    :nameParts [helper.getNameParts(films.actors.name)] ;
      |    :appear_on :[films.actors.film] ;
      |}
      |
      |:Actress :[films.actresses.name] {
      |    :name [helper.getName(films.actresses.name)] ;
      |    :surname [helper.getSurname(films.actresses.name)] ;
      |    :nameParts [helper.getNameParts(films.actresses.name)] ;
      |    :appear_on :[films.actresses.film] ;
      |}
    """.stripMargin

  private val mappingLauncher = new MappingLauncher()
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://example.com/"

  test("Shape 1 transformations are done correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "1", "screenwritterName", "Christopher", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "titleYear", "Dunkirk2017", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "name", "DUNKIRK", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "year", "2018", XSDDatatype.XSDinteger)))
  }

  test("Shape 2 transformations are done correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "2", "screenwritterName", "Christopher", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "screenwritterName", "Jonathan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "titleYear", "Interstellar2014", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "name", "INTERSTELLAR", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "year", "2015", XSDDatatype.XSDinteger)))
  }

  test("Shape 3 transformations are done correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "3", "screenwritterName", "Christopher", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "titleYear", "Inception2010", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "name", "INCEPTION", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "year", "2011", XSDDatatype.XSDinteger)))
  }

  test("Shape 4 transformations are done correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "4", "screenwritterName", "Christopher", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "screenwritterName", "Jonathan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "titleYear", "The Prestige2006", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "name", "THE PRESTIGE", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "year", "2007", XSDDatatype.XSDinteger)))
  }

  test("Actresses transformations are done correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "Ellen_Burstyn", "name", "Ellen", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Ellen_Burstyn", "nameParts", "Ellen", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Ellen_Burstyn", "nameParts", "Burstyn", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Ellen_Burstyn", "surname", "Burstyn", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Mackenzie_Foy", "name", "Mackenzie", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Mackenzie_Foy", "nameParts", "Mackenzie", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Mackenzie_Foy", "nameParts", "Foy", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Mackenzie_Foy", "surname", "Foy", XSDDatatype.XSDstring)))
  }

  test("Actors transformations are done correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "Joseph_Gordon-Levitt", "name", "Joseph", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Joseph_Gordon-Levitt", "nameParts", "Joseph", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Joseph_Gordon-Levitt", "nameParts", "Gordon-Levitt", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Joseph_Gordon-Levitt", "surname", "Gordon-Levitt", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Tom_Hardy", "name", "Tom", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Tom_Hardy", "nameParts", "Tom", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Tom_Hardy", "nameParts", "Hardy", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Tom_Hardy", "surname", "Hardy", XSDDatatype.XSDstring)))
  }

}
