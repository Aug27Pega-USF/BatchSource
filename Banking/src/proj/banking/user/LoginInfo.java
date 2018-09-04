package proj.banking.user;

public class LoginInfo{
	private String loginID;
	private String password;
	private String accountNumber;
	
	public LoginInfo(String loginID, String password, String accountNumber) {
		this.loginID = loginID;
		this.password = password;
		this.accountNumber = accountNumber;
	}
	
	public LoginInfo(String ...args) {
		int counter = 0;
		for(String s : args) {
			switch(counter) {
			case 0:
				this.loginID = s;
				break;
			case 1:
				this.password = s;
				break;
			case 2:
				this.accountNumber = s;
				break;
			default:
				break;
			}
			counter++;
		}
	}
	
	public String getLoginID() {
		return loginID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
