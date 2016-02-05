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

import java.util.logging.Logger;

/**
 * Classe principale du programme.
 * <p>
 * Lance la routine principale du compilateur : une compilation par fichier.
 * Elle s'occupe de gérer les erreurs critiques,
 *  et de garder une référence statique sur le {@link Logger}
 * @author racam
 * @since 1.0
 * @see CompilerOptions
 * @see DeltaCompiler
 * @see DeltaException
 */
public class Delta {
    
    /**
     * On garde toujours une référence sur le logger, pour ne pas que le
     * Garbage collector le supprime.
     */
    public static final Logger LOG = Logger.getGlobal();

    /**
     * Point d'entré du programme. 
     * <ul>
     * <li>Parse les arguments en input</li>
     * <li>Lance une compilation pour chaque fichier source</li>
     * <li>Gère les erreurs critiques de la compilation</li>
     * </ul>
     * @param args paramètres du programme
     * @see DeltaException
     * @see DeltaCompiler
     * @see CompilerOptions
     */
    public static void main(String[] args) {
        
        try {
            CompilerOptions options = new CompilerOptions();
            options.parseArgs(args);
            
            DeltaCompiler testCompiler = new DeltaCompiler(options);
            testCompiler.compile();
            
            LOG.fine("MD compiler end");
        } catch (DeltaException ex) {
            LOG.severe(ex.getMessage());
        }
    }
}
