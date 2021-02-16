import java.util.Scanner;


public class SalesTax {
	
	public static void main (String[] args) {
		
		final double RATE = 0.06;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter an purchase amount: ");
		double amt = input.nextDouble();
		double sales = amt * RATE;
		System.out.printf("Sales tax is: %.2f \n", sales);
		
	}
}

