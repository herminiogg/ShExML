package com.herminiogarcia.shexml.rml

import com.herminiogarcia.shexml.{MappingLauncher, RDFStatementCreator}
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by herminio on 21/2/18.
  */
class JsonAndXmlEventsMappingWithExternalQuery extends FunSuite with Matchers with RDFStatementCreator with RMLTestConversion {

  private val example =
    """
      |PREFIX ex: <http://ex.com/>
      |SOURCE performances_json <https://raw.githubusercontent.com/herminiogg/ShExML/master/src/test/resources/events.json>
      |SOURCE events_xml <https://raw.githubusercontent.com/herminiogg/ShExML/master/src/test/resources/events.xml>
      |QUERY performances_query <jsonpath: $.Performances[*]>
      |QUERY events_query <xpath: /Events/Exhibition>
      |ITERATOR performances_iterator <performances_query> {
      |   FIELD performances_ids <Perf_ID>
      |   FIELD venues_ids <Venue.Venue_ID>
      |   FIELD venues_names_json <Name>
      |   FIELD lat_json <Location.lat>
      |   FIELD long_json <Location.long>
      |}
      |ITERATOR events_iterator <events_query> {
      |   FIELD events_ids <@id>
      |   FIELD venues_names <Venue>
      |   FIELD lat_xml <Location/lat>
      |   FIELD long_xml <Location/long>
      |}
      |EXPRESSION performances_union <performances_json.performances_iterator.performances_ids UNION events_xml.events_iterator.events_ids>
      |EXPRESSION venues_union <performances_json.performances_iterator.venues_ids UNION events_xml.events_iterator.venues_names>
      |EXPRESSION location_union <performances_json.performances_iterator.lat_json + "-" + performances_json.performances_iterator.long_json UNION
      |                             events_xml.events_iterator.lat_xml + "-" + events_xml.events_iterator.long_xml>
      |EXPRESSION lat_union <performances_json.performances_iterator.lat_json UNION events_xml.events_iterator.lat_xml>
      |EXPRESSION long_union <performances_json.performances_iterator.long_json UNION events_xml.events_iterator.long_xml>
      |
      |ex:Performance ex:[performances_union] {
      |  ex:venue ex:[venues_union] ;
      |  ex:location @ex:Location ;
      |}
      |
      |ex:Location ex:[location_union] {
      |  ex:lat [lat_union] ;
      |  ex:long [long_union] ;
      |}
    """.stripMargin
  private val mappingLauncher = new MappingLauncher()
  private val result = mappingLauncher.launchRMLTranslation(example)
  private val prefix = "http://ex.com/"
  private val output = doTranslation(result, prefix).getDefaultModel

  test("Location shape is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "51.043613-3.717333", "lat", "51.043613", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "51.043613-3.717333", "long", "3.717333", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "51.043611-3.717222", "lat", "51.043611", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "51.043611-3.717222", "long", "3.717222", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "51.076891-3.717222", "lat", "51.076891", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "51.076891-3.717222", "long", "3.717222", XSDDatatype.XSDstring)))
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
