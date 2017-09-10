package Oving4;

public class TestCircularDouble {
	public static void main(String[] args){
		CircularDoubleList list = new CircularDoubleList();
		System.out.println(list.isEmpty());
		
		list.insertAtStart(5);
		list.insertAtStart(4);
		list.insertAtStart(3);
		list.insertAtStart(2);
		list.insertAtStart(1);
		
		list.displayList();
		
	}
}
