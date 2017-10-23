package Oving4;

public class Stack {
	private int[] array;
	private int number = 0;
	
	public Stack(int length){
		array = new int[length];
	}
	
	public boolean isEmpty(){
		return number == 0;
	}
	
	public boolean isFull(){
		return number == array.length;
	}
	
	public void push(int check){
		if (!isFull()) array[number++] = check;
	}
	
	public int pop(){
		if (!isEmpty()) return array[--number];
		else return 0;
	}
	
	public int checkStack(){
		if(!isEmpty()) return array[number-1];
		else return 0;
	}
}
