package controller;

import model.*;
import repository.MyIRepo;
import repository.MyRepo;
import repository.MyRepoException;

public class MyController {
	/////////////////////////
	
	public MyIRepo repo;
	boolean debug=false;
	public MyController(MyIRepo repo){
		this.repo=repo;
	}
	public MyController(String filePath) throws MyControllerException {
		try {
			repo=new MyRepo(filePath);
		} catch (MyRepoException e) {
			// TODO Auto-generated catch block
			throw new MyControllerException(e.getMessage());
		}
	}
	
	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public void addProgram(IStmt prg){
		repo.addProgram(prg);
	}
	
	public PrgState oneStep(PrgState state) throws MyControllerException{
		try{
			MyIStack<IStmt> stk = state.getExeStack();
			if(stk.isEmpty());
			IStmt crtStmt=stk.pop();
			return crtStmt.execute(state);
		}
		catch(MyStackException e){
			throw new MyControllerException("Program finished!\n");
		}
		 catch(MyStmtExecException e){
			 throw new MyControllerException("Cannot step: "+e.getMessage());
		 }
		 
	}
	
	public void allStep() throws MyControllerException{
		String output="";
		try{
		 PrgState prg = repo.getCrtPrg();
		 output+=prg.toString();
			 while(true){
				oneStep(prg);
				repo.logPrgStateExec();
				output+=prg.toString();
			} 
			
		 }
		
		 catch(MyControllerException |MyRepoException  e){
			 if(debug)
				 throw new MyControllerException(output+e.getMessage());
			 else 
				 throw new MyControllerException(e.getMessage());
		 } 
	}

	
	

}
