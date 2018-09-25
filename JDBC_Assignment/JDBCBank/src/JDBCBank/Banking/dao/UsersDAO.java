package JDBCBank.Banking.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import JDBCBank.Banking.accounts.Users;


public interface UsersDAO {
	//CRUD Operations
	public abstract void create(String username, String password, String firstname, String lastname) throws SQLException;
	
	public abstract ArrayList<Users> read() throws SQLException;

	public abstract Users readOne(String user_name) throws SQLException;
	
	public abstract void update(int userid, String first_name, String last_name) throws SQLException;
	
	public abstract void delete(int userid) throws SQLException;
}
