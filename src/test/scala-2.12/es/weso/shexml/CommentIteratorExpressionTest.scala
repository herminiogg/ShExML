package es.weso.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.{FunSuite, Matchers}

class CommentIteratorExpressionTest extends FunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX ex: <http://ex.com/>
      |SOURCE performances_json <https://cdn.rawgit.com/herminiogg/ShExML/f1fa70f6/src/test/resources/events.json>
      |SOURCE events_xml <https://cdn.rawgit.com/herminiogg/ShExML/f1fa70f6/src/test/resources/events.xml>
      |ITERATOR performances_iterator <jsonpath: $.Performances[*]> {
      |   FIELD ids <Perf_ID>
      |   FIELD venues_names <Venue.Venue_ID>
      |   FIELD venues_names_json <Venue.Name>
      |   FIELD lat <Location.lat>
      |   FIELD long <Location.long>
      |}
      |ITERATOR events_iterator <xpath: /Events/Exhibition> {
      |   FIELD ids <@id>
      |   FIELD venues_names <Venue>
      |   FIELD lat <Location/lat>
      |   FIELD long <Location/long>
      |}
      |
      |EXPRESSION performances <performances_json.performances_iterator UNION events_xml.events_iterator>
      |EXPRESSION location_union <performances_json.performances_iterator.lat + "-" + performances_json.performances_iterator.long UNION
      |                             events_xml.events_iterator.lat + "-" + events_xml.events_iterator.long>
      |
      |ex:Performance ex:[performances.ids] {
      |  ex:venue ex:[performances.venues_names] ;
      |  ex:location @ex:Location ;
      |}
      |
      |ex:Location ex:[location_union] {
      |  ex:lat [performances.lat] ;
      |  #ex:long [performances.long] ;
      |}
    """.stripMargin
  private val mappingLauncher = new MappingLauncher()
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://ex.com/"

  test("Location shape is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "51.043613-3.717333", "lat", "51.043613", XSDDatatype.XSDdecimal)))
    assert(!output.contains(createStatementWithLiteral(prefix, "51.043613-3.717333", "long", "3.717333", XSDDatatype.XSDdecimal)))
    assert(output.contains(createStatementWithLiteral(prefix, "51.043611-3.717222", "lat", "51.043611", XSDDatatype.XSDdecimal)))
    assert(!output.contains(createStatementWithLiteral(prefix, "51.043611-3.717222", "long", "3.717222", XSDDatatype.XSDdecimal)))
    assert(output.contains(createStatementWithLiteral(prefix, "51.076891-3.717222", "lat", "51.076891", XSDDatatype.XSDdecimal)))
    assert(!output.contains(createStatementWithLiteral(prefix, "51.076891-3.717222", "long", "3.717222", XSDDatatype.XSDdecimal)))
  }

  test("Venue is translated correctly") {
    assert(output.contains(createStatement(prefix, "398", "venue", "STAM")))
    assert(output.contains(createStatement(prefix, "567", "venue", "78")))
    assert(output.contains(createStatement(prefix, "444", "venue", "STOM")))
    assert(output.contains(createStatement(prefix, "989", "venue", "68")))
  }

  test("Location shape is linked correctly in venue shape") {
    assert(output.contains(createStatement(prefix, "398", "location", "51.076891-3.717222")))
    assert(output.contains(createStatement(prefix, "567", "location", "51.043611-3.717222")))
    assert(output.contains(createStatement(prefix, "444", "location", "51.076891-3.717222")))
    assert(output.contains(createStatement(prefix, "989", "location", "51.043613-3.717333")))
  }

}
