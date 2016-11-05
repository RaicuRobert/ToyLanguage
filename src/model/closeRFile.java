package model;

import java.io.IOException;

public class closeRFile implements IStmt {

	Exp var_file_id;
	
	public closeRFile(Exp id) {
		var_file_id=id;
	}

	@Override

	public PrgState execute(PrgState state) throws MyStmtExecException{
		int fileId;
		try {
			fileId=var_file_id.eval(state.getSymTable());
			state.getFileTable().get(fileId).getRight().close();
			state.getFileTable().remove(fileId);
		} catch (IOException e) {
			throw new MyStmtExecException("File error for file id="+var_file_id.toString());
		} catch (MyDataException e) {
			throw new MyStmtExecException("Data exception: "+e.toString());
		} catch (MyExpExecException e) {
			throw new MyStmtExecException("Error evaluating: "+e.getMessage());
		}
		return state;
	}
	
	public String toString(){
		return "closeRFile("+var_file_id.toString()+")";
	}

}
