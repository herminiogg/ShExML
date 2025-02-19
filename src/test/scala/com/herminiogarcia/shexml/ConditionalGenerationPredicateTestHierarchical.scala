package com.herminiogarcia.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class ConditionalGenerationPredicateTestHierarchical extends AnyFunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |SOURCE films_xml_incomplete_data <src/test/resources/filmsIncompleteDataHierarchical.xml>
      |FUNCTIONS helper <scala: https://raw.githubusercontent.com/herminiogg/ShExML/enhancement-%23122/src/test/resources/functions.scala>
      |ITERATOR film_xml <xpath: //film> {
      |    FIELD id <@id>
      |    FIELD name <name>
      |    ITERATOR years <years[*]> {
      |        FIELD year1 <year1>
      |        FIELD year2 <year2>
      |    }
      |}
      |EXPRESSION films <films_xml_incomplete_data.film_xml>
      |
      |:FilmsCondGenerationName :[films.id] {
      |    :name [films.name IF helper.isBefore2010(films.years.year2)] ;
      |    :year1 [films.years.year1] ;
      |    :year2 [films.years.year2] ;
      |}
    """.stripMargin

  private val mappingLauncher = new MappingLauncher(normaliseURIs = true)
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://example.com/"

  test("Shape 1 is generated completely") {
    assert(output.contains(createStatementWithLiteral(prefix, "1", "name", "Complete film 1", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "year1", "2000", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "year2", "2000", XSDDatatype.XSDstring)))
  }

  test("Shape 2 is generated completely") {
    assert(!output.contains(createStatementWithLiteral(prefix, "2", "name", "Incomplete film 2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "year1", "2000", XSDDatatype.XSDstring)))
    assert(!output.contains(createStatementWithLiteral(prefix, "2", "year2", "2000", XSDDatatype.XSDstring)))
  }

  test("Shape 3 is generated without name") {
    assert(output.contains(createStatementWithLiteral(prefix, "3", "name", "Incomplete film 3", XSDDatatype.XSDstring)))
    assert(!output.contains(createStatementWithLiteral(prefix, "3", "year1", "2000", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "year2", "2000", XSDDatatype.XSDstring)))
  }

  test("Shape 4 is generated without name") {
    assert(!output.contains(createStatementWithLiteral(prefix, "4", "name", "Complete film 4", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "year1", "2011", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "year2", "2011", XSDDatatype.XSDstring)))
  }

}
