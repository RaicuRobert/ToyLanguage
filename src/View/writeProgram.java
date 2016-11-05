package View;

import controller.MyController;
import controller.MyControllerException;
import repository.MyIRepo;
import repository.MyRepo;
import repository.MyRepoException;

public class writeProgram extends Command {

	public writeProgram(String key, String description) {
		super(key, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		try{

			MyIRepo repo = new MyRepo("log3.txt");
			MyController ctr = new MyController(repo);
			StmtBuilder bd = new StmtBuilder();
			ctr.addProgram(bd.createStatement());
			ctr.allStep();
		 }
		 catch (MyControllerException | MyRepoException e) {
				System.out.println(e.getMessage());
		}
	}

}
