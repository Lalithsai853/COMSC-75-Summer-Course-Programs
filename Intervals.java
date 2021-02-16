/*
 * Lalithsai Posam
 * Interval.java
 * This program will prompt the user to enter two time intervals, and
 * it will convert these times into hours and minutes and will compute
 * and compare which interval is longer. Finally, this information will
 * be displayed to the user. 
 */

import java.util.Scanner;

public class Intervals {
	public static void main (String[] args) {
		// Input object created.
		Scanner input = new Scanner(System.in);
		
		// Prompts user to enter two 24 hours format times (earlier times)
		System.out.print("Enter earlier start and end time as two" + 
						" 24-hour format times: ");
		
		// Taking in user's input and converts datatype to integer.				
		int earlier_start = input.nextInt();
		int earlier_end = input.nextInt();
		
		// Prompts user to enter two 24 hours format times (later times)
		System.out.print("Enter later start and end time as two" + 
						" 24-hour format times: ");
		
		// Taking in user's input and converts datatype to integer.
		int later_start = input.nextInt();
		int later_end = input.nextInt();
		
		// Calculating earlier time interval using conversions
		int earlier_interval = (earlier_end / 100 * 60 + earlier_end % 100) 
							   - (earlier_start / 100 * 60 + 
							   earlier_start % 100);
		
		// Calculating earlier time interval using conversions					
		int later_interval = (later_end / 100 * 60 + later_end % 100) - 
							 (later_start / 100 * 60 + 
							  later_start % 100);
		
		// Displaying interval lengths					  
		System.out.println("The earlier interval is " + earlier_interval 
						   + " minutes long.");
		System.out.println("The later interval is " + later_interval 
						   + " minutes long.");
		
		// Determining which interval is longer
		if (later_interval > earlier_interval) {
			System.out.println("The later interval is longer.");
		
		} else if (later_interval == earlier_interval) {
			System.out.println("The intervals are of equal length.");
		
		} else {
			System.out.println("The earlier interval is longer.");
		}
		
		// Determining whether or not intervals overlap
		if (later_start < earlier_end) {
			System.out.println("The intervals overlap.");
		
		} else {
			System.out.println("The intervals will not overlap.");

		}
	}
}
