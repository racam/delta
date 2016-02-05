package fr.racam.delta.ast;

import fr.racam.delta.tools.IVisitor;

/**
 *
 * @author racam
 */


public class Moins extends AbstractOpArith{

    public Moins(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }
    
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
    
}
