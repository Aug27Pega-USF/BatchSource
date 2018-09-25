package jdbc.bank.beans;

public class ACCOUNT {
private int member_id;
private String userName;
private int account_id;
private double balance;
public ACCOUNT() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * @return the member_id
 */
public int getMember_id() {
	return member_id;
}
/**
 * @param member_id the member_id to set
 */
public void setMember_id(int member_id) {
	this.member_id = member_id;
}
/**
 * @return the userName
 */
public String getUserName() {
	return userName;
}
/**
 * @param userName the userName to set
 */
public void setUserName(String userName) {
	this.userName = userName;
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
public ACCOUNT(int member_id, String userName, int account_id, double balance) {
	super();
	this.member_id = member_id;
	this.userName = userName;
	this.account_id = account_id;
	this.balance = balance;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "ACCOUNT [member_id=" + member_id + ", userName=" + userName + ", account_id=" + account_id + ", balance="
			+ balance + "]";
}



}