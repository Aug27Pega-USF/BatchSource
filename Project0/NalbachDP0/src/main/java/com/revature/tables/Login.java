package com.revature.tables;

public class Login {
		private int loginID;
		private String username;
		private String password;
		public Login() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Login(int loginID, String username, String password) {
			super();
			this.loginID = loginID;
			this.username = username;
			this.password = password;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getLoginID() {
			return loginID;
		}
		public void setLoginID(int loginID) {
			this.loginID = loginID;
		}
		public String getUsername() {
			return username;
		}
		public void setFirstNames(String username) {
			this.username = username;
		}
		@Override
		public String toString() {
			return "Customers [loginID=" + loginID + ", username=" + username + ", password="+ password +"]";
		}
}