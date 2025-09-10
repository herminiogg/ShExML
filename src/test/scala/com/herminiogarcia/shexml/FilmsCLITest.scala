package com.herminiogarcia.shexml

import com.herminiogarcia.shexml.helper.PicocliLeftAlignedLayout
import org.apache.jena.rdf.model.ModelFactory
import org.scalatest.funsuite.AnyFunSuite
import picocli.CommandLine
import java.io.{ByteArrayInputStream, ByteArrayOutputStream, File}
import scala.util.Try

class FilmsCLITest extends AnyFunSuite {

  private val filepath = "src/test/resources/filmsCLIInput.shexml"

  private val expectedTurtleOutput =
    """@prefix :      <http://example.com/> .
      |@prefix schema: <http://schema.org/> .
      |@prefix dbr:   <http://dbpedia.org/resource/> .
      |@prefix xs:    <http://www.w3.org/2001/XMLSchema#> .
      |
      |:4      a                       schema:Movie ;
      |        :screenwritter          dbr:Jonathan_Nolan , dbr:Christopher_Nolan ;
      |        :year                   2006 ;
      |        schema:countryOfOrigin  dbr:USA ;
      |        schema:director         dbr:Christopher_Nolan ;
      |        schema:musicBy          dbr:David_Julyan ;
      |        schema:name             "The Prestige"@en .
      |
      |:3      a                       schema:Movie ;
      |        :screenwritter          dbr:Christopher_Nolan ;
      |        :year                   2010 ;
      |        schema:countryOfOrigin  dbr:USA ;
      |        schema:director         dbr:Christopher_Nolan ;
      |        schema:musicBy          dbr:Hans_Zimmer ;
      |        schema:name             "Inception"@en .
      |
      |:2      a                       schema:Movie ;
      |        :screenwritter          dbr:Jonathan_Nolan , dbr:Christopher_Nolan ;
      |        :year                   2014 ;
      |        schema:countryOfOrigin  dbr:USA ;
      |        schema:director         dbr:Christopher_Nolan ;
      |        schema:musicBy          dbr:Hans_Zimmer ;
      |        schema:name             "Interstellar"@en .
      |
      |:1      a                       schema:Movie ;
      |        :screenwritter          dbr:Christopher_Nolan ;
      |        :year                   2017 ;
      |        schema:countryOfOrigin  dbr:USA ;
      |        schema:director         dbr:Christopher_Nolan ;
      |        schema:musicBy          dbr:Hans_Zimmer ;
      |        schema:name             "Dunkirk"@en .
      |""".stripMargin

  private val expectedTurtleWithoutInferenceOfDatatypesOutput =
    """@prefix :      <http://example.com/> .
      |@prefix schema: <http://schema.org/> .
      |@prefix dbr:   <http://dbpedia.org/resource/> .
      |@prefix xs:    <http://www.w3.org/2001/XMLSchema#> .
      |
      |:4      a                       schema:Movie ;
      |        :screenwritter          dbr:Jonathan_Nolan , dbr:Christopher_Nolan ;
      |        :year                   "2006" ;
      |        schema:countryOfOrigin  dbr:USA ;
      |        schema:director         dbr:Christopher_Nolan ;
      |        schema:musicBy          dbr:David_Julyan ;
      |        schema:name             "The Prestige"@en .
      |
      |:3      a                       schema:Movie ;
      |        :screenwritter          dbr:Christopher_Nolan ;
      |        :year                   "2010" ;
      |        schema:countryOfOrigin  dbr:USA ;
      |        schema:director         dbr:Christopher_Nolan ;
      |        schema:musicBy          dbr:Hans_Zimmer ;
      |        schema:name             "Inception"@en .
      |
      |:2      a                       schema:Movie ;
      |        :screenwritter          dbr:Jonathan_Nolan , dbr:Christopher_Nolan ;
      |        :year                   "2014" ;
      |        schema:countryOfOrigin  dbr:USA ;
      |        schema:director         dbr:Christopher_Nolan ;
      |        schema:musicBy          dbr:Hans_Zimmer ;
      |        schema:name             "Interstellar"@en .
      |
      |:1      a                       schema:Movie ;
      |        :screenwritter          dbr:Christopher_Nolan ;
      |        :year                   "2017" ;
      |        schema:countryOfOrigin  dbr:USA ;
      |        schema:director         dbr:Christopher_Nolan ;
      |        schema:musicBy          dbr:Hans_Zimmer ;
      |        schema:name             "Dunkirk"@en .
      |""".stripMargin

