/*
 * Lalithsai Posam
 * Shipping.java
 * This program prompts the user to enter the weight of a package. 
 * The program begina by checking if the weight of the package is valid,
 * and then it determines the cost of shipping the package based on the 
 * weight. This cost is displayed to the user at the end of the program.
 */
import java.util.Scanner;

public class Shipping {
	public static void main (String[] args) {
		// Input object created.
		Scanner input = new Scanner(System.in);
		
		// Prompts user to enter weight
		System.out.print("Enter weight of package in pounds: ");
		
		// Taking in user's input and converts datatype to double.
		double weight = input.nextDouble();
						
		// Checking if weight is appropriate
		if (weight < 0) {
			System.out.println("Invalid Input");
		} else if (weight > 25) {
			System.out.println("The package cannot be shipped");
			
		// If the weight is valid (passed the two statements above), 
		// the following statements assign different values to cost 
		// depending on the value of weight.
		
		} else {
			double cost;

			if (weight <= 2) {
				cost = 3.5;
			} else if (weight <= 7) {
				cost = 5.8;
			} else if (weight <= 15) {
				cost = 9.2;
			} else {
				cost = 11.75;
			}
			
			// Cost is displayed to the user
			System.out.printf("Cost: $%.2f\n", cost);
		}
	}
}
