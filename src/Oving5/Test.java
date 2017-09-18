package Oving5;

public class Test {
	public static void main(String[] args){
		ReadFromFile rff = new ReadFromFile();
		if (rff.getFile() == true) System.out.println("check ok");
		else System.out.println("failed");
	}
}
