package Oving4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReadJavaFile {

	private static String getFilePath(){
		JFileChooser jc = new JFileChooser();
		jc.setAcceptAllFileFilterUsed(false);
		jc.addChoosableFileFilter(new FileNameExtensionFilter("java", "java"));
		String file_path = null;
		if (jc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			File file = jc.getSelectedFile();
			file_path = file.getAbsolutePath();
		} else {
			file_path = "";
		}
		return file_path;
	}

	public static Scanner getScannerObject(){
		Scanner sc = null;
		try {
			sc = new Scanner(new BufferedReader(new FileReader(getFilePath())));
		} catch (FileNotFoundException e){
			return null;
		}
		return sc;
	}

	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = getScannerObject();
		Stack stack = new Stack(500);
		if (sc == null) System.out.println("Could not get file path");
		else{
			while (sc.hasNext()){
				String line = sc.nextLine();
				if (line.contains("{")) stack.push('{');
				if (line.contains("}")) stack.push('}');
				if (line.contains("(")) stack.push('(');
				if (line.contains(")")) stack.push(')');
				if (line.contains("[")) stack.push('[');
				if (line.contains("]")) stack.push(']');
			}
			sc.close();
		}
		while (!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
}
