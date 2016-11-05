package model;

import java.io.BufferedReader;

public class PrgState {

	
	
	MyIStack<IStmt> exeStack;
	MyIDictionary<String,Integer> symTable;
	MyIList<Integer> out;
	MyIFileTable<Integer,Pair<String,BufferedReader>> fileTable;
	

	IStmt originalProgram;
	
	public PrgState(MyIStack<IStmt> stk, MyIDictionary<String,Integer> symtbl,MyIFileTable<Integer,Pair<String,BufferedReader>> fileTable, MyIList<Integer> ot, IStmt prg) {
		exeStack=stk;
		symTable=symtbl;
		out=ot;
		this.fileTable=fileTable;
		originalProgram=prg;
		stk.push(prg);
	}
	//**********************
	
	public String toString(){
		String msg="";
		msg+="____________________________\n\n";
		msg+="Stack:\n"+exeStack.toString()+"\n";
		msg+="StmTable:\n"+symTable.toString()+"\n";
		msg+="FileTable:\n"+fileTable.toString()+"\n";
		msg+="Out:\n"+out.toString()+"\n\n";
		
		return msg;
	}
	
	//getters setters
	public MyIStack<IStmt> getExeStack() {
		return exeStack;
	}

	public void setExeStack(MyIStack<IStmt> exeStack) {
		this.exeStack = exeStack;
	}

	public MyIDictionary<String, Integer> getSymTable() {
		return symTable;
	}

	public void setSymTable(MyIDictionary<String, Integer> symTable) {
		this.symTable = symTable;
	}

	public MyIList<Integer> getOut() {
		return out;
	}

	public void setOut(MyIList<Integer> out) {
		this.out = out;
	}

	public IStmt getOriginalProgram() {
		return originalProgram;
	}

	public void setOriginalProgram(IStmt originalProgram) {
		this.originalProgram = originalProgram;
	}
	
	public MyIFileTable<Integer, Pair<String, BufferedReader>> getFileTable() {
		return fileTable;
	}

	public void setFileTable(MyIFileTable<Integer, Pair<String, BufferedReader>> fileTable) {
		this.fileTable = fileTable;
	}
}
