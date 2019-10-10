package com.sullivan.support;

public class User {
	private int uid;
	private String fname;
	private String lname;
	private String uname;
	private String pw;
	private String type;

	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String fname, String lname, String uname, String pw) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.pw = pw;
	}
	
	public User(int uid, String fname, String lname, String uname, String pw) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.pw = pw;
		//this.type = type;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", uname=" + uname + ", pw=" + pw + "]";
	}
}