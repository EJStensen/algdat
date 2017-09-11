package Oving4;

public class JosephusProblem {	
	public static void main(String[] args){
		CircularList list = new CircularList();
		int numberofpeople = 10;
		int interval = 4;
		for (int i = 1; i < numberofpeople+1; i++){
			list.insertToList(i);
		}
		list.execute(interval);
	}
}
