package Oving7;

public class Queue {

	private Object[] array;
	private int start = 0;
	private int stop = 0;
	private int number = 0;
	
	public Queue(int size) {
		array = new Object[size];
	}
	
	public boolean isEmpty() {
		return number == 0;
	}
	
	public boolean isFull() {
		return number == array.length;
	}
	
	public void addToQueue(Object e) {
		if (isFull()) return;
		array[stop] = e;
		stop = (stop + 1) % array.length;
		number++;
	}
	
	public Object nextInQueue() {
		if (!isEmpty()) {
			Object e = array[start];
			start = (start + 1) % array.length;
			--number;
			return e;
		}
		else return null;
	}
	
	public Object checkQueue() {
		if (!isEmpty()) return array[start];
		else return null;
	}
}
