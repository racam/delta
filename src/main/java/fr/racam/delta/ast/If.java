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
public class If extends AbstractInst{
    
    private final ListIfThen listIf; 
    private final ListInst instElse;

    public If(ListIfThen listIf, ListInst instElse) {
        assert(listIf != null);
        assert(instElse != null);
        this.listIf = listIf;
        this.instElse = instElse;
    }
    
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public ListIfThen getListIf() {
        return listIf;
    }

    public ListInst getInstElse() {
        return instElse;
    }

}
