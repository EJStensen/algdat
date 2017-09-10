package Oving4;

class Stack {
	private Object[] array;
	private int number = 0;
	
	public Stack(int length){
		array = new Object[length];
	}
	
	public boolean isEmpty(){
		return number == 0;
	}
	
	public boolean isFull(){
		return number == array.length;
	}
	
	public void push(Object e){
		if (!isFull()) array[number++] = e;
	}
	
	public Object pop(){
		if (!isEmpty()) return array[--number];
		else return null;
	}
	
	public Object checkStack(){
		if(!isEmpty()) return array[number-1];
		else return null;
	}
}
