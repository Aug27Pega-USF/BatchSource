package com.revature.dao;

import com.revature.models.User;

public interface UserDAO {
	//CREATE
	public void createUser(User u);
	//READ
	public User selectUser(String uname, String upassword);
	//UPDATE 
	public void updateUserFavs(User u);
	public void updateUserInfo(User u);
	public void updateUserLogin(User u);
	//DELETE
	public void deleteUser(User u);
}
