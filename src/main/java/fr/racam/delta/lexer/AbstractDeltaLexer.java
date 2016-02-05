package fr.racam.delta.lexer;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;

public abstract class AbstractDeltaLexer extends Lexer{
    public AbstractDeltaLexer(CharStream input) {
        super(input);
    }
}
