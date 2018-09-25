package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Admin;

public interface Admin_Dao {
	
	public abstract void createAdmin(String uname, String pwd, String fN) throws SQLException;
	public abstract List<Admin> getAdminList() throws SQLException;
	public abstract Admin getAdminByUsername(String username) throws SQLException;
	
}
