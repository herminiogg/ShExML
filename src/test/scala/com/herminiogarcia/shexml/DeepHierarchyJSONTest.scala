package com.herminiogarcia.shexml

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class DeepHierarchyJSONTest extends AnyFunSuite with Matchers with RDFStatementCreator {

  private val example =
    """
      PREFIX : <http://example.com/>
      |SOURCE test_file <https://raw.githubusercontent.com/herminiogg/ShExML/bug-%23113/src/test/resources/deepHierarchy.json>
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
      |                            FIELD id <id>
      |                            ITERATOR tag <tag[*]> {
      |                                FIELD id <id>
      |                                ITERATOR tag <tag[*]> {
      |                                    FIELD id <id>
      |                                    ITERATOR tag <tag[*]> {
      |                                        FIELD id <id>
      |                                        FIELD tag <tag>
      |                                    }
      |                                }
      |                            }
      |                        }
      |                    }
      |                }
      |            }
      |        }
      |    }
      |}
      |EXPRESSION tag <test_file.first_tag>
      |
      |:tag1 :[tag.id] {
      |    :nested @:tag2 ;
      |}
      |
      |:tag2 :[tag.tag.id] {
      |    :nested @:tag3 ;
      |}
      |
      |:tag3 :[tag.tag.tag.id] {
      |    :nested @:tag4 ;
      |}
      |
      |:tag4 :[tag.tag.tag.tag.id] {
      |    :nested @:tag5 ;
      |}
      |
      |:tag5 :[tag.tag.tag.tag.tag.id] {
      |    :nested @:tag6 ;
      |}
      |
      |:tag6 :[tag.tag.tag.tag.tag.tag.id] {
      |    :nested @:tag7 ;
      |}
      |
      |:tag7 :[tag.tag.tag.tag.tag.tag.tag.id] {
      |    :nested @:tag8 ;
      |}
      |
      |:tag8 :[tag.tag.tag.tag.tag.tag.tag.tag.id] {
      |    :nested @:tag9 ;
      |}
      |
      |:tag9 :[tag.tag.tag.tag.tag.tag.tag.tag.tag.id] {
      |    :nested @:tag10 ;
      |}
      |
      |:tag10 :[tag.tag.tag.tag.tag.tag.tag.tag.tag.tag.id] {
      |    :tag [tag.tag.tag.tag.tag.tag.tag.tag.tag.tag.tag] ;
      |}
    """.stripMargin
  private val mappingLauncher = new MappingLauncher(inferenceDatatype = true, normaliseURIs = true)
  private val output = mappingLauncher.launchMapping(example).getDefaultModel
  private val prefix = "http://example.com/"

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

  test("No additional triples are generated") {
    val triplesCount = 30
    assert(output.size() == triplesCount)
  }

}