  private val expectedOpenShaclShapes =
    """@prefix :      <http://example.com/> .
      |@prefix schema: <http://schema.org/> .
      |@prefix rdf:   <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
      |@prefix sh:    <http://www.w3.org/ns/shacl#> .
      |@prefix dbr:   <http://dbpedia.org/resource/> .
      |@prefix xsd:   <http://www.w3.org/2001/XMLSchema#> .
      |@prefix xs:    <http://www.w3.org/2001/XMLSchema#> .
      |
      |:Films  a               sh:NodeShape ;
      |        sh:nodeKind     sh:IRI ;
      |        sh:property     [ sh:maxCount  1 ;
      |                          sh:minCount  1 ;
      |                          sh:nodeKind  sh:IRI ;
      |                          sh:path      schema:director
      |                        ] ;
      |        sh:property     [ sh:languageIn  ( "en" ) ;
      |                          sh:path        schema:name
      |                        ] ;
      |        sh:property     [ sh:maxCount  1 ;
      |                          sh:minCount  1 ;
      |                          sh:nodeKind  sh:IRI ;
      |                          sh:path      schema:musicBy
      |                        ] ;
      |        sh:property     [ sh:maxCount  1 ;
      |                          sh:minCount  1 ;
      |                          sh:nodeKind  sh:IRI ;
      |                          sh:path      schema:countryOfOrigin
      |                        ] ;
      |        sh:property     [ sh:minCount  1 ;
      |                          sh:nodeKind  sh:IRI ;
      |                          sh:path      :screenwritter
      |                        ] ;
      |        sh:property     [ sh:in    ( schema:Movie ) ;
      |                          sh:path  rdf:type
      |                        ] ;
      |        sh:property     [ sh:maxCount  1 ;
      |                          sh:minCount  1 ;
      |                          sh:datatype  xs:string ;
      |                          sh:path      :year
      |                        ] ;
      |        sh:targetClass  schema:Movie .
      |""".stripMargin

  private val expectedClosedShaclShapes = expectedOpenShaclShapes + ":Films sh:closed true ."

