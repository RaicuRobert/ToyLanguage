package Test;
import java.io.BufferedReader;

import model.*;

public class ModelTest {
	
	
	
	public ModelTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void start(){
		try {
			test_ConstExp();
			test_ArithExp();
			test_VarExp();
			test_AssignStmt();
			test_PrintStmt();
			test_CompStmt();
			test_IfStmt();
		} catch (MyExpExecException | MyStackException | MyDataException | MyStmtExecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void test_ConstExp() throws MyExpExecException{
		Exp e = new ConstExpr(3);
		assert(3==e.eval(null));
	}
	
	void test_ArithExp() throws MyExpExecException{
		Exp e= new ArithExp(new ConstExpr(3),new ConstExpr(3),1);
		assert(6==e.eval(null));
	}
	
	void test_VarExp() throws MyExpExecException{
		Exp e2 = new VarExp("x");
		MyIDictionary d = new MyDictionary();
		d.put("x",2);
		assert(2==e2.eval(d));
	}
	
	void test_AssignStmt() throws MyStmtExecException, MyStackException, MyDataException{
		MyIStack<IStmt> stk = new MyStack<IStmt>();
		MyIDictionary<String,Integer> symtbl =new MyDictionary<String,Integer>();
		MyIList<Integer> out = new MyList<Integer>();
		MyIFileTable<Integer,Pair<String,BufferedReader>> fileTable = new MyFileTable<Integer,Pair<String,BufferedReader>>();
		PrgState s= new PrgState(stk,symtbl,fileTable, out,new AssignStmt("x",new ConstExpr(3)));
		s.getExeStack().pop().execute(s);
		assert(3==s.getSymTable().get("x"));
	}
	
	void test_PrintStmt() throws MyStmtExecException, MyStackException, MyDataException{
		
		MyIStack<IStmt> stk = new MyStack<IStmt>();
		MyIDictionary<String,Integer> symtbl =new MyDictionary<String,Integer>();
		MyIList<Integer> out = new MyList<Integer>();
		IStmt stmt = new PrintStmt(new ConstExpr(2));
		PrgState s= new PrgState(stk,symtbl,null, out,stmt);
		
		s.getExeStack().pop().execute(s);
		assert(2==s.getOut().get(0));
	}
	
	void test_CompStmt() throws MyStmtExecException, MyStackException, MyDataException{
		IStmt stmt = new CompStmt(new PrintStmt(new ConstExpr(2)),new PrintStmt(new ConstExpr(3)));
		
		MyIStack<IStmt> stk = new MyStack<IStmt>();
		MyIDictionary<String,Integer> symtbl =new MyDictionary<String,Integer>();
		MyIList<Integer> out = new MyList<Integer>();
		PrgState s= new PrgState(stk,symtbl,null, out,stmt);
		
		s.getExeStack().pop().execute(s);
		s.getExeStack().pop().execute(s);
		s.getExeStack().pop().execute(s);
		assert(2==s.getOut().get(0));
		assert(3==s.getOut().get(1));
	}
	
	void test_IfStmt() throws  MyStmtExecException, MyStackException, MyDataException{
		IStmt stmt = new IfStmt(new ConstExpr(1),new PrintStmt(new ConstExpr(2)),new PrintStmt(new ConstExpr(3)));
		MyIStack<IStmt> stk = new MyStack<IStmt>();
		MyIDictionary<String,Integer> symtbl =new MyDictionary<String,Integer>();
		MyIList<Integer> out = new MyList<Integer>();
		PrgState s= new PrgState(stk,symtbl,null, out,stmt);
		
		s.getExeStack().pop().execute(s);
		s.getExeStack().pop().execute(s);
		
		assert(2==s.getOut().get(0));
	}
	
	
	
}
