package com.runtime.dao;

import java.sql.SQLException;
import java.util.List;

import com.runtime.bean.User;

public interface UserDao {

	public int insertUser(User user) throws SQLException;

	public List<User> getUserList() throws SQLException;

	public int getUserById(int userId) throws SQLException;

	public int updateUserById(int userId) throws SQLException;

	public int deleteUserById(int userId) throws SQLException;

	public User getUserByUsrPass(String username, String password) throws SQLException;

}
