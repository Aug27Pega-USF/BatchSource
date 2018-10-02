package Jbdc.dao;

import java.sql.SQLException;


public interface accountsDAO {
	public abstract void getAccounts(String userName) throws SQLException;
	public abstract void getInfo(String userName) throws SQLException;
	
}
