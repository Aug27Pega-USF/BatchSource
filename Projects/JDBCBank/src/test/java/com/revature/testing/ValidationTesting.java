package com.revature.testing;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.login.Login;
public class ValidationTesting {
	private static Login.Validation validator; 
	private static Method m;
	@SuppressWarnings("rawtypes")
	private static Class[] parameterTypes;
	private static Object[] parameters;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		validator = new Login.Validation();
		parameterTypes = new Class[1];
		parameterTypes[0] = String.class;
		parameters = new Object[4];
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}


		
		@Test 
		void createValidNames() throws Exception {
			m = validator.getClass().getDeclaredMethod("validateNames", parameterTypes[0],parameterTypes[0]);
			m.setAccessible(true);
			parameters[0] ="Kevin" ;
			parameters[1] = "Rivera-Doi";
			parameters[2] = "O'Connor";
			parameters[3] = "%Bad5Name_!";
			assertTrue((boolean) m.invoke(validator, parameters[0],parameters[1]));
			assertTrue((boolean) m.invoke(validator, parameters[0],parameters[2]));
			assertFalse((boolean) m.invoke(validator, parameters[0],parameters[3]));
		}
		@Test
		void createValidSocials() throws Exception {
			m = validator.getClass().getDeclaredMethod("validateSocial", parameterTypes[0]);
			m.setAccessible(true);
			assertTrue((boolean) m.invoke(validator, "123-45-6789"));
			assertFalse((boolean) m.invoke(validator, "000-34-5567"));
			assertFalse((boolean) m.invoke(validator, "546-455-6787"));
			assertFalse((boolean) m.invoke(validator, ""));
		}
		
		@Test
		void createValidPhoneNumber() throws Exception {
			m = validator.getClass().getDeclaredMethod("validatePhone", parameterTypes[0]);
			m.setAccessible(true);
			assertTrue((boolean) m.invoke(validator, "(603)973-4608"));
			assertFalse((boolean) m.invoke(validator, "603-973-4608"));
			assertFalse((boolean) m.invoke(validator, "(603)-973-4608"));
			assertFalse((boolean) m.invoke(validator, "(123)456-5678 x456"));
			assertFalse((boolean) m.invoke(validator, ""));
		}
     	@Test 
		void createValidBirth() throws Exception{
     		m = validator.getClass().getDeclaredMethod("validateBirth", parameterTypes[0]);
			m.setAccessible(true);
     		assertTrue((boolean) m.invoke(validator, "2015-12-30"));
     		assertFalse((boolean) m.invoke(validator, "July 8th 1995"));
     		assertFalse((boolean) m.invoke(validator, ""));
     	}
     	@Test
     	void createValidUsn() throws Exception {
     		m = validator.getClass().getDeclaredMethod("validateUsn", parameterTypes[0]);
			m.setAccessible(true);
			assertTrue((boolean) m.invoke(validator, "KMedara213"));
     		assertTrue((boolean) m.invoke(validator, "Git_Gud_Scrubz"));
     		assertFalse((boolean) m.invoke(validator, "Haramz!q%45"));
     	}
     	@Test 
     	void createValidPassword() throws Exception {
     		m = validator.getClass().getDeclaredMethod("validatePassword",  parameterTypes[0],  parameterTypes[0]);
     		m.setAccessible(true);
     		assertTrue((boolean) m.invoke(validator, "1aA@rR","1aA@rR"));
     		assertTrue((boolean) m.invoke(validator, "F04b2klr9!","F04b2klr9!"));
     		assertFalse((boolean) m.invoke(validator, "F04b2klr9!","ffff"));
     	}
     	@Test
     	void personAlreadyExists() throws Exception {
     		m = validator.getClass().getDeclaredMethod("userExists", parameterTypes[0]);
			m.setAccessible(true);
			assertTrue((boolean) m.invoke(validator, "123-45-6789"));
			assertFalse((boolean) m.invoke(validator, "342-65-7654"));
     	}
	}
