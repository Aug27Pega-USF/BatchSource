package com.revature.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.daoimpl.LoginInfoDaoImpl;
	
class LoginDaoTesting {
	static LoginInfoDaoImpl login;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		login  = new LoginInfoDaoImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void checkForUsername() {
		assertTrue(login.checkExistence("LOGIN_USERNAME","luis_rivera"));
		assertFalse(login.checkExistence("LOGIN_USERNAME","kmedara20153"));
	}
	 
}
