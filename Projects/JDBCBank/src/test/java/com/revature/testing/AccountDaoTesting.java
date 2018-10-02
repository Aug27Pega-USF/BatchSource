package com.revature.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.beans.Account;
import com.revature.daoimpl.AccountDaoImpl;


class AccountDaoTesting {
	static AccountDaoImpl acImpl = new AccountDaoImpl();
	static Account acc;
		
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		acc = acImpl.getAccountsByUser(86).get(0);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void getAccountHolders() {
		assertNotNull(acImpl.getHolders(22));
	}
	@Test
	void testDeposit() {
		double testAmount = acc.getBalance() + 400;
		acImpl.deposit(400, acc);
		acc = acImpl.get(acc.getId());
		assertEquals( testAmount, acc.getBalance(), 0.0000000000);
	}

}
