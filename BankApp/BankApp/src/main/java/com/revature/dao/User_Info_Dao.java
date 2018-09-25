package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.User_Info;


public interface User_Info_Dao {
	//CRUD
	public abstract void createUser(String uname, String pwd, String fN, String lN) throws SQLException;
	public abstract List<User_Info> getUser_InfoList() throws SQLException;
	public abstract User_Info getUserByUsername(String usr) throws SQLException;
	public abstract User_Info getUserByPassword(String psd) throws SQLException;
	public abstract void updateUser_Info(int id) throws SQLException;
	public abstract void removeUser_Info(int id) throws SQLException;


}
