package Oving10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	
	public static boolean regextest(String regex, String testString) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(testString);
		return m.matches();
	}
	
	public static void main(String[] args) {
		//regex: (character* (digit) character*)*
		String stringOne = "aaa1aaa", regexOne = "([a-zA-Z]*\\d[a-zA-Z]*)*";
		
		//regex: two digits / two digits / four digits
		String stringTwo = "14/05/2007", regexTwo = "\\d{2}/\\d{2}/\\d{4}";
		
		//regex: any character atleast ten times
		String stringThree = "abcdefghij", regexThree = ".{10,}";
		
		//regex: (character* (digit | non-character) character*)*
		String stringFour = "aaaa5aasdasd", regexFour = "([a-zA-Z]*(\\d|\\W)[a-zA-Z]*)*";

		System.out.println(regextest(regexOne, stringOne));
		System.out.println(regextest(regexTwo, stringTwo));
		System.out.println(regextest(regexThree, stringThree));
		System.out.println(regextest(regexFour, stringFour));
	}
}
