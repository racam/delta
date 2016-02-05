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
 *
 * @author racam
 * @since 1.0
 */
public class Location {
    private final int ligne;
    private final int colonne;

    /**
     * Constructeur
     * @param ligne int ligne de la localisation
     * @param colonne int colonne de la localisation
     */
    public Location(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

    @Override
    public String toString() {
        return ligne + ":" + colonne;
    }
}
