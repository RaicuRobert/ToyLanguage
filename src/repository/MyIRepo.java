package repository;

import model.IStmt;
import model.MyDataException;
import model.PrgState;

public interface MyIRepo {
	void addProgram(IStmt prg);
	void addProgram(PrgState p);
	PrgState getCrtPrg() throws MyRepoException ;
	void logPrgStateExec() throws MyRepoException;
}
