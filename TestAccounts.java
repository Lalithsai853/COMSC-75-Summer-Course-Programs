/*
 * Lalithsai Posam
 * TestAccounts.java
 * This program creates several Account objects including Saving Accounts
 * and Credit Card Accounts.
 */

public class TestAccounts {
	public static void main (String[] args) {
		final int NUMBER_OF_ACCOUNTS = 5;
		// Creates an array of Account objects
		Account [] accounts = new Account[NUMBER_OF_ACCOUNTS];
		
		// Intializes each object in Account Array
		accounts[0] = new Account(1066L, 7500);
		accounts[1] = new SavingsAccount(30507L, 4500.00, 0.015);
		accounts[2] = new CreditCardAccount(51782737L, 7000.00, 0.08, 1000.00);
		accounts[3] = new CreditCardAccount(629553328L, 1500.00, 0.075, 5000);
		accounts[4] = new CreditCardAccount(4977201043L, -5000.00, 
											0.07, 10000);
		
		// Displays information about each specific account.
		for (int account = 0; account <  NUMBER_OF_ACCOUNTS; account++) {
			accounts[account].deposit(2134.00);
			accounts[account].withdraw(4782.00);
			
			System.out.println(accounts[account].toString());
			
			if (accounts[account] instanceof SavingsAccount) {
				System.out.printf("Annual Interest: $%.2f\n\n", 
				((SavingsAccount)accounts[account]).calculateInterest());
			}
			
			else if (accounts[account] instanceof CreditCardAccount) {
				System.out.printf("Monthly Payment: $%.2f\n\n", 
				((CreditCardAccount)accounts[account]).calculatePayment());
			}
		}
	}
}

class Account {
	// Declares private variables 
	private long number;
	private double balance;
	
	// No arg constructor
	public Account () {
		this(0L, 0.0);
	}
	
	// Two arg constructor
	public Account(long number, double balance) {
		this.number = number;
		this.balance = balance;
	}
	
	// Returns Account Number
	public long getNumber () {
		return number;
	}
	
	// Returns balance
	public double getBalance () {
		return balance;
	}
	
	// sets balance
	public void setBalance (double balance) {
		this.balance = balance;
	}
	
	// Deposits money into account if amount is greater than 0
	public void deposit (double amount) {
		if (amount > 0.0) {
			balance += amount;
		}
	}
	
	// Withdraws money from account if amount is greater than 0 and 
	// the amount is less than the balance
	public void withdraw (double amount) {
		if (amount > 0.0 && amount <= balance) {
			balance -= amount;
		}
	}
	
	// Displays account information
	@Override
	public String toString () {
		return String.format("Account Number: " + number + "\n" + 
		"Balance: $%.2f" + "\n", balance);
	}
}

class SavingsAccount extends Account{
	// Declares private variable apr
	private double apr;
	
	// No arg constructor
	public SavingsAccount() {
		this(0L, 0.0, 0.0);
	}
	
	// Three arg constructor
	public SavingsAccount(long number, double balance, double apr){
		super(number, balance);
		this.apr = apr;
	}
	
	// returns apr
	public double getAPR () {
		return apr;
	}
	
	// sets apr
	public void setAPR (double apr) {		
		if (apr > 0) {
			this.apr = apr;
		}
	}
	
	// Calculates total interest
	public double calculateInterest () {
		return apr * getBalance();
	}
	
	// Displays savings account information
	@Override
	public String toString () {
		return String.format(super.toString() + "Interest Rate: %.2f%%", 
		(apr * 100));
	}
}

class CreditCardAccount extends Account {
	// Declares private variables apr and credit limit
	private double apr;
	private double creditLimit;

	// No arg constructor
	public CreditCardAccount() {
		this(0L, 0.0, 0.0, 0.0);
	}
	
	// Four arg constructor
	public CreditCardAccount(long number, double balance, double apr, 
							 double creditLimit) {
		super(number, balance);
		this.apr = apr;
		this.creditLimit = creditLimit;
	}
	
	// Returns the apr
	public double getAPR () {
		return apr;
	}
	
	// Sets the apr
	public void setAPR (double apr) {		
		if (apr > 0) {
			this.apr = apr;
		}
	}
	
	// Returns credit limit
	public double getCreditLimit (double creditLimit) {
		return creditLimit;
	}
	
	// Sets the credit limit
	public void setCreditLimit (double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	// Withdraws if the amount is greater than 0 or the amount is less 
	// than or equal to the balance, balance is left untouched
	@Override
	public void withdraw (double amount)  {
		if (amount > 0 && amount <= (getBalance() + creditLimit)) {
			setBalance(getBalance() - amount);
		}
	}
	
	// Calculates the total payment for the card
	public double calculatePayment () {
		double payment = 0.0;
		
		if (getBalance() <= 0) {
			payment = Math.min(20.0, (apr/12) * (-getBalance()));
		}
		return payment;
	}
	
	// Displays account information
	@Override
	public String toString () {
		return String.format(super.toString() + "Interest Rate: %.2f%%" 
		+ "\n" + "Credit Limit: $%.2f", (apr * 100), creditLimit);
	}

}






