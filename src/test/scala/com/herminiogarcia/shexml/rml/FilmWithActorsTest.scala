package com.herminiogarcia.shexml.rml

import com.herminiogarcia.shexml.{MappingLauncher, RDFStatementCreator}
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.{FunSuite, Matchers}

class FilmWithActorsTest extends FunSuite with Matchers with RDFStatementCreator with RMLTestConversion {

  private val example =
    """
      PREFIX : <http://example.com/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |SOURCE films_xml_file <http://shexml.herminiogarcia.com/files/films.xml>
      |SOURCE films_json_file <http://shexml.herminiogarcia.com/files/films.json>
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

  private val mappingLauncher = new MappingLauncher()
  private val result = mappingLauncher.launchRMLTranslation(example)
  private val prefix = "http://example.com/"
  private val output = doTranslation(result, prefix).getDefaultModel

  test("Shape 1 is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "1", "name", "Dunkirk", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "year", "2017", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    //Needs update to a newer version of rml-mapper
    //assert(output.contains(createStatement(prefix, "1", "actor", "Aneurin%Barnard")))
    //assert(output.contains(createStatement(prefix, "1", "actor", "Fionn%Whitehead")))
    //assert(output.contains(createStatement(prefix, "1", "actor", "James%20Bloorn")))
    //assert(output.contains(createStatement(prefix, "1", "actor", "Lee%20Armstrong")))
    //assert(output.contains(createStatement(prefix, "1", "actor", "Damien%20Bonnard")))

    assert(output.contains(createStatement(prefix, "Aneurin%20Barnard", "appear_on", "1")))
    assert(output.contains(createStatementWithLiteral(prefix, "Aneurin%20Barnard", "name", "Aneurin Barnard", XSDDatatype.XSDstring)))
  }

  test("Shape 2 is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "2", "name", "Interstellar", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "year", "2014", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    //assert(output.contains(createStatement(prefix, "2", "actor", "Matthew%20McConaughey")))
    //assert(output.contains(createStatement(prefix, "2", "actor", "Ellen%20Burstyn")))
    //assert(output.contains(createStatement(prefix, "2", "actor", "Timothée%C3%A9e%20Chalamet")))
    //assert(output.contains(createStatement(prefix, "2", "actor", "Mackenzie%20Foy")))
    //assert(output.contains(createStatement(prefix, "2", "actor", "John%20Lithgow")))

    assert(output.contains(createStatement(prefix, "Ellen%20Burstyn", "appear_on", "2")))
    assert(output.contains(createStatementWithLiteral(prefix, "Ellen%20Burstyn", "name", "Ellen Burstyn", XSDDatatype.XSDstring)))
  }

  test("Shape 3 is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "3", "name", "Inception", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "year", "2010", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    //assert(output.contains(createStatement(prefix, "3", "actor", "Joseph%20Gordon-Levitt")))
    //assert(output.contains(createStatement(prefix, "3", "actor", "Ellen%20Page")))
    //assert(output.contains(createStatement(prefix, "3", "actor", "Leonardo%20DiCaprio")))
    //assert(output.contains(createStatement(prefix, "3", "actor", "Tom%20Hardy")))

    assert(output.contains(createStatementWithLiteral(prefix, "Leonardo%20DiCaprio", "name", "Leonardo DiCaprio", XSDDatatype.XSDstring)))
  }

  test("Shape 4 is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "4", "name", "The Prestige", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "year", "2006", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    //assert(output.contains(createStatement(prefix, "4", "actor", "Christian%20Bale")))
    //assert(output.contains(createStatement(prefix, "4", "actor", "Piper%20Perabo")))
    //assert(output.contains(createStatement(prefix, "4", "actor", "Hugh%20Jackman")))
    //assert(output.contains(createStatement(prefix, "4", "actor", "Michael%20Caine")))

    assert(output.contains(createStatementWithLiteral(prefix, "Christian%20Bale", "name", "Christian Bale", XSDDatatype.XSDstring)))
  }

}
