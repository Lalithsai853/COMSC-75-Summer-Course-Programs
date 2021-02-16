/*
 * SavingsAccount.java
 * 
 */


public class SavingsAccount extends Account{
	private double apr;
	
	public SavingsAccount() {
		this(0, 0.0, 0.0);
	}
	
	public SavingsAccount(long number, double balance, double apr){
		super(number, balance);
		this.apr = apr;
	}
	
	public double getAPR () {
		return apr;
	}
	
	public void setAPR (double apr) {		
		if (apr > 0) {
			this.apr = apr;
		}
	}
	
	public String toString () {
		return String.format("Account Number: " + getNumber() + "\n" + 
		"Balance: $%.2f" + "\n" + "Interest Rate: %.2f%%", getBalance(), 
		(apr * 100));
	}
	
	public double calculateInterest () {
		return apr * getBalance();
	}
}

