package com.herminiogarcia.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class ConditionalGenerationTest extends AnyFunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |SOURCE films_xml_file <https://shexml.herminiogarcia.com/files/films.xml>
      |SOURCE films_json_file <https://shexml.herminiogarcia.com/files/films.json>
      |FUNCTIONS helper <scala: https://raw.githubusercontent.com/herminiogg/ShExML/enhancement-%23122/src/test/resources/functions.scala>
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
      |
      |:Films :[films.id IF helper.isBefore2010(films.year)] {
      |    :name [films.name] ;
      |    :year [films.year] ;
      |    :countryOfOrigin [films.country IF helper.outsideUSA(films.country)] ;
      |    :director [films.directors] ;
      |    :screenwritter [films.screenwritters] ;
      |    :musicBy [films.music] ;
      |    :cinematographer [films.photography] ;
      |}
    """.stripMargin

  private val mappingLauncher = new MappingLauncher(inferenceDatatype = true)
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://example.com/"

  test("Shape 4 is generated without country") {
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "musicBy", "David Julyan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "name", "The Prestige", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "screenwritter", "Jonathan Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "screenwritter", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "year", "2006", XSDDatatype.XSDinteger)))
    assert(!output.contains(createStatementWithLiteral(prefix, "4", "countryOfOrigin", "USA", XSDDatatype.XSDinteger)))
  }

  test("Shape 1, 2 and 3 are not generated") {
    assert(output.listSubjects().filterKeep(s => s.hasURI(prefix + "1")).toSet.size() == 0)
    assert(output.listSubjects().filterKeep(s => s.hasURI(prefix + "2")).toSet.size() == 0)
    assert(output.listSubjects().filterKeep(s => s.hasURI(prefix + "3")).toSet.size() == 0)
  }


}
