package Jbdc.dao;

import java.sql.SQLException;

public interface UsersDAO {
	public abstract void createNewUser( String newUser, String newPwd) throws SQLException;
	public abstract void userLogin(String userName, String password) throws SQLException;
	
}
