package Oving11;

public class Main {
	public static void main(String[] args) {
		boolean[] acceptConditionsNumbers = {false, false, true, false};
		int[][] nextCondition1 = new int[acceptConditionsNumbers.length][2];
		
		nextCondition1[0][0] = 1;
		nextCondition1[0][1] = 3;
		nextCondition1[1][0] = 1;
		nextCondition1[1][1] = 2;
		nextCondition1[2][0] = 2;
		nextCondition1[2][1] = 3;
		nextCondition1[3][0] = 3;
		nextCondition1[3][1] = 3;
		
		Automat automat1 = new Automat(new char[]{'0','1'}, acceptConditionsNumbers, nextCondition1);
		
		System.out.println("inputalfabet {0, 1}");
		System.out.println("e->"+automat1.checkInput(new char[] {'e'}));
		System.out.println("010->"+automat1.checkInput(new char[] {'0','1','0'}));
		System.out.println("111->"+automat1.checkInput(new char[] {'1','1','1'}));
		System.out.println("010110->"+automat1.checkInput(new char[] {'0','1','0','1','1','0'}));
		System.out.println("001000->"+automat1.checkInput(new char[] {'0','0','1','0','0','0'}));
		
		boolean[] acceptConditionsChar = {false, false, false, false, true};
		int[][] nextCondition2 = new int[acceptConditionsChar.length][2];
		
		nextCondition2[0][0] = 1;
		nextCondition2[0][1] = 2;
		nextCondition2[1][0] = 3;
		nextCondition2[1][1] = 4;
		nextCondition2[2][0] = 4;
		nextCondition2[2][1] = 3;
		nextCondition2[3][0] = 3;
		nextCondition2[3][1] = 3;
		nextCondition2[4][0] = 4;
		nextCondition2[4][1] = 4;
		
		Automat automat2 = new Automat(new char[]{'a','b'}, acceptConditionsChar, nextCondition2);
		
		System.out.println("\ninputalfabet {a, b}");
		System.out.println("abbb->"+automat2.checkInput(new char[] {'a','b','b','b'}));
		System.out.println("aaab->"+automat2.checkInput(new char[] {'a','a','a','b'}));
		System.out.println("babab->"+automat2.checkInput(new char[] {'b','a','b','a','b'}));
	}
}
