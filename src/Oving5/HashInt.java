package Oving5;

public class HashInt {
	int key;
	int value;
	HashInt next;
	
	public HashInt(){
		
	}
	
	public HashInt(int k, int v){
		key = k;
		value = v;
	}
	
	public int getValue(){
		return value;
	}
	
	public int getKey(){
		return key;
	}
}
