package jdbc.bank.beans;

public class USERS {
	private String newUser;
	private String newPwd;
	private int member_id;
	private String userName;
	private String password;
	public USERS(String newUser, String newPwd, int member_id, String userName, String password) {
		super();
		this.newUser = newUser;
		this.newPwd = newPwd;
		this.member_id = member_id;
		this.userName = userName;
		this.password = password;
	}
	/**
	 * @return the newUser
	 */
	public String getNewUser() {
		return newUser;
	}
	/**
	 * @param newUser the newUser to set
	 */
	public void setNewUser(String newUser) {
		this.newUser = newUser;
	}
	/**
	 * @return the newPwd
	 */
	public String getNewPwd() {
		return newPwd;
	}
	/**
	 * @param newPwd the newPwd to set
	 */
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "USERS [newUser=" + newUser + ", newPwd=" + newPwd + ", member_id=" + member_id + ", userName="
				+ userName + ", password=" + password + "]";
	}
}