package model;

public class PrintStmt implements IStmt {
	////////
	Exp exp;
	
	public PrintStmt(Exp exp) {
		this.exp=exp;
	}

	@Override
	public String toString() {
		return "(print: "+exp.toString()+")";
	}

	@Override
	public PrgState execute(PrgState state) throws MyStmtExecException {
		try {
			state.getOut().add(exp.eval(state.getSymTable()));
		} catch (MyExpExecException e) {
			// TODO Auto-generated catch block
			throw new MyStmtExecException("Error evaluating: "+e.getMessage());
		}
		return state;
	}

}
