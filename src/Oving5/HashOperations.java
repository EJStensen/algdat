package Oving5;

import java.util.HashMap;

public class HashOperations {
	
	//size 2^23, closest 2^x after 5*10^6
	private final int size = 8388608;
	private HashInt[] table = new HashInt[size];
	
	public void fillHashTable(int[] input){
		int collisions = 0;
		
		for (int i = 0; i < input.length; i++){
			int userhash = h1(input[i]);
			int hash = getSupplementalHash(userhash);
			
			HashInt newEntry = new HashInt(hash, input[i]);
			if (table[hash] == null){
				//System.out.println("Putting key: "+hash+", value: "+input+" to list");
				table[hash] = newEntry;
			} else {
				int hash2 = h2(hash);
				if (table[hash2] == null){
					table[hash2] = newEntry;
				} else {
					collisions++;
				}
			}
		}
		System.out.println("Collisions: "+collisions);
	}
	
	public void benchmarkHashInt(int[] input){
		HashInt[] benchmark = new HashInt[size];
		for (int i = 0; i < input.length; i++){
			int userhash = h1(input[i]);
			int hash = getSupplementalHash(userhash);
			
			HashInt newEntry = new HashInt(hash, input[i]);
			if (benchmark[hash] == null){
				benchmark[hash] = newEntry;
			} else {
				int hash2 = h2(hash);
				if (benchmark[hash2] == null){
					benchmark[hash2] = newEntry;
				}
			}
		}
	}
	
	public void benchmarkHashMap(int[] input){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++){
			int userhash = h1(input[i]);
			int hash = getSupplementalHash(userhash);
			if (!map.containsKey(hash)){
				map.put((Integer) hash, (Integer) input[i]);
			} else {
				int hash2 = h2(hash);
				if (!map.containsKey(hash2)){
					map.put((Integer) hash2, (Integer) input[i]);
				}
			}
		}
	}
	
	private int h1(int key){
		return key % size;
	}
	
	private int h2(int key){
		return (key+1)%size;
	}
	
	/**
	 * * REFERENCE: JAVA SOURCE CODE *
	 * 
	 * Applies a supplemental hash function to a given hashCode, which defends
	 * against poor quality hash functions. This is critical because HashMap
	 * uses power-of-two length hash tables, that otherwise encounter collisions
	 * for hashCodes that do not differ in lower bits. Note: Null keys always
	 * map to hash 0, thus index 0.
	 */
	private int getSupplementalHash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}
}
