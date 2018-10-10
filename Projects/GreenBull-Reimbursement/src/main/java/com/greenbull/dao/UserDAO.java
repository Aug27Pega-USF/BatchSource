package com.greenbull.dao;

import java.util.List;

import com.greenbull.users.User;

public interface UserDAO {

	//may be unused, until we have a register page
	//CREATE
	//public int insertUser(User u);
	
	//READ
	public User readUserByUsername(String username);
	public List<User> readAllUsers();
	
	//UPDATE
	//public int updateUser(String username);
	
	//unused? here for prosperity
	//DELETE
}