  private val expectedRMLOutput =
    """
      |@prefix :      <http://example.com/> .
      |@prefix schema: <http://schema.org/> .
      |@prefix rml:   <http://semweb.mmlab.be/ns/rml#> .
      |@prefix rr:    <http://www.w3.org/ns/r2rml#> .
      |@prefix d2rq:  <http://www.wiwiss.fu-berlin.de/suhl/bizer/D2RQ/0.1#> .
      |@prefix dbr:   <http://dbpedia.org/resource/> .
      |@prefix xs:    <http://www.w3.org/2001/XMLSchema#> .
      |@prefix ql:    <http://semweb.mmlab.be/ns/ql#> .
      |@prefix map:   <http://mapping.example.com/> .
      |
      |map:po_4  a              rr:PredicateObjectMap ;
      |        rr:objectMap     map:o_4 ;
      |        rr:predicateMap  map:p_4 .
      |
      |map:p_3  a           rr:predicateMap ;
      |        rr:constant  schema:name .
      |
      |map:o_11  a          rr:ObjectMap ;
      |        rr:template  "http://dbpedia.org/resource/{crew.screenwritter}" ;
      |        rr:termType  rr:IRI .
      |
      |map:o_3  a           rr:ObjectMap ;
      |        rr:language  "en" ;
      |        rr:template  "{name}" ;
      |        rr:termType  rr:Literal .
      |
      |map:s_2  a           rr:SubjectMap ;
      |        rr:template  "http://example.com/{id}" .
      |
      |map:p_10  a          rr:predicateMap ;
      |        rr:constant  :screenwritter .
      |
      |map:po_9  a              rr:PredicateObjectMap ;
      |        rr:objectMap     map:o_9 ;
      |        rr:predicateMap  map:p_9 .
      |
      |map:po_10  a             rr:PredicateObjectMap ;
      |        rr:objectMap     map:o_10 ;
      |        rr:predicateMap  map:p_10 .
      |
      |map:p_8  a           rr:predicateMap ;
      |        rr:constant  schema:director .
      |
      |map:o_8  a           rr:ObjectMap ;
      |        rr:template  "http://dbpedia.org/resource/{crew/directors/director}" ;
      |        rr:termType  rr:IRI .
      |
      |map:po_3  a              rr:PredicateObjectMap ;
      |        rr:objectMap     map:o_3 ;
      |        rr:predicateMap  map:p_3 .
      |
      |map:p_2  a           rr:predicateMap ;
      |        rr:constant  schema:name .
      |
      |map:o_10  a          rr:ObjectMap ;
      |        rr:template  "http://dbpedia.org/resource/{crew//screenwritter}" ;
      |        rr:termType  rr:IRI .
      |
      |map:o_2  a           rr:ObjectMap ;
      |        rr:language  "en" ;
      |        rr:template  "{name}" ;
      |        rr:termType  rr:Literal .
      |
      |map:l_353498812  a                rml:LogicalSource ;
      |        rml:iterator              "$.films[*]" ;
      |        rml:referenceFormulation  ql:JSONPath ;
      |        rml:source                "https://shexml.herminiogarcia.com/files/films.json" .
      |
      |map:s_1  a           rr:SubjectMap ;
      |        rr:template  "http://example.com/{@id}" .
      |
      |map:m_2  a                     rr:TriplesMap ;
      |        rml:logicalSource      map:l_353498812 ;
      |        rr:predicateObjectMap  map:po_5 , map:po_3 , map:po_13 , map:po_1 , map:po_11 , map:po_9 , map:po_7 ;
      |        rr:subjectMap          map:s_2 .
      |
      |map:po_8  a              rr:PredicateObjectMap ;
      |        rr:objectMap     map:o_8 ;
      |        rr:predicateMap  map:p_8 .
      |
      |map:p_7  a           rr:predicateMap ;
      |        rr:constant  schema:countryOfOrigin .
      |
      |map:o_7  a           rr:ObjectMap ;
      |        rr:template  "http://dbpedia.org/resource/{country}" ;
      |        rr:termType  rr:IRI .
      |
      |map:po_2  a              rr:PredicateObjectMap ;
      |        rr:objectMap     map:o_2 ;
      |        rr:predicateMap  map:p_2 .
      |
      |map:p_1  a           rr:predicateMap ;
      |        rr:constant  <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> .
      |
      |map:l_1572684380  a               rml:LogicalSource ;
      |        rml:iterator              "//film" ;
      |        rml:referenceFormulation  ql:XPath ;
      |        rml:source                "https://shexml.herminiogarcia.com/files/films.xml" .
      |
      |map:o_1  a           rr:ObjectMap ;
      |        rr:template  "http://schema.org/Movie" ;
      |        rr:termType  rr:IRI .
      |
      |map:m_1  a                     rr:TriplesMap ;
      |        rml:logicalSource      map:l_1572684380 ;
      |        rr:predicateObjectMap  map:po_12 , map:po_10 , map:po_4 , map:po_8 , map:po_1 , map:po_6 , map:po_2 ;
      |        rr:subjectMap          map:s_1 .
      |
      |map:po_7  a              rr:PredicateObjectMap ;
      |        rr:objectMap     map:o_7 ;
      |        rr:predicateMap  map:p_7 .
      |
      |map:p_6  a           rr:predicateMap ;
      |        rr:constant  schema:countryOfOrigin .
      |
      |map:o_6  a           rr:ObjectMap ;
      |        rr:template  "http://dbpedia.org/resource/{country}" ;
      |        rr:termType  rr:IRI .
      |
      |map:po_1  a              rr:PredicateObjectMap ;
      |        rr:objectMap     map:o_1 ;
      |        rr:predicateMap  map:p_1 .
      |
      |map:p_13  a          rr:predicateMap ;
      |        rr:constant  schema:musicBy .
      |
      |map:po_13  a             rr:PredicateObjectMap ;
      |        rr:objectMap     map:o_13 ;
      |        rr:predicateMap  map:p_13 .
      |
      |map:po_6  a              rr:PredicateObjectMap ;
      |        rr:objectMap     map:o_6 ;
      |        rr:predicateMap  map:p_6 .
      |
      |map:p_5  a           rr:predicateMap ;
      |        rr:constant  :year .
      |
      |map:o_13  a          rr:ObjectMap ;
      |        rr:template  "http://dbpedia.org/resource/{crew.music}" ;
      |        rr:termType  rr:IRI .
      |
      |map:o_5  a           rr:ObjectMap ;
      |        rr:template  "{year}" ;
      |        rr:termType  rr:Literal .
      |
      |map:p_12  a          rr:predicateMap ;
      |        rr:constant  schema:musicBy .
      |
      |map:po_12  a             rr:PredicateObjectMap ;
      |        rr:objectMap     map:o_12 ;
      |        rr:predicateMap  map:p_12 .
      |
      |map:po_5  a              rr:PredicateObjectMap ;
      |        rr:objectMap     map:o_5 ;
      |        rr:predicateMap  map:p_5 .
      |
      |map:p_4  a           rr:predicateMap ;
      |        rr:constant  :year .
      |
      |map:o_12  a          rr:ObjectMap ;
      |        rr:template  "http://dbpedia.org/resource/{crew/music}" ;
      |        rr:termType  rr:IRI .
      |
      |map:o_4  a           rr:ObjectMap ;
      |        rr:template  "{year}" ;
      |        rr:termType  rr:Literal .
      |
      |map:p_11  a          rr:predicateMap ;
      |        rr:constant  :screenwritter .
      |
      |map:po_11  a             rr:PredicateObjectMap ;
      |        rr:objectMap     map:o_11 ;
      |        rr:predicateMap  map:p_11 .
      |
      |map:p_9  a           rr:predicateMap ;
      |        rr:constant  schema:director .
      |
      |map:o_9  a           rr:ObjectMap ;
      |        rr:template  "http://dbpedia.org/resource/{crew.director}" ;
      |        rr:termType  rr:IRI .
      |""".stripMargin

