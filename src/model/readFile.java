package model;

import java.io.BufferedReader;
import java.io.IOException;

public class readFile implements IStmt {

	Exp var_file_id;
	String var_name;
	
	public readFile(Exp id, String name) {
		var_file_id=id;
		var_name=name;
		// TODO Auto-generated constructor stub
	}

	@Override
	public PrgState execute(PrgState state) throws MyStmtExecException{
		
		
		try {
			Pair<String, BufferedReader> r = state.getFileTable().get(var_file_id.eval(state.getSymTable()));
			state.getSymTable().put(var_name, Integer.parseInt(r.getRight().readLine()));
		} catch (NumberFormatException e) {
			throw new MyStmtExecException("Bad data file. Wrong format.");
		} catch (IOException e) {
			throw new MyStmtExecException("Error loading file");
		} catch (MyDataException e) {
			throw new MyStmtExecException(e.getMessage());
		} catch (MyExpExecException e) {
			throw new MyStmtExecException("Error evaluating: "+e.getMessage());
		}
		
		return state;
	}
	
	public String toString(){
		return "readFile("+var_file_id.toString()+","+var_name+")";
	}
}
