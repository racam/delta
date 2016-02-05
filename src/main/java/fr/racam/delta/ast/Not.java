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

import fr.racam.delta.tools.IVisitable;
import fr.racam.delta.tools.IVisitor;

/**
 * AST représentant l'inverse du paramètre {@link AbstractUnaryExpr#operand}.
 * <p>
 * Comme c'est une classe concrète (pas abstraite) on doit la rendre visitable
 * @author racam
 * @since 1.0
 * @see AbstractUnaryExpr#operand
 * @see AST
 * @see IVisitable
 */
public class Not extends AbstractUnaryExpr{

    /**
     * Constructeur des AST de comparaison
     * @param operand expression à inverser
     */
    public Not(AbstractExpr operand) {
        super(operand);
    }
    
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
    
}
