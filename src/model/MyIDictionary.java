package model;


public interface MyIDictionary<TKey,TValue> {
	void put(TKey key,TValue value);
	void remove(TKey key) throws MyDataException;
	TValue get(TKey key) throws MyDataException;
	boolean containsKey(TKey key) throws MyDataException;
	boolean containsValue(TValue value) throws MyDataException;
	String toString();
}
