package com.revature.dao;

import java.sql.SQLException;
import com.revature.bean.User;


public interface UserDAO {
	public abstract void createUser(String userName, String password, String firstName, String lastName,
									String address, String city,String state,int zip,int areaCode, int phone, int ssn, int lastfour)
											throws SQLException;
	public abstract void getUserList() throws SQLException;
	public abstract void getNewUserList() throws SQLException;
	public abstract void getCertainUser(int id) throws SQLException;
	public abstract int userSignIn(String a,String b) throws SQLException;
	public abstract void deleteUser(User user);
	public abstract void updateUser(User user);

}
