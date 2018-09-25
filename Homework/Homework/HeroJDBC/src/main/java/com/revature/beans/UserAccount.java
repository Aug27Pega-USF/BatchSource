package com.revature.beans;

public class UserAccount {
		//private int usID;
		private String uName;
		private String upasw;
		private int Adminf;
		public UserAccount(int j2, String string2, String string) {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "UserAccount [ "+"your User ID is: "+"usID"+" User Name = " + uName +"Password"+"upasw"+"]";
		}
		public UserAccount(String uName, String upasw) {
			super();
			//this.usID = usID;
			this.uName = uName;
			this.upasw = upasw;
			this.Adminf = Adminf;
		}

		/*public int getuID() {
			return usID;
		}
		public void setuID(int usID) {
			this.usID = usID;
		}*/
		public String getuName() {
			return uName;
		}
		public void setuName(String uName) {
			this.uName = uName;
		}
		public String getupasw() {
			return upasw;
		}
		public void setupasw(String upasw) {
			this.upasw = upasw;
		}
		public int getAdminf() {
			return Adminf;
		}
		public void setAdminf(int Adminf) {
			this.Adminf = Adminf;
		}
	}
