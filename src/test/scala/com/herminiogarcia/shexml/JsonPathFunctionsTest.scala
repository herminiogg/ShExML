package com.herminiogarcia.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.{Model, ResourceFactory}
import org.scalatest.ConfigMap
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class JsonPathFunctionsTest extends AnyFunSuite
  with Matchers with RDFStatementCreator
  with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

  private val example =
    """
      PREFIX : <http://example.com/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |SOURCE films_json_file <https://shexml.herminiogarcia.com/files/films.json>
      |ITERATOR film_json <jsonpath: $.films[?(@.year!=2010)]> {
      |    PUSHED_FIELD id <id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <crew.director>
      |    FIELD screenwritters <crew.screenwritter>
      |    FIELD music <crew.music>
      |    FIELD photography <crew.cinematographer>
      |    FIELD numberOfActors <cast.length()>
      |    ITERATOR actors <cast[*]> {
      |        FIELD name <name>
      |        FIELD role <role>
      |        POPPED_FIELD film <id>
      |    }
      |}
      |EXPRESSION films <films_json_file.film_json>
      |
      |:Films :[films.id] {
      |    :type :Film ;
      |    :name [films.name] ;
      |    :year :[films.year] ;
      |    :countryOfOrigin [films.country] ;
      |    :director [films.directors] ;
      |    :screenwritter [films.screenwritters] ;
      |    :musicBy [films.music] ;
      |    :cinematographer [films.photography] ;
      |    :castSize [films.numberOfActors] ;
      |    :actor @:Actor ;
      |}
      |
      |:Actor :[films.actors.name] {
      |    :name [films.actors.name] ;
      |    :appear_on :[films.actors.film] ;
      |}
    """.stripMargin

  private var output: Model = _
  private val prefix = "http://example.com/"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    output = mappingLauncher.launchMapping(example).getDefaultModel
  }

  test("Shape 4 is translated correctly") {
    assert(output.contains(createStatement(prefix, "4", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "name", "The Prestige", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "4", "year", "2006")))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "countryOfOrigin", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "screenwritter", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "screenwritter", "Jonathan Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "musicBy", "David Julyan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "cinematographer", "Wally Pfister", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "castSize", "4", XSDDatatype.XSDinteger)))
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
    val triplesCount = 22
    assert(output.size() == triplesCount)
  }

}