  private val expectedRMLPrettifiedOutput =
    """
      |@prefix :      <http://example.com/> .
      |@prefix schema: <http://schema.org/> .
      |@prefix rml:   <http://semweb.mmlab.be/ns/rml#> .
      |@prefix rr:    <http://www.w3.org/ns/r2rml#> .
      |@prefix d2rq:  <http://www.wiwiss.fu-berlin.de/suhl/bizer/D2RQ/0.1#> .
      |@prefix dbr:   <http://dbpedia.org/resource/> .
      |@prefix xs:    <http://www.w3.org/2001/XMLSchema#> .
      |@prefix ql:    <http://semweb.mmlab.be/ns/ql#> .
      |@prefix map:   <http://mapping.example.com/> .
      |
      |map:m_2  a                     rr:TriplesMap ;
      |        rml:logicalSource      [ a                         rml:LogicalSource ;
      |                                 rml:iterator              "$.films[*]" ;
      |                                 rml:referenceFormulation  ql:JSONPath ;
      |                                 rml:source                "https://shexml.herminiogarcia.com/files/films.json"
      |                               ] ;
      |        rr:predicateObjectMap  _:b0 ;
      |        rr:predicateObjectMap  [ a                rr:PredicateObjectMap ;
      |                                 rr:objectMap     [ a            rr:ObjectMap ;
      |                                                    rr:template  "{year}" ;
      |                                                    rr:termType  rr:Literal
      |                                                  ] ;
      |                                 rr:predicateMap  [ a            rr:predicateMap ;
      |                                                    rr:constant  :year
      |                                                  ]
      |                               ] ;
      |        rr:predicateObjectMap  [ a                rr:PredicateObjectMap ;
      |                                 rr:objectMap     [ a            rr:ObjectMap ;
      |                                                    rr:template  "http://dbpedia.org/resource/{crew.screenwritter}" ;
      |                                                    rr:termType  rr:IRI
      |                                                  ] ;
      |                                 rr:predicateMap  [ a            rr:predicateMap ;
      |                                                    rr:constant  :screenwritter
      |                                                  ]
      |                               ] ;
      |        rr:predicateObjectMap  [ a                rr:PredicateObjectMap ;
      |                                 rr:objectMap     [ a            rr:ObjectMap ;
      |                                                    rr:template  "http://dbpedia.org/resource/{crew.director}" ;
      |                                                    rr:termType  rr:IRI
      |                                                  ] ;
      |                                 rr:predicateMap  [ a            rr:predicateMap ;
      |                                                    rr:constant  schema:director
      |                                                  ]
      |                               ] ;
      |        rr:predicateObjectMap  [ a                rr:PredicateObjectMap ;
      |                                 rr:objectMap     [ a            rr:ObjectMap ;
      |                                                    rr:language  "en" ;
      |                                                    rr:template  "{name}" ;
      |                                                    rr:termType  rr:Literal
      |                                                  ] ;
      |                                 rr:predicateMap  [ a            rr:predicateMap ;
      |                                                    rr:constant  schema:name
      |                                                  ]
      |                               ] ;
      |        rr:predicateObjectMap  [ a                rr:PredicateObjectMap ;
      |                                 rr:objectMap     [ a            rr:ObjectMap ;
      |                                                    rr:template  "http://dbpedia.org/resource/{crew.music}" ;
      |                                                    rr:termType  rr:IRI
      |                                                  ] ;
      |                                 rr:predicateMap  [ a            rr:predicateMap ;
      |                                                    rr:constant  schema:musicBy
      |                                                  ]
      |                               ] ;
      |        rr:predicateObjectMap  [ a                rr:PredicateObjectMap ;
      |                                 rr:objectMap     [ a            rr:ObjectMap ;
      |                                                    rr:template  "http://dbpedia.org/resource/{country}" ;
      |                                                    rr:termType  rr:IRI
      |                                                  ] ;
      |                                 rr:predicateMap  [ a            rr:predicateMap ;
      |                                                    rr:constant  schema:countryOfOrigin
      |                                                  ]
      |                               ] ;
      |        rr:subjectMap          [ a            rr:SubjectMap ;
      |                                 rr:template  "http://example.com/{id}"
      |                               ] .
      |
      |map:m_1  a                     rr:TriplesMap ;
      |        rml:logicalSource      [ a                         rml:LogicalSource ;
      |                                 rml:iterator              "//film" ;
      |                                 rml:referenceFormulation  ql:XPath ;
      |                                 rml:source                "https://shexml.herminiogarcia.com/files/films.xml"
      |                               ] ;
      |        rr:predicateObjectMap  _:b0 ;
      |        rr:predicateObjectMap  [ a                rr:PredicateObjectMap ;
      |                                 rr:objectMap     [ a            rr:ObjectMap ;
      |                                                    rr:template  "http://dbpedia.org/resource/{country}" ;
      |                                                    rr:termType  rr:IRI
      |                                                  ] ;
      |                                 rr:predicateMap  [ a            rr:predicateMap ;
      |                                                    rr:constant  schema:countryOfOrigin
      |                                                  ]
      |                               ] ;
      |        rr:predicateObjectMap  [ a                rr:PredicateObjectMap ;
      |                                 rr:objectMap     [ a            rr:ObjectMap ;
      |                                                    rr:template  "http://dbpedia.org/resource/{crew/directors/director}" ;
      |                                                    rr:termType  rr:IRI
      |                                                  ] ;
      |                                 rr:predicateMap  [ a            rr:predicateMap ;
      |                                                    rr:constant  schema:director
      |                                                  ]
      |                               ] ;
      |        rr:predicateObjectMap  [ a                rr:PredicateObjectMap ;
      |                                 rr:objectMap     [ a            rr:ObjectMap ;
      |                                                    rr:template  "http://dbpedia.org/resource/{crew/music}" ;
      |                                                    rr:termType  rr:IRI
      |                                                  ] ;
      |                                 rr:predicateMap  [ a            rr:predicateMap ;
      |                                                    rr:constant  schema:musicBy
      |                                                  ]
      |                               ] ;
      |        rr:predicateObjectMap  [ a                rr:PredicateObjectMap ;
      |                                 rr:objectMap     [ a            rr:ObjectMap ;
      |                                                    rr:template  "http://dbpedia.org/resource/{crew//screenwritter}" ;
      |                                                    rr:termType  rr:IRI
      |                                                  ] ;
      |                                 rr:predicateMap  [ a            rr:predicateMap ;
      |                                                    rr:constant  :screenwritter
      |                                                  ]
      |                               ] ;
      |        rr:predicateObjectMap  [ a                rr:PredicateObjectMap ;
      |                                 rr:objectMap     [ a            rr:ObjectMap ;
      |                                                    rr:language  "en" ;
      |                                                    rr:template  "{name}" ;
      |                                                    rr:termType  rr:Literal
      |                                                  ] ;
      |                                 rr:predicateMap  [ a            rr:predicateMap ;
      |                                                    rr:constant  schema:name
      |                                                  ]
      |                               ] ;
      |        rr:predicateObjectMap  [ a                rr:PredicateObjectMap ;
      |                                 rr:objectMap     [ a            rr:ObjectMap ;
      |                                                    rr:template  "{year}" ;
      |                                                    rr:termType  rr:Literal
      |                                                  ] ;
      |                                 rr:predicateMap  [ a            rr:predicateMap ;
      |                                                    rr:constant  :year
      |                                                  ]
      |                               ] ;
      |        rr:subjectMap          [ a            rr:SubjectMap ;
      |                                 rr:template  "http://example.com/{@id}"
      |                               ] .
      |
      |_:b0    a                rr:PredicateObjectMap ;
      |        rr:objectMap     [ a            rr:ObjectMap ;
      |                           rr:template  "http://schema.org/Movie" ;
      |                           rr:termType  rr:IRI
      |                         ] ;
      |        rr:predicateMap  [ a            rr:predicateMap ;
      |                           rr:constant  <http://www.w3.org/1999/02/22-rdf-syntax-ns#type>
      |                         ] .
      |""".stripMargin

