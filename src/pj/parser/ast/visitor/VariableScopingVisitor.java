package pj.parser.ast.visitor;

import java.util.Iterator;

import pj.parser.ast.TypeParameter;
import pj.parser.ast.body.BodyDeclaration;
import pj.parser.ast.body.ClassOrInterfaceDeclaration;
import pj.parser.ast.body.ConstructorDeclaration;
import pj.parser.ast.body.FieldDeclaration;
import pj.parser.ast.body.MethodDeclaration;
import pj.parser.ast.body.Parameter;
import pj.parser.ast.body.VariableDeclarator;
import pj.parser.ast.body.VariableDeclaratorId;
import pj.parser.ast.expr.Expression;
import pj.parser.ast.expr.FieldAccessExpr;
import pj.parser.ast.expr.NameExpr;
import pj.parser.ast.expr.VariableDeclarationExpr;
import pj.parser.ast.stmt.BlockStmt;
import pj.parser.ast.stmt.CatchClause;
import pj.parser.ast.stmt.ForStmt;
import pj.parser.ast.stmt.ForeachStmt;
import pj.parser.ast.stmt.Statement;
import pj.parser.ast.stmt.SwitchEntryStmt;
import pj.parser.ast.stmt.SwitchStmt;
import pj.parser.ast.stmt.TryStmt;
import pj.parser.ast.symbolscope.ScopeInfo;
import pj.parser.ast.symbolscope.Symbol;
import pj.parser.ast.symbolscope.Symbol.SymbolType;
import pj.parser.ast.symbolscope.SymbolTable;
import pj.parser.ast.type.ClassOrInterfaceType;
import pj.parser.ast.type.PrimitiveType;
import pj.parser.ast.type.Type;


public class VariableScopingVisitor extends GenericVisitorAdapter<String,Object>{
	
	SymbolTable symbolTable = new SymbolTable();

	public String visit(BlockStmt n, Object arg) {
		this.symbolTable.enterNewScope("normalBlock", ScopeInfo.Type.StatementScope);
		if (n.getStmts() != null) {
            for (Statement s : n.getStmts()) {
                s.accept(this, arg);
            }
        }
        this.symbolTable.exitScope();
        return null;
	}
	
	public String visit(ClassOrInterfaceDeclaration n, Object arg) {		
		String className = n.getName();

		/////////////////////////////////////////
        if (n.getTypeParameters() != null) {
            for (Iterator<TypeParameter> i = n.getTypeParameters().iterator(); i.hasNext();) {
                TypeParameter t = i.next();
                t.accept(this, arg);
            }
        }
        if (n.getExtends() != null) {
            for (Iterator<ClassOrInterfaceType> i = n.getExtends().iterator(); i.hasNext();) {
                ClassOrInterfaceType c = i.next();
                c.accept(this, arg);
            }
        }
        if (n.getImplements() != null) {
            for (Iterator<ClassOrInterfaceType> i = n.getImplements().iterator(); i.hasNext();) {
                ClassOrInterfaceType c = i.next();
                c.accept(this, arg);
            }
        }
        //////////////////////////////////////////
		this.symbolTable.enterNewScope(className, ScopeInfo.Type.ClassScope);
        //Visit the main body of class
        if (n.getMembers() != null) {
        	for (BodyDeclaration member : n.getMembers()) {
                member.accept(this, arg);
            }
        }
        this.symbolTable.exitScope();
        return null;
    }
	
	public String visit(MethodDeclaration n, Object arg) {
		
		/*
		 * Firstly add method name symbol to parent scope
		 */
		Type type = n.getType();
		String methodReturnType = type.accept(this, arg);
		String methodName = n.getName();
		Symbol symbol = new Symbol(methodName,  this.symbolTable.getCurrentScope(), methodReturnType, SymbolType.ClassMemberField);
		this.symbolTable.addSymbolDeclaration(methodName, symbol);
		/*
		 * secondly enter new scope which this method holds
		 */
		this.symbolTable.enterNewScope(methodName, ScopeInfo.Type.MethodScope);
		/*
		 * thirdly visit all parameters and method body
		 */
		 if (n.getParameters() != null) {
	            for (Iterator<Parameter> i = n.getParameters().iterator(); i.hasNext();) {
	                Parameter p = i.next();
	                p.accept(this, arg);
	            }
	     }
		 if (n.getBody() != null) {
	            n.getBody().accept(this, arg);
	     }
		 /*
		  * finally exit current method scope
		  */
		 this.symbolTable.exitScope();
		 return null;
	}
	
