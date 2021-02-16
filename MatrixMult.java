/*
 * Lalithsai Posam
 * MatrixMult.java
 * This program takes the input of two matrices and multiplies them 
 * together using the getMatrix and the multiplyMatrix methods. The 
 * final matrix is displayed to the user.
 */

import java.util.Scanner;

public class MatrixMult {
	
	public static void main(String[] args) {
		// Input object created
		Scanner input = new Scanner(System.in);
		
		// Two matrices intialized and declared using getMatrix method
		double[][] a = getMatrix("Matrix A", input);
		double[][] b = getMatrix("Matrix B", input);
		
		// Checking if the two arrays can be multiplied. If not, error
		// message will be displayed to the user
		if (a[0].length == b.length) {
			double[][] c = multiplyMatrix(a, b);
			printMatrix("Matrix C", c);
		}	
		else {
			System.out.println("The first matrix must have the same " + 
							   "number of rows as the number of columns " + 
							   "in the second matrix.");
		}
	}
	
	// The getMatrix method takes in the two matrices given by the user.
	// This method will be used twice to get two matrices from the user.
	public static double [][] getMatrix(String matrixName, 
										Scanner userInput) {
		System.out.println(matrixName);
		
		// Rows and columns are taken as input
		System.out.print("Enter number of rows: ");
		int rows = userInput.nextInt();
		
		System.out.print("Enter the number of columns: ");
		int columns = userInput.nextInt();
		
		double[][] resultMatrix = new double[rows][columns]; 
		System.out.print("Enter the content of the matrix: ");
		
		// The matrix is filled with the values from the user
		for (int row = 0; row < rows; row++) {  
			for (int column = 0; column < columns; column++) {    
				resultMatrix[row][column] = userInput.nextInt();   
			}
		}
		
		return resultMatrix; 
	}
	
	// This method multiplies both matrices together using 3 for loops.
	public static double [][] multiplyMatrix(double[][] a, double[][] b) {
		
		// The resulting matrix is declared and intialized with the 
		// correct dimensions.
		double[][] productMatrix = new double [a.length][b[0].length];
		
		// This loop loops through the rows in the first matrix.
		for (int row = 0; row < a.length; row++) {
			
			// This loop loops through the columns of the second matrix.
			for (int column = 0; column < b[0].length; column++) {
				
				// This loop calculates each of the numbers in the final
				// array.
				for (int i = 0; i < a[0].length; i++) {
					productMatrix[row][column] += a[row][i] * 
												  b[i][column];
				}
			}
		}
		
		return productMatrix;
	}
	
	// This method prints the matrix if it is considered compatible
	public static void printMatrix(String matrixName, 
								   double[][] resultMatrix) {
		
		System.out.println(matrixName);
			
			for (int row = 0; row < resultMatrix.length; row++) {
				
				for (int column = 0; column < resultMatrix[row].length; 
					column++) {
					System.out.print(resultMatrix[row][column] + " ");
				}
				
				System.out.println(" ");
			}

	}
}

