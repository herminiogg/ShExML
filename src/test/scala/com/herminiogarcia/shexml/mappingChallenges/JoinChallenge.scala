package com.herminiogarcia.shexml.mappingChallenges

import com.herminiogarcia.shexml.{MappingLauncher, RDFStatementCreator}
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

/**
  * Created by herminio on 21/2/18.
  */
class JoinChallenge extends AnyFunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX : <http://example.com/>
      |PREFIX experson: <http://example.com/person/>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |SOURCE jsonfile <https://raw.githubusercontent.com/herminiogg/mapping-challenges/2aac9680cd731fd647abd33d44a7f400e4278cf3/challenges/join-on-literal/input-1/input.json>
      |ITERATOR author <jsonpath: $.author[*]> {
      |    FIELD id <id>
      |    FIELD firstname <firstname>
      |    FIELD affiliation <affiliation>
      |}
      |ITERATOR people <jsonpath: $.people[*]> {
      |  	FIELD firstname <firstname>
      |  	FIELD familyname <familyName>
      |}
      |EXPRESSION authors <jsonfile.author UNION jsonfile.people>
      |EXPRESSION familyName <jsonfile.people.familyname UNION jsonfile.author.firstname JOIN jsonfile.people.firstname>
      |
      |:Author :[authors.id] {
      |    :affiliation [authors.affiliation] ;
      |    :lastName [familyName] ;
      |}
    """.stripMargin
  private val mappingLauncher = new MappingLauncher()
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://example.com/"

  test("Author shape translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "1", "affiliation", "Uni1", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "1", "lastName", "Doe", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "affiliation", "Uni2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "lastName", "Dane", XSDDatatype.XSDstring)))
  }

  test("No additional triples are generated") {
    val triplesCount = 4
    assert(output.size() == triplesCount)
  }

}
