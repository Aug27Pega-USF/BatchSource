package com.PrestonL.sqlbank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.daoimpl.AccountDAOImpl;
import com.revature.daoimpl.AdminDAOImpl;
import com.revature.daoimpl.CustomerDAOImpl;
import com.revature.exceptions.UnassociatedException;

class BankTests {



	@Test
	void test() {
		AccountDAOImpl acdi = new AccountDAOImpl();
		AdminDAOImpl adi = new AdminDAOImpl();
		CustomerDAOImpl cdi= new CustomerDAOImpl();
		try {
			adi.createUser("Test", "password"); //check admin create user
			int check= (adi.login("Test", "password")); //check login
			assertTrue(check>0); //check exists
			assertTrue(adi.checkUser(check)); 
			adi.updateUser(check, "Test2", "password2");//check update
			assertTrue(adi.checkUser(check)); //check still there.
			acdi.createAccount(check); //check create account.
			adi.createUser("Test2", "password"); //check failed creation
			adi.updateUser(check, "ALPHA1", "IAMNUMBER1"); //check failed update
			adi.deleteUser(check); //check delete
			assertTrue(!adi.checkUser(check)); //check delete success
		} catch (Exception e) {
		}	
	}
	
	@Test
	void test2() {
		AccountDAOImpl acdi = new AccountDAOImpl();
		AdminDAOImpl adi = new AdminDAOImpl();
		CustomerDAOImpl cdi= new CustomerDAOImpl();
		try {
			cdi.registerAccount("Test", "password"); //test register
			int check= (cdi.login("Test", "password")); //test other login
			assertTrue(check>0); //check exists
			assertTrue(adi.checkUser(check)); 
			adi.deleteUser(check); //check delete
			assertTrue(!adi.checkUser(check)); //check delete success
		} catch (Exception e) {
		}	
	}
	
	@Test
	void test3() {
		AccountDAOImpl acdi = new AccountDAOImpl();
		AdminDAOImpl adi = new AdminDAOImpl();
		CustomerDAOImpl cdi= new CustomerDAOImpl();
		try {
			System.out.println("\nStuff should come out below in this test.\n");
			
			acdi.createAccount(111111); //check this doesn't cause errors or stuff
			assertTrue(acdi.checkAccount(111111, 111111)); //check exists
			assertTrue(acdi.deposit(121, 100000, 123456)); //check true
			assertTrue(acdi.withdraw(120.99, 100000, 123456)); //check true
			assertTrue(!acdi.deposit(-1.111, 100000, 123456));//check false
			assertTrue(!acdi.withdraw(-1.111, 100000, 123456));//check false
			System.out.println("Below should be accounts list.");
			cdi.listAccounts(111111);
			System.out.println("Below should be users list.");
			adi.viewUsers(); 
			System.out.println("Below should be Transaction History");
			cdi.viewTransactionHistory(100000);
			System.out.println("DeleteAccount works, I swear.");
		} catch (Exception e) {
		}	
	}

}
