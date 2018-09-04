package proj.banking.test.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import proj.banking.BankAccounts;
import proj.banking.BankMain;
import proj.banking.user.CustomerAccount;
import proj.banking.user.EmployeeAccount;
import proj.banking.user.UserAccount;
import proj.banking.user.UserLogin;
import proj.banking.user.bean.UserAccountInfo;
import proj.banking.utils.DataFiles;
import proj.banking.utils.Enums.*;

class BankTest {
	private static final String transactionFile = "mockData/transaction.txt";
	private static final String userFile = "mockData/userLogin.txt";
	private static final String userInfoFile = "mockData/userInformation.txt";
	private static final String bankAccountFile = "mockData/bankAccountList.txt";
	static DataFiles fileData;
	
	BankMain bank = BankMain.getInstance(fileData);
	UserLogin login = UserLogin.getInstance(fileData.getUserFile(), fileData.getUserInfoFile());
	
	@BeforeAll
	static void InitializeBank() {
		fileData = new DataFiles(transactionFile, userFile, userInfoFile, bankAccountFile);
	}
	
	@Nested
	class InitializationTests{
		@Test
		void SingletonBankTest() {
			BankMain bank2 = BankMain.getInstance(null);
			assertEquals(bank.getInstance(null), bank2.getInstance(null));
		}
		
		@Test
		void SingletonUserLoginTest() {
			UserLogin login2 = UserLogin.getInstance(fileData.getUserFile(),fileData.getUserInfoFile());
			assertEquals(login.getInstance(null, null), login2.getInstance(null, null));
		}
	}
	
	@Nested
	class LoginTest{
		@Test
		void LoginSuccess() throws Exception {
			UserAccountInfo userInfo = new UserAccountInfo("9123456780", "CustomerAccount", "John Doe", "jDoe@fake.com",
					"123-456-7890", "1/1/1990", "123 Fake st", "NW", "11223");
			assertEquals(userInfo.toString(), bank.login("user01", "pass01").toString());
		}
		
		@Test
		void IncorrectPassword() throws Exception {
			assertEquals(null, bank.login("user01", "password"));
		}
		
		@Test
		void InvalidLogin() throws Exception {
			assertEquals(null, bank.login("asdfasdfasdf", "password"));
		}
		@Test
		void SuccessCreateNewUser() {
			assertEquals(newLogin.SUCCESS, bank.createUser("newUser01", "newPass01"));
		}
		@Test
		void GetCustomerData() throws Exception {
			UserAccountInfo accountInfo = new UserAccountInfo("9123456780", "CustomerAccount", "John Doe", "jDoe@fake.com",
					"123-456-7890", "1/1/1990", "123 Fake st", "NW", "11223");
			assertEquals(accountInfo.toString(), bank.getUserInfo("9123456780").toString());
		}
	}
	/*
	@Test
	void Logout() {
		BankMain bank = new BankMain(fileData);
		Customer user = new Customer();
		user.getUser("9123456789");
		
		assertEquals(true, bank.logout(user));
	}
	*/
	@Nested
	class UserTests{
		@Nested
		class CustomerTests{
			@Test
			void GetUserBankAccounts() throws Exception {
				List<BankAccounts> accountsTest = new ArrayList<BankAccounts>();
				List<BankAccounts> accounts = bank.getUserBankAccounts("9123456780");
				accountsTest.add(new BankAccounts("9123456780,,1234567890,1000.00,".split(",")));
				accountsTest.add(new BankAccounts("9123456780,,1234567891,3000.00,".split(",")));
				accountsTest.add(new BankAccounts("9123456789,9123456780,2234567891,500000.00,".split(",")));
				
				assertEquals(accountsTest.containsAll(accounts), accounts.containsAll(accountsTest));
			}
			@Test
			void SuccessfulCustomerLogin() throws Exception {
				UserAccount user = new CustomerAccount().login("user01", "pass01");
				UserAccountInfo testUser = new UserAccountInfo("9123456780", "CustomerAccount", "John Doe", "jDoe@fake.com",
						"123-456-7890", "1/1/1990", "123 Fake st", "NW", "11223"); 
				assertEquals(testUser.toString(), user.getAccountInfo().toString());
			}
			@Test
			void BadCustomerLogin() throws Exception {
				assertEquals(null, new CustomerAccount().login("user99", "pass99"));
			}
		}

		@Nested
		class EmployeeTests{
			@Test
			void ApproveNewAccountRequest() {
				EmployeeAccount employee = new EmployeeAccount();
				List<BankAccounts> accountsTest = new ArrayList<BankAccounts>();
				assertEquals(null, bank.getBankAccount("9123456789", "2234567891"));
				employee.approveRequest("2234567891");
				assertEquals(false, bank.getBankAccount("9123456789", "2234567891").getWaitingApproval());
			}
			
			@Test
			void GetSingleCustomerInformation() {
				UserAccountInfo userInfo = new UserAccountInfo("9123456780", "CustomerAccount", "John Doe", "jDoe@fake.com",
						"123-456-7890", "1/1/1990", "123 Fake st", "NW", "11223");
				assertEquals(userInfo.toString(), ((UserAccountInfo) login.getCustomerPersonalInfo("9123456780", "Customer").get(0)).toString());
			}
			
