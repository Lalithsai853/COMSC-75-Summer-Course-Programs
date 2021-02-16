/*
 * Lalithsai Posam
 * MergeTest.java
 * This program merges two sorted arrays using the merge method. It 
 * compares the value of two numbers in each array and chooses the 
 * smaller one to insert into the resulting array. There are two other 
 * methods, getArray and printArray which focus on getting the input 
 * from the user and displaying the final sorted list. 
 */

import java.util.Scanner;

public class MergeTest {
	public static void main (String[] args) {
		// Input object is created
		Scanner input = new Scanner(System.in);
		
		// Two arrays are declared and intialized using the getArray method.
		int [] array1 = getArray("list 1", input);
		int [] array2 = getArray("list 2", input);
		
		// Two arrays are merged using the merge method.
		int [] mergedArray = merge(array1, array2);
		
		// The final array is printed using the printArray method.
		printArray(mergedArray);
	}
	
	// This method takes in the user's list that they entered as input
	public static int[] getArray (String inputPrompt, Scanner userInput) {
		
		// Prompts user for the size of the array and stores the input
		System.out.print("Enter size of " + inputPrompt + ": ");
		int sizeOfArray = userInput.nextInt();
		
		// The array is declared and intialized with the correct size
		int[] userArray = new int [sizeOfArray];
		System.out.print("Enter all the items in " + inputPrompt + ": ");
		
		// This for loop fills up the array with the user's inputted values.
		for (int item = 0; item < sizeOfArray; item++) {
			userArray[item] = userInput.nextInt();
		}
		
		return userArray;
	}
	
	// This method merges both of the sorted arrays.
	public static int[] merge(int[] list1, int[] list2) {
		// The length of the arrays are declared as constants
		int length1 = list1.length;
		int length2 = list2.length;
		
		// The indices that will be used to loop through the arrays are
		// declared and intialized to 0. 
		int index1 = 0;
		int index2 = 0;
		
		// The resulting array is declared and intialized 
		int[] result = new int [length1 + length2];
		int resultIndex = 0;
		
		// This while loop loops through each list and checks which 
		// element is smaller at a given index. It adds the smaller 
		// element to the final array.
		while (index1 < length1 && index2 < length2) {
			
			if (list1[index1] <= list2[index2]) {
				result[resultIndex++] = list1[index1++];
			}
			
			else {
				result[resultIndex++] = list2[index2++];
			}
		}
		
		// The following while loops check if there are any more items 
		// in both lists. If there are any, then the program adds them 
		// to the final list.
		while (index1 < length1) {
			result[resultIndex++] = list1[index1++];
		}
		while (index2 < length2) {
			result[resultIndex++] = list2[index2++];
		}
		
		return result;
	}
	
	// This method loops through the final array and prints the elements
	// out.
	public static void printArray (int [] mergedList) {
		System.out.print("The merged list is ");
		for (int item = 0; item < mergedList.length; item++) {
			System.out.print(mergedList[item] + " ");
		}
		System.out.print(".\n");

	}
}

