package com.herminiogarcia.shexml.mappingChallenges

import com.herminiogarcia.shexml.{ParallelConfigInferenceDatatypesNormaliseURIsFixture, RDFStatementCreator}
import org.apache.jena.rdf.model.Model
import org.scalatest.ConfigMap
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

/**
  * Created by herminio on 21/2/18.
  */
class MultiValueReferencesHierarchicalFile extends AnyFunSuite
  with Matchers with RDFStatementCreator
  with ParallelConfigInferenceDatatypesNormaliseURIsFixture {

  private val example =
    """
      |PREFIX ex: <http://example.com/>
      |PREFIX exLab: <http://example.com/lab/>
      |PREFIX exArticle: <http://example.com/article/>
      |PREFIX exAuthor: <http://example.com/author/>
      |PREFIX exAff: <http://example.com/aff/>
      |SOURCE lab_file <https://raw.githubusercontent.com/herminiogg/mapping-challenges/main/challenges/multivalue-references/input-1/input.json>
      |ITERATOR lab <jsonpath: $> {
      |    FIELD labName <labName>
      |    ITERATOR articles <articles[*]> {
      |        FIELD title <title>
      |        ITERATOR authors <authors[*]> {
      |            FIELD name <name>
      |          ITERATOR affiliation <affiliation[*]> {
      |              FIELD label <label>
      |          }
      |        }
      |    }
      |}
      |
      |EXPRESSION labValues <lab_file.lab>
      |
      |ex:Lab ex:[labValues.labName] {
      |  	a ex:Lab ;
      |	  ex:hasArticles @ex:Article ;
      |	  ex:hasMembers @ex:Author ;
      |}
      |
      |ex:Article ex:[labValues.articles.title] {
      |  	ex:hasAuthor @ex:Author ;
      |}
      |
      |ex:Author ex:[labValues.articles.authors.name] {
      |  	ex:hasAffiliation ex:[labValues.articles.authors.affiliation.label] ;
      |}
    """.stripMargin

  private var output: Model = _
  private val prefix = "http://example.com/"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    output = mappingLauncher.launchMapping(example).getDefaultModel
  }

  test("Lab shape is correctly translated") {
    assert(output.contains(createStatement(prefix, "AmazingLab1", "hasArticles", "article1")))
    assert(output.contains(createStatement(prefix, "AmazingLab1", "hasArticles", "article2")))
    assert(output.contains(createStatement(prefix, "AmazingLab1", "hasMembers", "Alice")))
    assert(output.contains(createStatement(prefix, "AmazingLab1", "hasMembers", "Bob")))
    assert(output.contains(createStatement(prefix, "AmazingLab1", "hasMembers", "Claire")))
  }

  test("Article shape is correctly translated") {
    assert(output.contains(createStatement(prefix, "article1", "hasAuthor", "Alice")))
    assert(output.contains(createStatement(prefix, "article1", "hasAuthor", "Bob")))
    assert(output.contains(createStatement(prefix, "article2", "hasAuthor", "Claire")))
  }

  test("Author shape is correctly translated") {
    assert(output.contains(createStatement(prefix, "Alice", "hasAffiliation", "Uni1")))
    assert(output.contains(createStatement(prefix, "Alice", "hasAffiliation", "Company2")))
    assert(output.contains(createStatement(prefix, "Bob", "hasAffiliation", "Uni3")))
    assert(output.contains(createStatement(prefix, "Bob", "hasAffiliation", "Company4")))
    assert(output.contains(createStatement(prefix, "Claire", "hasAffiliation", "Uni5")))
    assert(output.contains(createStatement(prefix, "Claire", "hasAffiliation", "Company6")))
  }

  test("No additional triples are generated") {
    val triplesCount = 15
    assert(output.size() == triplesCount)
  }

}
