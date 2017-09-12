package Oving4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReadFilePushStack {
	
	private Scanner sc;
	private Stack stack;

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

	private void getScannerObject() throws FileNotFoundException{
		sc = null;
		try {
			sc = new Scanner(new BufferedReader(new FileReader(getFilePath())));
		} catch (FileNotFoundException e){
			System.out.println("Could not get file path");
		}
	}
	
	private String pushToStack(){
		String output = "";
		while (sc.hasNext()){
			String line = sc.nextLine();
			if (line.contains("{")){
				stack.push('{');
				output += "{";
			}
			if (line.contains("}")){
				stack.push('}');
				output += "}";
			}
			if (line.contains("(")){
				stack.push('(');
				output += "(";
			}
			if (line.contains(")")){
				stack.push(')');
				output += ")";
			}
			if (line.contains("[")){
				stack.push('[');
				output += "[";
			}
			if (line.contains("]")){
				stack.push(']');
				output += "]";
			}
		}
		sc.close();
		return output;
	}
	
	public void scanFile(int stacksize) throws FileNotFoundException{
		getScannerObject();
		stack = new Stack(stacksize);
		String ss = pushToStack();
		System.out.println("String: "+ss);
		System.out.println("\n");
		for (int i = 0; i < ss.length(); i++){
				int pop = stack.pop();
				if ((ss.charAt(i) == 123 && pop != 125) ||
					(ss.charAt(i) == 40 && pop != 41) ||
					(ss.charAt(i) == 91 && pop != 93)){
					break;
			}
		}
		if (stack.isEmpty()) System.out.println("Clean code"); else System.out.println("Bad Code");
	}
}