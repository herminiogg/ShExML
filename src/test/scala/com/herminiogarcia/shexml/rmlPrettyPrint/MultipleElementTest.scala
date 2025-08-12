package com.herminiogarcia.shexml.rmlPrettyPrint

import com.herminiogarcia.shexml.{ParallelConfigInferenceDatatypesNormaliseURIsFixture, RDFStatementCreator}
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.Model
import org.scalatest.ConfigMap
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class MultipleElementTest extends AnyFunSuite
  with Matchers with RDFStatementCreator
  with ParallelConfigInferenceDatatypesNormaliseURIsFixture with RMLTestConversion {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |SOURCE films_xml_file <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.xml>
      |SOURCE films_json_file <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.json>
      |ITERATOR film_xml <xpath: //film> {
      |    FIELD id <@id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <directors/director>
      |}
      |ITERATOR film_json <jsonpath: $.films[*]> {
      |    FIELD id <id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <director>
      |}
      |EXPRESSION film_ids <films_xml_file.film_xml.id UNION films_json_file.film_json.id>
      |EXPRESSION film_names <films_xml_file.film_xml.name UNION films_json_file.film_json.name>
      |EXPRESSION film_years <films_xml_file.film_xml.year UNION films_json_file.film_json.year>
      |EXPRESSION film_countries <films_xml_file.film_xml.country UNION films_json_file.film_json.country>
      |EXPRESSION film_directors <films_xml_file.film_xml.directors UNION films_json_file.film_json.directors>
      |
      |:Films :[film_ids] {
      |    :name [film_names] ;
      |    :year [film_years] ;
      |    :country [film_countries] ;
      |    :director [film_directors] ;
      |}
    """.stripMargin


  private var output: Model = _
  private val prefix = "http://example.com/"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    val result = mappingLauncher.launchRMLTranslation(example, true)
    output = doTranslation(result, prefix).getDefaultModel
  }

  test("Shape 1 is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "1", "name", "Dunkirk", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "year", "2017", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 2 is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "2", "name", "Interstellar", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "year", "2014", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 3 is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "3", "name", "Inception", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "year", "2010", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 4 is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "4", "name", "The Prestige", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "year", "2006", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "director", "Jonathan Nolan", XSDDatatype.XSDstring)))
  }

}
