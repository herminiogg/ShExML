package com.herminiogarcia.shexml.shacl

import org.scalatest.FunSuite

class MultipleElementIteratorExpressionWithCSVAndDBTest extends FunSuite with SHACLValidation {

  private val example =
    """
      |PREFIX ex: <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
      |SOURCE films_xml_file <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.xml>
      |SOURCE films_json_file <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.json>
      |SOURCE films_csv_file <https://rawgit.com/herminiogg/ShExML/enhancement-%239/src/test/resources/films.csv>
      |SOURCE films_db_connection <jdbc:sqlite:src/test/resources/films.sqlite>
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
      |ITERATOR film_csv <csvPerRow> {
      |    FIELD id <id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <director>
      |}
      |ITERATOR film_db <sql: SELECT * FROM films;> {
      |    FIELD id <id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <director>
      |}
      |EXPRESSION films <films_xml_file.film_xml UNION films_json_file.film_json UNION films_csv_file.film_csv
      |               UNION films_db_connection.film_db>
      |
      |ex:Films ex:[films.id] {
      |    a ex:Film ;
      |    ex:type ex:Film ;
      |    ex:name [films.name] @en ;
      |    ex:year [films.year] xs:gYear ;
      |    ex:country [films.country] ;
      |    ex:director [films.directors] ;
      |}
    """.stripMargin

  test("Films validate against generated schema") {
    assert(this.validate(example))
  }

  test("Films validate against generated schema with closed shapes") {
    assert(this.validate(example, true))
  }

}
