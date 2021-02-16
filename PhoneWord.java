/*
 * Lalithsai Posam
 * PhoneWords.java
 * This program prompts the user to enter a phone word and converts the
 * word into a phone number using an alphabetic mnemonic. If the uaer
 * enters a phone word less than 7 character, an error message is
 * displayed. If the phone word is greater than 7 characters, then the 
 * first 7 characters are displayed.
 */

import java.util.Scanner;

public class PhoneWord {
	public static void main (String[] args) {
		// Input object created.
		Scanner input = new Scanner(System.in);
		
		// Prompts user to enter a phone word
		System.out.print("Enter a phone word: ");
		
		// User input taken in and converted to string datatype
		String phoneword = input.nextLine();
		
		// Variable result declared as string type and intialized to 
		// empty string.
		String result = "";
		
		// Phone number is declared and intialized to 0
		String phone_num = "0";
		
		// For loop that loops through the user's input
		for (int index = 0; index < phoneword.length(); index++) {
			
			// Chooses the character at set index
			char test_char = phoneword.charAt(index);
			
			if (Character.isLetter(test_char)) {
				
				// Letter character is changed to upper case
				test_char = Character.toUpperCase(test_char);
				
				// Switch statement checks all cases for test_char and 
				// changes value of phone_num.
				switch (test_char) {
					case 'A' :
					case 'B' :
					case 'C' :
						phone_num = "2";
						break;
					case 'D' :
					case 'E' :
					case 'F' :
						phone_num = "3";
						break;
					case 'G' :
					case 'H' :
					case 'I' :
						phone_num = "4";
						break;
					case 'J' :
					case 'K' :
					case 'L' :
						phone_num = "5";
						break;
					case 'M' :
					case 'N' :
					case 'O' :
						phone_num = "6";
						break;
					case 'P' :
					case 'Q' :
					case 'R' :
					case 'S' :
						phone_num = "7";
						break;
					case 'T' :
					case 'U' :
					case 'V' :
						phone_num = "8";
						break;
					case 'W' :
					case 'X' :
					case 'Y' :
					case 'Z' :
						phone_num = "9";
						break;
				}
				// Phone number is added to the string result.
				result = result.concat(phone_num);
			}
			
			// If the test_char is a digit, it is directly added to
			// result.
			else if (Character.isDigit(test_char)) {
				result = result.concat(Character.toString(test_char));
			}
		}
		
		// Result string must have an extra character to avoid out of bounds 
		// error in the next else statement.
		result = result.concat(" ");
		
		// Checking if phone word is less than 7 characters. If not, 
		// phone number is displayed to user
		if (result.length() < 7) {
			System.out.println("Your phone word is less than 7 character. " + 
			"Please enter a phone number that is 7 characters or longer.");
		}
		else {
			System.out.println("Your phone number is " + 
								result.substring(0,3) + "-" + 
								result.substring(3,7));
			
		}
	}

}
