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

import fr.racam.delta.ast.*;

/**
 * 
 * @author racam
 * @since 1.0
 */
public interface IVisitor {
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link And}
     * @see AST
     * @see And
     */
    void visit(And o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Assign}
     * @see AST
     * @see Assign
     */
    void visit(Assign o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link BooleanLiteral}
     * @see AST
     * @see BooleanLiteral
     */
    void visit(BooleanLiteral o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Cast}
     * @see AST
     * @see Cast
     */
    void visit(Cast o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link DeclVar}
     * @see AST
     * @see DeclVar
     */
    void visit(DeclVar o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link DeclVarSet}
     * @see AST
     * @see DeclVarSet
     */
    void visit(DeclVarSet o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Division}
     * @see AST
     * @see Division
     */
    void visit(Division o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link EmptyMain}
     * @see AST
     * @see EmptyMain
     */
    void visit(EmptyMain o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Equals}
     * @see AST
     * @see Equals
     */
    void visit(Equals o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link FloatLiteral}
     * @see AST
     * @see FloatLiteral
     */
    void visit(FloatLiteral o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Greater}
     * @see AST
     * @see Greater
     */
    void visit(Greater o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link GreaterOrEqual}
     * @see AST
     * @see GreaterOrEqual
     */
    void visit(GreaterOrEqual o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Identifier}
     * @see AST
     * @see Identifier
     */
    void visit(Identifier o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link If}
     * @see AST
     * @see If
     */
    void visit(If o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link IfThen}
     * @see AST
     * @see IfThen
     */
    void visit(IfThen o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Initialization}
     * @see AST
     * @see Initialization
     */
    void visit(Initialization o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link IntLiteral}
     * @see AST
     * @see IntLiteral
     */
    void visit(IntLiteral o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link ListDeclVar}
     * @see AST
     * @see ListDeclVar
     */
    void visit(ListDeclVar o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link ListIfThen}
     * @see AST
     * @see ListIfThen
     */
    void visit(ListIfThen o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link ListInst}
     * @see AST
     * @see ListInst
     */
    void visit(ListInst o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Lower}
     * @see AST
     * @see Lower
     */
    void visit(Lower o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link LowerOrEqual}
     * @see AST
     * @see LowerOrEqual
     */
    void visit(LowerOrEqual o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Main}
     * @see AST
     * @see Main
     */
    void visit(Main o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Modulo}
     * @see AST
     * @see Modulo
     */
    void visit(Modulo o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Moins}
     * @see AST
     * @see Moins
     */
    void visit(Moins o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Multiplication}
     * @see AST
     * @see Multiplication
     */
    void visit(Multiplication o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link NoInitialization}
     * @see AST
     * @see NoInitialization
     */
    void visit(NoInitialization o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Not}
     * @see AST
     * @see Not
     */
    void visit(Not o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link NotEquals}
     * @see AST
     * @see NotEquals
     */
    void visit(NotEquals o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Or}
     * @see AST
     * @see Or
     */
    void visit(Or o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Plus}
     * @see AST
     * @see Plus
     */
    void visit(Plus o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link Program}
     * @see AST
     * @see Program
     */
    void visit(Program o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link UnaryMoins}
     * @see AST
     * @see UnaryMoins
     */
    void visit(UnaryMoins o);
    
    /**
     * Visite l'objet <code>o</code>
     * @param o AST de type {@link While}
     * @see AST
     * @see While
     */
    void visit(While o);
}
