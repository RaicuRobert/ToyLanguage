package View;

import java.util.Scanner;

import model.*;

public class StmtBuilder {
	Scanner input = new Scanner(System.in);
	public StmtBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	int getInt(String msg){
		try{
			if(msg.length()>1)
				System.out.println(msg);
			return input.nextInt();
		}
		catch (Exception e){
			print("Wrong data type!");
			return getInt(msg);
		}
	}
	
	public String getStr(String msg){
		try{
			if(msg.length()>1)
				System.out.println(msg);
			return input.next();
		}
		catch(Exception e){
			print("Wrong data type!");
			return getStr(msg);
		}
	}
	
	void print(String str){
		System.out.println(str);
	}
	
	public IStmt CompStmt(){
		print("CompStmt( here , ???)");
		IStmt s1 =createStatement();
		print("CompStmt( "+s1.toString()+" , here)");
		IStmt s2 =createStatement();
		print("CompStmt( "+s1.toString()+" , "+s2.toString()+")");
		return new CompStmt(s1,s2);
	}
	public IStmt AssigStmt(){
		print("AssigStmt( here , ???)");
		String var=getStr("Var name: ");
		print("AssigStmt( "+var+", here)");
		Exp e=createExpression();
		print("AssigStmt( "+var+", "+e.toString()+")");
		return new AssignStmt(var,e);
	}
	
	public IStmt PrintStmt(){
		print("Print: here");
		return new PrintStmt(createExpression());
	}
	
	public IStmt IfStmt(){
		print("IfStmt(here,????,???)");
		Exp e= createExpression();
		print("IfStmt("+e.toString()+",here,???)");
		IStmt s1= createStatement();
		print("IfStmt("+e.toString()+","+s1.toString()+",here)");
		IStmt s2 = createStatement();
		print("IfStmt("+e.toString()+","+s1.toString()+","+s2.toString()+")");
		return new IfStmt(e,s1,s2);
	}
	
	public Exp ConstExp(){
		print("ContsExpr( here )");
		Exp e =new ConstExpr(getInt("Enter Integer: "));
		print("ContsExpr("+e.toString()+" )");
		return e;
	}
	
	public Exp ArithExp(){
		print("ArithExp( here , ??? , ???)");
		Exp e1 =createExpression();
		print("ArithExp( "+e1.toString()+", here , ???)");
		Exp e2 = createExpression();
		print("ArithExp( "+e1.toString()+","+e2.toString()+" , here)");
		int op = getInt("1.+\n2.-\n3.*\n4./\n Enter option: ");
		print("ArithExp( "+e1.toString()+","+e2.toString()+" , "+op+")");
		return new ArithExp(e1,e2,op);
	}
	
	public Exp VarExp(){
		print("VarExp( here )");
		Exp e=new VarExp(getStr("Var name: "));
		print("VarExp( "+e.toString()+")");
		return e;
	}
	
	public Exp createExpression(){
		System.out.println("1.ConstExp\n2.ArithExp\n3.VarExp\n");
		int option=getInt("Enter option: ");
		print("\n");
		Exp e=null;
		switch(option){
			case 1: e = ConstExp(); break;
			case 2: e = ArithExp();	break;
			case 3: e = VarExp();	break;
			default:print("No such option!");return createExpression();
		}
		//print(e.toString()); 
		return e;
	}
	
	public IStmt createStatement(){
		System.out.println("1.CompStmt\n2.AssigStmt\n3.PrintStmt\n4.IfStmt\n");
		int option = getInt("Enter option: ");
		print("\n");
		IStmt s = null;
		switch(option){
			case 1: s= CompStmt();break;
			case 2: s= AssigStmt();break;
			case 3: s=PrintStmt();break;
			case 4: s=IfStmt();break;
			default:print("No such option!");return createStatement();
		}
		//print(s.toString());
		return s;
	}
	
	public String getFileName(){
		return getStr("Enter log file: ");
	}

}
