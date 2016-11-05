package model;

public class ArithExp extends Exp {

	Exp e1;
	Exp e2;
	int op;
	public ArithExp(Exp e1, Exp e2, int op){
		this.e1=e1;
		this.e2=e2;
		this.op=op;
	}

	@Override
	public int eval(MyIDictionary<String, Integer> tbl) throws MyExpExecException {
		//1:+,2:-,3:*,4:/
		switch(op){
			case 1:return e1.eval(tbl)+e2.eval(tbl);
			case 2:return e1.eval(tbl)-e2.eval(tbl);
			case 3:return e1.eval(tbl)*e2.eval(tbl); 
			case 4:{
				if(e2.eval(tbl)==0)
					throw new MyExpExecException("Divide by 0");
				return e1.eval(tbl)/e2.eval(tbl);
			}
			default:throw new MyExpExecException("No such operation: "+op);
		}
		
		
		
	}

	@Override
	public
	String toString() {
		return "("+e1.toString()+" op: "+op+" "+e2.toString()+")";
	}

}
