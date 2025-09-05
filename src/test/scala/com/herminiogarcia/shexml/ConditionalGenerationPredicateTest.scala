package com.herminiogarcia.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.Model
import org.scalatest.ConfigMap
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class ConditionalGenerationPredicateTest extends AnyFunSuite
  with Matchers with RDFStatementCreator
  with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |SOURCE films_xml_incomplete_data <src/test/resources/filmsIncompleteData.xml>
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
      |EXPRESSION films <films_xml_incomplete_data.film_xml>
      |
      |:Films :[films.id] {
      |    :name [films.name IF helper.isBefore2010(films.year)] ;
      |    :countryOfOrigin [films.country] ;
      |}
    """.stripMargin

  private var output: Model = _
  private val prefix = "http://example.com/"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    output = mappingLauncher.launchMapping(example).getDefaultModel
  }

  test("Shape 99 is generated without name") {
    assert(!output.contains(createStatementWithLiteral(prefix, "99", "name", "Incomplete film", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "99", "countryOfOrigin", "USA", XSDDatatype.XSDstring)))
  }

}
