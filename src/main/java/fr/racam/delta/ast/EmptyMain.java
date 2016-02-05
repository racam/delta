package fr.racam.delta.ast;

import fr.racam.delta.tools.IVisitor;

/**
 *
 * @author racam
 */
public class EmptyMain extends AbstractMain{

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
