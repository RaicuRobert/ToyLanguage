package model;

public interface MyIList<T> extends Iterable<T> {
	void add(T elem);
	void remove(T elem) throws MyDataException;
	T get(int pos) throws MyDataException;
	String toString();
}
