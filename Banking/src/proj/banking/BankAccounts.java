package proj.banking;

public class BankAccounts {
	private String accountHolderID;
	private String jointHolderID;
	private String accountNumber;
	private double amount;
	private boolean waitingApproval;
	
	public BankAccounts(String accountHolderID, String accountNumber) {
		this(accountHolderID, accountNumber, 0);
	}
	
	public BankAccounts(String accountHolderID, String accountNumber, double amount) {
		this(accountHolderID, "", accountNumber, amount, true);
	}
	
	public BankAccounts(String accountHolderID, String jointHolderID, String accountNumber, double amount, boolean waiting) {
		this.accountHolderID = accountHolderID;
		this.jointHolderID = jointHolderID;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.waitingApproval = waiting;
	}
	
	public BankAccounts(String ...args) {
		int counter = 0;
		for(String s : args) {
			switch(counter) {
			case 0:
				this.accountHolderID = s;
				break;
			case 1:
				this.jointHolderID = s;
				break;
			case 2:
				this.accountNumber = s;
				break;
			case 3:
				this.amount = Double.parseDouble(s);
			case 4:
				this.waitingApproval = Boolean.parseBoolean(s);
			default:
				break;
			}
			counter++;
		}
	}
	
	public String getJointHolderID() {
		return jointHolderID;
	}
	public String getAccountHolderID() {
		return accountHolderID;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public boolean getWaitingApproval() {
		return waitingApproval;
	}
	
	public void setWaitingApproval(boolean waitingApproval) {
		this.waitingApproval = waitingApproval;
	}
	public void setAccountHolderID(String accountHolderID) {
		this.accountHolderID = accountHolderID;
	}

	public void setJointHolderID(String jointHolderID) {
		this.jointHolderID = jointHolderID;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String toString() {
		return accountHolderID + " " + accountNumber + " " + amount + " " + jointHolderID + " " + waitingApproval;
	}
}
