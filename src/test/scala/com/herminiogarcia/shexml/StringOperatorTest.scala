package com.herminiogarcia.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.Model
import org.scalatest.ConfigMap
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class StringOperatorTest extends AnyFunSuite
  with Matchers with RDFStatementCreator
  with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

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
      |}
      |EXPRESSION films <films_xml_file.film_xml UNION films_json_file.film_json>
      |EXPRESSION films_name <films_xml_file.film_xml.name + "_something_" + films_xml_file.film_xml.id>
      |
      |:Films :["films/" + films.id + films.country + films.year] {
      |    :name :[films_name] ;
      |    :titleYear [films.name + "-" + films.year + films.screenwritters] ;
      |    :titleYear2 :["films/" + films.year + films.screenwritters] ;
      |    :titleYear3 [films.name + "films"] ;
      |    :titleYear4 ["pre" + films.name + "post"] ;
      |    :year :[films.year] ;
      |    :country :[films.country] ;
      |    :director [films.directors] ;
      |    :screenwritter [films.screenwritters] ;
      |}
    """.stripMargin

  private var output: Model = _
  private val prefix = "http://example.com/"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    output = mappingLauncher.launchMapping(example).getDefaultModel
  }

  test("Shape 1 transformations are done correctly") {
    assert(output.contains(createStatement(prefix, "films/1USA2017", "name", "Dunkirk_something_1")))
    assert(output.contains(createStatementWithLiteral(prefix, "films/1USA2017", "titleYear", "Dunkirk-2017Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "films/1USA2017", "titleYear2", "films/2017Christopher_Nolan")))
    assert(output.contains(createStatementWithLiteral(prefix, "films/1USA2017", "titleYear3", "Dunkirkfilms", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "films/1USA2017", "titleYear4", "preDunkirkpost", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "films/1USA2017", "year", "2017")))
    assert(output.contains(createStatement(prefix, "films/1USA2017", "country", "USA")))
    assert(output.contains(createStatementWithLiteral(prefix, "films/1USA2017", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "films/1USA2017", "screenwritter", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 2 transformations are done correctly") {
    assert(output.contains(createStatement(prefix, "films/2USA2014", "name", "Interstellar_something_2")))
    assert(output.contains(createStatementWithLiteral(prefix, "films/2USA2014", "titleYear", "Interstellar-2014Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "films/2USA2014", "titleYear", "Interstellar-2014Jonathan Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "films/2USA2014", "titleYear2", "films/2014Christopher_Nolan")))
    assert(output.contains(createStatement(prefix, "films/2USA2014", "titleYear2", "films/2014Jonathan_Nolan")))
    assert(output.contains(createStatementWithLiteral(prefix, "films/2USA2014", "titleYear3", "Interstellarfilms", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "films/2USA2014", "titleYear4", "preInterstellarpost", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "films/2USA2014", "year", "2014")))
    assert(output.contains(createStatement(prefix, "films/2USA2014", "country", "USA")))
    assert(output.contains(createStatementWithLiteral(prefix, "films/2USA2014", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "films/2USA2014", "screenwritter", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "films/2USA2014", "screenwritter", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 3 transformations are done correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "films/3USA2010", "titleYear", "Inception-2010Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "films/3USA2010", "titleYear2", "films/2010Christopher_Nolan")))
    assert(output.contains(createStatementWithLiteral(prefix, "films/3USA2010", "titleYear3", "Inceptionfilms", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "films/3USA2010", "titleYear4", "preInceptionpost", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "films/3USA2010", "year", "2010")))
    assert(output.contains(createStatement(prefix, "films/3USA2010", "country", "USA")))
    assert(output.contains(createStatementWithLiteral(prefix, "films/3USA2010", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "films/3USA2010", "screenwritter", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 4 transformations are done correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "films/4USA2006", "titleYear", "The Prestige-2006Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "films/4USA2006", "titleYear", "The Prestige-2006Jonathan Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "films/4USA2006", "titleYear2", "films/2006Christopher_Nolan")))
    assert(output.contains(createStatement(prefix, "films/4USA2006", "titleYear2", "films/2006Jonathan_Nolan")))
    assert(output.contains(createStatementWithLiteral(prefix, "films/4USA2006", "titleYear3", "The Prestigefilms", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "films/4USA2006", "titleYear4", "preThe Prestigepost", XSDDatatype.XSDstring)))
    assert(output.contains(createStatement(prefix, "films/4USA2006", "year", "2006")))
    assert(output.contains(createStatement(prefix, "films/4USA2006", "country", "USA")))
    assert(output.contains(createStatementWithLiteral(prefix, "films/4USA2006", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "films/4USA2006", "screenwritter", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "films/4USA2006", "screenwritter", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

  test("No additional triples are generated") {
    val triplesCount = 40
    assert(output.size() == triplesCount)
  }

}
