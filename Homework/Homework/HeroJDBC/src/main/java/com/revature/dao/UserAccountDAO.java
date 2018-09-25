package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.UserAccount;

public interface UserAccountDAO {

		//CRUD Operations
		public abstract void createUserAccount(String uName, String upasw, int Adminf) throws SQLException;
		public abstract List<UserAccount> getUserAccountList() throws SQLException;
	}