  private val expectedShExOutput =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |PREFIX dbr: <http://dbpedia.org/resource/>
      |PREFIX schema: <http://schema.org/>
      |PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
      |
      |:Films IRI {
      |  rdf:type [ schema:Movie ] ;
      |  schema:name [ @en ] ;
      |  :year xs:string  ;
      |  schema:countryOfOrigin [ dbr:~ ]  ;
      |  schema:director [ dbr:~ ]  ;
      |  :screenwritter [ dbr:~ ] + ;
      |  schema:musicBy [ dbr:~ ]  ;
      |}
      |""".stripMargin.trim.replaceAll("\\s+", " ")

  private val expectedShapeMapOutput = ":3@:Films,:4@:Films,:1@:Films,:2@:Films"

  private val precompilationInput =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE films_xml_file <https://shexml.herminiogarcia.com/files/films.xml>
      |SOURCE films_json_file <https://shexml.herminiogarcia.com/files/films.json>
      |IMPORT <src/test/resources/importTestIterators.shexml>
      |EXPRESSION films <films_xml_file.film_xml UNION films_json_file.film_json>
      |
      |:Films :[films.id] {
      |    :type :Film ;
      |    :name [films.name] ;
      |    :year [films.year] xs:gYear ;
      |    :country [films.country] ;
      |    :director [films.directors] ;
      |    :actor @:Actor ;
      |    :actor @:Actress ;
      |}
      |IMPORT <src/test/resources/importTestShapes.shexml>
      |""".stripMargin

