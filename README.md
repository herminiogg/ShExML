# ShExML
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

## Usage

### CLI
A command line interface is offered under the jar library with the following options available:
```
Usage: ShExML [-hrV] [-f=<format>] -m=<file> [-o=<output>] [-p=<password>]
              [-u=<username>]
Map and merge heterogeneous data sources with a Shape Expressions based syntax
  -f, --format=<format>   Output format for RDF graph. Turtle, RDF/XML,
                            N-Triples, ...
  -h, --help              Show this help message and exit.
  -m, --mapping=<file>    Path to the file with the mappings
  -o, --output=<output>   Path where the output file should be created
  -p, --password=<password>
                          Password in case of using a database
  -r, --rml               Generate RML output
  -u, --username=<username>
                          Username in case of using a database
  -V, --version           Print version information and exit.
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
Also a live demo is offered online (http://shexml.herminiogarcia.com). However, due to hardware limitations it is not 
intended for intesive use.
