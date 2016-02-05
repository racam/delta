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
public class DeclVar extends AbstractDeclVar{

    private final AbstractIdentifier ident;
    private final AbstractInitialization init;
    
    
    public DeclVar(AbstractIdentifier ident, AbstractInitialization init) {
        this.ident = ident;
        this.init = init;
    }
    
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public AbstractIdentifier getIdent() {
        return ident;
    }

    public AbstractInitialization getInit() {
        return init;
    }
    
}
