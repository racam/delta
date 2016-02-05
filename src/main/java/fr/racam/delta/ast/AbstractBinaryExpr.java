package fr.racam.delta.ast;

/**
 *
 * @author racam
 */


public abstract class AbstractBinaryExpr extends AbstractExpr{
    private final AbstractExpr leftOperand;
    private final AbstractExpr rightOperand;

    /**
     * Constructeur pour les opérations binaire
     * @param leftOperand expression de gauche
     * @param rightOperand expression de droite
     */
    public AbstractBinaryExpr(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        assert(leftOperand != null);
        assert(rightOperand != null);
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }   

    /**
     * Getter sur l'expression gauche
     * @return l'expression de gauche de l'opérateur binaire
     */
    public AbstractExpr getLeftOperand() {
        return leftOperand;
    }
    
    /**
     * Getter sur l'expression droite
     * @return l'expression de droite de l'opérateur binaire
     */
    public AbstractExpr getRightOperand() {
        return rightOperand;
    }
}
