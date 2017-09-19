package Oving5;

public class MainTaskTwo {
	
	private final static int size = 5000000;
	private final static int min = 0;
	private final static int max = 25000000;
	
	private static int[] fillArray(){
		int[] output = new int[size];
		java.util.Random ran = new java.util.Random();
		long start = System.currentTimeMillis();
		for (int i = 0; i < output.length; i++){
			output[i] = ran.nextInt((max - (min)) + 1) + (min);
		}
		long stop = System.currentTimeMillis();
		System.out.println("Time to fill array: "+(stop-start)+" ms");
		return output;
	}
	
	public static void benchmarkHashInt(int[] input){
		HashOperations h = new HashOperations();
		long start = System.currentTimeMillis();
		h.benchmarkHashInt(input);
		long stop = System.currentTimeMillis();
		System.out.println("Time used: "+(stop-start)+" ms (custom)");
	}
	
	public static void benchmarkHashMap(int[] input){
		HashOperations h = new HashOperations();
		long start = System.currentTimeMillis();
		h.benchmarkHashInt(input);
		long stop = System.currentTimeMillis();
		System.out.println("Time used: "+(stop-start)+" ms (hashmap)");
	}
	
	public static void main(String[] args){
		int[] table = fillArray();
		//HashOperations ho = new HashOperations();
		//ho.fillHashTable(table);
		benchmarkHashInt(table);
		benchmarkHashMap(table);
		
	}
}
