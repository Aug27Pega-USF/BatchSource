package com.revature.DAO;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.UserAccount;

public interface UserAccountDAO {

        //CRUD Operations
        public abstract void createUserAccount(int userID, String userName, String pass, int adminn) throws SQLException;
        public abstract List<UserAccount> getUserAccountList() throws SQLException;
    }
