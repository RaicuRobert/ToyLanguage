package model;

public class AssignStmt implements IStmt {
	
	String var;
	Exp value;
	
	public AssignStmt(String var, Exp value) {
		this.var=var;
		this.value=value;
	}

	@Override
	public String toString() {
		return "("+var+"="+value.toString()+")";
	}

	@Override
	public PrgState execute(PrgState state) throws MyStmtExecException {
		try {
			state.getSymTable().put(var, value.eval(state.getSymTable()));
		} catch (MyExpExecException e) {
			// TODO Auto-generated catch block
			throw new MyStmtExecException("Error evaluating: "+e.getMessage());
		}
		return state;
	}

}
