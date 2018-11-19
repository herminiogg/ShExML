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