  private val expectedPrecompilationOutput =
    """
      |PREFIX : <http://example.com/>
      |PREFIX xs: <http://www.w3.org/2001/XMLSchema#>
      |SOURCE films_xml_file <https://shexml.herminiogarcia.com/files/films.xml>
      |SOURCE films_json_file <https://shexml.herminiogarcia.com/files/films.json>
      |ITERATOR film_xml <xpath: //film> {
      |    FIELD id <@id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <crew/directors/director>
      |    ITERATOR actors <cast/actor> {
      |        FIELD name <name>
      |        FIELD role <role>
      |        FIELD film <../../@id>
      |    }
      |    ITERATOR actresses <cast/actress> {
      |        FIELD name <name>
      |        FIELD role <role>
      |        FIELD film <../../@id>
      |    }
      |}
      |ITERATOR film_json <jsonpath: $.films[*]> {
      |    PUSHED_FIELD id <id>
      |    FIELD name <name>
      |    FIELD year <year>
      |    FIELD country <country>
      |    FIELD directors <crew.director>
      |    ITERATOR actors <cast[*]> {
      |        FIELD name <name>
      |        FIELD role <role>
      |        POPPED_FIELD film <id>
      |    }
      |}
      |EXPRESSION films <films_xml_file.film_xml UNION films_json_file.film_json>
      |
      |:Films :[films.id] {
      |    :type :Film ;
      |    :name [films.name] ;
      |    :year [films.year] xs:gYear ;
      |    :country [films.country] ;
      |    :director [films.directors] ;
      |    :actor @:Actor ;
      |    :actor @:Actress ;
      |}
      |:Actor :[films.actors.name] {
      |    :name [films.actors.name] ;
      |    :appear_on :[films.actors.film] ;
      |}
      |
      |:Actress :[films.actresses.name] {
      |    :name [films.actresses.name] ;
      |    :appear_on :[films.actresses.film] ;
      |}
      |""".stripMargin.trim.replaceAll("\\s+", " ")

