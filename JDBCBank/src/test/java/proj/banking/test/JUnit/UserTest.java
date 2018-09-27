package proj.banking.test.JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import proj.banking.driver.Driver;
import proj.banking.user.Login;
import proj.banking.*;

class UserTest {
	@Nested
	class RunTests {
		@Test
		void customerRunTest() throws Exception {
			String inputSim = "1\n\ruser01\n\rpass01\n\r1\n\r1\n\r500\n\r";
			ByteArrayInputStream bais = new ByteArrayInputStream(inputSim.getBytes());
			System.setIn(bais);
			Driver.main(null);
		}
	}
	@Nested
	class LoginTest {
		Login loginService = new Login();
		
		@Test
		void incorrectUsernamePassword() throws Exception {
			assertEquals(null, loginService.checkLogin(1, "user", "pass"));
			assertEquals(null, loginService.checkLogin(1, "user01", "pass"));
			assertEquals(null, loginService.checkLogin(1, "user", "pass01"));
			assertEquals(null, loginService.checkLogin(2, "emp", "pass"));
			assertEquals(null, loginService.checkLogin(2, "emp01", "pass"));
			assertEquals(null, loginService.checkLogin(2, "emp", "emppass"));
			assertEquals(null, loginService.checkLogin(3, "ad", "pass"));
			assertEquals(null, loginService.checkLogin(3, "admin01", "pass"));
			assertEquals(null, loginService.checkLogin(3, "admin", "adpass"));
		}
		
		@Test
		void incorrectUserLevel() throws Exception {
			assertEquals(null, loginService.checkLogin(1, "emp01", "emppass"));
			assertEquals(null, loginService.checkLogin(2, "user01", "pass01"));
			assertEquals(null, loginService.checkLogin(3, "emp01", "emppass"));
		}
		
		@Test
		void correctCustomerLogin() throws Exception {
			assertTrue("CustomerAccount".equals(loginService.checkLogin(1, "user01", "pass01").getClass().getSimpleName()));
			assertTrue("CustomerAccount".equals(loginService.checkLogin(1, "user02", "pass02").getClass().getSimpleName()));
		}
		
		@Test
		void correctEmployeeLogin() throws Exception {
			assertTrue("EmployeeAccount".equals(loginService.checkLogin(2, "emp01", "emppass").getClass().getSimpleName()));
		}
		
		@Test
		void correctAdminLogin() throws Exception {
			assertTrue("AdminAccount".equals(loginService.checkLogin(3, "admin01", "adpass").getClass().getSimpleName()));
		}
		
		@Test
		void registerNewUser() throws SQLException, Exception {
			String inputSim = "Joe\r\nDoe\r\njoeDoe@fake.com\r\n1990-12-01\r\n\r\n\r\n\r\n";
			ByteArrayInputStream bais = new ByteArrayInputStream(inputSim.getBytes());
			System.setIn(bais);
			loginService.registerUserLogin("user03", "pass03");
		}
	}
	
	@Nested
	class CustomerAccountTest {
		@Before
		void setup() {
			
		}
		
	}

}