	public String visit(ConstructorDeclaration n, Object arg) {
		/*
		 * Firstly add method name symbol to parent scope
		 */
		String ReturnType = "Constructor";
		String constructorName = n.getName();
		Symbol symbol = new Symbol(constructorName,  this.symbolTable.getCurrentScope(), ReturnType, SymbolType.ClassMemberField);
		this.symbolTable.addSymbolDeclaration(constructorName, symbol);
		/*
		 * secondly enter new scope which this method holds
		 */
		this.symbolTable.enterNewScope(constructorName, ScopeInfo.Type.MethodScope);
		/*
		 * thirdly visit all parameters and method body
		 */
		 if (n.getParameters() != null) {
	            for (Iterator<Parameter> i = n.getParameters().iterator(); i.hasNext();) {
	                Parameter p = i.next();
	                p.accept(this, arg);
	            }
	     }
		 if (n.getBlock() != null) {
	            n.getBlock().accept(this, arg);
	     }
		 /*
		  * finally exit current method scope
		  */
		 this.symbolTable.exitScope();
		 return null;
	}
	public String visit(SwitchStmt n, Object arg) {
		/*
		 * firstly enter new scope which this statement
		 */
		this.symbolTable.enterNewScope("swithchBlock", ScopeInfo.Type.StatementScope);
		/*
		 * secondly visit all nodes inside this statement
		 */
		if (n.getEntries() != null) {
            for (SwitchEntryStmt e : n.getEntries()) {
                e.accept(this, arg);
            }
        }
		/*
		 * finally exit current method scope
		 */
		this.symbolTable.exitScope();
		return null;
	}
	public String visit(ForeachStmt n, Object arg) {
		/*
		 * firstly enter new scope which this statement
		 */
		this.symbolTable.enterNewScope("ForeachStmt", ScopeInfo.Type.StatementScope);
		/*
		 * secondly visit all nodes inside this statement
		 */
	    n.getVariable().accept(this, arg);
	    n.getIterable().accept(this, arg);
		/*
		 * finally exit current method scope
		 */
		this.symbolTable.exitScope();
	    n.getBody().accept(this, arg);
		return null;
	}
	
	public String visit(ForStmt n, Object arg) {
		/*
		 * firstly enter new scope which this statement
		 */
		this.symbolTable.enterNewScope("ForStmt", ScopeInfo.Type.StatementScope);
		/*
		 * secondly visit all nodes inside this statement
		 */
		if (n.getInit() != null) {
            for (Iterator<Expression> i = n.getInit().iterator(); i.hasNext();) {
                Expression e = i.next();
                e.accept(this, arg);
            }
        }
        if (n.getCompare() != null) {
            n.getCompare().accept(this, arg);
        }
        if (n.getUpdate() != null) {
            for (Iterator<Expression> i = n.getUpdate().iterator(); i.hasNext();) {
                Expression e = i.next();
                e.accept(this, arg);
            }
        }
		/*
		 * finally exit current method scope
		 */
		this.symbolTable.exitScope();
	    n.getBody().accept(this, arg);
		return null;
	}
	    
    public String visit(TryStmt n, Object arg) {

		this.symbolTable.enterNewScope("tryBlock", ScopeInfo.Type.StatementScope);
        n.getTryBlock().accept(this, arg);
		this.symbolTable.exitScope();
        if (n.getCatchs() != null) {
            for (CatchClause c : n.getCatchs()) {
                c.accept(this, arg);
            }
        }
        if (n.getFinallyBlock() != null) {
    		this.symbolTable.enterNewScope("finalBlock", ScopeInfo.Type.StatementScope);
            n.getFinallyBlock().accept(this, arg);
    		this.symbolTable.exitScope();
        }
        
        return null;
    }

    public String visit(CatchClause n, Object arg) {

		this.symbolTable.enterNewScope("catchBlock", ScopeInfo.Type.StatementScope);
        n.getCatchBlock().accept(this, arg);
        this.symbolTable.exitScope();
        return null;

    }
	/////////////////////////////////////////////////////////////////////////////
	public String visit(NameExpr n, Object arg) {
		String varName = n.getName();
		Symbol symbol = new Symbol(varName);
		this.symbolTable.addSymbolUse(varName,symbol);
		return null;
	}

	public String visit(FieldAccessExpr n, Object arg) {
		String fieldName = n.getField();
		Symbol symbol = new Symbol(fieldName);
		this.symbolTable.addSymbolUse(fieldName,symbol);
		n.getScope().accept(this, arg);
		return null;
	}

	public String visit(Parameter n, Object arg) {
		String varName = n.getId().getName();
		Type varType = n.getType();
		String typeName = varType.accept(this, arg);
		Symbol symbol = new Symbol(varName,  this.symbolTable.getCurrentScope(), typeName, SymbolType.MethodParameter);
		this.symbolTable.addSymbolDeclaration(varName, symbol);
		return null;
	}
	
    public String visit(ClassOrInterfaceType n, Object arg) {
        if (n.getScope() != null) {
            n.getScope().accept(this, arg);
        }
        return n.getName();
    }
    
    public String visit(PrimitiveType n, Object arg) {
        switch (n.getType()) {
            case Boolean:
            	return new String("boolean");
            case Byte:
            	return new String("byte");
            case Char:
            	return new String("char");
            case Double:
            	return new String("double");
            case Float:
            	return new String("float");
            case Int:
            	return new String("int");
            case Long:
            	return new String("long");
            case Short:
            	return new String("short");
        }
        return null;
    }
    

	public String visit(VariableDeclarationExpr n, Object arg) {
		Type varType = n.getType();
		String typeName = varType.accept(this, arg);

		for (Iterator<VariableDeclarator> i = n.getVars().iterator(); i.hasNext();) {
			VariableDeclarator v = i.next();
			String varName = v.getId().getName();
			Symbol symbol = new Symbol(varName,  this.symbolTable.getCurrentScope(), typeName, SymbolType.ScopeLocalParameter);
			this.symbolTable.addSymbolDeclaration(varName, symbol);
		}
		return null;
	}

	public String visit(FieldDeclaration n, Object arg) {
		Type varType = n.getType();
		String typeName = varType.accept(this, arg);
		
		for (Iterator<VariableDeclarator> i = n.getVariables().iterator(); i.hasNext();) {
			VariableDeclarator var = i.next();
			String varName = var.getId().getName();
			Symbol symbol = new Symbol(varName,  this.symbolTable.getCurrentScope(), typeName, SymbolType.ClassMemberField);
			this.symbolTable.addSymbolDeclaration(varName, symbol);
		}
		return null;
	}
	

}
