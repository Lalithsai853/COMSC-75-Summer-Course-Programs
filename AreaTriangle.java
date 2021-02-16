/*
 * Lalithsai Posam
 * AreaTriangle.java
 * The program below prompts the user to enter three coordinates, 
 * computes the lengths of each side, calculates the semiperimeter, 
 * and finally computes and displays the area to the user. 
*/ 

//import statement to access Scanner method 
import java.util.Scanner;

public class AreaTriangle {
	public static void main (String[] args) {
		// Input object created.
		Scanner input = new Scanner(System.in);
		
		// Prompt displayed asking user to enter coordinates.
		System.out.println("Enter the coordinates of three points" + 
						   " seperated by spaces");				   
		System.out.print("in the order x1 y1 x2 y2 x3 y3: ");
		
		// Taking in user's input and converts datatype to double.
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		
		// Computes the length of each side
		double side1 =  Math.sqrt(Math.pow((x2 - x1) , 2) + 
						Math.pow((y2 - y1), 2));
		double side2 =  Math.sqrt(Math.pow((x3 - x1) , 2) + 
						Math.pow((y3 - y1), 2));				
		double side3 =  Math.sqrt(Math.pow((x3 - x2) , 2) + 
						Math.pow((y3 - y2), 2));

		// Computes semiperimeter 
		double semiPerimeter = ((side1 + side2 + side3) / 2);
		
		// Computes area
		double area = Math.sqrt((semiPerimeter) * (semiPerimeter - side1) 
					  * (semiPerimeter - side2) * (semiPerimeter - side3));

		// Displays Area rounded to two decimal places
		System.out.printf("The area of the triangle is %.2f square units.\n", 
						  area);
		
	}
}

