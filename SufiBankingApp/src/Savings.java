
public class Savings extends Account{
	private static String accountType = "Saving";
	
	Savings(double initialDeposit){
		super();
		this.setBalance(initialDeposit);
	}
	
	@Override
	public String toString() {
		return  "Account Type: " + accountType + " Account\n" + 
				"Account Number: " + this.getAccountNumber() + "\n" + 
				"Balance: " + this.getBalance() + "\n";
	}

}
