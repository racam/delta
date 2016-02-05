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

/**
 *
 * @author racam
 * @since 1.0
 */
public class Initialization extends AbstractInitialization{
    
    private final AbstractExpr expr;
    
    public Initialization(AbstractExpr expr) {
        this.expr = expr;
    }
    
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Getter sur l'expression de l'initialisation
     * @return l'expression de l'initialisation
     */
    public AbstractExpr getExpr() {
        return expr;
    }
}
