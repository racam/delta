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

package fr.racam.delta.ast;

import fr.racam.delta.tools.IVisitor;
import fr.racam.delta.tools.SymbolTable.Symbol;

/**
 *
 * @author racam
 * @since 1.0
 */
public class Identifier extends AbstractIdentifier{

    private final Symbol name;
    
    public Identifier(Symbol name) {
        this.name = name;
    }
    
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public Symbol getName() {
        return name;
    }
}
