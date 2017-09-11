package Oving4;

public class JosephusProblem {	
	public static void main(String[] args){
		CircularList list = new CircularList();
		int numberofpeople = 10;
		int interval = 4;
		for (int i = 0; i < numberofpeople; i++){
			list.insertAtTail(i);
		}
		
		//list.displayList();
		list.execute(interval);
		
		//list.execute(interval);
	}
}
