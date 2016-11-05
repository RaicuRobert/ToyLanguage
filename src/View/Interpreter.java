package View;


import java.io.BufferedReader;

import Test.*;
import controller.MyController;
import controller.MyControllerException;
import model.*;
import repository.MyIRepo;
import repository.MyRepo;
import repository.MyRepoException;

public class Interpreter {
	
	

	public static void main(String[] args) throws MyRepoException{		
		
		
		ModelTest test = new ModelTest();
		test.start();
		
		StmtBuilder bd = new StmtBuilder();
		
		
		IStmt ex1=new CompStmt(new CompStmt(new openRFile("a","test.in"),new readFile(new VarExp("a"),"x")),new CompStmt(new IfStmt(new VarExp("x"),new CompStmt(new readFile(new VarExp("a"),"x"),new PrintStmt(new VarExp("x"))),new PrintStmt(new ConstExpr(0))),new closeRFile(new VarExp("a"))));
		PrgState prg1 = new PrgState(new MyStack(), new MyDictionary(), new MyFileTable<Integer,Pair<String,BufferedReader>>(), new MyList(), ex1);
		MyIRepo repo1 = new MyRepo(prg1,"log1.txt");
		MyController ctr1 = new MyController(repo1);
		
		IStmt ex2=new CompStmt(new CompStmt(new openRFile("a","test.in"),new readFile(new ArithExp(new VarExp("a"),new ConstExpr(2),1),"x")),new CompStmt(new IfStmt(new VarExp("x"),new CompStmt(new readFile(new VarExp("a"),"x"),new PrintStmt(new VarExp("x"))),new PrintStmt(new ConstExpr(0))),new closeRFile(new VarExp("a"))));
		PrgState prg2 = new PrgState(new MyStack(), new MyDictionary(),new MyFileTable<Integer,Pair<String,BufferedReader>>(), new MyList(), ex2);
		MyIRepo repo2 = new MyRepo(prg2,"log2.txt");
		MyController ctr2 = new MyController(repo2);
		
		
		TextMenu menu = new TextMenu();
		menu.addCommand(new ExitCommand("0", "exit"));
		menu.addCommand(new RunExample("1",ex1.toString(),ctr1));
		menu.addCommand(new RunExample("2",ex2.toString(),ctr2));
		menu.addCommand(new writeProgram("3","Write a new program")); //Statement builder
		
		
		menu.show();
		//contr.addProgram(bd.createStatement()); //for interactive build
		//contr.setDebug(Boolean.parseBoolean(bd.getStr("Is debug on? (true or false)")));
	}

}
