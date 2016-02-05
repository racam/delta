lexer grammar DeltaLexer;

options {
   language=Java;
   // Tell ANTLR to make the generated lexer class extend the
   // the named class, which is where any supporting code and
   // variables will be placed.
   superClass = AbstractDeltaLexer;
}
@header{
    import fr.racam.delta.lexer.AbstractDeltaLexer;
}

@members {
}

// Mots reservés
CLASS: ('class');
ELSE: ('else');
EXTENDS: ('extends');
FALSE: ('false');
IF: ('if');
INSTANCEOF: ('instanceof');
NEW: ('new');
NULL: ('null');
READINT: ('readInt');
READFLOAT: ('readFloat');
PRINT: ('print');
PRINTLN: ('println');
PRINTLNX: ('printlnx');
PRINTX: ('printx');
PROTECTED: ('protected');
RETURN: ('return');
THIS: ('this');
TRUE: ('true');
WHILE: ('while');

// Deca lexer rules.
fragment LETTER:('a'..'z'|'A'..'Z');
fragment DIGIT:('0'..'9');
IDENT:(LETTER | ('$') | ('_')) (LETTER | ('$') | ('_') | DIGIT)*; 

// Symboles spéciaux
LT: ('<');
GT: ('>');
EQUALS: ('=');
EXCLAM: ('!');
SEMI: (';'); 
EQEQ: ('==');
PLUS: ('+');
MINUS: ('-');
NEQ: ('!=');
TIMES: ('*');
GEQ: ('>=');
SLASH: ('/');
LEQ: ('<=');
PERCENT: ('%');
DOT: ('.');
AND: ('&&'); 
OR: ('||');
COMMA: (',');
OPARENT: ('(');
CPARENT: (')');
OBRACE: ('{');
CBRACE: ('}');

// Litteraux
fragment POSITIVE_DIGIT:('1'..'9');
INT:('0') | ((POSITIVE_DIGIT) (DIGIT)*);
fragment NUM:(DIGIT)+;
fragment SIGN:('+') | ('-') | ('');
fragment EXP:(('E') | ('e')) SIGN NUM;
fragment DEC: NUM DOT NUM;
FLOAT: ((DEC) | (DEC EXP)) (('f' | 'F')?); // Peut avoir un 'f' à la fin ou pas
fragment DIGITHEX: DIGIT | ('a'..'f') | ('A'..'F');
fragment NUMHEX: (DIGITHEX)+;
FLOATHEX: (('0x1.') | ('0X1.')) NUMHEX (('P') | ('p')) SIGN NUM (('F') | ('f') | (''));

// Chaine de caracteres
fragment EOL: ('\n') ;
fragment STRING_CAR: ~('"' | '\\' | '\n' | '\t');
STRING: ('"') ((STRING_CAR) | ('\\"') | ('\\\\'))* ('"') ;
MULTI_LINE_STRING: ('"') ((STRING_CAR) | (EOL) | ('\t') | ('\\"') | ('\\\\'))* ('"');

// Commentaires
COMMENT_MULTI_LINE: ('/*') (.)*? ('*/') { skip(); };
COMMENT_MONO_LINE: ('//') (~('\n'))* { skip(); };

// Separateurs
SEPARATEUR: ((' ') | (EOL) | ('\t') | COMMENT_MULTI_LINE | COMMENT_MONO_LINE) { skip(); };

// Inclusion de fichiers
fragment FILENAME: ((LETTER) | (DIGIT) | ('.') | ('-') | ('_'))+;
fragment INCLUDE: ('#include') (' ')* ('"') FILENAME ('"');