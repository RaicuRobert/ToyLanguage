package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class openRFile implements IStmt {

	String filename;
	String var_file_id;
	static int count=0;
	
	public openRFile(String var_file_id, String filename) {
		this.filename=filename;
		this.var_file_id=var_file_id;
	}

	@Override
	public PrgState execute(PrgState state) throws MyStmtExecException {
	//	for(Pair<String,BufferedReader> p : state.getFileTable().)
		try {
			state.getFileTable().put(count, new Pair(filename,new BufferedReader(new FileReader(filename))));
			state.getSymTable().put(var_file_id, count++);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new MyStmtExecException("No such file "+filename);
		}
		
		return state;
	}
	
	public String toString(){
		return "openRFile("+var_file_id+", "+filename+")";
	}
}
