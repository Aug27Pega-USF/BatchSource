package com.revature.interfaceaccount;


import java.sql.SQLException;
import java.util.List;

import com.revature.accounts.Admin;
import com.revature.accounts.Users;



public interface UserDAO {

	public abstract void createUser(String fname, String lname, String uname, String pswrd) throws SQLException;
	public abstract int getUserID(String uname) throws SQLException;
	public abstract void createAccount(int uid, String name, double balance) throws SQLException;
	public abstract boolean checkUserLogin(String uname, String pswrd)throws SQLException;
	public abstract Users getUser(int uid) throws SQLException;
	public abstract boolean checkName(String uname) throws SQLException;
}
