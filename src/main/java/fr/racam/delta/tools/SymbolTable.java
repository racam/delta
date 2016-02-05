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

package fr.racam.delta.tools;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author racam
 * @since 1.0
 */


public class SymbolTable {
    
    private final Map<String, Symbol> map = new HashMap<>();
    
    /**
     * Créé le <code>Symbol</code> correspondant à <code>name</code> et le stocke.
     * S'il existe déjà, renvoi le <code>Symbol</code> déjà existant
     * @param name le nom du <code>Symbol</code> à créer ou retrouver
     * @return le <code>Symbol</code> correspondant à <code>name</code>
     */
    public Symbol create(String name) {
    	if(map.containsKey(name)) {
            return map.get(name);
    	}
    	Symbol s = new Symbol(name);
    	map.put(name, s);
    	return s;
    }

    /**
     * Symbole pour la table des symboles
     */
    public class Symbol {
        private final String name;
        
        private Symbol(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
