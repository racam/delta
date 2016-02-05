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
import fr.racam.delta.tools.SymbolTable.Symbol;
import java.io.PrintStream;
import java.util.Iterator;

/**
 * Decompile est une classe de type {@link IVisitor} qui permet l'affichage 
 * indenté du code source.
 * Cette classe respecte <a href="http://en.wikipedia.org/wiki/Programming_style">
 * le coding style</a> du langage Delta, et fournie donc un PrettyPrinter basique.
 * <p>
 * L'axiome (racine de l'AST) est le noeud {@link AbstractProgram}, ainsi pour 
 * générer le code source dans sa totalité il convient de passer par la méthode 
 * {@link #visit(fr.racam.delta.ast.Program)} après une étape de parsing.
 * 
 * @author racam
 * @since 1.0
 */
public class Decompile implements IVisitor{
    
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
    public Decompile(PrintStream stream) {
        this.stream = stream;
        this.nombreTabulation = 0;
    }

    private void visit(AbstractBinaryExpr o, String name){
        o.getLeftOperand().accept(this);
        stream.print(" " + name + " ");
        o.getRightOperand().accept(this);
    }
    
    private void newLine(){
        stream.println();
        for(int i = 0; i < this.nombreTabulation; i++){
            stream.print("\t");
        }
    }
    
    private void newIncLine(){
        this.nombreTabulation++;
        this.newLine();
    }
    
    private void newDecLine(){
        this.nombreTabulation--;
        this.newLine();
    }
    
    private void visitBlock(ListInst o){
        stream.print("{");
        this.newIncLine();
        o.accept(this);
        this.newDecLine();
        stream.print("}");
    }
    
    private void visit(AbstractUnaryExpr o, String name){
        stream.print(name);
        o.getOperand().accept(this);
    }
    
    @Override
    public void visit(And o) {
        this.visit((AbstractBinaryExpr)o, "&&");
    }

    @Override
    public void visit(Assign o) {
        this.visit((AbstractBinaryExpr)o, " = ");
        stream.print(";");
    }

    @Override
    public void visit(BooleanLiteral o) {
        boolean b = o.getValue();
        stream.print(b);
    }

    @Override
    public void visit(Cast o) {
        stream.print("(");
        o.getType().accept(this);
        stream.print(")");
        o.getExpr().accept(this);
    }

    @Override
    public void visit(DeclVar o) {
        o.getIdent().accept(this);
        o.getInit().accept(this);
    }

    @Override
    public void visit(DeclVarSet o) {
        o.getType().accept(this);
        stream.print(" ");
        o.getDecls().accept(this);
        stream.print(";");
    }

    @Override
    public void visit(Division o) {
        this.visit((AbstractBinaryExpr)o, "/");
    }

    @Override
    public void visit(EmptyMain o) {}

    @Override
    public void visit(Equals o) {
        this.visit((AbstractBinaryExpr)o, "==");
    }

    @Override
    public void visit(FloatLiteral o) {
        float f = o.getValue();
        stream.print(f);
    }

    @Override
    public void visit(Greater o) {
        this.visit((AbstractBinaryExpr)o, ">");
    }

    @Override
    public void visit(GreaterOrEqual o) {
        this.visit((AbstractBinaryExpr)o, ">=");
    }

    @Override
    public void visit(Identifier o) {
        Symbol s = o.getName();
        stream.print(s);
    }

    @Override
    public void visit(IntLiteral o) {
        int i = o.getValue();
        stream.print(i);
    }

    @Override
    public void visit(ListDeclVar o) {
        Iterator<AbstractDeclVar> it = o.iterator();
        while(it.hasNext()){
            AbstractDeclVar decl = it.next();
            decl.accept(this);
            if(it.hasNext()){
                stream.print(", ");
            }
        }
    }

    @Override
    public void visit(ListIfThen o) {
        boolean test = true;
        for(AbstractIfThen i : o){
            if(test){
                stream.print("if");
                test = false;
            }else{
                stream.print("elseif");
            }
            
            i.accept(this);
        }
    }

    @Override
    public void visit(ListInst o) {
        Iterator<AbstractInst> it = o.iterator();
        while(it.hasNext()){
            AbstractInst i = it.next();
            i.accept(this);
            if(it.hasNext()){
                this.newLine();
            }
        }
    }

    @Override
    public void visit(Lower o) {
        this.visit((AbstractBinaryExpr)o, "<");
    }

    @Override
    public void visit(LowerOrEqual o) {
        this.visit((AbstractBinaryExpr)o, "<=");
    }

    @Override
    public void visit(Main o) {
        stream.print("main ");
        ListInst insts = o.getInsts();
        this.visitBlock(insts);
    }

    @Override
    public void visit(Modulo o) {
        this.visit((AbstractBinaryExpr)o, "%");
    }

    @Override
    public void visit(Moins o) {
        this.visit((AbstractBinaryExpr)o, "-");
    }

    @Override
    public void visit(Multiplication o) {
        this.visit((AbstractBinaryExpr)o, "*");
    }

    @Override
    public void visit(NoInitialization o) {}

    @Override
    public void visit(Not o) {
        this.visit((AbstractUnaryExpr)o, "!");
    }

    @Override
    public void visit(NotEquals o) {
        this.visit((AbstractBinaryExpr)o, "!=");
    }

    @Override
    public void visit(Or o) {
        this.visit((AbstractBinaryExpr)o, "||");
    }

    @Override
    public void visit(Plus o) {
        this.visit((AbstractBinaryExpr)o, "+");
    }

    @Override
    public void visit(Program o) {
        o.getMain().accept(this);
        this.newLine();
    }

    @Override
    public void visit(UnaryMoins o) {
        this.visit((AbstractUnaryExpr)o, "!");
    }

    @Override
    public void visit(While o) {
        stream.print("while(");
        o.getCondition().accept(this);
        stream.print(")");
        ListInst insts = o.getInsts();
        this.visitBlock(insts);
    }

    @Override
    public void visit(If o) {
        o.getListIf().accept(this);
        stream.print("else");
        ListInst insts = o.getInstElse();
        this.visitBlock(insts);
    }

    @Override
    public void visit(IfThen o) {
        stream.print("(");
        o.getCondition().accept(this);
        stream.print(")");
        ListInst insts = o.getInsts();
        this.visitBlock(insts);
    }

    @Override
    public void visit(Initialization o) {
        stream.print(" = ");
        o.getExpr().accept(this);
    }
    
}
