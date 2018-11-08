grammar ShExML;

@header {
package es.weso.antlr;
}

shExML: decl* shape* ;
decl: (source | prefix | query | querySet | expression | expressionSet | matcher | iterator | field) ;
prefix: PREFIX variable '<' URL '>' ;
source: SOURCE variable '<' URL '>' ;
iterator: ITERATOR variable '<' queryClause '>' ;
field: FIELD variable '<' queryParts '>' ;
query: QUERY variable '<' queryClause '>' ;
querySet: QUERY_SET variable '<' queryClause '>' ;
expression: EXPRESSION variable '<' exp '>' ;
expressionSet: EXPRESSION_SET variable '(' variables ')' '<' exp '>' ;
matcher: MATCHER variable '<' replacedStrings AS STRING_OR_VAR '>' ;
replacedStrings: STRING_OR_VAR ',' replacedStrings | STRING_OR_VAR ;
exp: sourceQuery | union | join | stringOperation | iteratorQuery ;
stringOperation: queryAlternative '+' STRINGOPERATOR '+' queryAlternative ;
sourceQuery: variable '.' variable ;
iteratorQuery: variable '.' variable '.' variable ;
queryAlternative: sourceQuery | iteratorQuery ;
queryClause: JSONPATH | XMLPATH ;
join: queryAlternative UNION queryAlternative JOIN queryAlternative ;
union: leftUnionOption UNION rightUnionOption ;
leftUnionOption: queryAlternative | stringOperation ;
rightUnionOption: queryAlternative | union | stringOperation ;
shape: tripleElement prefixVar '[' (exp | variable) ']' '{' (predicateObject ';')* predicateObject? '}' ;
predicateObject: predicate (objectElement | shapeLink) ;
objectElement: prefixVar? '[' (exp | variable) (MATCHING variable)? ']' ;
shapeLink: '@' tripleElement ;
predicate: prefixVar variable ;
tripleElement: predicate | '<' variable '>' ;
prefixVar: variable | URL ;
variable: STRING_OR_VAR | URI_VAR ;
variables: variable | variable ',' variables ;
queryParts: '@'? STRING_OR_VAR | '@'? STRING_OR_VAR ('/' | '.') queryParts ;


PREFIX: 'PREFIX' ;
SOURCE: 'SOURCE' ;
QUERY: 'QUERY' ;
ITERATOR: 'ITERATOR' ;
FIELD: 'FIELD' ;
EXPRESSION: 'EXPRESSION' ;
UNION: 'UNION' ;
JOIN: 'JOIN' ;
MATCHER: 'MATCHER' ;
AS: 'AS' ;
MATCHING: 'MATCHING' ;
QUERY_SET: 'QUERY_SET' ;
EXPRESSION_SET: 'EXPRESSION_SET' ;
LESS_SYMBOL: '<' ;
GREATER_SYMBOL: '>' ;
BRACKET_LEFT: '[' ;
BRACKET_RIGHT: ']' ;
PAREN_LEFT: '(' ;
PAREN_RIGHT: ')' ;
BRACE_LEFT: '{' ;
BRACE_RIGHT: '}' ;
SEMICOLON: ';' ;
DOT: '.' ;
AT: '@' ;
ADD: '+' ;
COMMA: ',' ;
QUOTE: '"' ;
STRING_OR_VAR: LETTER (LETTER | DIGIT | '_')* ;
URI_VAR: (LETTER | DIGIT | '_')* ':' ;
URL: ('http' | 'https' | 'file') '://' (LETTER | DIGIT | ALLOWED_CHARACTERS)* ;
STRINGOPERATOR: '"' (LETTER | DIGIT | ALLOWED_CHARACTERS)+ '"' ;
JSONPATH: 'jsonpath: ' (LETTER | DIGIT | ALLOWED_CHARACTERS)+ ;
XMLPATH: 'xpath: ' (LETTER | DIGIT | ALLOWED_CHARACTERS)+ ;
COMMENT: '#' ~[\r\n]* -> skip ;
WS: [ \t\n\r] -> skip ;

fragment LETTER: [a-zA-Záéíóú] ;
fragment DIGIT: [0-9] ;
fragment ALLOWED_CHARACTERS: '[' | ']' | '*' | '_' | '/' | '@' | '.' | ',' | '%' | '-' | '(' | ')'
        | '?' | '=' | '&' | '#' | '$' ;
