package es.weso.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.{FunSuite, Matchers}

class CommentTest extends FunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      |PREFIX ex: <http://ex.com/>
      |SOURCE performances_json <https://cdn.rawgit.com/herminiogg/ShExML/f1fa70f6/src/test/resources/events.json>
      |SOURCE events_xml <https://cdn.rawgit.com/herminiogg/ShExML/f1fa70f6/src/test/resources/events.xml>
      |QUERY performances <$.Performances[*].Perf_ID>
      |QUERY events </Events/Exhibition/@id>
      |QUERY venues_ids <$.Performances[*].Venue.Venue_ID>
      |QUERY venues_names </Events/Exhibition/Venue>
      |QUERY venues_names_json <$.Performance.Name>
      |QUERY lat_json <$.Performances[*].Location.lat>
      |QUERY lat_xml </Events/Exhibition/Location/lat>
      |QUERY long_json <$.Performances[*].Location.long>
      |QUERY long_xml </Events/Exhibition/Location/long>
      |EXPRESSION performances_union <$performances_json.performances UNION $events_xml.events>
      |EXPRESSION venues_union <$performances_json.venues_ids UNION $events_xml.venues_names>
      |EXPRESSION location_union <$performances_json.lat_json + "-" + $performances_json.long_json UNION
      |                             $events_xml.lat_xml + "-" + $events_xml.long_xml>
      |EXPRESSION lat_union <$performances_json.lat_json UNION $events_xml.lat_xml>
      |EXPRESSION long_union <$performances_json.long_json UNION $events_xml.long_xml>
      |
      |ex:Performance ex:[performances_union] {
      |  ex:venue ex:[venues_union] ;
      |  ex:location @ex:Location ;
      |}
      |
      |ex:Location ex:[location_union] {
      |  ex:lat [lat_union] ;
      |#  ex:long [long_union] ;
      |}
    """.stripMargin
  private val mappingLauncher = new MappingLauncher()
  private val output = mappingLauncher.launchMapping(example)
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
