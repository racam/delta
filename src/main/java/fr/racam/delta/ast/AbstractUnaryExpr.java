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

/**
 *
 * @author racam
 * @since 1.0
 */
public abstract class AbstractUnaryExpr extends AbstractExpr{
    
    private final AbstractExpr operand;
    
    public AbstractUnaryExpr(AbstractExpr operand) {
        assert(operand != null);
        this.operand = operand;
    }

    public AbstractExpr getOperand() {
        return operand;
    }
}
