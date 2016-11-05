package View;
import controller.*;

public class RunExample extends Command {
	 private MyController ctr;
	 public RunExample(String key, String desc,MyController ctr){
		 super(key, desc);
		 this.ctr=ctr;
	 }
	 @Override
	 public void execute() {
		 try{
			 ctr.allStep();
		 }
		 catch (MyControllerException e) {
				System.out.println(e.getMessage());
		}
	}
}
