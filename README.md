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
square brackets.

## Run the example
To run this example clone this project and run the following command:
```
> sbt "run films.shexml"
```
You can design your own files and run them using the same command but changing films.shexml for the path or the URL to
your target file.

## Complex example
```
PREFIX : <http://example.com/>
PREFIX dbr: <http://dbpedia.org/resource/>
PREFIX schema: <http://schema.org/>
SOURCE films_xml_file <https://rawgit.com/herminiogg/ShExML/enhancement-%237/src/test/resources/filmsExpanded.xml>
SOURCE films_json_file <https://rawgit.com/herminiogg/ShExML/enhancement-%237/src/test/resources/filmsExpanded.json>
ITERATOR film_xml <xpath: //film> {
    FIELD id <@id>
    FIELD name <name>
    FIELD year <year>
    FIELD country <country>
    FIELD directors <crew/directors/director>
    FIELD screenwritters <crew//screenwritter>
    FIELD music <crew/music>
    FIELD photography <crew/photography>
    ITERATOR actors <cast/actor> {
        FIELD name <name>
        FIELD role <role>
        FIELD film <../../@id>
    }
    ITERATOR actresses <cast/actress> {
        FIELD name <name>
        FIELD role <role>
        FIELD film <../../@id>
    }
}
ITERATOR film_json <jsonpath: $.films[*]> {
    FIELD id <id>
    FIELD name <name>
    FIELD year <year>
    FIELD country <country>
    FIELD directors <crew.director>
    FIELD screenwritters <crew.screenwritter>
    FIELD music <crew.music>
    FIELD photography <crew.cinematography>
    ITERATOR actors <cast[*]> {
        FIELD name <name>
        FIELD role <role>
    }
}
EXPRESSION films <films_xml_file.film_xml UNION films_json_file.film_json>

:Films :[films.id] {
    schema:name [films.name] ;
    :year dbr:[films.year] ;
    schema:countryOfOrigin dbr:[films.country] ;
    schema:director dbr:[films.directors] ;
    :screenwritter dbr:[films.screenwritters] ;
    schema:musicBy dbr:[films.music] ;
    :cinematographer dbr:[films.photography] ;
    schema:actor @:Actor ;
    schema:actor @:Actress ;
}

:Actor dbr:[films.actors.name] {
    :name [films.actors.name] ;
    :appear_on :[films.actors.film] ;
}

:Actress dbr:[films.actresses.name] {
    :name [films.actresses.name] ;
    :appear_on :[films.actresses.film] ;
}
```
This example shows how iterators can be nested to cover more complicated data structures and how different shapes
can be used and linked.