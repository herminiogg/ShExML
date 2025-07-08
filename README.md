# ShExML
[![Master build](https://github.com/herminiogg/shexml/actions/workflows/scala.yml/badge.svg?branch=master)](https://github.com/herminiogg/ShExML/actions/workflows/scala.yml?query=branch%3Amaster)
[![Maven Central](https://img.shields.io/maven-central/v/com.herminiogarcia/shexml_3?color=blue)](https://central.sonatype.com/artifact/com.herminiogarcia/shexml_3)
[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.11577338.svg)](https://doi.org/10.5281/zenodo.11577338)
[![SWH](https://archive.softwareheritage.org/badge/origin/https://github.com/herminiogg/ShExML/)](https://archive.softwareheritage.org/browse/origin/?origin_url=https://github.com/herminiogg/ShExML)

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
Usage: ShExML [-h] [-id] [-nu] [-V] [-d=<drivers>] [-f=<format>] -m=<file>
              [-o=<output>] [-p=<password>] [-u=<username>] [-pc | -r | -rp |
              -s | -sm | -sh | -shc]
Map and merge heterogeneous data sources with a Shape Expressions based syntax
  -m, --mapping=<file>         Path to the file with the mappings
  -h, --help                   Show this help message and exit.
  -V, --version                Print version information and exit.
Options for the transformation to RDF
  -id, --inferenceDatatypes    Use the inference system for choosing the best
                                 suited datatype for the generated literal.
                                 Without this option, and not declaring a
                                 datatype in the mapping rules, all the
                                 literals will be outputted as strings
  -nu, --normaliseURIs         Activate the URI normalisation system which
                                 allows to avoid malformed URIs when using
                                 strings for URI creation
  -f, --format=<format>        Output format for RDF graph. Turtle, RDF/XML,
                                 N-Triples, ...
Other transformation options
  -pc, --precompile            Create a single version including all the
                                 imported files, useful for debugging purposes.
                                 Additionally it checks the input for syntactic
                                 and grammatical errors
  -r, --rml                    Generate RML output
  -rp, --rmlPrettified         Generate RML output using Blank nodes for better
                                 readability
  -s, --shex                   Generate ShEx validation
  -sm, --shapeMap              Generate Shape Map for ShEx validation
  -sh, --shacl                 Generate SHACL validation
  -shc, --shaclClosed          Generate SHACL validation with closed shapes as
                                 default
General configuration options applying to all the available transformations
  -o, --output=<output>        Path where the output file should be created
  -u, --username=<username>    Username in case of using a database
  -p, --password=<password>    Password in case of using a database
  -d, --drivers=<drivers>      Add more JDBC database drivers in the form of
                                 <startJDBCURL>%<driver> and separating them
                                 with ";". Example: jdbc:postgresql%org.
                                 postgresql.Driver;jdbc:oracle%oracle.jdbc.
                                 OracleDriver
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
### Requirements
The minimal versions for this software to work are:
- JDK 17, or the Open JDK 17. (Versions matching earlier JDK version can be generated following the [Build](#build) instructions or provided upon request.) 
- Scala 2.12.17
- SBT 1.7.2

### Webpage
A live playground is also offered online (http://shexml.herminiogarcia.com). However, due to hardware limitations it is not 
intended for intensive use.

### Citation
This tool is part of a scientific project which has led to different publications. The main and preferred publication for citation is:
```
García-González, H., Boneva, I., Staworko, S., Labra-Gayo, J. E., & Lovelle, J. M. C. (2020). 
ShExML: improving the usability of heterogeneous data mapping languages for first-time users. 
PeerJ Computer Science, 6, e318. https://doi.org/10.7717/peerj-cs.318
```

Other possible publications per topic are:
* Optimisatin of the ShExML engine
```
García-González, H. (2025). Optimising the ShExML engine through code profiling: From turtle’s pace 
to state-of-the-art performance. Semantic Web, (Preprint), 1-30. https://doi.org/10.3233/SW-243736
```
* Translation from ShExML to RML
```
García-González, H., & Dimou, A. (2022, September). Why to tie to a single data mapping language? 
enabling a transformation from shexml to rml. In Proceedings of Poster and Demo Track and Workshop 
Track of the 18th International Conference on Semantic Systems co-located with 18th International 
Conference on Semantic Systems (SEMANTiCS 2022) (Vol. 3235, pp. paper-11). 
https://ceur-ws.org/Vol-3235/paper11.pdf
```
* Addressing mapping challenges with ShExML
```
García-González, H. (2021, June). A ShExML perspective on mapping challenges: already solved ones, 
language modifications and future required actions. In 2nd International Workshop on Knowledge Graph 
Construction co-located with 18th Extended Semantic Web Conference (ESWC 2021), Online, June 6, 2021, 
CEUR Workshop Proceedings (vol. 2873). http://ceur-ws.org/Vol-2873/paper2.pdf
```
* Inception poster
```
Garcia-Gonzalez, H., Fernandez-Alvarez, D., & Gayo, J. E. L. (2018). ShExML: An Heterogeneous Data 
Mapping Language based on ShEx. In EKAW (Posters & Demos) (pp. 9-12). https://ceur-ws.org/Vol-2262/ekaw-poster-08.pdf
```

### Build
The library uses sbt as the package manager and building tool, therefore to compile the project you can use the following command:
```
$ sbt compile
```
To run the project from within sbt you can use the command below, where `<options>` can be replaced by the arguments explained in the [CLI](#cli)
```
$ sbt "run <options>"
```
To generate an executable JAR file you can call the following command. Take into account that if you want to test the library before
generating the artifact you need to set up the testing environment as explained in the [Testing](#testing) section. Alternatively, you can use 
the `"set test in assembly := {}"` option to omit the tests during the build process.
```
$ sbt "set test in assembly := {}" clean update assembly
```
### Testing
The project contains a full suite of tests that checks that all the features included in the engine work as expected. These
tests units are included under the src/test/scala folder. To run them you can use the command below. Notice that it is of utmost
importance to test that the project pass the test for all the cross-compiled versions used within the project 
(see the [Cross-compilation](#cross-compilation) section for more details).
```
$ sbt test
```
The test environment uses some external resources that need to be set up before running them. This mainly involves starting 
a MySQL/MariaDB and a PostreSQL database, creating the relational schema and filling the tables up with the dummy data. This process is
enclosed in a Docker contain and can be set up using the following command:
```
$ docker compose up -d
```

### Cross-compilation
The project is enabled to work with three different versions of Scala (i.e., 2.12.x, 2.13.x and 3.x) so it can be used across different
Scala environments. Therefore, all the commands will work by default with the 3.x version but it is possible to run the same command 
for all the versions at the same time or just for one specific version. Below you can see how to do so with the test command.

Testing against all the cross-compiled versions:
```
$ sbt "+ test"
```

Testing against a specific version where `<version>` is one of the configured versions in the build.sbt file:
```
$ sbt "++<version> test"
```

### Dependencies
The following dependencies are used by this library:

| Dependency                                 | License                                 |
|--------------------------------------------|-----------------------------------------|
| org.antlr / antlr4                         | BSD-3-Clause                            |
| net.sf.saxon / Saxon-HE                    | MPL-2.0                                 |
| org.apache.jena / jena-base                | Apache License 2.0                      |
| org.apache.jena / jena-core                | Apache License 2.0                      |
| org.apache.jena / jena-arq                 | Apache License 2.0                      |
| org.apache.jena / jena-shacl               | Apache License 2.0                      |
| info.picocli / picocli                     | Apache License 2.0                      |
| org.slf4j / slf4j-nop                      | MIT License                             |
| com.github.tototoshi / scala-csv           | Apache License 2.0                      |
| org.xerial / sqlite-jdbc                   | Apache License 2.0                      |
| mysql / mysql-connector-java               | GPL-v2 (Universal FOSS Exception v1)    |
| org.postgresql / postgresql                | BSD-2-Clause                            |
| org.mariadb.jdbc / mariadb-java-client     | LGPL-2.1                                |
| com.microsoft.sqlserver / mssql-jdbc       | MIT License                             |
| com.github.vickumar1981 / stringdistance   | Apache License 2.0                      |
| com.typesafe.scala-logging / scala-logging | Eclipse Public License v1.0 or LGPL-2.1 |
| com.jayway.jsonpath / json-path            | Apache License 2.0                      |
| org.scala-lang / scala-reflect             | Apache License 2.0                      |
| org.scala-lang / scala-compiler            | Apache License 2.0                      |
| ch.qos.logback / logback-classic           | Eclipse Public License v1.0 or LGPL-2.1 |

For performing a more exhaustive licenses check, including subdependecies and testing ones the 
[sbt-license-report](https://github.com/sbt/sbt-license-report) plugin is included in the project, enabling the generation
of a report with the command:
```
$ sbt dumpLicenseReport
```
The results are available, after the execution of this command, under the directory `target/license-reports`.