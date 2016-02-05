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
import java.io.PrintStream;

/**
 * PrintAST est une classe de type {@link IVisitor} qui permet l'affichage d'un
 * {@link AST} de manière indentée et récursive. 
 * <p>
 * L'axiome (racine de l'AST) est le noeud {@link AbstractProgram}, ainsi pour 
 * afficher l'arbre dans sa totalité il convient de passer par la méthode 
 * {@link #visit(fr.racam.delta.ast.Program)} après une étape de parsing.
 * 
 * @author racam
 * @since 1.0
 */
public class PrintAST implements IVisitor{
    
    /**
     * PrintStream dans lequel la classe va écrire pour afficher l'AST
     */
    private final PrintStream stream;
    
    /**
     * Nombre de tabulation en cours
     */
    private int nombreTabulation;

    /**
     * Prend en paramètre le <code>stream</code> sur lequel écrire
     * @param stream PrintStream dans lequel la classe va écrire pour afficher l'AST
     */
    public PrintAST(PrintStream stream) {
        this.stream = stream;
        this.nombreTabulation = 0;
    }
    
    /**
     * Revient à la ligne avec une tabulations en plus.
     * @see #nombreTabulation
     * @see #newLine()
     */
    private void newIncLine(){
        this.nombreTabulation++;
        this.newLine();
    }
    
    /**
     * Revient à la ligne avec une tabulations en moins.
     * @see #nombreTabulation
     * @see #newLine()
     */
    private void newDecLine(){
        this.nombreTabulation--;
        this.newLine();
    }
    
    /**
     * Ecrit un saut de ligne suivit des tabulations {@link #printTab()}
     * @see #printTab()
     */
    private void newLine(){
        stream.println();
        this.printTab();
    }
    
    /**
     * Ecrit dans le <code>stream</code> autant de tabulations que le précise
     * {@link #nombreTabulation}
     * @see #nombreTabulation
     */
    private void printTab(){
        for(int i = 0; i < nombreTabulation; i++){
            stream.print("\t");
        }
    }
    
    /**
     * Ecrit dans le <code>stream</code> "[ligne:colonne] name" où 
     * <code>ligne</code> et <code>colonne</code> sont des attributs 
     * de <code>loc</code>
     * @param loc la localisation à écrire
     * @param name le nom à écrire
     * @see Location
     */
    private void printSimple(Location loc, String name){
        stream.print("[");
        stream.print(loc);
        stream.print("] ");
        stream.print(name);

    }
    
    /**
     * Préfixe l'écriture de {@link #printSimple(Location, String)} par un chevron
     * @param o l'AST à afficher
     */
    private void printAst(AST o){
        stream.print("> ");
        this.printSimple(o.getLocation(), o.getClass().getSimpleName());
    }
    
    /**
     * Ecrit de manière indentée un <code>ASTList</code> quelconque en ajoutant
     * à la fin le nombre d'éléments que contient cette liste.
     * <p>
     * Par exemple : [1:0] ListInst [List with 4 elements], avec <code>o</code> 
     * un ListInst
     * @param o un <code>ASTLIST</code>
     */
    private void printList(ASTList o){
        stream.print("+> ");
        this.printSimple(o.getLocation(), o.getClass().getSimpleName());
        stream.print(" [List with ");
        stream.print(o.size());
        stream.print(" elements]");
    }
    
    /**
     * Ecrit de manière indentée un noeud <code>AST</code> quelconque en ajoutant
     * à la fin "(<code>value</code>)"
     * <p>
     * Par exemple : [1:0] IntLiteral (42), avec <code>o</code> un {@link IntLiteral}
     * et <code>value</code> = 42
     * @param o un noeud <code>AST</code> d'un AST
     * @param value la valeur à écrire entre parenthèses
     */
    private void printAstValue(AST o, String value){
        this.printAst(o);
        stream.print(" (");
        stream.print(value);
        stream.print(")");
    }
    
    /**
     * Ecrit de manière indentée un noeud <code>AbstractBinaryExpr</code> d'un AST.
     * @param o un noeud <code>AbstractBinaryExpr</code> d'un AST
     */
    private void printAstBinary(AbstractBinaryExpr o){
        this.printAst(o);
        this.newIncLine();
        o.getLeftOperand().accept(this);
        this.newLine();
        o.getRightOperand().accept(this);
        this.nombreTabulation--;
    }
    
    /**
     * Ecrit de manière indentée un noeud <code>And</code> d'un AST.
     * @param o un noeud <code>And</code> d'un AST
     */
    @Override
    public void visit(And o) {
        this.printAstBinary(o);
    }

    /**
     * Ecrit de manière indentée un noeud <code>Assign</code> d'un AST.
     * @param o un noeud <code>Assign</code> d'un AST
     */
    @Override
    public void visit(Assign o) {
        this.printAstBinary(o);
    }

    /**
     * Ecrit de manière indentée un noeud <code>BooleanLiteral</code> d'un AST.
     * @param o un noeud <code>BooleanLiteral</code> d'un AST
     */
    @Override
    public void visit(BooleanLiteral o) {
        String value = String.valueOf(o.getValue());
        this.printAstValue(o, value);
    }

