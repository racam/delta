package fr.racam.delta;

import fr.racam.delta.ast.AbstractProgram;
import fr.racam.delta.tools.SymbolTable;
import java.io.IOException;
import java.io.Reader;
import org.antlr.v4.runtime.ANTLRFileStream;

/**
 *
 * @author racam
 */
public class DeltaCompiler {

    private final CompilerOptions options;
    private final SymbolTable symTable;

    public DeltaCompiler(CompilerOptions options) {
        this.options = options;
        this.symTable = new SymbolTable();
    }

    /**
     * Execute les différentes étapes de compilation
     * <ol>
     * <li>Lexer</li>
     * <li>Parser</li>
     * <li>Vérfication contextuelle</li>
     * <li>Génération de code</li>
     * </ol>
     * @throws fr.racam.delta.DeltaException
     */
    public void compile() throws DeltaException {
        
        AbstractProgram prog = doLexing(this.getOptions().getSourceFile());
        
        //PrintAST v = new PrintAST(System.out);
        //prog.accept(v);
        
    }
    
    /**
     * Getter sur la table des symboles
     * @return SymbolTable la table des symboles
     */
    public SymbolTable getSymTable() {
        return symTable;
    }

    private AbstractProgram doLexing(Reader source) throws DeltaException {
        DeltaLexer lex;
        try {
            lex = new DeltaLexer(new ANTLRFileStream(source.toString()));
        } catch (IOException ex) {
            throw new DeltaException(1, "Failed to open input file: " + ex.getLocalizedMessage());
        }
        return null;
    }

	public CompilerOptions getOptions() {
		return options;
	}

}
