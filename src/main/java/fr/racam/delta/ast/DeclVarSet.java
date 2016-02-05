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
public class DeclVarSet extends AbstractDeclVarSet{
    
    private final AbstractIdentifier type;
    private final ListDeclVar decls;
    
    public DeclVarSet(AbstractIdentifier type, ListDeclVar decls) {
        this.type = type;
        this.decls = decls;
    }
    
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public AbstractIdentifier getType() {
        return type;
    }

    public ListDeclVar getDecls() {
        return decls;
    }
    
}
