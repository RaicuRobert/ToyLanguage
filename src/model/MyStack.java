package model;
import java.util.Stack;
public class MyStack<T> implements MyIStack<T>{
	
	Stack<T> stack ;
	
	public MyStack(){
		stack=new Stack<T>();
	}
	
	public MyStack(Stack<T> stack){
		this.stack=stack;
	}
	
	@Override
	public T pop() throws MyStackException {
		isEmpty();
		return stack.pop();
	}

	@Override
	public void push(T v) {
		stack.push(v);
	}

	@Override
	public void clear() {
		stack.clear();
	}

	@Override
	public boolean isEmpty() throws MyStackException {
		if(stack.isEmpty())	
			throw new MyStackException("Stack si empty!");
		return false;
	}
	
	@Override
	public String toString(){
		String msg="";
		for(T el : stack)
			msg=el.toString()+'\n'+msg;
		return msg;
	}

}
