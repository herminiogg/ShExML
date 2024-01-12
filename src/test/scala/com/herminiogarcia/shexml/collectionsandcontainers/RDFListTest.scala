package com.herminiogarcia.shexml.collectionsandcontainers

import com.herminiogarcia.shexml.{MappingLauncher, RDFStatementCreator}
import org.apache.jena.rdf.model.ResourceFactory
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

/**
  * Created by herminio on 21/2/18.
  */
class RDFListTest extends AnyFunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      PREFIX ex: <http://example.com/>
      |PREFIX exArticle: <http://example.com/article/>
      |PREFIX exLab: <http://example.com/lab/>
      |PREFIX exAuthor: <http://example.com/person/>
      |PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
      |PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
      |SOURCE input <https://raw.githubusercontent.com/herminiogg/mapping-challenges/main/challenges/rdf-collections/input-1/input.json>
      |ITERATOR lab <jsonpath: $> {
      |    FIELD labName <labName>
      |    ITERATOR articles <article> {
      |        FIELD title <title>
      |        ITERATOR authors <authors[*]> {
      |            FIELD name <name>
      |        }
      |    }
      |}
      |
      |EXPRESSION labValues <input.lab>
      |
      |ex:Lab ex:[labValues.labName] {
      |    a ex:Lab ;
      |    ex:hasArticles @ex:Article ;
      |}
      |
      |ex:Article ex:[labValues.articles.title] {
      |    a ex:Article ;
      |    ex:hasAuthors ex:[labValues.articles.authors.name AS RDFList] ;
      |}
    """.stripMargin
  private val mappingLauncher = new MappingLauncher(inferenceDatatype = true, normaliseURIs = true)
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://example.com/"

  test("Lab shape is correctly translated") {
    assert(output.contains(createStatement(prefix, "AmazingLab1", "hasArticles", "article1")))
  }

  test("Article shape is correctly translated") {
    val values = List(ResourceFactory.createResource("http://example.com/Alice"), ResourceFactory.createResource("http://example.com/Bob"))
    values.foreach(v => assert(output.containsResource(v)))
    output.containsResource(ResourceFactory.createResource("http://www.w3.org/1999/02/22-rdf-syntax-ns#List"))
  }

}
