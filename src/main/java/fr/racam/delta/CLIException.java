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
 * Exception levée lorsqu'il y a une erreur lors de la lecture ou l'interprétation
 * des arguments donnés au compilateur.
 * @author racam
 * @since 1.0
 * @see CompilerOptions#parseArgs(java.lang.String[]) 
 */
public class CLIException extends DeltaException {

    public CLIException(int numeroErreur, String message) {
        super(numeroErreur, message);
    }
    
}
