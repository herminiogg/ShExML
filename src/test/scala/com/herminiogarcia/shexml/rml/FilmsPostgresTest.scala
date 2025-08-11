package com.herminiogarcia.shexml.rml

import com.herminiogarcia.shexml.{ParallelConfigDatabase, RDFStatementCreator}
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.Model
import org.scalatest.ConfigMap
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class FilmsPostgresTest extends AnyFunSuite
  with Matchers with RDFStatementCreator
  with ParallelConfigDatabase with RMLTestConversion {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE films_database <jdbc:postgresql://localhost:55432/films>
      |ITERATOR films_iterator <sql: SELECT * FROM films;> {
      |    FIELD id <id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD director <director>
      |}
      |
      |EXPRESSION films <films_database.films_iterator>
      |
      |:Films :[films.id] {
      |    :type :Film ;
      |    :name [films.name] @en ;
      |    :year [films.year] xs:gYear ;
      |    :country [films.country] ;
      |    :director [films.director] ;
      |}
    """.stripMargin


  private var output: Model = _
  private val prefix = "http://example.com/"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    val result = mappingLauncher.launchRMLTranslation(example)
    output = doTranslation(result, prefix).getDefaultModel
  }

  test("Shape 8 is translated correctly") {
    assert(output.contains(createStatement(prefix, "8", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "8", "name", "Tenet", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "8", "year", "2020", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "8", "country", "UK", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "8", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

  test("Shape 9 is translated correctly") {
    assert(output.contains(createStatement(prefix, "9", "type", "Film")))
    assert(output.contains(createStatementWithLiteral(prefix, "9", "name", "Batman Begins", "en")))
    assert(output.contains(createStatementWithLiteral(prefix, "9", "year", "2005", XSDDatatype.XSDgYear)))
    assert(output.contains(createStatementWithLiteral(prefix, "9", "country", "USA", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "9", "director", "Christopher Nolan", XSDDatatype.XSDstring)))
  }

}
