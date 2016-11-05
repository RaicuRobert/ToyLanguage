package model;

public class ConstExpr extends Exp {
	
	int number;
	
	public ConstExpr(int number) {
		this.number=number;
	}

	@Override
	public int eval(MyIDictionary<String, Integer> tbl) {
		return number;
	}

	@Override
	public
	String toString() {
		return "("+number+")";
	}

}
