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
EXPRESSION film_ids <films_xml_file.film_xml.id UNION films_json_file.film_json.id>
EXPRESSION film_names <films_xml_file.film_xml.name UNION films_json_file.film_json.name>
EXPRESSION film_years <films_xml_file.film_xml.year UNION films_json_file.film_json.year>
EXPRESSION film_countries <films_xml_file.film_xml.country UNION films_json_file.film_json.country>
EXPRESSION film_directors <films_xml_file.film_xml.directors UNION films_json_file.film_json.directors>

:Films :[film_ids] {
    :name [film_names] ;
    :year [film_years] ;
    :country [film_countries] ;
    :director [film_directors] ;
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
    ITERATOR actors <xpath: /cast/actor> {
        FIELD name <name>
        FIELD role <role>
        FIELD film <../../@id>
    }
    ITERATOR actresses <xpath: /cast/actress> {
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
    ITERATOR actors <jsonpath: .cast[*]> {
        FIELD name <name>
        FIELD role <role>
    }
}
EXPRESSION film_ids <films_xml_file.film_xml.id UNION films_json_file.film_json.id>
EXPRESSION film_names <films_xml_file.film_xml.name UNION films_json_file.film_json.name>
EXPRESSION film_years <films_xml_file.film_xml.year UNION films_json_file.film_json.year>
EXPRESSION film_countries <films_xml_file.film_xml.country UNION films_json_file.film_json.country>
EXPRESSION film_directors <films_xml_file.film_xml.directors UNION films_json_file.film_json.directors>
EXPRESSION film_screenwritter <films_xml_file.film_xml.screenwritters UNION films_json_file.film_json.screenwritters>
EXPRESSION film_music <films_xml_file.film_xml.music UNION films_json_file.film_json.music>
EXPRESSION film_photography <films_xml_file.film_xml.photography UNION films_json_file.film_json.photography>
EXPRESSION actor_name <films_xml_file.film_xml.actors.name UNION films_xml_file.film_xml.actresses.name UNION
                    films_json_file.film_json.actors.name>
EXPRESSION actor_role <films_xml_file.film_xml.actors.role UNION films_xml_file.film_xml.actresses.role UNION
                    films_json_file.film_json.actors.role>
EXPRESSION actor_appears_on <films_xml_file.film_xml.actors.film UNION films_xml_file.film_xml.actresses.film>

:Films :[film_ids] {
    schema:name [film_names] ;
    :year dbr:[film_years] ;
    schema:countryOfOrigin dbr:[film_countries] ;
    schema:director dbr:[film_directors] ;
    :screenwritter dbr:[film_screenwritter] ;
    schema:musicBy dbr:[film_music] ;
    :cinematographer dbr:[film_photography] ;
    schema:actor @:Actor ;
}

:Actor dbr:[actor_name] {
    :name [actor_name] ;
    :appear_on :[actor_appears_on] ;
}
```
This example shows how iterators can be nested to cover more complicated data structures and how different shapes
can be used and linked.