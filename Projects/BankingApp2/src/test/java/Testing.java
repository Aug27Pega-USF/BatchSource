import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.HashMap;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import com.revature.Bank;
import com.revature.Login;
import com.revature.Serialize;
import com.revature.accounts.Account;
import com.revature.accounts.CheckingAccount;
import com.revature.beans.Customer;
class Testing {
	static Serialize serializer = new Serialize();
	static Login login = new Login();
	static Bank theBank = new Bank();
	static File customerFile = new File("BankCustomers.txt");
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeAll 
	static void InitializeFile() {
		HashMap<Integer,Customer> customerMap = new HashMap<Integer, Customer>();
		customerMap = serializer.readFromFile(customerFile);	
	}

	@Test
	 void testCustomerAccountsNotNull() {
		Customer C = new Customer("Kevin", "Medara", "UNAME", "PWORD", "555-55-5555");
		Account account = new CheckingAccount();
		C.getCustomerAccounts().add(account);
		assertEquals(1,C.getCustomerAccounts().size());
	}
	@Test
	void EmloyeeFindCustomer() {
		HashMap<Integer,Customer> customerMap = new HashMap<Integer, Customer>();
		customerMap = serializer.readFromFile(customerFile);
		int userID = 1166642;//customerID in map
		Customer C = customerMap.get(userID);
		assertEquals(C, theBank.findCustomerByID(userID, customerMap));
	}

	@Nested
	class LoginTest{
		@Test 
		void UserLogin() {
			Customer C = new Customer("Kevin", "Medara", "UNAME", "PWORD", "555-55-5555");
			
		}
		void GetCustomerData() throws Exception {
			HashMap<Integer,Customer> customerMap = new HashMap<Integer, Customer>();
			customerMap = serializer.readFromFile(customerFile);
			Customer C = new Customer("Kevin", "Medara", "UNAME", "PWORD", "555-55-5555");

			assertEquals(C.toString(), theBank.findCustomerByUSN(C.getUsername(), customerMap));

		}
	}
	@Nested
	class AccountTest{
		@Test
		void TestDepositToPendingAccount() {
			Account a = new CheckingAccount("Kevin");
			a.deposit(400.56);
			assertEquals(a.getBalance(),0.00,0.000005);
		}
		@Test
		void TestDepositToOpenAccount() {
			Account a = new CheckingAccount("Kevin");
			a.setStatus(Account.AccountStatus.OPEN);
			a.deposit(400.56);
			assertEquals(a.getBalance(),400.56,0.000005);
		}
		@Test
		void TestTransferBetweenAccounts() {
			Account a = new CheckingAccount();
			Account b = new CheckingAccount();
			a.setStatus(Account.AccountStatus.OPEN);
			b.setStatus(Account.AccountStatus.OPEN);
			a.setBalance(300);
			a.transfer(300, a, b);
			assertEquals(b.getBalance(),300,0.000005);
		}
		
	 
	}
	
	
	

}
