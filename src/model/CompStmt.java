package model;

public class CompStmt implements IStmt {

	IStmt first;
	IStmt snd;
	
	public CompStmt(IStmt first, IStmt snd) {
		this.first=first;
		this.snd=snd;
	}

	@Override
	public String toString() {
		return "("+first.toString()+";"+snd.toString()+")";
	}

	@Override
	public PrgState execute(PrgState state) {
		MyIStack<IStmt> stk=state.getExeStack();
		stk.push(snd);
		stk.push(first);
		return state;
	}

}
