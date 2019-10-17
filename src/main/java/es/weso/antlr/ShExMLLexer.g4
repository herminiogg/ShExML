lexer grammar ShExMLLexer;

@header {
package es.weso.antlr;
}

PREFIX: 'PREFIX' -> mode(DECLARATION_CONTENT) ;
SOURCE: 'SOURCE' -> mode(DECLARATION_CONTENT) ;
QUERY: 'QUERY' ;
ITERATOR: 'ITERATOR' -> mode(DECLARATION_CONTENT) ;
FIELD: 'FIELD' -> mode(DECLARATION_CONTENT) ;
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
AND: '&' | 'AND' ;
A: 'a' ;
STRING_OR_VAR: LETTER (LETTER | DIGIT | '_')* ;
URI_VAR: (LETTER | DIGIT | '_')* ':' ;
STRINGOPERATOR: '"' (LETTER | DIGIT | ALLOWED_CHARACTERS | ' ')+ '"' ;
XMLSCHEMADATATYPE: XMLSCHEMADATATYPEPREFIX ':' ALLOWEDTYPES ;
COMMENT: '#' ~[\r\n]* -> skip ;
WS: [ \t\n\r] -> skip ;

mode QUERY_CONTENT ;
URL: ('http' | 'https' | 'file') '://' (LETTER | DIGIT | ALLOWED_CHARACTERS)* ;
JSONPATH: 'jsonpath: ' (LETTER | DIGIT | ALLOWED_CHARACTERS)+ ;
XMLPATH: 'xpath: ' (LETTER | DIGIT | ALLOWED_CHARACTERS)+ ;
QUERY_PART: (LETTER | DIGIT | ALLOWED_CHARACTERS)+ ;
GREATER_SYMBOL_QUERY: '>' -> mode(DEFAULT_MODE) ;
WS_QUERY: [ \t\n\r] -> skip ;

mode DECLARATION_CONTENT ;
LESS_SYMBOL_QUERY: '<' -> mode(QUERY_CONTENT) ;
STRING_OR_VAR_QUERY: LETTER (LETTER | DIGIT | '_')* ;
URI_VAR_QUERY: (LETTER | DIGIT | '_')* ':' ;
WS_DECLARATION: [ \t\n\r] -> skip ;


fragment LETTER: [a-zA-Z] | '\u00C0'..'\u00D6' | '\u00D8'..'\u00F6' | '\u00F8'..'\u00FF' ;
fragment DIGIT: [0-9] ;
fragment XMLSCHEMADATATYPEPREFIX: ('xs' | 'xsd') ;
fragment ALLOWEDTYPES: ('string' | 'boolean' | 'decimal' | 'integer' | 'double' | 'float' | 'date' | 'time'
    | 'dateTime' | 'dateTimeStamp' | 'gYear' | 'gMonth' | 'gDay' | 'gYearMonth' | 'gMonthDay' | 'duration'
    | 'yearMonthDuration' | 'dayTimeDuration' | 'byte' | 'short' | 'int' | 'long' | 'unsignedByte' | 'unsignedShort'
    | 'unsignedInt' | 'unsignedLong' | 'positiveInteger' | 'nonNegativeInteger' | 'negativeInteger'
    | 'nonPositiveInteger' | 'hexBinary' | 'base64Binary' | 'anyURI' | 'language' | 'normalizedString' | 'token'
    | 'NMTOKEN' | 'Name' | 'NCName') ;
fragment ALLOWED_CHARACTERS: '[' | ']' | '*' | '_' | '/' | '\\' | '@' | '.' | ',' | '%' | '-' | '(' | ')'
        | '?' | '=' | '&' | '#' | '$' | ':' | '^' | '\'' ;
