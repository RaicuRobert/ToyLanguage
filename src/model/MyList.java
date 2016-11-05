package model;

import java.util.ArrayList;
import java.util.Iterator;

public class MyList<T> implements MyIList<T> {
	
	ArrayList<T> list;
	public MyList(){
		list = new ArrayList<T>();
	}
	
	public MyList(ArrayList<T> list){
		this.list=list;
	}
	
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public void add(T elem) {
		list.add(elem);		
	}

	@Override
	public void remove(T elem) throws MyDataException {
		if(!list.contains(elem))
			throw new MyDataException("No such element: "+elem.toString());
		list.remove(elem);
	}
	@Override
	public String toString(){
		String msg="";
		for(T el : list)
			msg+=el.toString()+'\n';
		return msg;
	}
	
	public T get(int pos) throws MyDataException{
		try{
		return list.get(pos);
		}
		catch (Exception e){
			throw new MyDataException("Invalid pos in List");
		}
	}

}
