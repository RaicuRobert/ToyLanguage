package Test;
import model.*;
import repository.MyIRepo;
import repository.MyRepo;
import repository.MyRepoException;
public class RepoTest {

	public RepoTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void start(){
		
	}
	
	void test_addProgram() throws MyExpExecException, MyStackException, MyDataException, MyRepoException, MyStmtExecException{
		MyIRepo repo = new MyRepo(null);
		repo.addProgram(new PrintStmt(new ConstExpr(3)));
		repo.getCrtPrg().getExeStack().pop().execute(repo.getCrtPrg());
		
		assert(3==repo.getCrtPrg().getOut().get(0));
	}

}
