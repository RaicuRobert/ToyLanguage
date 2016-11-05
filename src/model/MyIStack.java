package model;

public interface MyIStack<T> {
	T pop() throws MyStackException;
	void push(T v);
	void clear();
	boolean isEmpty() throws MyStackException;
	String toString();
}
