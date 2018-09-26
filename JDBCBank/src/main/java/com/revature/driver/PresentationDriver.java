package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimp.AccountDAOImp;
import com.revature.daoimp.TransactionDAOImp;
import com.revature.daoimp.UserDAOImp;

public class PresentationDriver {

	public static void main(String[] args) {
		UserDAOImp u = new UserDAOImp();
		AccountDAOImp a = new AccountDAOImp();
		TransactionDAOImp t = new TransactionDAOImp();
		System.out.println("Grabbing all user from databse");
		try {
			u.getUserList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Creating user into database");
		try {
			u.createUser("chrisavila", "password2", "chris", "avila", "550 buthead lane", "Orlando", "FL", 32819);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Grabbing recent entered user to see userid");
		try {
			u.getNewUserList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Grabbing all user to see difference");
		try {
			u.getUserList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Signing in on one user username chrisavila and password password2");
		try {
			System.out.println(u.userSignIn("chrisavila", "password2"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Deleting a certain user with userid 6");
		try {
			u.deleteUser(6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Getting user list again to show delete");
		try {
			u.getUserList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Getting clearance level of a user");
		try {
			System.out.println("Passing in the userID of 1 and getting back a clearance level of: "+ u.getUserClearance(1) + " for Administrator");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Getting user before update");
		try {
			u.getCertainUser(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Updating that user");
		try {
			u.updateUser(1, "robinavila", "avila");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Grabbing updated user to see difference");
		try {
			u.getCertainUser(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Creating an checking account for userid 1");
		try {
			a.createAccount(1, 1, 1000.00);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Geeting account list to show new checking account");
		try {
			a.getAccountList(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Grabbing recent account created");
		try {
			a.getLastAccount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Grabbing a certain account based on account id and userid");
		try {
			a.getCertainAccount(1110000001, 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("deleting that account but will produce error because of balance");
		try {
			a.deleteAccount(1110000001, 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Withdraw from account in order to delete");
		try {
			a.withdrawlUpdateAccount(1110000001, 1, 1000.00);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Delete Round 2");
		try {
			a.deleteAccount(1110000001, 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Next few lines will show deposits ");
		try {
			a.depositUpdateAccount(1110000000, 1, 1000.00);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		try {
			a.depositUpdateAccount(1110000000, 1, 1000.00);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		try {
			a.depositUpdateAccount(1110000000, 1, 1000.00);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("next few lines will show withdrawls");
		try {
			a.withdrawlUpdateAccount(1110000000, 1, 1000.00);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		try {
			a.withdrawlUpdateAccount(1110000000, 1, 1000.00);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		try {
			a.withdrawlUpdateAccount(1110000000, 1, 1000.00);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("this withdrawl should be denied for purpose of not having enough money in account");
		try {
			a.withdrawlUpdateAccount(1110000000, 1, 1100.00);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Grabbing all transactions from account we were working with");
		try {
			t.getTransactionList(1110000000);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
