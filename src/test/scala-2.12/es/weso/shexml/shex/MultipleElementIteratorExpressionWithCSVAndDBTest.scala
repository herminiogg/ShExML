package es.weso.shexml.shex

import es.weso.shexml.{MappingLauncher, RDFStatementCreator}
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.{FunSuite, Matchers}

class MultipleElementIteratorExpressionWithCSVAndDBTest extends FunSuite with ShExValidation {

  private val example =
    """
      |PREFIX ex: <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
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
      |    ex:type ex:Film ;
      |    ex:name [films.name] @en ;
      |    ex:year [films.year] xs:gYear ;
      |    ex:country [films.country] ;
      |    ex:director [films.directors] ;
      |}
    """.stripMargin
  private val shapeMap = "<ex:1>@<ex:Films>,<ex:2>@<ex:Films>,<ex:3>@<ex:Films>,<ex:4>@<ex:Films>,<ex:5>@<ex:Films>," +
                          "<ex:6>@<ex:Films>,<ex:7>@<ex:Films>,<ex:8>@<ex:Films>,<ex:9>@<ex:Films>"

  test("Films validate against generated schema") {
    this.validate(example, shapeMap)
  }

}
