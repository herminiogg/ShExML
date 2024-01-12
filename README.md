# ShExML
![Master build](https://github.com/herminiogg/shexml/actions/workflows/scala.yml/badge.svg?branch=master)
![Maven Central](https://img.shields.io/maven-central/v/com.herminiogarcia/shexml_3?color=blue)

Shape Expressions Mapping Language (ShExML) is a DSL that offers a solution
for mapping and merging heterogeneous data sources. As being based on ShEx the
shape is the main foundation to define the transformations.

## Example
```
PREFIX : <http://example.com/>
SOURCE films_xml_file <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.xml>
SOURCE films_json_file <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.json>
ITERATOR film_xml <xpath: //film> {
    FIELD id <@id>
    FIELD name <name>
    FIELD year <year>
    FIELD country <country>
    FIELD directors <directors/director>
}
ITERATOR film_json <jsonpath: $.films[*]> {
    FIELD id <id>
    FIELD name <name>
    FIELD year <year>
    FIELD country <country>
    FIELD directors <director>
}
EXPRESSION films <films_xml_file.film_xml UNION films_json_file.film_json>

:Films :[films.id] {
    :name [films.name] ;
    :year [films.year] ;
    :country [films.country] ;
    :director [films.directors] ;
}
```
This example shows how to map and merge two files (in JSON and XML) with different films. In the first part, the
declarations, we can define some 'variables' that can be used inside the shapes. Prefixes used in the resulting RDF,
sources to the files, iterators and fields (queries) to be applied over the files and expressions to merge and transform the queries results.
Then, the shapes are defined as in ShEx but using the previously defined expressions or composing them inside the
square brackets. More complex example can be seen under the ````films.shexml```` file.

## Features
* XML support (using XPath queries)
* JSON support (using JSONPath queries)
* CSV and TSV support
* Relational databases, with following included drivers
    + MySQL
    + SQLite
    + PostgreSQL
    + MariaDB
    + SQLServer
* Matchers
* Joins
* Named graphs
* Autoincrement ids

The full specification with all the supported features and examples can be consulted [here](https://shexml.herminiogarcia.com/spec/).

## Usage

### CLI
A command line interface is offered under the jar library with the following options available:
```
Usage: ShExML [-hrsV] [-id] [-nu] [-rp] [-sh] [-shc] [-sm] [-d=<drivers>]
              [-f=<format>] -m=<file> [-o=<output>] [-p=<password>]
              [-u=<username>]
Map and merge heterogeneous data sources with a Shape Expressions based syntax
  -d, --drivers=<drivers>    Add more JDBC database drivers in the form of
                               <startJDBCURL>%<driver> and separating them with
                               ";". Example: jdbc:postgresql%org.postgresql.
                               Driver;jdbc:oracle%oracle.jdbc.OracleDriver
  -f, --format=<format>      Output format for RDF graph. Turtle, RDF/XML,
                               N-Triples, ...
  -h, --help                 Show this help message and exit.
      -id, --inferenceDatatypes
                             Use the inference system for choosing the best
                               suited datatype for the generated literal.
                               Without this option, and not declaring a
                               datatype in the mapping rules, all the literals
                               will be outputted as strings
  -m, --mapping=<file>       Path to the file with the mappings
      -nu, --normaliseURIs   Activate the URI normalisation system which allows
                               to avoid malformed URIs when using strings for
                               URI creation
  -o, --output=<output>      Path where the output file should be created
  -p, --password=<password>  Password in case of using a database
  -r, --rml                  Generate RML output
      -rp, --rmlPrettified   Generate RML output using Blank nodes for better
                               readability
  -s, --shex                 Generate ShEx validation
      -sh, --shacl           Generate SHACL validation
      -shc, --shaclClosed    Generate SHACL validation with closed shapes as
                               default
      -sm, --shapeMap        Generate Shape Map for ShEx validation
  -u, --username=<username>  Username in case of using a database
  -V, --version              Print version information and exit.
```
Therefore, to execute the films example: ```java -jar shexml.jar -m films.shexml```

### JVM compatible API
ShExML is coded in Scala and, because of that, it can be used with JVM compatible languages. See the example below 
on how to use the programmatic API.
```
val file = scala.io.Source.fromFile(pathToFile).mkString
val mappingLauncher = new MappingLauncher()
val output = mappingLauncher.launchMapping(file, "TURTLE")
```

### Webpage
A live playground is also offered online (http://shexml.herminiogarcia.com). However, due to hardware limitations it is not 
intended for intensive use.

### Citation
This tool is part of a scientific project which has led to different publications. The main and preferred publication for citation is:
```
García-González, H., Boneva, I., Staworko, S., Labra-Gayo, J. E., & Lovelle, J. M. C. (2020). 
ShExML: improving the usability of heterogeneous data mapping languages for first-time users. 
PeerJ Computer Science, 6, e318.
```

Other possible publications per topic are:
* Translation from ShExML to RML
```
García-González, H., & Dimou, A. (2022, September). Why to tie to a single data mapping language? 
enabling a transformation from shexml to rml. In Proceedings of Poster and Demo Track and Workshop 
Track of the 18th International Conference on Semantic Systems co-located with 18th International 
Conference on Semantic Systems (SEMANTiCS 2022) (Vol. 3235, pp. paper-11).
```
* Addressing mapping challenges with ShExML
```
García-González, H. (2021, June). A ShExML perspective on mapping challenges: already solved ones, 
language modifications and future required actions. In 2nd International Workshop on Knowledge Graph 
Construction co-located with 18th Extended Semantic Web Conference (ESWC 2021), Online, June 6, 2021, 
CEUR Workshop Proceedings (vol. 2873)
```
* Inception poster
```
Garcia-Gonzalez, H., Fernandez-Alvarez, D., & Gayo, J. E. L. (2018). ShExML: An Heterogeneous Data 
Mapping Language based on ShEx. In EKAW (Posters & Demos) (pp. 9-12).
```
