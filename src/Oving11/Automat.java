package Oving11;

public class Automat {
	
	private char[] inputAlphabet;
	private boolean[] acceptCondition;
	private int[][] nextCondition;

	public Automat(char[] inputAlphabet, boolean[] acceptCondition, int[][] nextCondition) {
		this.inputAlphabet = inputAlphabet;
		this.acceptCondition = acceptCondition;
		this.nextCondition = nextCondition;
	}
	
	public boolean checkInput(char[] input) {
		boolean result = false;
		int position = 0;
		int index1 = 0;
		int index2 = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 'e') return false;
			index1 = Character.getNumericValue(input[i]);
			if (index1 > 1) index1 = getAlphabetPosition(input[i]);
			index2 = nextCondition[position][index1];
			position = index2;
			result = acceptCondition[index2];
		}
		return result;
	}
	
	public int getAlphabetPosition(char input) {
		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h",
							 "i", "j", "k", "l", "m", "n", "o", "p",
							 "q", "r", "s", "t", "u", "v", "w", "x",
							 "y", "z"};
		int result = 0;
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i].equals(String.valueOf(input))) {
				result = i;
			}
		}
		return result;
	}
}