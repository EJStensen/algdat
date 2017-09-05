package Oving3;

import java.util.Random;

public class QuicksortOppgaveEn {
		
	public static void sort(int length, int limit){
		int[] unsortedarray =  RandomArray(length);
		if (unsortedarray == null || unsortedarray.length == 0) return;
		long start = System.currentTimeMillis();
		int[] sortedarray = Quicksort(unsortedarray, 0, unsortedarray.length - 1, limit);
		long end = System.currentTimeMillis();
		boolean testfailed = false;
		
		for (int i = 0; i < sortedarray.length - 2; i++){
			if (!(sortedarray[i+1] >= sortedarray[i])){
				testfailed = true;
				break;
			}
		}
		if (testfailed == true) System.out.println("Sorting failed");
		else System.out.println("Time used: "+(end-start)+" ms. Array length: "+length+ ". Limit: "+limit);
		
		if (sortedarray.length <= 10){
			for (int i = 0; i < sortedarray.length; i++){
				System.out.println(sortedarray[i]);
			}
		}
	}
	
	private static int[] Quicksort(int[] array, int left, int right, int limit){
		int i = left, j = right;
		int[] output = array;
		if ((right-left) <= limit) output = InsertionSort(array, left, right);
		else {
			int median = array[i + (j-i)/2];
			while(i <= j){
				while(array[i] < median) i++;
				while(array[j] > median) j--;
				if (i <= j){
					output = ChangePosition(array, i, j);
					i++;
					j--;
				}
			}
			if(left < j) Quicksort(output, left, j, limit);
			if(i < right) Quicksort(output, i, right, limit);
		}
		return output;
	}
	
	private static int[] InsertionSort(int[] input, int start, int end){
		int i, j;
		for (j = start + 1; j <= end; j++){
			int temp = input[j];
			i = j;
			
			while (i > start && input[i - 1] >= temp){
				input[i] = input[i -1];
				i--;
			}
			input[i] = temp;
		}
		return input;
	}
	
	private static int[] ChangePosition(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}
	
	private static int[] RandomArray(int length){
		java.util.Random ran = new Random();
		int[] output = new int[length];
		for(int i = 0; i < length; i++){
			output[i] = ran.nextInt((100000 - (0)) + 1) + 0;
		}
		return output;
	}
	
	public static void main(String[] args){
		int arraylength = 1000000;
		int[] limit = new int[] {30, 50, 70, 100, 150, 200, 300, 400, 500, 750, 1000};
		
		for (int i = 0; i < limit.length; i++){
			sort(arraylength, limit[i]);
		}
	}
}
