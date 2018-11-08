# ShExML

Shape Expressions Mapping Language (ShExML) is a DSL that offers a solution
for mapping and merging heterogeneous data sources. As being based on ShEx the
shape is the main foundation to define the transformations.

## Example
```
PREFIX : <http://example.com/>
SOURCE films_xml <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.xml>
SOURCE films_json <https://rawgit.com/herminiogg/ShExML/master/src/test/resources/films.json>
ITERATOR film_xml <xpath: //film>
ITERATOR film_json <jsonpath: $.films[*]>
FIELD film_id_xml <@id>
FIELD film_id_json <id>
FIELD film_name <name>
FIELD film_year <year>
FIELD film_country <country>
FIELD film_director <director>
FIELD film_director_xml <directors/director>
EXPRESSION film_ids <films_xml.film_xml.film_id_xml UNION films_json.film_json.film_id_json>
EXPRESSION film_names <films_xml.film_xml.film_name UNION films_json.film_json.film_name>
EXPRESSION film_years <films_xml.film_xml.film_year UNION films_json.film_json.film_year>
EXPRESSION film_countries <films_xml.film_xml.film_country UNION films_json.film_json.film_country>
EXPRESSION film_directors <films_xml.film_xml.film_director_xml UNION films_json.film_json.film_director>

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

