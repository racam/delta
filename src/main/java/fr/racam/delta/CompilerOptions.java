/**
 * DeltaCompiler : compilateur du langage Delta
 * @licence : GPL V3 - voir fichier "LICENCE" 
 * 
 * DeltaCompiler est un projet visant à démistifier la compilation. Il se veut 
 * le plus explicite possible et avec beaucoup d'indications sur comment
 * marche un compilateur.
 * Le langage cible : le Delta, a pour seule motivation la création de son 
 * compilateur.
 * 
 * Pour plus d'informations, merci de consulter le README
 */

package fr.racam.delta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 *
 * @author racam
 * @since 1.0
 */
public class CompilerOptions {
    
	
    private final Level logLevel = Level.INFO;
    private Reader sourceFile;

    /**
     * Constructeur
     */
    public CompilerOptions() {
        this.configLog();
    }

    private void configLog() {
        //Level + disable parent handler
        Delta.LOG.setUseParentHandlers(false);
        Delta.LOG.setLevel(logLevel);

        StreamHandler handler = new StreamHandler(System.out, new MDFormatter());
        handler.setLevel(logLevel);
        Delta.LOG.addHandler(handler);
        
        
        Delta.LOG.log(Level.CONFIG, "set level of log to : {0}", logLevel);
    }

    public void parseArgs(String[] args) throws CLIException {
    	Delta.LOG.fine("Start parsing arguments");

        try {
        	String filePath = args[0];
            File f = new File(filePath);
            
            sourceFile = new FileReader(f);
            
            Delta.LOG.log(Level.CONFIG, "add source file : {0}", filePath);
        } catch (FileNotFoundException ex) {
            throw new CLIException(1, ex.getMessage());
        }

        Delta.LOG.fine("End parsing arguments");
    }

    public Reader getSourceFile() {
        return this.sourceFile;
    }

    private class MDFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            StringBuilder s = new StringBuilder();
            s.append("[");
            s.append(record.getLevel());
            s.append("]");
            s.append(record.getMessage());
            s.append("\n");
            
            return s.toString();
        }
    }
}
