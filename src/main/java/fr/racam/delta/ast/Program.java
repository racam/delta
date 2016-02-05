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
public class Program extends AbstractProgram{
    private final AbstractMain main;
    
    /**
     * Constructeur de l'AST Program
     * @param main AST main
     */
    public Program(AbstractMain main) {
        assert(main != null);
        this.main = main;
    }

    public AbstractMain getMain() {
        return main;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
