package model;

public class IfStmt implements IStmt {
	
	Exp exp;
	IStmt thenS;
	IStmt elseS;
	
	public IfStmt(Exp e, IStmt t, IStmt el) {
		exp=e;
		thenS=t;
		elseS=el;
	}
	
	public String toString(){
		return "IF("+ exp.toString()+") THEN(" +thenS.toString()+")ELSE("+elseS.toString()+")";
	}

	@Override
	public PrgState execute(PrgState state) throws MyStmtExecException {
		try {
			if(exp.eval(state.getSymTable())!=0){
				state.getExeStack().push(thenS);
			}
			else
				state.getExeStack().push(elseS);
		} catch (MyExpExecException e) {
			// TODO Auto-generated catch block
			throw new MyStmtExecException("Error evaluating: "+e.getMessage());
		}
		return state;
	}
	
	

}