    /**
     * Ecrit de manière indentée un noeud <code>Cast</code> d'un AST.
     * @param o un noeud <code>Cast</code> d'un AST
     */
    @Override
    public void visit(Cast o) {
        this.printAst(o);
        this.newIncLine();
        o.getType().accept(this);
        this.newLine();
        o.getExpr().accept(this);
        this.nombreTabulation--;
    }

    /**
     * Ecrit de manière indentée un noeud <code>DeclVar</code> d'un AST.
     * @param o un noeud <code>DeclVar</code> d'un AST
     */
    @Override
    public void visit(DeclVar o) {
        this.printAst(o);
        this.newIncLine();
        o.getIdent().accept(this);
        this.newLine();
        o.getInit().accept(this);
        this.nombreTabulation--;
    }

    /**
     * Ecrit de manière indentée un noeud <code>DeclVarSet</code> d'un AST.
     * @param o un noeud <code>DeclVarSet</code> d'un AST
     */
    @Override
    public void visit(DeclVarSet o) {
        this.printAst(o);
        this.newIncLine();
        o.getType().accept(this);
        this.newLine();
        o.getDecls().accept(this);
        this.nombreTabulation--;
    }
    
    /**
     * Ecrit de manière indentée un noeud <code>Division</code> d'un AST.
     * @param o un noeud <code>Division</code> d'un AST
     */
    @Override
    public void visit(Division o) {
        this.printAstBinary(o);
    }

    /**
     * Ecrit de manière indentée un noeud <code>EmptyMain</code> d'un AST.
     * @param o un noeud <code>EmptyMain</code> d'un AST
     */
    @Override
    public void visit(EmptyMain o) {
        this.printAst(o);
    }

    /**
     * Ecrit de manière indentée un noeud <code>Equals</code> d'un AST.
     * @param o un noeud <code>Equals</code> d'un AST
     */
    @Override
    public void visit(Equals o) {
        this.printAstBinary(o);
    }

    /**
     * Ecrit de manière indentée un noeud <code>FloatLiteral</code> d'un AST.
     * @param o un noeud <code>FloatLiteral</code> d'un AST
     */
    @Override
    public void visit(FloatLiteral o) {
        String value = String.valueOf(o.getValue());
        this.printAstValue(o, value);
    }

    /**
     * Ecrit de manière indentée un noeud <code>Greater</code> d'un AST.
     * @param o un noeud <code>Greater</code> d'un AST
     */
    @Override
    public void visit(Greater o) {
        this.printAstBinary(o);
    }

    /**
     * Ecrit de manière indentée un noeud <code>GreaterOrEqual</code> d'un AST.
     * @param o un noeud <code>GreaterOrEqual</code> d'un AST
     */
    @Override
    public void visit(GreaterOrEqual o) {
        this.printAstBinary(o);
    }

    /**
     * Ecrit de manière indentée un noeud <code>Identifier</code> d'un AST.
     * @param o un noeud <code>Identifier</code> d'un AST
     */
    @Override
    public void visit(Identifier o) {
        String value = o.getName().toString();
        this.printAstValue(o, value);
    }

    /**
     * Ecrit de manière indentée un noeud <code>If</code> d'un AST.
     * @param o un noeud <code>If</code> d'un AST
     */
    @Override
    public void visit(If o) {
        this.printAst(o);
        this.newIncLine();
        o.getListIf().accept(this);
        this.newLine();
        o.getInstElse().accept(this);
        this.nombreTabulation--;
    }

    /**
     * Ecrit de manière indentée un noeud <code>IfThen</code> d'un AST.
     * @param o un noeud <code>IfThen</code> d'un AST
     */
    @Override
    public void visit(IfThen o) {
        this.printAst(o);
        this.newIncLine();
        o.getCondition().accept(this);
        this.newLine();
        o.getInsts().accept(this);
        this.nombreTabulation--;
    }

    /**
     * Ecrit de manière indentée un noeud <code>Initialization</code> d'un AST.
     * @param o un noeud <code>Initialization</code> d'un AST
     */
    @Override
    public void visit(Initialization o) {
        this.printAst(o);
        this.newIncLine();
        o.getExpr().accept(this);
        this.nombreTabulation--;
    }

    /**
     * Ecrit de manière indentée un noeud <code>IntLiteral</code> d'un AST.
     * @param o un noeud <code>IntLiteral</code> d'un AST
     */
    @Override
    public void visit(IntLiteral o) {
        String value = String.valueOf(o.getValue());
        this.printAstValue(o, value);
    }
    
    /**
     * Ecrit de manière indentée une list de noeuds <code>AbstractDeclVar</code> 
     * d'un AST.
     * @param o un <code>ListDeclVar</code> 
     */
    @Override
    public void visit(ListDeclVar o) {
        this.printList(o);
        this.nombreTabulation++;
        o.stream().forEach((d) -> {this.newLine();d.accept(this);});
        this.nombreTabulation--;
    }

