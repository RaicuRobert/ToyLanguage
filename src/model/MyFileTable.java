package model;

import java.util.HashMap;
import java.util.Hashtable;

public class MyFileTable<TKey, TValue> implements MyIFileTable<TKey, TValue> {
	Hashtable<TKey,TValue> dict;
	
	public MyFileTable() {
		dict = new Hashtable<TKey, TValue>();
	}
	
	public MyFileTable(Hashtable<TKey,TValue> dict) {
		this.dict = dict;
	}

	@Override
	public void put(TKey key, TValue value) {
		dict.put(key, value);		
	}

	@Override
	public void remove(TKey key) throws MyDataException {
		containsKey(key);
		dict.remove(key);
	}

	@Override
	public TValue get(TKey key) throws MyDataException {
		containsKey(key);
		return dict.get(key);
	}

	@Override
	public boolean containsKey(TKey key) throws MyDataException {
		if(!dict.containsKey(key))
			throw new MyDataException("No such key: "+key.toString());
		return true;
	}

	@Override
	public boolean containsValue(TValue value) throws MyDataException {
		if(!dict.containsValue(value))
			throw new MyDataException("No such value: "+value.toString());
		return true;
	}
	
	
	@Override
	public String toString(){
		String msg="";
		for(TKey key : dict.keySet())
			msg+=key.toString()+" = "+dict.get(key).toString()+'\n';
		return msg;
			
	}
}
