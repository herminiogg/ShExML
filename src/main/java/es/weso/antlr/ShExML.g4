grammar ShExML;

@header {
package es.weso.antlr;
}

shExML: decl* shape* ;
decl: (source | prefix | query | expression) ;
prefix: PREFIX VAR '<' URL '>' ;
source: SOURCE VAR '<' fileSource '>' ;
query: QUERY VAR '<' queryClause '>' ;
expression: EXPRESSION VAR '<' exp '>' ;
exp: sourceQuery | union | join | stringOperation;
stringOperation: sourceQuery '+' STRINGOPERATOR '+' sourceQuery ;
sourceQuery: '$' VAR '.' VAR ;
join: sourceQuery UNION sourceQuery JOIN sourceQuery ;
union: leftUnionOption UNION rightUnionOption ;
leftUnionOption: sourceQuery | stringOperation ;
rightUnionOption: sourceQuery | union | stringOperation ;
shape: tripleElement prefixVar '[' (exp | VAR) ']' '{' (predicateObject ';')* predicateObject? '}' ;
predicateObject: predicate (objectElement | shapeLink) ;
objectElement: prefixVar? '[' (exp | VAR) ']' ;
shapeLink: '@' tripleElement ;
predicate: prefixVar VAR ;
fileSource: URL ;
queryClause: JSONPATH | XMLPATH ;
tripleElement: predicate | '<' VAR '>' ;
prefixVar: VAR | URL;


PREFIX: 'PREFIX' ;
SOURCE: 'SOURCE' ;
QUERY: 'QUERY' ;
EXPRESSION: 'EXPRESSION' ;
UNION: 'UNION' ;
JOIN: 'JOIN' ;
LESS_SYMBOL: '<' ;
GREATER_SYMBOL: '>' ;
DOLLAR: '$' ;
BRACKET_LEFT: '[' ;
BRACKET_RIGHT: ']' ;
BRACE_LEFT: '{' ;
BRACE_RIGHT: '}' ;
SEMICOLON: ';' ;
COLON: ':' ;
DOT: '.' ;
AT: '@' ;
ADD: '+' ;
QUOTE: '"' ;
VAR: LETTER (LETTER | DIGIT | '_')* ':'? ;
JSONPATH: '$.' ALLOWED_CHARACTERS* ;
XMLPATH: '/' ALLOWED_CHARACTERS* ;
URL: ('http' | 'https' | 'file') '://' ALLOWED_CHARACTERS* ;
STRINGOPERATOR: '"' ALLOWED_CHARACTERS+ '"' ;
WS: [ \t\n\r] -> skip ;

fragment LETTER: [a-zA-Z] ;
fragment DIGIT: [0-9] ;
fragment ALLOWED_CHARACTERS: LETTER | DIGIT | '[' | ']' | '*' | '_' | '/' | '@' | ',' | '.' | '%' | '-' ;
