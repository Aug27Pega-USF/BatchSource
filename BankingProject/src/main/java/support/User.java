package support;

import java.io.Serializable;

public class User implements Serializable{
	private String fname;
	private String lname;
	private String uname;
	private String pw;
	private String type;
	private String acctno;
	private double c_acct;
	private double s_acct;
	
	public User() {
		super();
	}
	
	public User(String fname, String lname, String uname, String pw, String type, String acctno, double c_acct,
			double s_acct) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.pw = pw;
		this.type = type;
		this.acctno = acctno;
		this.c_acct = c_acct;
		this.s_acct = s_acct;
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
	public String getAcctno() {
		return acctno;
	}
	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}
	public double getC_acct() {
		return c_acct;
	}
	public void setC_acct(double c_acct) {
		this.c_acct = c_acct;
	}
	public double getS_acct() {
		return s_acct;
	}
	public void setS_acct(double s_acct) {
		this.s_acct = s_acct;
	}

	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", uname=" + uname + ", pw=" + pw + ", type=" + type
				+ ", acctno=" + acctno + ", c_acct=" + c_acct + ", s_acct=" + s_acct + "]";
	}
	
}
