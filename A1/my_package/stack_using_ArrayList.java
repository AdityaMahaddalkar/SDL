package m_package;
import java.util.*;

public class stack_using_ArrayList<T>{
	private ArrayList<T> Al;
	private int top;
	
	public stack_using_ArrayList(){
		ArrayList<T> Al = new ArrayList<T>();
		top = 0;
	}
	
	public void push(T element){
		try{
			Al.add(element);
			top += 1;
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public Object pop(){
		
		try{
			Object return_value = Al.remove(top-1);
			top -= 1;
			return return_value;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return -1;
	}
	
	public Object peek(){
		
		try{
			Object return_value = Al.get(top-1);
			return return_value;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return -1;
	}
}
