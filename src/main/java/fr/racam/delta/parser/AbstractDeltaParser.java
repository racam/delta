package fr.racam.delta.parser;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;


public abstract class AbstractDeltaParser extends Parser {

    public AbstractDeltaParser(TokenStream input) {
        super(input);
    }
    
}
