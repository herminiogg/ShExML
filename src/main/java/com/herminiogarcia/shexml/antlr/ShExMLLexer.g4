lexer grammar ShExMLLexer;

@header {
package com.herminiogarcia.shexml.antlr;
}

PREFIX: P R E F I X -> mode(DECLARATION_CONTENT) ;
SOURCE: S O U R C E -> mode(DECLARATION_CONTENT) ;
QUERY: Q U E R Y -> mode(DECLARATION_CONTENT) ;
ITERATOR: I T E R A T O R -> mode(DECLARATION_CONTENT) ;
FUNCTIONS: F U N C T I O N S -> mode(DECLARATION_CONTENT) ;
FIELD: F I E L D -> mode(DECLARATION_CONTENT) ;
PUSHED_FIELD: P U S H E D '_' F I E L D -> mode(DECLARATION_CONTENT) ;
POPPED_FIELD: P O P P E D '_' F I E L D -> mode(DECLARATION_CONTENT) ;
AUTOINCREMENT: A U T O I N C R E M E N T -> mode(AUTOINCREMENT_CONTENT);
EXPRESSION: E X P R E S S I O N ;
UNION: U N I O N ;
JOIN: J O I N ;
SUBSTITUTING: S U B S T I T U T I N G ;
MATCHER: M A T C H E R ;
AS: A S ;
IF: I F ;
ON: O N ;
MATCHING: M A T C H I N G ;
RDFLIST: R D F L I S T ;
RDFBAG: R D F B A G ;
RDFSEQ: R D F S E Q ;
RDFALT: R D F A L T ;
LESS_SYMBOL: '<' ;
GREATER_SYMBOL: '>' ;
BRACKET_LEFT: '[' ;
DOUBLE_BRACKET_LEFT: '[[' ;
BRACKET_RIGHT: ']' ;
DOUBLE_BRACKET_RIGHT: ']]' ;
PAREN_LEFT: '(' ;
PAREN_RIGHT: ')' ;
BRACE_LEFT: '{' ;
BRACE_RIGHT: '}' ;
SEMICOLON: ';' ;
DOT: '.' ;
ADD: '+' ;
COMMA: ',' ;
QUOTE: '"' ;
AND: '&' | 'AND' ;
A: ('a' | 'A');
AT: '@' ;
EQUAL: '=' ;
INDEX: I N D E X '(' ')' ;
STRING_OR_VAR: (LETTER | DIGIT | '_' | '-' | '\\.' | '%2E')+ ;
URI_VAR: (LETTER | DIGIT | '_' | '-' | '\\.' | '%2E')* ':' ;
STRINGOPERATOR: '"' (LETTER | DIGIT | ALLOWED_CHARACTERS | ' ')+ '"' ;
XMLSCHEMADATATYPE: XMLSCHEMADATATYPEPREFIX ':' ALLOWEDTYPES ;
SHAPELINK: '@' (URI_VAR STRING_OR_VAR | '<' STRING_OR_VAR '>') ;
LANGTAG: '@' LETTER+ ('-' (LETTER | DIGIT)+)* ;
COMMENT: '#' ~[\r\n]* -> skip ;
WS: [ \t\n\r] -> skip ;

mode QUERY_CONTENT ;
URL: ('http' | 'https' | 'file') '://' (LETTER | DIGIT | ALLOWED_CHARACTERS)* ;
JDBC_URL: 'jdbc:' (LETTER | DIGIT)+ ':' (LETTER | DIGIT | ALLOWED_CHARACTERS)* ;
JSONPATH: J S O N P A T H ':' ;
XMLPATH: X P A T H ':' ;
CSVPERROW: C S V P E R R O W ;
SQL: S Q L ':' ;
SCALA: S C A L A ':' ;
SPARQL: S P A R Q L ':' ;
QUERY_PART: (LETTER | DIGIT | ALLOWED_CHARACTERS | '}' | '{' | '"')+ ;
GREATER_SYMBOL_QUERY: '>' -> mode(DEFAULT_MODE) ;
WS_QUERY: [ \t\n\r] -> skip ;

mode DECLARATION_CONTENT ;
LESS_SYMBOL_QUERY: '<' -> mode(QUERY_CONTENT) ;
STRING_OR_VAR_QUERY: LETTER (LETTER | DIGIT | '_' | '-')* ;
URI_VAR_QUERY: (LETTER | DIGIT | '_' | '-')* ':' ;
WS_DECLARATION: [ \t\n\r] -> skip ;

mode AUTOINCREMENT_CONTENT ;
LESS_SYMBOL_AUTOINCREMENT: '<' ;
TO: T O ;
BY: B Y ;
ADD_AUTOINCREMENT: '+' ;
DIGITS: DIGIT+ ;
STRING_OR_VAR_AUTOINCREMENT: LETTER (LETTER | DIGIT | '_' | '-')* ;
STRINGOPERATOR_AUTOINCREMENT: '"' (LETTER | DIGIT | ALLOWED_CHARACTERS | ' ')+ '"' ;
GREATER_SYMBOL_AUTOINCREMENT: '>' -> mode(DEFAULT_MODE) ;
WS_AUTOINCREMENT: [ \t\n\r] -> skip ;


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
        | '?' | '=' | '&' | '#' | '$' | ':' | '^' | '\'' | ';' | '\\<' | '\\>' ;
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');