			@Test
			void GetAllCustomerInformation() {
				ArrayList<UserAccountInfo> userInfo = new ArrayList<UserAccountInfo>();
				
				userInfo.add(new UserAccountInfo("9123456780", "CustomerAccount", "John Doe", "jDoe@fake.com",
						"123-456-7890", "1/1/1990", "123 Fake st", "NW", "11223"));
				userInfo.add(new UserAccountInfo("9123456789,CustomerAccount,Jane Doe,janeDoe@fake.com,987-654-3210,2/2/1991,321 Fake Blvd,NW,33221,".split(",")));
				userInfo.add(new UserAccountInfo("1234567899,Employee,Jack Doe,jackDoe123@fake.com,111-222-333,12/23/1980,321 Impossible Blvd,VD,22331,".split(",")));
				userInfo.add(new UserAccountInfo("9987654321,Admin,Elis Doe, eDoe@fake.com, 444,555,666,5/15/1985,456 Rich Lane,VD,995511,".split(",")));
				assertEquals(userInfo.toString(), login.getCustomerPersonalInfo("0","0").toString());
			}
		}
	}
	
	@Nested
	class TransactionTest{
		@Test
		void NotEnoughFunds() {
			assertEquals(transactionStatus.NOT_ENOUGH_FUNDS, bank.transaction(transactionType.WITHDRAW, "9123456780","1234567890", "", 90000000000.00));
		}
		@Test
		void InvalidTransaction() {
			assertEquals(transactionStatus.FAILED, bank.transaction(transactionType.WITHDRAW, "9123456780","9876543211", "", 10.00));
		}
		@Test
		void SuccessfulWithdraw() {
			bank.transaction(transactionType.WITHDRAW, "9123456780","1234567890", "", 10.00);
			assertEquals(990.00, bank.getBankAccount("9123456780", "1234567890").getAmount());
		}
		@Test
		void SuccessfulDeposit() {
			bank.transaction(transactionType.DEPOSIT, "9123456780","1234567890", "", 10.00);
			assertEquals(1000.00, bank.getBankAccount("9123456780", "1234567890").getAmount());
		}	
		@Test
		void SuccessfulTransfer() {
			bank.transaction(transactionType.TRANSFER, "9123456780","1234567890", "1234567891", 10.00);
			assertEquals(3010.00, bank.getBankAccount("9123456780", "1234567891").getAmount());
			bank.transaction(transactionType.TRANSFER, "9123456780","1234567891", "1234567890", 10.00);
		}
		@Test
		void NotEnoughFundsToTransfer() {
			assertEquals(transactionStatus.NOT_ENOUGH_FUNDS, bank.transaction(transactionType.TRANSFER, "9123456780","1234567890", "1234567891", 999999.00));
		}
		@Test
		void InvalidAmount() {
			assertEquals(transactionStatus.INVALID_AMOUNT, bank.transaction(transactionType.TRANSFER, "9123456780", "1234567890", "", -500.00));
		}
		@Test
		void GetBankAccount() {
			List<BankAccounts> accountsTest = new ArrayList<BankAccounts>();
			accountsTest.add(new BankAccounts("9123456780,,1234567890,1000.00,".split(",")));
			accountsTest.add(new BankAccounts("9123456780,,1234567891,3000.00,".split(",")));
			accountsTest.add(new BankAccounts("9123456789,9123456780,2234567891,500000.00,".split(",")));
			assertEquals(accountsTest.get(1).toString(), bank.getBankAccount("9123456780","1234567891").toString());
		}
	}
	@Test
	void CreateNewBankAccount() {
		String newAccountNumber = bank.newBankAccount("9123456789","",2222.00);
		assertEquals(true, bank.getApprovalStatus(newAccountNumber));
	}
	/*
	@Nested
	class WithdrawTest {
		@Test
		void NegativeWithdraw() {
			assertEquals(false, bank.withdraw(001, -500.00));
		}
		
		@Test
		void WithdrawSuccess() {
			assertEquals(transactionStatus.SUCCESS, bank.withdraw(001, 500.00));
		}
		
		@Test
		void NotEnoughtFundsWithdraw() {
			assertEquals(transactionStatus.NOT_ENOUGH_FUNDS, bank.withdraw(001, 999999999999.00));
		}
	}
	
	@Nested
	class DepositTest {
		@Test
		void NegativeDeposit() {
			assertEquals(false, bank.deposit(001, -500.00));
		}
		
		@Test
		void DepositSuccess() {
			assertEquals(true,bank.deposit(001, 500.00));
		}
	}
	
	@Nested
	class TransferTest {
		@Test
		void NegativeTransfer() {
			assertEquals(false, bank.transfer(001, 002, -500.00));
		}
		
		@Test
		void TransferSuccess() {
			assertEquals(true, bank.transfer(001, 002, 500.00));
		}
		
		@Test
		void NotEnoughtFundsTransfer() {
			assertEquals(false, bank.transfer(001, 002, 999999999.00));
		}
	}
	*/
}
