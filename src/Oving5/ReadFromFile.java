package Oving5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {
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
				System.out.println(fullnames[0]+" "+fullnames[1]);
			}
			if (fullnames.length == 3){
				System.out.println(fullnames[0]+" "+fullnames[1]+" "+fullnames[2]);
			}
			if (fullnames.length == 4){
				System.out.println(fullnames[0]+" "+fullnames[1]+" "+fullnames[2]+" "+fullnames[3]);
			}
			//System.out.println(line);
		}
		sc.close();
		return true;
	}
}
