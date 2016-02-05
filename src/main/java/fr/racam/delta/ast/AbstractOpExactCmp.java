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
 * AST abstrait représentant une opération binaire de comparaison d'équivalence.
 * @author racam
 * @since 1.0
 * @see AbstractBinaryExpr
 * @see AST
 */
public abstract class AbstractOpExactCmp extends AbstractOpCmp{

    /**
     * Constructeur des AST de comparaison d'équivalence
     * @param leftOperand expression de gauche
     * @param rightOperand expression de droite
     */
    public AbstractOpExactCmp(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }
    
}
