package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.ACCOUNT;

public interface ACCOUNTdao {
	
	public List<ACCOUNT> getACCOUNTList() throws SQLException;

}
