/*
 * Lalithsai Posam
 * Pizza.java
 * This program prompts the user to enter the length and width of the 
 * pizza as well as the number of toppings. The program checks if the 
 * area and number of toppings are valid. If valid, then the cost is 
 * calculated based on size and number of toppings. This cost is then
 * displayed to user. 
 */

import java.util.Scanner;

public class Pizza {
	
	public static void main (String[] args) {
		// Input object created.
		Scanner input = new Scanner(System.in);
		
		// Takes in user's input and converts datatype to int.
		System.out.print("Enter legnth of pizza in cm: ");
		int length = input.nextInt();
		
		System.out.print("Enter width of pizza in cm: ");
		int width = input.nextInt();
		
		System.out.print("Enter the number of toppings: ");
		int toppings = input.nextInt();
		
		// Calculates area using length * width
		int area = length * width;
		
		double cost;
		
		// Displays error message if area is less than 0
		if (area <= 0) {
			System.out.println("The area must be greater than zero.");
		}
		
		// Displays error message if number of toppings is negative
		else if (toppings < 0) {
			System.out.println("Number of toppings must be greater than"
							   + " or equal to zero");
		}
		
		// Displays an error message if the area is greater than 1000
		else if (area >= 1000) {
			System.out.println("The area of your pizza is " + area + 
							   " square cm.");
			System.out.println("We cannot make a pizza that" +
							   " large, sorry.");
		}
		
		// Since area is valid, the size can be checked to match the  
		// correct price. The size of pizza and size type are displayed. 
		// Cost is updated.
		else {
			if (area <= 225) {
				cost = 7.25;
				System.out.println("The area of your pizza is " + area + 
								  " square cm.");
				System.out.println("That is a small pizza.");
			}
			else if (area <= 650) {
				cost = 10.50;
				System.out.println("The area of your pizza is " + area + 
								  " square cm.");
				System.out.println("That is a medium pizza.");
			}
			else {
				cost = 14.75;
				System.out.println("The area of your pizza is " + area + 
								  " square cm.");
				System.out.println("That is a large pizza.");
			}
			
			// Cost of toppings is added to cost.
			cost = cost + (0.85 * toppings);
			
			// Cost is displayed to the user.
			System.out.printf("Your pizza costs %.2f euros.", cost);
		}	
	}
}

