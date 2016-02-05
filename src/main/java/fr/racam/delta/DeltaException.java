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

package fr.racam.delta;

/**
 * Toutes les {@link Exception} levées par le projet doivent héritées de 
 * <code>DeltaException</code>. 
 * <p>
 * En effet, chaque exception liée au projet possède
 * son propre numéro d'erreur. Celui-ci permet un debugage plus simple à la fois
 * pour l'utilisateur que pour le développeur.
 * <p>
 * On surchage aussi la message {@link #getMessage()} pour un affichage standart
 * à tout le projet
 * @author racam
 * @since 1.0
 */
public class DeltaException extends Exception {

    /**
     * Chaque erreur du compilateur MD est identifiée par un numéro unique
     */
    protected final int numeroErreur;
    
    /**
     * Constructeur avec numéro d'erreur
     * @param numeroErreur int numéro de l'erreur
     * @param msg String message de l'erreur
     */
    public DeltaException(int numeroErreur, String msg) {
        super(msg);
        this.numeroErreur = numeroErreur;
    }

    /**
     * Le numéro d'erreur de l'exception
     * @return int numéro d'erreur
     */
    public int getNumeroErreur() {
        return numeroErreur;
    }

    /**
     * On formate le message d'erreur avec le numéro d'erreur
     * @return String le message formaté
     */
    @Override
    public String getMessage() {
        return "[" + numeroErreur + "] " + super.getMessage(); 
    }
    
    
    
}
