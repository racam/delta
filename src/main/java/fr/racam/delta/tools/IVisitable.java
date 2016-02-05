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

package fr.racam.delta.tools;

/**
 * Précise si une classe peut être visiter par un {@link IVisitor}.
 * <p>
 * Cette classe fait partie intégrante du 
 * <a href="http://fr.wikipedia.org/wiki/Visiteur_(patron_de_conception)">Design
 * pattern visitor</a>
 * @author racam
 * @since 1.0
 * @see IVisitor
 */
public interface IVisitable {
    /**
     * Précise que la classe accepte d'être visitée par <code>visitor</code>.
     * Cette méthode se contente d'apeller la méthode <code>visit</code> de
     * l'interface {@link IVisitor}.
     * @param visitor Le visteur qui veut effectuer un traitement sur l'AST
     */
    void accept(IVisitor visitor);
}
