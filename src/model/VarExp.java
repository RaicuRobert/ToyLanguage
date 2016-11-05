package model;

public class VarExp extends Exp {

	String id;
	
	public VarExp(String id) {
		this.id=id;
	}

	@Override
	public int eval(MyIDictionary<String, Integer> tbl) throws MyExpExecException {
		
		try {
			return tbl.get(id);
		} catch (MyDataException e) {
			// TODO Auto-generated catch block
			throw new MyExpExecException(e.getMessage());
		}
	}

	@Override
	public
	String toString() {
		return "("+id+")";
	}

}
