package com.revature.testing;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.revature.beans.User;
import com.revature.daoimpl.UserDaoImpl;
import com.revature.login.Login;
class UserDaoTesting {
	static Login login = new Login();
	static UserDaoImpl userImpl = new UserDaoImpl();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@Nested 
	class UserDaoImpleTest{
		@Test 
		void retrieveUserBySocial(){
			String social ="123-45-6789";
			String badSoc = "1";
			assertNotNull(userImpl.getBySSN(social).getSocial());
			assertNull(userImpl.getBySSN(badSoc));
		}
		@Test
		void retrieveAllUsers() throws SQLException {
			assertFalse(userImpl.getAll().isEmpty());
		}
		@Test 
		void checkExistence() {
			assertTrue(userImpl.checkExistence("SOCIAL", "123-45-6789"));
			assertTrue(userImpl.checkExistence("USER_ID", "2"));
		}
		
		@Test 
		void getByUsnTest() {
			String username = "kmedara2015";
			String usernameCust = "shawnpalmer2";
			assertNotNull(userImpl.getByUsn(username));
			assertNotNull(userImpl.getByUsn(usernameCust));
			
		}
		@Test 
		void getById(){
			String string = "kmedara2015";
			assertEquals(string, ((User)userImpl.get(2)).getUsername());
		}
		
	}
}
