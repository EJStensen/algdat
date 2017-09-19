package Oving5;

public class MainTaskOne {
	public static void main(String[] args){
		ReadFromFile rff = new ReadFromFile();
		rff.getFile();
		Names test = new Names("Eirik", "Johan", "Stensen");
		System.out.println(rff.get(test));
		//rff.display();
	}
}
