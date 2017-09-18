package Oving5;

public class Test {
	public static void main(String[] args){
		ReadFromFile rff = new ReadFromFile();
		rff.getFile();
		Names test = new Names("Eirik", "Johan", "Stensen");
		rff.get(test);
		//rff.display();
	}
}
