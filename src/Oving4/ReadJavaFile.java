package Oving4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReadJavaFile {
	
	public static String getFilePath(){
		JFileChooser jc = new JFileChooser();
		jc.setAcceptAllFileFilterUsed(false);
		jc.addChoosableFileFilter(new FileNameExtensionFilter("java files", "java"));
		String file_path = null;
		if (jc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			File file = jc.getSelectedFile();
			file_path = file.getAbsolutePath();
		} else {
			file_path = "";
		}
		return file_path;
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		String filepath = getFilePath();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filepath));
		} catch (FileNotFoundException e){
			System.out.println("File not found");
		}
		Scanner sc = new Scanner(reader);
		while(sc.hasNext()){
			System.out.println(sc.nextLine());
		}
		sc.close();
	}
}
