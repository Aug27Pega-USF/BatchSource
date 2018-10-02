package jdbc.bank.beans;

public class TRANSACTIONS {
	private double balance;
	private double amount;
	private int account_id;
	private String username;
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the account_id
	 */
	public int getAccount_id() {
		return account_id;
	}
	/**
	 * @param account_id the account_id to set
	 */
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return username;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.username = username;
	}
	public TRANSACTIONS(double balance, double amount, int account_id, String userName) {
		super();
		this.balance = balance;
		this.amount = amount;
		this.account_id = account_id;
		this.username = userName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TRANSACTIONS [balance=" + balance + ", amount=" + amount + ", account_id=" + account_id + ", userName="
				+ username + "]";
	}
	
	
	
}