/*
 * Lalithsai Posam
 * Creditcard.java 
 * This program uses methods to check if the user's credit card is 
 * valid or not. It checks if the card has the correct starting digit(s),
 * follows the Mod 10 Check, and has the correct number of digits. If the
 * card is valid, the card type is returned with a validation statement. 
 */

import java.util.Scanner;

public class CreditCard {
	public static void main (String[] args) {
		
		// Input object created.
		Scanner input = new Scanner(System.in);
		
		// Prompts uer to enter a credit card number
		System.out.print ("Enter credit card number: ");
		
		//Input type changed to double
		long number = input.nextLong();
		
		// Checking if card is valid using isValid method
		if (isValid(number) == true) {
			System.out.println("That is a valid " + getType(number) + " credit card number");
		}
		else {
			System.out.println("That is not a valid credit card number");
		}
	}
	
	// Method isValid checks if the card passes all requirements using 
	// if-else chains and accessing all other methods 
	// Checks size of credit card, Mod 10 Theorem, and if it starts with 
	// the correct digits. 
	public static boolean isValid (long number) {
		if ((getSize(number) >= 13 && getSize(number) <= 16) == false) {
			return false;
					
		}
		
		if (((sumOfDoubleEvenPlace(number) + 
			sumOfOddPlace(number)) % 10) != 0) {
			return false;
	
		}
		
		long startDigit = getPrefix (number, 1);
		if (startDigit == 4 || startDigit == 5 || startDigit == 6) {
			return true;

		}
		
		long start2Digits = getPrefix (number, 2);
		if (start2Digits == 37) {
			return true;

		}
		return false;
		
	}
	
	// sumOfDoubleEvenPlace method takes in the credit card number and
	// doubles and adds all the even-positioned digits
	public static long sumOfDoubleEvenPlace(long number) {
		long sumEven = 0, position = 1;
		long digit;
		
		while (number != 0) {
			if (position % 2 == 0) {
				digit = (number % 10) * 2;
				if (digit >= 10) {
					sumEven += getDoubleDigitSum(digit);
				}
				else {
					sumEven += digit;
				}
			}
			number /= 10;
			position++;

		}
		return sumEven;	
	}
	
	// If twice the digit of a number in sumOfDoubleEvenPlace is greater
	// than 10, then this method is called to add up the individual digits.
	public static long getDoubleDigitSum(long digit) {
		long doubleDigitSum = digit % 10 + 1;
		return doubleDigitSum;
	}
	
	// The sumOfOddPlace takes the sum of all the digits at the odd 
	// positions within the credit card number
	public static int sumOfOddPlace(long number) {
		int sumOdd = 0, position = 1;
		while (number != 0) {
			if (position % 2 != 0) {
				sumOdd += number % 10;
			}
			number /= 10;
			position ++;
		}
		return sumOdd;
	}
	
	// The getSize method calculates the size of the credit card number.
	public static int getSize(long number) {
		int size = 0;
		while (number != 0) {
			number /= 10;
			size ++;
		}
		return size;
	}
	
	// The getPrefix method accesses the first digit or the first two
	// digits.
	public static long getPrefix(long number, int k) {
		 while (number >= Math.pow(10, k)) { 
            number /= 10;
         }
		 return number; 

	}
	
	// If the card is valid, getType is called and the type is returned
	// based on the getPrefix method
	public static String getType (long number) {
		long startDigit = getPrefix(number, 1);
		
		String type;
		if (startDigit == 4) {
			type = "Visa";
		}
		else if (startDigit == 5) {
			type = "Master"; 
		}
		else if (startDigit == 6) {
			type = "Discovery";
		}
		else { 
			type = "American Express";
		}
		return type;

	}
}