  private val expectedDatabaseOutput =
    """
      |@prefix :      <http://example.com/> .
      |@prefix schema: <http://schema.org/> .
      |@prefix dbr:   <http://dbpedia.org/resource/> .
      |@prefix xs:    <http://www.w3.org/2001/XMLSchema#> .
      |
      |:9      :country   "USA" ;
      |        :director  "Christopher Nolan" ;
      |        :name      "Batman Begins"@en ;
      |        :type      :Film ;
      |        :year      "2005"^^xs:gYear .
      |
      |:8      :country   "UK" ;
      |        :director  "Christopher Nolan" ;
      |        :name      "Tenet"@en ;
      |        :type      :Film ;
      |        :year      "2020"^^xs:gYear .
      |""".stripMargin

  private def executeCapturingStdout(f: CommandLine => Unit): String = {
    val byteOutputStream = new ByteArrayOutputStream()
    val picocliCommandLine = new CommandLine(new Main())
      .setPosixClusteredShortOptionsAllowed(false)
      .setHelpFactory(PicocliLeftAlignedLayout.createCustomizedUsageHelp())
    Console.withOut(byteOutputStream) {
      f(picocliCommandLine)
    }
    byteOutputStream.toString
  }

  private def compareTwoRDFModels(model1: String, format1: String, model2: String, format2: String): Boolean = {
    val result = ModelFactory.createDefaultModel()
    result.read(new ByteArrayInputStream(model1.getBytes), null, format1)
    val expectedResult = ModelFactory.createDefaultModel()
    expectedResult.read(new ByteArrayInputStream(model2.getBytes), null, format2)
    result.isIsomorphicWith(expectedResult)
  }

