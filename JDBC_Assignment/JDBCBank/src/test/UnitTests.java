package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import JDBCBank.Banking.Functions;
import JDBCBank.Banking.accounts.Account;
import JDBCBank.Banking.impl.AccountImpl;
import JDBCBank.Banking.impl.UserImpl;


public class UnitTests {
	@Test
	void Testing() {
		
	}
	
	/**
	 * AccountImpl
	 * Functions pertaining to SQL 
	 * @author zrjam
	 */
	//ArrayList<Account> read() throws SQLException
	@Test
	void test_AccountImpl_read() {
		AccountImpl a = new AccountImpl();
		ArrayList<Account> acc = new ArrayList<Account>();
		
		try {
			System.out.println("*Loading...*");
			acc = a.read();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//test if we got data correctly
		assertEquals(7, acc.get(0).getAccount_id());
	}
	/**
	 * Inputs
	 * @author zrjam
	 *
	 */
	@Nested
	class inputStringTests {
		Scanner s = new Scanner(System.in);
		
		/**
		 * 		FUNCTIONS class
		 * @author zrjam
		 */
		/* Functions.
		 * GetMenuSelection(Scanner s, String ... a)
		 * should return a string selected from the strings you inserted in here
		 */
			@Test
			void test_GetMenuSelection() {
				System.out.println();
				String goal_str = "test2";
				System.out.println("Select the option for " + goal_str);
				String str = Functions.GetMenuSelection(s, "test1", "test2", "test3");
				assertEquals(goal_str, str);
				
				goal_str = "test1";
				System.out.println("Select the option for " + goal_str);
				str = Functions.GetMenuSelection(s, "test1", "test2", "test3");
				assertEquals(goal_str, str);
				
				goal_str = "test3";
				System.out.println("Select the option for " + goal_str);
				str = Functions.GetMenuSelection(s, "test1", "test2", "test3");
				assertEquals(goal_str, str);
			}
		
		/* Functions.
		 * GetAccountSelection(Scanner s, ArrayList<String> a, ArrayList<Integer> id, ArrayList<Integer> balance)
		 * should return an int from 1 to array size, as selected
		 */
			@Test
			void test_GetAccountSelection() {
				System.out.println();
				//prep some arrays
				ArrayList<String> name = new ArrayList<String>();
				ArrayList<Integer> id = new ArrayList<Integer>();
				ArrayList<Integer> balance = new ArrayList<Integer>();
				
				//populate them with arbitrary values
				name.add("account 1");
				name.add("account 2");
				name.add("account 3");
				
				id.add(4);
				id.add(7);
				id.add(12);
				
				balance.add(1000);
				balance.add(55);
				balance.add(0);
				
				int goal_int = 7;
				System.out.println("Select the option for 2");
				int res = Functions.GetAccountSelection(s, name, id, balance);
				assertEquals(goal_int, res);
				
				goal_int = 4;
				System.out.println("Select the option for 1");
				res = Functions.GetAccountSelection(s, name, id, balance);
				assertEquals(goal_int, res);
				
				goal_int = 12;
				System.out.println("Select the option for 3");
				res = Functions.GetAccountSelection(s, name, id, balance);
				assertEquals(goal_int, res);
				
				//"quitting" the menu
				goal_int = -1;
				System.out.println("Select the option for 0");
				res = Functions.GetAccountSelection(s, name, id, balance);
				assertEquals(goal_int, res);
			}
		/*
		 * GetUserSelection(Scanner s, ArrayList<String> a, ArrayList<Integer> id)
		 * should return an int 
		 */
			@Test
			void test_GetUserSelection() {
				System.out.println();
				//prep some arrays
				ArrayList<String> name = new ArrayList<String>();
				ArrayList<Integer> id = new ArrayList<Integer>();
			
				//populate them with arbitrary values
				name.add("user 1");
				name.add("user 2");
				name.add("user 3");
				
				id.add(4);
				id.add(7);
				id.add(12);
				
				int goal_int = 7;
				System.out.println("Select the option for 2");
				int res = Functions.GetUserSelection(s, name, id);
				assertEquals(goal_int, res);
				
				goal_int = 4;
				System.out.println("Select the option for 1");
				res = Functions.GetUserSelection(s, name, id);
				assertEquals(goal_int, res);
				
				goal_int = 12;
				System.out.println("Select the option for 3");
				res = Functions.GetUserSelection(s, name, id);
				assertEquals(goal_int, res);
				
				//"quitting" the menu
				goal_int = -1;
				System.out.println("Select the option for 0");
				res = Functions.GetUserSelection(s, name, id);
				assertEquals(goal_int, res);
			}
	}
}
