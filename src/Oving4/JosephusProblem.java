package Oving4;

public class JosephusProblem {
	public static void main(String[] args){
		CircularList list = new CircularList();
		int numberofpeople = 10;
		int interval = 4;
		for (int i = 0; i <= numberofpeople; i++){
			list.insertAtPosition(i+1, i);
		}
		list.displayJosephus();

	}
}
