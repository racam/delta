package fr.racam.delta.ast;

import fr.racam.delta.tools.IVisitor;

/**
 *
 * @author racam
 */
public class ListIfThen extends ASTList<AbstractIfThen>{
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
