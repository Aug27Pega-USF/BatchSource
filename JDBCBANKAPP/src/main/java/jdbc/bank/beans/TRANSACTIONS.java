package jdbc.bank.beans;

public class TRANSACTIONS {
	private double balance;
	private double withdraw;
	private double deposit;
	public TRANSACTIONS(double balance, double withdraw, double deposit) {
		super();
		this.balance = balance;
		this.withdraw = withdraw;
		this.deposit = deposit;
	}
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
	 * @return the withdraw
	 */
	public double getWithdraw() {
		return withdraw;
	}
	/**
	 * @param withdraw the withdraw to set
	 */
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	/**
	 * @return the deposit
	 */
	public double getDeposit() {
		return deposit;
	}
	/**
	 * @param deposit the deposit to set
	 */
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TRANSACTIONS [balance=" + balance + ", withdraw=" + withdraw + ", deposit=" + deposit + "]";
	}
	
	
}
