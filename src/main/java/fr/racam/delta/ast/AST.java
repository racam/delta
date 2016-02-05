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

import fr.racam.delta.tools.IVisitable;
import fr.racam.delta.tools.Location;

/**
 *
 * @author racam
 * @since 1.0
 */
public abstract class AST implements IVisitable{

    /**
     * Chaque noeud de l'arbre possède sa propre localisation dans le fichier
     * source
     */
    protected Location location;

    /**
     * Setter pour l'attribut de localisation
     * @param location la localisation à enregistrer
     */
    public void setLocation(Location location) {
        assert(location != null);
        this.location = location;
    }

    /**
     * Getter pour l'attribut de localisation
     * @return la localisation
     */
    public Location getLocation() {
        return location;
    }
}
