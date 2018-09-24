grammar ShExML;

@header {
package es.weso.antlr;
}

shExML: decl* shape* ;
decl: (source | prefix | query | querySet | expression | expressionSet | matcher) ;
prefix: PREFIX variable '<' URL '>' ;
source: SOURCE variable '<' fileSource '>' ;
query: QUERY variable '<' queryClause '>' ;
querySet: QUERY_SET variable '<' queryClause '>' ;
expression: EXPRESSION variable '<' exp '>' ;
expressionSet: EXPRESSION_SET variable '(' variables ')' '<' exp '>' ;
matcher: MATCHER variable '<' replacedStrings AS STRING_OR_VAR '>' ;
replacedStrings: STRING_OR_VAR ',' replacedStrings | STRING_OR_VAR ;
exp: sourceQuery | union | join | stringOperation;
stringOperation: sourceQuery '+' STRINGOPERATOR '+' sourceQuery ;
sourceQuery: '$' variable '.' variable ;
join: sourceQuery UNION sourceQuery JOIN sourceQuery ;
union: leftUnionOption UNION rightUnionOption ;
leftUnionOption: sourceQuery | stringOperation ;
rightUnionOption: sourceQuery | union | stringOperation ;
shape: tripleElement prefixVar '[' (exp | variable) ']' '{' (predicateObject ';')* predicateObject? '}' ;
predicateObject: predicate (objectElement | shapeLink) ;
objectElement: prefixVar? '[' (exp | variable) (MATCHING variable)? ']' ;
shapeLink: '@' tripleElement ;
predicate: prefixVar variable ;
fileSource: URL ;
queryClause: JSONPATH | XMLPATH ;
tripleElement: predicate | '<' variable '>' ;
prefixVar: variable | URL ;
variable: STRING_OR_VAR | URI_VAR ;
variables: variable | variable ',' variables ;


PREFIX: 'PREFIX' ;
SOURCE: 'SOURCE' ;
QUERY: 'QUERY' ;
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
DOLLAR: '$' ;
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
JSONPATH: '$.' ALLOWED_CHARACTERS* ;
XMLPATH: '/' ALLOWED_CHARACTERS* ;
URL: ('http' | 'https' | 'file') '://' ALLOWED_CHARACTERS* ;
STRINGOPERATOR: '"' ALLOWED_CHARACTERS+ '"' ;
COMMENT: '#' ~[\r\n]* -> skip ;
WS: [ \t\n\r] -> skip ;

fragment LETTER: [a-zA-Záéíóú] ;
fragment DIGIT: [0-9] ;
fragment ALLOWED_CHARACTERS: LETTER | DIGIT | '[' | ']' | '*' | '_' | '/' | '@' | '.' | ',' | '%' | '-' | '(' | ')'
        | '?' | '=' | '&' | '#' | [ ] ;
