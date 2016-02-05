package fr.racam.delta.ast;

import fr.racam.delta.tools.IVisitor;

/**
 *
 * @author racam
 */


public class ListDeclVar extends ASTList<AbstractDeclVar>{
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
