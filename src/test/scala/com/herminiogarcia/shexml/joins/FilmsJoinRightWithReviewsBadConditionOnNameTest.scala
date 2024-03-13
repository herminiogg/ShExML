package com.herminiogarcia.shexml.joins

import com.herminiogarcia.shexml.{MappingLauncher, RDFStatementCreator}
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class FilmsJoinRightWithReviewsBadConditionOnNameTest extends AnyFunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      PREFIX : <http://example.com/>
      |PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |SOURCE films_json_file <https://shexml.herminiogarcia.com/files/films.json>
      |SOURCE films_with_reviews_file <https://raw.githubusercontent.com/herminiogg/ShExML/bug-%23170/src/test/resources/filmsWithReviews.json>
      |ITERATOR film_json <jsonpath: $.films[*]> {
      |    PUSHED_FIELD id <id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <crew.director>
      |    FIELD screenwritters <crew.screenwritter>
      |    FIELD music <crew.music>
      |    FIELD photography <crew.cinematography>
      |    ITERATOR actors <cast[*]> {
      |        FIELD name <name>
      |        FIELD role <role>
      |        POPPED_FIELD film <id>
      |    }
      |}
      |ITERATOR film_with_reviews <jsonpath: $.films[*]> {
      |    FIELD name <name>
      |    ITERATOR goodReviews <reviews.goodReviews[*]> {
      |        FIELD user <user>
      |        FIELD review <review>
      |    }
      |    ITERATOR badReviews <reviews.badReviews[*]> {
      |        FIELD user <user>
      |        FIELD review <review>
      |    }
      |}
      |
      |EXPRESSION films <films_with_reviews_file.film_with_reviews JOIN films_json_file.film_json ON films_with_reviews_file.film_with_reviews.name=films_json_file.film_json.id>
      |
      |:Films :[films.id] {
      |    :year :[films.year] ;
      |    :countryOfOrigin :[films.country] ;
      |    :director :[films.directors] ;
      |    :screenwriter :[films.screenwritters] ;
      |    :musicBy :[films.music] ;
      |    :cinematographer :[films.photography] ;
      |    :goodReview [films.goodReviews.review] ;
      |    :badReview [films.badReviews.review] ;
      |    :actor @:Actor ;
      |}
      |
      |:Actor :[films.actors.name] {
      |    :name [films.actors.name] ;
      |}
    """.stripMargin

  private val mappingLauncher = new MappingLauncher(inferenceDatatype = false, normaliseURIs = true)
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://example.com/"

  test("Film Inception is translated correctly") {
    assert(output.contains(createStatement(prefix, "3", "year", "2010")))
    assert(output.contains(createStatement(prefix, "3", "countryOfOrigin", "USA")))
    assert(output.contains(createStatement(prefix, "3", "director", "Christopher_Nolan")))
    assert(output.contains(createStatement(prefix, "3", "screenwriter", "Christopher_Nolan")))
    assert(output.contains(createStatement(prefix, "3", "musicBy", "Hans_Zimmer")))
    assert(output.contains(createStatement(prefix, "3", "actor", "Leonardo_DiCaprio")))
    assert(output.contains(createStatement(prefix, "3", "actor", "Joseph_Gordon-Levitt")))
    assert(output.contains(createStatement(prefix, "3", "actor", "Ellen_Page")))
    assert(output.contains(createStatement(prefix, "3", "actor", "Tom_Hardy")))
    assert(!output.contains(createStatementWithLiteral(prefix, "3", "goodReview", "good", XSDDatatype.XSDstring)))
    assert(!output.contains(createStatementWithLiteral(prefix, "3", "badReview", "bad", XSDDatatype.XSDstring)))
  }

  test("Film The Prestige is translated correctly") {
    assert(output.contains(createStatement(prefix, "4", "year", "2006")))
    assert(output.contains(createStatement(prefix, "4", "countryOfOrigin", "USA")))
    assert(output.contains(createStatement(prefix, "4", "director", "Christopher_Nolan")))
    assert(output.contains(createStatement(prefix, "4", "screenwriter", "Christopher_Nolan")))
    assert(output.contains(createStatement(prefix, "4", "screenwriter", "Jonathan_Nolan")))
    assert(output.contains(createStatement(prefix, "4", "musicBy", "David_Julyan")))
    assert(output.contains(createStatement(prefix, "4", "actor", "Hugh_Jackman")))
    assert(output.contains(createStatement(prefix, "4", "actor", "Christian_Bale")))
    assert(output.contains(createStatement(prefix, "4", "actor", "Michael_Caine")))
    assert(output.contains(createStatement(prefix, "4", "actor", "Piper_Perabo")))
    assert(!output.contains(createStatementWithLiteral(prefix, "4", "goodReview", "good", XSDDatatype.XSDstring)))
    assert(!output.contains(createStatementWithLiteral(prefix, "4", "badReview", "bad", XSDDatatype.XSDstring)))
  }

  test("Actors are translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "Leonardo_DiCaprio", "name", "Leonardo DiCaprio", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Joseph_Gordon-Levitt", "name", "Joseph Gordon-Levitt", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Ellen_Page", "name", "Ellen Page", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Tom_Hardy", "name", "Tom Hardy", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Hugh_Jackman", "name", "Hugh Jackman", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Christian_Bale", "name", "Christian Bale", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Michael_Caine", "name", "Michael Caine", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "Piper_Perabo", "name", "Piper Perabo", XSDDatatype.XSDstring)))
  }

  test("No additional triples are generated") {
    val triplesCount = 27
    assert(output.size() == triplesCount)
  }

}
