package com.revature.Connection;

import java.sql.SQLException;

import com.revature.DAOImpl.AccountDAOImpl;
import com.revature.DAOImpl.Account_TypesDAOImpl;
import com.revature.DAOImpl.LoginDAOImpl;
import com.revature.DAOImpl.TransactionTypesDAOImpl;
import com.revature.DAOImpl.UsersDAOImpl;

public class Driver {

	public static void main(String[] args) {
		Account_TypesDAOImpl atdi = new Account_TypesDAOImpl();
		try {
			atdi.createAccount_Types("Gambit");
			System.out.println(atdi.getAccount_TypesList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*LoginDAOImpl ldi = new LoginDAOImpl();
		try {
			ldi.createLogin("username", "password");
			System.out.println(ldi.getLoginList());
		}catch (SQLException e) {
			e.printStackTrace();
		}
		UsersDAOImpl udi = new UsersDAOImpl();
		try {
			udi.createUsers("Ssn", "username", "password", "firstName", "lastName", "phone", "address", "state", "country", "email");
			System.out.println(udi.getUserslist());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		AccountDAOImpl adi = new AccountDAOImpl();
		try {
			adi.createAccount(1, "accountName", 8, 5, 6);
			System.out.println(adi.getAccountlist());
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		*/
		TransactionTypesDAOImpl ttdi = new TransactionTypesDAOImpl();
		try {
			ttdi.createTransactionTypes("TransactionName");
			System.out.println(ttdi.getTransactionTypesList());
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
