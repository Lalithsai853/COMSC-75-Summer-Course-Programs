/*
 * CreditCardAccount.java
 * Lalithsai Posam
 * 
 */


public class CreditCardAccount extends Account {
	private double apr;
	private double creditLimit;

	public CreditCardAccount() {
		this(0, 0.0, 0.0, 0.0);
	}
	
	public CreditCardAccount(long number, double balance, double apr, double creditLimit) {
		super(number, balance);
		this.apr = apr;
		this.creditLimit = creditLimit;
	}
	
	public double getAPR () {
		return apr;
	}
	
	public void setAPR (double apr) {		
		if (apr > 0) {
			this.apr = apr;

		}
	}
	public void setCreditLimit (double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	public void withdraw (double amount)  {
		if (amount > 0 || amount <= getBalance() + creditLimit) {
			setBalance(getBalance() - amount);
		}
	}
	
	public double calculatePayment () {
		if (getBalance() > 0) {
			return 0;
		}
		else {
			return Math.min(20, (apr/12) * (-1 * getBalance()));
		}
	}
	
	public String toString () {
		return String.format("Account Number: " + getNumber() + "\n" + 
		"Balance: $%.2f" + "\n" + "Interest Rate: %.2f%%" + "\n" + 
		"Credit Limit: $%.2f", getBalance(), (apr * 100), creditLimit);
		
	}

}


