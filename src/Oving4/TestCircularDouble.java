package Oving4;

public class TestCircularDouble {
	public static void main(String[] args){
		CircularDoubleList list = new CircularDoubleList();
		System.out.println(list.isEmpty());
		int number = 10;
		for (int i = 0; i < number; i++){
			list.insertAtPosition(i, i);
		}
		list.displayList();
		list.execute(5);
	}
}
