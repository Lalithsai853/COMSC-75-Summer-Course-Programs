/*
 * Lalithsai Posam
 *  
 */


public class Account {
	private long number;
	private double balance;

	public Account () {
		this(0, 0.0);
	}
	
	public Account(long number, double balance) {
		this.number = number;
		this.balance = balance;
	}
	
	public long getNumber () {
		return number;
	}
	
	public double getBalance () {
		return balance;
	}
	
	public void setBalance (double balance) {
		this.balance = balance;
	}
	
	public void deposit (double amount) {
		if (amount > 0.0) {
			balance = balance + amount;
		}
	}
	
	public void withdraw (double amount) {
		if (amount >- 0.0 && amount < balance) {
			balance = balance - amount;
		}
		
	}
	
	public String toString () {
		return String.format("Account Number: " + number + "\n" + "Balance: $%.2f" + "\n", balance);
	}
}
