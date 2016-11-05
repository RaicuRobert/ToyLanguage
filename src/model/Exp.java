package model;

public abstract class Exp {
	public abstract int eval(MyIDictionary<String,Integer> tbl) throws MyExpExecException;
	public abstract String toString();
}
