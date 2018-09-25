package com.revature.beans;

import java.sql.Date;
import java.util.List;

public class User {

	private Date lastLogin;
	private int roleTypeId;
	private Date birthDate;
	private String social;
	private String last;
	private String first;
	private int id;
	private String phone;
	private String roleTypeName;
	private String username;
	private String password;
	private List<?> accounts;
	private int loginId;

	/*default constructor*/
	public User() {
		super();
	}
	
	/*constructor missing id, accounts, loginId, and lastLogin. used only used when user is created, these fields are set in db.*/
	public User(String first, String last, String social, Date birthDate, String phone, int roleTypeId, String username, String password) {
		this.first = first;
		this.last = last;
		this.social = social;
		this.phone = phone;
		this.birthDate = birthDate;
		this.roleTypeId = roleTypeId;
		this.username = username;
		this.password = password;
	}
	
	/*complete user object, missing roleTypeId because type name is less ambiguous*/
	public User(int id, String first, String last, String social, Date birthDate, String phone, String roleTypeName,int loginId, Date lastLogin, String username, String password, List<?> accounts) {
		this.id = id;
		this.first = first;
		this.last = last;
		this.social = social;
		this.phone = phone;
		this.birthDate = birthDate;
		this.roleTypeName = roleTypeName;
		this.lastLogin = lastLogin;
		this.username = username;
		this.password = password;
		this.accounts = accounts;
		
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getRoleTypeId() {
		return roleTypeId;
	}

	public void setRoleTypeId(int rollTypeId) {
		this.roleTypeId = rollTypeId;
	}
	
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
		
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getSocial() {
		return social;
	}

	public void setSocial(String social) {
		this.social = social;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getRoleTypeName() {
		return roleTypeName;
	}
	public void setRoleTypeName(String role) {
		this.roleTypeName = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		
	}
	public List<?> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<?> accounts) {
		this.accounts = accounts;
	}
	
	public StringBuilder printAccounts() {
		StringBuilder string = new StringBuilder();
		this.getAccounts().forEach(a -> string.append("| "+a.toString()+"\t|\n"));
		return string;
		
	}
	
	public String toBasicString() {
		return "\nName:"+this.getFirst()+" "+this.getLast() +" "+ this.getRoleTypeName()
				+"\nID: "+this.getId();
	}
	@Override
	public String toString() {
		return"\t\t\t\t\t\t\033[34;1;4m---"+this.getRoleTypeName()+" "+ this.getId()+"---\033[0m\n"
				+ "\t_________________________________________________________________________________________________\n"
				+ "\t|  Real Name\t|   Phone\t|  Birth Date\t|    Social\t|  Last Login\t|  ID Number\t|\n"
				+ "\t|************************************************************************************************\n"
				+ "\t|  "+this.getFirst().substring(0,1)+" "+this.getLast()+"\t|"+this.getPhone()
				+ "\t|  "+this.getBirthDate()+"\t|  "+this.getSocial()+"\t|   "+this.getLastLogin()+"\t|  "+this.getId()+"\t|\n"
				+ "\t|************************************************************************************************\n"
				+ "\t"+this.printAccounts();
	}	
}
