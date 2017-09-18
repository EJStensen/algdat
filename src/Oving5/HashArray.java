package Oving5;

public class HashArray {

	Names key;
	int value;
	HashArray next;
	
	public HashArray(){
		
	}

	public HashArray(Names k, int v){
		key = k;
		value = v;
	}
	
	public int getValue(){
		return value;
	}
	
	public Names getKey(){
		return key;
	}
}
