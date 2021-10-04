package es.weso.shexml.shex

import org.scalatest.FunSuite

/**
  * Created by herminio on 21/2/18.
  */
class JsonAndXmlEventsMapping extends FunSuite with ShExValidation {

  private val example =
    """
      |PREFIX ex: <http://ex.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE performances_json <https://cdn.rawgit.com/herminiogg/ShExML/f1fa70f6/src/test/resources/events.json>
      |SOURCE events_xml <https://cdn.rawgit.com/herminiogg/ShExML/f1fa70f6/src/test/resources/events.xml>
      |ITERATOR performances_iterator <jsonpath: $.Performances[*]> {
      |   FIELD performances_ids <Perf_ID>
      |   FIELD venues_ids <Venue.Venue_ID>
      |   FIELD venues_names_json <Name>
      |   FIELD lat_json <Location.lat>
      |   FIELD long_json <Location.long>
      |}
      |ITERATOR events_iterator <xpath: /Events/Exhibition> {
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
  private val shapeMap = "ex:51.043613-3.717333@ex:Location, ex:51.043611-3.717222@ex:Location, ex:51.076891-3.717222@ex:Location," +
    "ex:398@ex:Performance, ex:567@ex:Performance, ex:444@ex:Performance, ex:989@ex:Performance"

  test("Events validate against created schema") {
    assert(this.validate(example, shapeMap))
  }

}
