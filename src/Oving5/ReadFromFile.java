package Oving5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {
	
	private static final int size = 128;
	//private int positionsInArray = 1;
	private int collisions = 0;
	private HashArray[] table = new HashArray[size];
	
	public boolean getFile(){
		Scanner sc = null;
		try {
			sc = new Scanner(new File("Navn.txt"));
		} catch (FileNotFoundException e){
			return false;
		}
		while(sc.hasNext()){
			String line = sc.nextLine();
			String[] fullnames = line.split("\\s+");
			//System.out.println(fullnames.length);
			if (fullnames.length == 2){
				Names newName = new Names(fullnames[0], fullnames[1]);
				int key = newName.getHashCode();
				put(newName, key);
				//System.out.println(newName.toString()+". Hash: "+getSupplementalHash(key));
			}
			if (fullnames.length == 3){
				Names newName = new Names(fullnames[0], fullnames[1], fullnames[2]);
				int key = newName.getHashCode();
				put(newName, key);
				//System.out.println(newName.toString()+". Hash: "+getSupplementalHash(key));
			}
			if (fullnames.length == 4){
				Names newName = new Names(fullnames[0], fullnames[1], fullnames[2]+fullnames[3]);
				int key = newName.getHashCode();
				put(newName, key);
				//System.out.println(newName.toString()+". Hash: "+getSupplementalHash(key));
			}
		}
		sc.close();
		System.out.println("Number of collisions: "+collisions);
		int elements = 0;
		for (int i = 0; i < size; i++){
			if (table[i] != null){
				elements++;
			}
		}
		System.out.println("Load factor: "+((double)(elements)/(double)(size)));
		return true;
	}
	
	public void put(Names key, int value){
		
		int h1 = key.getHashCode();
		HashArray newEntry = new HashArray(key, value);
		
		if (table[h1] == null){
			System.out.println("Putting key: "+key+", value: "+value+" to list");
			table[h1] = newEntry;
		} else {
			System.out.println("Collision detected for key: "+key);
			//HashArray current = table[h1];
			//collisions++;
			int hash2 = h2(h1);
			if (table[hash2] == null){
				table[h1] = newEntry;
			} else {
				collisions++;
			}
			/*
			while(current.next != null){
				if (current.getKey().equals(newEntry.getKey())){
					current.value = newEntry.value;
					return;
				}
				current = current.next;
			}
			current.next = newEntry;
			*/
		}
		
	}
	
	public boolean get(Names key){
		//int h1 = key.getHashCode();
		HashArray x = table[0];
		while (x != null){
			if (x.getKey().equals(key)){
				return true;
			}
			x = x.next;
		}
		return false;
	}
	
	public void display(){
		for (int i = 0; i < size; i++){
			if (table[i] != null){
				System.out.println(table[i].getKey());
			}
		}
	}
	
	private int h2(int h) {
		return (h+1)%size;
	}
}
