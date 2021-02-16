/*
 * Lalithsai Posam
 * Statistics.java
 * This program continously asks the user to enter a price until they 
 * enter -1. Once they enter -1, the program stops and displays the 
 * average price and the standard deviation, if possible.
 */


import java.util.Scanner; 

public class Statistics {
	
	public static void main (String[] args) {
		// Input object created.
		Scanner input = new Scanner(System.in);
		
		// Count, the sum of the numbers, and the sum of the squares
		// are declared and intialized to 0
		int count = 0;
		double sumOfNums = 0;
		double sumOfSquares = 0;

		// Prompts user to enter a price
		System.out.print("Enter first price, or -1 to quit: $");
		double price = input.nextDouble();
		
		// If user enters -1 to begin with, the following message is displayed.
		if (price == -1) {
	        System.out.println("Number of items: " + count);
			System.out.println("No data entered. Cannot calculate " +  
			"statistics.");
		}
		else  {
			count += 1;
			sumOfNums += price;
			sumOfSquares += price * price;
			
			// The follwing do-while loop repeatedly asks the user to 
			// enter a price and the count, sum of the numbers, 
			// and the sum of the squares is constantly updated.
			do {
				System.out.print("Enter next price, or -1 to quit: $");
				price = input.nextDouble();
				
				if (price != -1) {
					sumOfNums += price;
					sumOfSquares += price * price;
					count += 1;
				}
			} while (price != -1);
			
			// If user enters only one price, the following message is
			// displayed.
			if (count == 1) {
				System.out.println("Number of items: " + count);
				System.out.printf("Average price is $%.2f\n", sumOfNums);
				System.out.println("Cannot calculate standard deviation" +
								   " for one item.");
				System.exit(1);
			}
			
			// Average and standard deviation are calculated
			double average = sumOfNums / count;
			double standardDev = 
				Math.sqrt((count * sumOfSquares - 
						  sumOfNums * sumOfNums) / (count * (count - 1)));
			
			// Information is displayed to user
			System.out.println("Number of items: " + count);
			System.out.printf("Average price is $%.2f\n", average);
			System.out.printf("Standard deviation of prices is $%.2f\n", 
								standardDev);
			

		}
	
		
		
	}
		
	

}
