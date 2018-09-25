package JDBCBank.Banking.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import JDBCBank.Banking.accounts.Account;

public interface AccountDAO {
	public abstract void create(String accountname, int userid) throws SQLException;
	
	public abstract ArrayList<Account> read() throws SQLException;
	
	public abstract void update(int accountid, int balance) throws SQLException;
	
	public abstract void delete(int accountid) throws SQLException;
}
