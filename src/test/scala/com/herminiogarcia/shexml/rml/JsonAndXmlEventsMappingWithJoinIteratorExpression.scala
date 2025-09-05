package com.herminiogarcia.shexml.rml

import com.herminiogarcia.shexml.{ParallelConfigInferenceDatatypesNormaliseURIsFixture, RDFStatementCreator}
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.Model
import org.scalatest.ConfigMap
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

/**
  * Created by herminio on 21/2/18.
  */
class JsonAndXmlEventsMappingWithJoinIteratorExpression extends AnyFunSuite
  with Matchers with RDFStatementCreator
  with ParallelConfigInferenceDatatypesNormaliseURIsFixture with RMLTestConversion {

  val example =
    """
      |PREFIX ex: <http://ex.com/>
      |SOURCE performances_json <https://raw.githubusercontent.com/herminiogg/ShExML/master/src/test/resources/events.json>
      |SOURCE events_xml <https://raw.githubusercontent.com/herminiogg/ShExML/master/src/test/resources/events.xml>
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
      |EXPRESSION venues_union <performances_json.performances_iterator.venues_names UNION events_xml.events_iterator.venues_names SUBSTITUTING performances_json.performances_iterator.venues_names_json>
      |
      |ex:Performance ex:[performances.ids] {
      |  ex:venue ex:[venues_union] ;
      |  ex:location @ex:Location ;
      |}
      |
      |ex:Location ex:[location_union] {
      |  ex:lat [performances.lat] ;
      |  ex:long [performances.long] ;
      |}
    """.stripMargin

  private var output: Model = _
  private val prefix = "http://ex.com/"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    val result = mappingLauncher.launchRMLTranslation(example)
    output = doTranslation(result, prefix).getDefaultModel
  }

  test("Location shape is translated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "51.043613-3.717333", "lat", "51.043613", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "51.043613-3.717333", "long", "3.717333", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "51.043611-3.717222", "lat", "51.043611", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "51.043611-3.717222", "long", "3.717222", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "51.076891-3.717222", "lat", "51.076891", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "51.076891-3.717222", "long", "3.717222", XSDDatatype.XSDstring)))
  }

  test("Venue is translated correctly") {
    assert(output.contains(createStatement(prefix, "398", "venue", "78")))
    assert(output.contains(createStatement(prefix, "567", "venue", "78")))
 //   assert(output.contains(createStatement(prefix, "444", "venue", "STOM"))) // join not working as in ShExML
    assert(output.contains(createStatement(prefix, "989", "venue", "68")))
  }

  test("Location shape is linked correctly in venue shape") {
    assert(output.contains(createStatement(prefix, "398", "location", "51.076891-3.717222")))
    assert(output.contains(createStatement(prefix, "567", "location", "51.043611-3.717222")))
    assert(output.contains(createStatement(prefix, "444", "location", "51.076891-3.717222")))
    assert(output.contains(createStatement(prefix, "989", "location", "51.043613-3.717333")))
  }

}
