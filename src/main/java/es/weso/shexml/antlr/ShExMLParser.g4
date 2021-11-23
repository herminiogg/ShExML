parser grammar ShExMLParser;

@header {
package es.weso.shexml.antlr;
}

options{tokenVocab=ShExMLLexer;}

shExML: decl* (shape | graph)* ;
decl: (source | prefix | query | expression | matcher | iterator | autoincrement) ;
prefix: PREFIX variable LESS_SYMBOL_QUERY URL GREATER_SYMBOL_QUERY ;
source: SOURCE variable LESS_SYMBOL_QUERY (URL | JDBC_URL | QUERY_PART) GREATER_SYMBOL_QUERY ;
query: QUERY variable LESS_SYMBOL_QUERY (URL | queryClause) GREATER_SYMBOL_QUERY ;
iterator: ITERATOR variable LESS_SYMBOL_QUERY (queryClause | QUERY_PART+) GREATER_SYMBOL_QUERY '{' field+ nestedIterator* '}' ;
nestedIterator: ITERATOR variable LESS_SYMBOL_QUERY QUERY_PART+ GREATER_SYMBOL_QUERY '{' field+ nestedIterator* '}' ;
field: (FIELD | PUSHED_FIELD | POPPED_FIELD) variable LESS_SYMBOL_QUERY QUERY_PART+ GREATER_SYMBOL_QUERY ;
autoincrement: AUTOINCREMENT variable LESS_SYMBOL_AUTOINCREMENT
    (STRINGOPERATOR_AUTOINCREMENT ADD_AUTOINCREMENT)? DIGITS (TO DIGITS)? (BY DIGITS)?
    (ADD_AUTOINCREMENT STRINGOPERATOR_AUTOINCREMENT)? GREATER_SYMBOL_AUTOINCREMENT ;
expression: EXPRESSION variable LESS_SYMBOL exp GREATER_SYMBOL ;
matcher: MATCHER variable LESS_SYMBOL matchers GREATER_SYMBOL ;
matchers: replacedStrings AS (STRING_OR_VAR | STRINGOPERATOR)
    | matchers AND replacedStrings AS (STRING_OR_VAR | STRINGOPERATOR) ;
replacedStrings: (STRING_OR_VAR | STRINGOPERATOR) ',' replacedStrings | (STRING_OR_VAR | STRINGOPERATOR) ;
exp: union | join | stringOperation | iteratorQuery ;
stringOperation: iteratorQuery ADD STRINGOPERATOR ADD iteratorQuery ;
iteratorQuery: variable '.' composedVariable ;
composedVariable: variable | variable '.' composedVariable ;
queryClause: JSONPATH QUERY_PART+ | XMLPATH QUERY_PART+ | CSVPERROW | SQL QUERY_PART+ | SPARQL QUERY_PART+ ;
join: iteratorQuery UNION iteratorQuery JOIN iteratorQuery ;
union: leftUnionOption UNION rightUnionOption ;
leftUnionOption: iteratorQuery | stringOperation ;
rightUnionOption: iteratorQuery | union | stringOperation ;
graph: literalValue '[[' shape+ ']]' ;
shape: tripleElement actionOrLiteral '{' (predicateObject ';')* predicateObject? '}' ;
actionOrLiteral: (action | literalSubject) ;
literalSubject: prefixVar variable ;
action: prefixVar '[' (exp | variable) ']' ;
predicateObject: predicate (objectElement | shapeLink | literalValue) ;
objectElement: firstPartObjectElement (xmlschemadatatype | langtag)? ;
firstPartObjectElement: prefixVar? valueRetriever ;
valueRetriever: ('[' (exp | variable) (MATCHING variable)? (AS rdfCollection)? ']' | STRINGOPERATOR) ;
rdfCollection: RDFLIST | RDFBAG | RDFSEQ | RDFALT ;
xmlschemadatatype: XMLSCHEMADATATYPE | firstPartObjectElement ;
langtag: LANGTAG | '@' valueRetriever ;
shapeLink: SHAPELINK ;
predicate: (literalValue | A) ;
literalValue: prefixVar variable ;
tripleElement: predicate | LESS_SYMBOL variable GREATER_SYMBOL ;
prefixVar: variable | URL ;
variable: STRING_OR_VAR | URI_VAR | STRING_OR_VAR_QUERY | URI_VAR_QUERY | STRING_OR_VAR_AUTOINCREMENT ;