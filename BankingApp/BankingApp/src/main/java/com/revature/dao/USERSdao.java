package com.revature.dao;

import java.sql.SQLException;
import java.util.List;


import com.revature.beans.AccountLogin;
import com.revature.beans.USERS;




public interface USERSdao {
	
	public abstract void createUSERS1(String USERName) throws SQLException;
	public abstract  List<USERS> getUSERSList() throws SQLException;
	public abstract void getLoginList(AccountLogin y) throws SQLException;
	
}
