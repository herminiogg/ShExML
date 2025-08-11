package com.herminiogarcia.shexml.mappingChallenges

import com.herminiogarcia.shexml.{ParallelConfigInferenceDatatypesNormaliseURIsFixture, RDFStatementCreator}
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.Model
import org.scalatest.ConfigMap
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class AccessFieldsOutsideIterators extends AnyFunSuite
  with Matchers with RDFStatementCreator
  with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE films_xml_file <https://shexml.herminiogarcia.com/files/films.xml>
      |SOURCE films_json_file <https://shexml.herminiogarcia.com/files/films.json>
      |ITERATOR film_xml <xpath: //film> {
      |    FIELD id <@id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <crew/directors/director>
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
      |    ITERATOR actors <cast[*]> {
      |        FIELD name <name>
      |        FIELD role <role>
      |        POPPED_FIELD film <id>
      |    }
      |}
      |EXPRESSION films <films_xml_file.film_xml UNION films_json_file.film_json>
      |
      |:Films :[films.id] {
      |    :type :Film ;
      |    :name [films.name] ;
      |    :year [films.year] xs:gYear ;
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


  private var output: Model = _
  private val prefix = "http://example.com/"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    output = mappingLauncher.launchMapping(example).getDefaultModel
  }

  test("Shape 1 is translated correctly") {
    assert(output.contains(createStatement(prefix, "1", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "name", "Dunkirk", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "year", "2017", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Aneurin_Barnard", "appear_on", "1")))
    assert(output.contains(createStatementWithLiteral(prefix, "Aneurin_Barnard", "name", "Aneurin Barnard", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Fionn_Whitehead", "appear_on", "1")))
    assert(output.contains(createStatementWithLiteral(prefix, "Fionn_Whitehead", "name", "Fionn Whitehead", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "James_Bloor", "appear_on", "1")))
    assert(output.contains(createStatementWithLiteral(prefix, "James_Bloor", "name", "James Bloor", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Damien_Bonnard", "appear_on", "1")))
    assert(output.contains(createStatementWithLiteral(prefix, "Damien_Bonnard", "name", "Damien Bonnard", XSDDatatype.XSDstring)))
  }

  test("Shape 2 is translated correctly") {
    assert(output.contains(createStatement(prefix, "2", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "name", "Interstellar", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "year", "2014", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Timothée_Chalamet", "appear_on", "2")))
    assert(output.contains(createStatementWithLiteral(prefix, "Timothée_Chalamet", "name", "Timothée Chalamet", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Ellen_Burstyn", "appear_on", "2")))
    assert(output.contains(createStatementWithLiteral(prefix, "Ellen_Burstyn", "name", "Ellen Burstyn", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Mackenzie_Foy", "appear_on", "2")))
    assert(output.contains(createStatementWithLiteral(prefix, "Mackenzie_Foy", "name", "Mackenzie Foy", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Matthew_McConaughey", "appear_on", "2")))
    assert(output.contains(createStatementWithLiteral(prefix, "Matthew_McConaughey", "name", "Matthew McConaughey", XSDDatatype.XSDstring)))
  }

  test("Shape 3 is translated correctly") {
    assert(output.contains(createStatement(prefix, "3", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "name", "Inception", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "year", "2010", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Leonardo_DiCaprio", "appear_on", "3")))
    assert(output.contains(createStatementWithLiteral(prefix, "Leonardo_DiCaprio", "name", "Leonardo DiCaprio", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Joseph_Gordon-Levitt", "appear_on", "3")))
    assert(output.contains(createStatementWithLiteral(prefix, "Joseph_Gordon-Levitt", "name", "Joseph Gordon-Levitt", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Ellen_Page", "appear_on", "3")))
    assert(output.contains(createStatementWithLiteral(prefix, "Ellen_Page", "name", "Ellen Page", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Tom_Hardy", "appear_on", "3")))
    assert(output.contains(createStatementWithLiteral(prefix, "Tom_Hardy", "name", "Tom Hardy", XSDDatatype.XSDstring)))
  }

  test("Shape 4 is translated correctly") {
    assert(output.contains(createStatement(prefix, "4", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "name", "The Prestige", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "year", "2006", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Hugh_Jackman", "appear_on", "4")))
    assert(output.contains(createStatementWithLiteral(prefix, "Hugh_Jackman", "name", "Hugh Jackman", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Christian_Bale", "appear_on", "4")))
    assert(output.contains(createStatementWithLiteral(prefix, "Christian_Bale", "name", "Christian Bale", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Michael_Caine", "appear_on", "4")))
    assert(output.contains(createStatementWithLiteral(prefix, "Michael_Caine", "name", "Michael Caine", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "Piper_Perabo", "appear_on", "4")))
    assert(output.contains(createStatementWithLiteral(prefix, "Piper_Perabo", "name", "Piper Perabo", XSDDatatype.XSDstring)))
  }

  test("No additional triples are generated") {
    val triplesCount = 74
    assert(output.size() == triplesCount)
  }

}
