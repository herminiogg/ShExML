package com.herminiogarcia.shexml

import com.herminiogarcia.shexml.helper.SourceHelper
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.Model
import org.scalatest.{BeforeAndAfter, ConfigMap}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers
import java.io.ByteArrayInputStream

class FilmsStdin extends AnyFunSuite
  with Matchers with RDFStatementCreator
  with BeforeAndAfter with ParallelConfigInferenceDatatypesNormaliseURIsFixture{

  private val example =
    """
      PREFIX : <http://example.com/>
      |SOURCE films_xml_file <./src/test/resources/filmsAlt.xml>
      |SOURCE films_json_file <stdin>
      |ITERATOR film_xml <xpath: //film> {
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <directors/director>
      |    FIELD comment <comment>
      |}
      |ITERATOR film_json <jsonpath: $.films[*]> {
      |    FIELD name <['name of the film']>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <director>
      |    FIELD comment <comment>
      |}
      |EXPRESSION films <films_xml_file.film_xml UNION films_json_file.film_json>
      |
      |:Films :film1 {
      |    a :Film ;
      |    :name [films.name] ;
      |    :year [films.year] ;
      |    :country [films.country] ;
      |    :director [films.directors] ;
      |    :comment [films.comment] ;
      |}
    """.stripMargin

  private var output: Model = _
  private val prefix = "http://example.com/"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    val stream = new ByteArrayInputStream(new SourceHelper().getContentFromRelativePath("./src/test/resources/filmsAlt.json").fileContent.getBytes())
    System.setIn(stream)
    stream.close()
    output = mappingLauncher.launchMapping(example).getDefaultModel
    System.setIn(System.in)
  }

  test("Shape film1 contains all the data, literal action, enhancement-#97") {
    assert(output.contains(createStatementWithLiteral(prefix, "film1", "name", "Dunkirk", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "film1", "year", "2017", XSDDatatype.XSDinteger)))
    assert(output.contains(createStatementWithLiteral(prefix, "film1", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "film1", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "film1", "year", "2010", XSDDatatype.XSDinteger)))
    assert(output.contains(createStatementWithLiteral(prefix, "film1", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "film1", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Allow spaces in the JSONPath expression, bug-#98") {
    assert(output.contains(createStatementWithLiteral(prefix, "film1", "name", "Inception", XSDDatatype.XSDstring)))
  }

  test("Escape quote marks inside strings, enhancement-#99") {
    assert(output.contains(createStatementWithLiteral(prefix, "film1", "comment", "A \"different\" movie", XSDDatatype.XSDstring)))
  }

  test("Avoid URL generation when string does not start by it, bug-#100") {
    assert(output.contains(createStatementWithLiteral(prefix, "film1", "comment", "Very interesting movie, see more comments on: http://example.com/comments", XSDDatatype.XSDstring)))
  }

  test("No additional triples are generated") {
    val triplesCount = 9
    assert(output.size() == triplesCount)
  }

}
