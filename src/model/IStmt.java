package model;

public interface IStmt {
	String toString();
	PrgState execute(PrgState state) throws MyStmtExecException;
	//************
}
