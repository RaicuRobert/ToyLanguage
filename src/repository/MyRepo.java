package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.*;

public class MyRepo implements MyIRepo {
	
	MyIList<PrgState> programs;
	String logFilePath="";
	public MyRepo(String logFile) throws MyRepoException {
		logFilePath=logFile;
		programs = new MyList<PrgState>();
		CheckFile();
	}
	
	public MyRepo(PrgState p,String logFile) throws MyRepoException {
		logFilePath=logFile;
		programs = new MyList<PrgState>();
		programs.add(p);
		CheckFile();
	}
	
	public void addProgram(IStmt prg){
		MyIStack<IStmt> stk = new MyStack<IStmt>();
		MyIDictionary<String,Integer> symtbl =new MyDictionary<String,Integer>();
		MyIFileTable<Integer,Pair<String,BufferedReader>> fileTable = new MyFileTable<Integer,Pair<String,BufferedReader>>();
		MyIList<Integer> out = new MyList<Integer>();
		programs.add(new PrgState(stk,symtbl,fileTable, out,prg));
	}
	
	public void addProgram(PrgState p){
		programs.add(p);
	}
	@Override
	public PrgState getCrtPrg() throws MyRepoException{
		try {
			return programs.get(0);
		} catch (MyDataException e) {
			// TODO Auto-generated catch block
			throw new MyRepoException("No program is available");
		}
	}

	@Override
	public void logPrgStateExec() throws MyRepoException {
		// TODO Auto-generated method stub
		try(PrintWriter logFile= new PrintWriter(new BufferedWriter(new FileWriter(logFilePath,true)))) {
			logFile.append(programs.get(0).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new MyRepoException(e.getMessage());
		}
		catch( MyDataException e){
			throw new MyRepoException(e.getMessage());
		}
	}
	
	void CheckFile() throws MyRepoException {
		File f = new File(logFilePath);
		
		try {
			if(!f.exists())
				f.createNewFile();
			else
				new PrintWriter(logFilePath).close();
		} catch (IOException e) {
				// TODO Auto-generated catch block
			throw new MyRepoException(e.getMessage());
		}
		
	}

}
