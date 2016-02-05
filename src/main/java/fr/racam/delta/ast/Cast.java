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
public class Cast extends AbstractExpr{

    private final AbstractIdentifier type;
    private final AbstractExpr expr;
    public Cast(AbstractIdentifier type, AbstractExpr expr) {
        assert(type != null);
        assert(expr != null);
        this.type = type;
        this.expr = expr;
    }
    
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public AbstractIdentifier getType() {
        return type;
    }

    public AbstractExpr getExpr() {
        return expr;
    }
}