  test("CLI generates Turtle output by default") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath, "-nu", "-id"))
    assert(compareTwoRDFModels(executionResult, "Turtle", expectedTurtleOutput, "Turtle"))
  }

  test("CLI generates Turtle output by default without inference of datatypes") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath, "-nu"))
    assert(compareTwoRDFModels(executionResult, "Turtle", expectedTurtleWithoutInferenceOfDatatypesOutput, "Turtle"))
  }

  test("CLI generates non valid Turtle file when not using the normalise URIs option") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath))
    val result = ModelFactory.createDefaultModel()
    val parsingResult = Try(result.read(new ByteArrayInputStream(executionResult.getBytes), null, "Turtle"))
    assert(parsingResult.isFailure)
  }

  test("CLI generates expected Turtle output when run in parallel") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath, "-nu", "-id", "--parallel"))
    assert(compareTwoRDFModels(executionResult, "Turtle", expectedTurtleOutput, "Turtle"))
  }

  test("CLI generates expected Turtle output when run in parallel, all aspect option and number of threads 10") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath, "-nu", "-id", "--parallel", "--parallelAspects", "all", "--nThreads", "10"))
    assert(compareTwoRDFModels(executionResult, "Turtle", expectedTurtleOutput, "Turtle"))
  }

  test("CLI generates expected Turtle output when run in parallel, shapes aspect option and number of threads 20") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath, "-nu", "-id", "--parallel", "--parallelAspects", "shapes", "--nThreads", "10"))
    assert(compareTwoRDFModels(executionResult, "Turtle", expectedTurtleOutput, "Turtle"))
  }

  test("CLI generates expected Turtle output when run in parallel, queries aspect option") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath, "-nu", "-id", "--parallel", "--parallelAspects", "queries"))
    assert(compareTwoRDFModels(executionResult, "Turtle", expectedTurtleOutput, "Turtle"))
  }

  test("CLI outputs to a file") {
    executeCapturingStdout(cl => cl.execute("-m", filepath, "-nu", "-id", "-o", "testOutput.ttl"))
    val file = scala.io.Source.fromFile(new File("testOutput.ttl"))
    assert(compareTwoRDFModels(file.mkString, "Turtle", expectedTurtleOutput, "Turtle"))
    file.close()
  }

  test("CLI generates RDF/XML output") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath, "-nu", "-id", "-f", "RDF/XML"))
    assert(compareTwoRDFModels(executionResult, "RDF/XML", expectedTurtleOutput, "Turtle"))
  }

  test("CLI generates SHACL open shapes output") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath, "-sh"))
    assert(compareTwoRDFModels(executionResult, "Turtle", expectedOpenShaclShapes, "Turtle"))
  }

  test("CLI generates SHACL closed shapes output") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath, "-shc"))
    assert(compareTwoRDFModels(executionResult, "Turtle", expectedClosedShaclShapes, "Turtle"))
  }

  test("CLI generates RML output") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath, "-r"))
    assert(compareTwoRDFModels(executionResult, "Turtle", expectedRMLOutput, "Turtle"))
  }

  test("CLI generates prettified RML output") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath, "-rp"))
    assert(compareTwoRDFModels(executionResult, "Turtle", expectedRMLPrettifiedOutput, "Turtle"))
  }

  test("CLI generates ShEx output") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath, "-s"))
    assert(executionResult.stripMargin.trim.replaceAll("\\s+", " ") == expectedShExOutput)
  }

  test("CLI generates ShapeMap output") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", filepath, "-sm"))
    assert(executionResult.stripMargin.trim.replaceAll("\\s+", " ") == expectedShapeMapOutput)
  }

  test("CLI precompiles ShExML file from stdin") {
    val byteInputStream = new ByteArrayInputStream(precompilationInput.getBytes())
    System.setIn(byteInputStream)
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", "-", "-pc"))
    System.setIn(System.in)
    assert(executionResult.stripMargin.trim.replaceAll("\\s+", " ") == expectedPrecompilationOutput)
  }

  test("CLI generates expected output from a database") {
    val executionResult = executeCapturingStdout(cl => cl.execute("-m", "src/test/resources/databaseTestInput.shexml", "-u", "root", "-p", "root"))
    assert(compareTwoRDFModels(executionResult, "Turtle", expectedDatabaseOutput, "Turtle"))
  }

}
