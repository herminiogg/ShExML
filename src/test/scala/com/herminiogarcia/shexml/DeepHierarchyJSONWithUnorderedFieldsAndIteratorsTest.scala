package com.herminiogarcia.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.Model
import org.scalatest.ConfigMap
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class DeepHierarchyJSONWithUnorderedFieldsAndIteratorsTest extends AnyFunSuite
  with Matchers with RDFStatementCreator
  with ParallelConfigNormaliseURIsFixture {

  private val example =
    """
      PREFIX : <http://example.com/>
      |SOURCE test_file <src/test/resources/deepHierarchyTwoAttributes.json>
      |ITERATOR first_tag <jsonpath: $.tags[*]> {
      |    FIELD id <id>
      |    ITERATOR tag <tag[*]> {
      |        FIELD id <id>
      |        ITERATOR tag <tag[*]> {
      |            FIELD id <id>
      |            ITERATOR tag <tag[*]> {
      |                FIELD id <id>
      |                ITERATOR tag <tag[*]> {
      |                    FIELD id <id>
      |                    ITERATOR tag <tag[*]> {
      |                        FIELD id <id>
      |                        ITERATOR tag <tag[*]> {
      |                            ITERATOR tag <tag[*]> {
      |                                FIELD id <id>
      |                                ITERATOR tag <tag[*]> {
      |                                    FIELD id <id>
      |                                    ITERATOR tag <tag[*]> {
      |                                        FIELD id <id>
      |                                        FIELD id2 <id2>
      |                                        FIELD tag <tag>
      |                                    }
      |                                    FIELD id2 <id2>
      |                                }
      |                                FIELD id2 <id2>
      |                            }
      |                            FIELD id2 <id2>
      |                            FIELD id <id>
      |                        }
      |                        FIELD id2 <id2>
      |                    }
      |                    FIELD id2 <id2>
      |                }
      |                FIELD id2 <id2>
      |            }
      |            FIELD id2 <id2>
      |        }
      |        FIELD id2 <id2>
      |    }
      |    FIELD id2 <id2>
      |}
      |EXPRESSION tag <test_file.first_tag>
      |
      |:tag1 :[tag.id] {
      |    :nested @:tag2 ;
      |    :value [tag.id2] ;
      |}
      |
      |:tag2 :[tag.tag.id] {
      |    :nested @:tag3 ;
      |    :value [tag.tag.id2] ;
      |}
      |
      |:tag3 :[tag.tag.tag.id] {
      |    :nested @:tag4 ;
      |    :value [tag.tag.tag.id2] ;
      |}
      |
      |:tag4 :[tag.tag.tag.tag.id] {
      |    :value [tag.tag.tag.tag.id2] ;
      |    :nested @:tag5 ;
      |}
      |
      |:tag5 :[tag.tag.tag.tag.tag.id] {
      |    :nested @:tag6 ;
      |    :value [tag.tag.tag.tag.tag.id2] ;
      |}
      |
      |:tag6 :[tag.tag.tag.tag.tag.tag.id] {
      |    :value [tag.tag.tag.tag.tag.tag.id2] ;
      |    :nested @:tag7 ;
      |}
      |
      |:tag7 :[tag.tag.tag.tag.tag.tag.tag.id] {
      |    :value [tag.tag.tag.tag.tag.tag.tag.id2] ;
      |    :nested @:tag8 ;
      |}
      |
      |:tag8 :[tag.tag.tag.tag.tag.tag.tag.tag.id] {
      |    :value [tag.tag.tag.tag.tag.tag.tag.tag.id2] ;
      |    :nested @:tag9 ;
      |}
      |
      |:tag9 :[tag.tag.tag.tag.tag.tag.tag.tag.tag.id] {
      |    :value [tag.tag.tag.tag.tag.tag.tag.tag.tag.id2] ;
      |    :nested @:tag10 ;
      |}
      |
      |:tag10 :[tag.tag.tag.tag.tag.tag.tag.tag.tag.tag.id] {
      |    :value [tag.tag.tag.tag.tag.tag.tag.tag.tag.tag.id2] ;
      |    :tag [tag.tag.tag.tag.tag.tag.tag.tag.tag.tag.tag] ;
      |}
    """.stripMargin

  private var output: Model = _
  private val prefix = "http://example.com/"

  override def beforeAll(configMap: ConfigMap): Unit = {
    super.beforeAll(configMap)
    output = mappingLauncher.launchMapping(example).getDefaultModel
  }

  test("Shapes are linked correctly") {
    assert(output.contains(createStatement(prefix, "1", "nested", "2")))
    assert(output.contains(createStatement(prefix, "2", "nested", "3")))
    assert(output.contains(createStatement(prefix, "3", "nested", "4")))
    assert(output.contains(createStatement(prefix, "4", "nested", "5")))
    assert(output.contains(createStatement(prefix, "5", "nested", "6")))
    assert(output.contains(createStatement(prefix, "6", "nested", "7")))
    assert(output.contains(createStatement(prefix, "7", "nested", "8")))
    assert(output.contains(createStatement(prefix, "8", "nested", "9")))
    assert(output.contains(createStatement(prefix, "9", "nested", "10")))
    assert(output.contains(createStatement(prefix, "1b", "nested", "2b")))
    assert(output.contains(createStatement(prefix, "2b", "nested", "3b")))
    assert(output.contains(createStatement(prefix, "3b", "nested", "4b")))
    assert(output.contains(createStatement(prefix, "4b", "nested", "5b")))
    assert(output.contains(createStatement(prefix, "5b", "nested", "6b")))
    assert(output.contains(createStatement(prefix, "6b", "nested", "7b")))
    assert(output.contains(createStatement(prefix, "7b", "nested", "8b")))
    assert(output.contains(createStatement(prefix, "8b", "nested", "9b")))
    assert(output.contains(createStatement(prefix, "9b", "nested", "10b")))
    assert(output.contains(createStatement(prefix, "1c", "nested", "2c")))
    assert(output.contains(createStatement(prefix, "2c", "nested", "3c")))
    assert(output.contains(createStatement(prefix, "3c", "nested", "4c")))
    assert(output.contains(createStatement(prefix, "4c", "nested", "5c")))
    assert(output.contains(createStatement(prefix, "5c", "nested", "6c")))
    assert(output.contains(createStatement(prefix, "6c", "nested", "7c")))
    assert(output.contains(createStatement(prefix, "7c", "nested", "8c")))
    assert(output.contains(createStatement(prefix, "8c", "nested", "9c")))
    assert(output.contains(createStatement(prefix, "9c", "nested", "10c")))
  }

  test("End is reached correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "10", "tag", "END", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "10b", "tag", "END-B", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "10c", "tag", "END-C", XSDDatatype.XSDstring)))
  }

  test("Rest of the fields are generated correctly") {
    assert(output.contains(createStatementWithLiteral(prefix, "1", "value", "12", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2", "value", "22", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3", "value", "32", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4", "value", "42", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "5", "value", "52", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "6", "value", "62", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "7", "value", "72", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "8", "value", "82", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "9", "value", "92", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "10", "value", "102", XSDDatatype.XSDstring)))

    assert(output.contains(createStatementWithLiteral(prefix, "1b", "value", "1b2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2b", "value", "2b2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3b", "value", "3b2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4b", "value", "4b2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "5b", "value", "5b2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "6b", "value", "6b2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "7b", "value", "7b2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "8b", "value", "8b2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "9b", "value", "9b2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "10b", "value", "10b2", XSDDatatype.XSDstring)))

    assert(output.contains(createStatementWithLiteral(prefix, "1c", "value", "1c2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "2c", "value", "2c2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "3c", "value", "3c2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "4c", "value", "4c2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "5c", "value", "5c2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "6c", "value", "6c2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "7c", "value", "7c2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "8c", "value", "8c2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "9c", "value", "9c2", XSDDatatype.XSDstring)))
    assert(output.contains(createStatementWithLiteral(prefix, "10c", "value", "10c2", XSDDatatype.XSDstring)))
  }

  test("No additional triples are generated") {
    val triplesCount = 60
    assert(output.size() == triplesCount)
  }

}
