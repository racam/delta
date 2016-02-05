package fr.racam.delta.ast;

/**
 *
 * @author racam
 */


public abstract class AbstractOpBool extends AbstractBinaryExpr{

    /**
     * Constructeur des AST booléens
     * @param leftOperand expression de gauche
     * @param rightOperand expression de droite
     * @see AbstractBinaryExpr
     */
    public AbstractOpBool(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }
    
}