    /**
     * Ecrit de manière indentée une list de noeuds <code>AbstractIfThen</code> 
     * d'un AST.
     * @param o un <code>ListIfThen</code>
     */
    @Override
    public void visit(ListIfThen o) {
        this.printList(o);
        this.nombreTabulation++;
        o.stream().forEach((i) -> {this.newLine(); i.accept(this);});
        this.nombreTabulation--;
    }

    /**
     * Ecrit de manière indentée une list de noeuds <code>AsbtractInst</code> d'un AST.
     * @param o un <code>ListInst</code>
     */
    @Override
    public void visit(ListInst o) {
        this.printList(o);
        this.nombreTabulation++;
        o.stream().forEach((i) -> {this.newLine(); i.accept(this);});
        this.nombreTabulation--;
    }

    /**
     * Ecrit de manière indentée un noeud <code>Lower</code> d'un AST.
     * @param o un noeud <code>Lower</code> d'un AST
     */
    @Override
    public void visit(Lower o) {
        this.printAstBinary(o);
    }

    /**
     * Ecrit de manière indentée un noeud <code>LowerOrEqual</code> d'un AST.
     * @param o un noeud <code>LowerOrEqual</code> d'un AST
     */
    @Override
    public void visit(LowerOrEqual o) {
        this.printAstBinary(o);
    }
    
    /**
     * Ecrit de manière indentée un noeud <code>Main</code> d'un AST.
     * @param o un noeud <code>Main</code> d'un AST
     */
    @Override
    public void visit(Main o) {
        this.printAst(o);
        this.newIncLine();
        o.getInsts().accept(this);
        this.nombreTabulation--;
    }

    /**
     * Ecrit de manière indentée un noeud <code>Modulo</code> d'un AST.
     * @param o un noeud <code>Modulo</code> d'un AST
     */
    @Override
    public void visit(Modulo o) {
        this.printAstBinary(o);
    }
    
    /**
     * Ecrit de manière indentée un noeud <code>Moins</code> d'un AST.
     * @param o un noeud <code>Moins</code> d'un AST
     */
    @Override
    public void visit(Moins o) {
        this.printAstBinary(o);
    }

    /**
     * Ecrit de manière indentée un noeud <code>Multiplication</code> d'un AST.
     * @param o un noeud <code>Multiplication</code> d'un AST
     */
    @Override
    public void visit(Multiplication o) {
        this.printAstBinary(o);
    }

    /**
     * Ecrit de manière indentée un noeud <code>NoInitialization</code> d'un AST.
     * @param o un noeud <code>NoInitialization</code> d'un AST
     */
    @Override
    public void visit(NoInitialization o) {
        this.printAst(o);
    }
    
    /**
     * Ecrit de manière indentée un noeud <code>Not</code> d'un AST.
     * @param o un noeud <code>Not</code> d'un AST
     */
    @Override
    public void visit(Not o) {
        this.printAst(o);
        this.newIncLine();
        o.getOperand().accept(this);
        this.nombreTabulation--;
    }
    
    /**
     * Ecrit de manière indentée un noeud <code>NotEquals</code> d'un AST.
     * @param o un noeud <code>NotEquals</code> d'un AST
     */
    @Override
    public void visit(NotEquals o) {
        this.printAstBinary(o);
    }
    
    /**
     * Ecrit de manière indentée un noeud <code>Or</code> d'un AST.
     * @param o un noeud <code>Or</code> d'un AST
     */
    @Override
    public void visit(Or o) {
        this.printAstBinary(o);
    }
    
    /**
     * Ecrit de manière indentée un noeud <code>Plus</code> d'un AST.
     * @param o un noeud <code>Plus</code> d'un AST
     */
    @Override
    public void visit(Plus o) {
        this.printAstBinary(o);
    }
    
    /**
     * Ecrit de manière indentée un noeud <code>Program</code> d'un AST.
     * C'est l'axiome : la racine des appels récursifs.
     * <em>La méthode inclut un retour à la ligne à la fin</em>
     * @param o un noeud <code>Program</code> d'un AST
     */
    @Override
    public void visit(Program o) {
        this.printAst(o);
        this.newIncLine();
        o.getMain().accept(this);
        this.newDecLine();
    }
    
    /**
     * Ecrit de manière indentée un noeud <code>UnaryMoins</code> d'un AST
     * @param o un noeud <code>UnaryMoins</code> d'un AST
     */
    @Override
    public void visit(UnaryMoins o) {
        this.printAst(o);
        this.newIncLine();
        o.getOperand().accept(this);
        this.nombreTabulation--;
    }
    
    /**
     * Ecrit de manière indentée un noeud <code>While</code> d'un AST
     * @param o un noeud <code>While</code> d'un AST
     */
    @Override
    public void visit(While o) {
        this.printAst(o);
        this.newIncLine();
        o.getCondition().accept(this);
        this.newLine();
        o.getInsts().accept(this);
        this.nombreTabulation--;
    }
    
}
