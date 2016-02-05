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
public class While extends AbstractInst{

    private final AbstractExpr condition;
    private final ListInst insts;
    
    public While(AbstractExpr condition, ListInst insts) {
        assert(condition != null);
        assert(insts != null);
        this.condition = condition;
        this.insts = insts;
    }
    
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public AbstractExpr getCondition() {
        return condition;
    }

    public ListInst getInsts() {
        return insts;
    }
}
