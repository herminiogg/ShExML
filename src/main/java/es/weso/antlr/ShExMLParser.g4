parser grammar ShExMLParser;

@header {
package es.weso.antlr;
}

options{tokenVocab=ShExMLLexer;}

shExML: decl* shape* ;
decl: (source | prefix | query | expression | matcher | iterator) ;
prefix: PREFIX variable LESS_SYMBOL_QUERY URL GREATER_SYMBOL_QUERY ;
source: SOURCE variable LESS_SYMBOL_QUERY URL GREATER_SYMBOL_QUERY ;
iterator: ITERATOR variable LESS_SYMBOL_QUERY queryClause GREATER_SYMBOL_QUERY '{' field+ nestedIterator* '}' ;
nestedIterator: ITERATOR variable LESS_SYMBOL_QUERY QUERY_PART GREATER_SYMBOL_QUERY '{' field+ nestedIterator* '}' ;
field: FIELD variable LESS_SYMBOL_QUERY QUERY_PART GREATER_SYMBOL_QUERY ;
query: QUERY variable LESS_SYMBOL_QUERY queryClause GREATER_SYMBOL_QUERY ;
expression: EXPRESSION variable LESS_SYMBOL exp GREATER_SYMBOL ;
matcher: MATCHER variable LESS_SYMBOL matchers GREATER_SYMBOL ;
matchers: replacedStrings AS (STRING_OR_VAR | STRINGOPERATOR)
    | matchers AND replacedStrings AS (STRING_OR_VAR | STRINGOPERATOR) ;
replacedStrings: (STRING_OR_VAR | STRINGOPERATOR) ',' replacedStrings | (STRING_OR_VAR | STRINGOPERATOR) ;
exp: union | join | stringOperation | iteratorQuery ;
stringOperation: iteratorQuery '+' STRINGOPERATOR '+' iteratorQuery ;
iteratorQuery: variable '.' composedVariable ;
composedVariable: variable | variable '.' composedVariable ;
queryClause: JSONPATH QUERY_PART | XMLPATH QUERY_PART | CSVPERROW ;
join: iteratorQuery UNION iteratorQuery JOIN iteratorQuery ;
union: leftUnionOption UNION rightUnionOption ;
leftUnionOption: iteratorQuery | stringOperation ;
rightUnionOption: iteratorQuery | union | stringOperation ;
shape: tripleElement prefixVar '[' (exp | variable) ']' '{' (predicateObject ';')* predicateObject? '}' ;
predicateObject: predicate (objectElement | shapeLink | literalValue) ;
objectElement: prefixVar? '[' (exp | variable) (MATCHING variable)? ']' XMLSCHEMADATATYPE? ;
shapeLink: '@' tripleElement ;
predicate: (literalValue | A) ;
literalValue: prefixVar variable ;
tripleElement: predicate | LESS_SYMBOL variable GREATER_SYMBOL ;
prefixVar: variable | URL ;
variable: STRING_OR_VAR | URI_VAR | STRING_OR_VAR_QUERY | URI_VAR_QUERY ;