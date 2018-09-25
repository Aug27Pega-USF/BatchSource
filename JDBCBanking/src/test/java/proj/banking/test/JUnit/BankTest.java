package proj.banking.test.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import proj.banking.BankMain;
import proj.banking.bean.BankAccounts;
import proj.banking.bean.UserAccountInfo;
import proj.banking.utils.Enums.*;

class BankTest {
	
	UserAccountInfo cust1 = new UserAccountInfo("999999999", "John", "Doe", "jDoe@fake.com", "123-456-7890", "1990-01-01", "123 Fake St", "NW", "11223");
	UserAccountInfo cust2 = new UserAccountInfo("999999998,Jane,Doe,janeDoe@fake.com,987-654-3210,1991-02-02,321 Fake Blvd,NW,33221,".split(","));
	UserAccountInfo emp = new UserAccountInfo("999999997,Jack,Doe,jackDoe@fake.com,111-222-3333,1980-12-23,321 Impossible Blvd,VD,22331,".split(","));
	UserAccountInfo admin = new UserAccountInfo("999999996,Elis,Doe,eDoe@fake.com,444-555-6666,1985-05-15,456 Rich Lane,VD,99551,".split(","));
	BankAccounts bankAcc98_99Active = new BankAccounts("1999999999,999999998,,650.00,N,".split(","));
	BankAccounts bankAcc99_98_98Waiting = new BankAccounts("1999999998,999999999,999999998,50000.00,Y,".split(","));
	BankAccounts bankAcc99_97Active = new BankAccounts("1999999997,999999999,,1000.00,N,".split(","));
	BankAccounts bankAcc99_98_96Joint = new BankAccounts("1999999996,999999999,999999998,3000.00,N,".split(","));
	BankAccounts bankAcc99_98_95Empty = new BankAccounts("1999999995,999999999,999999998,0,N,".split(","));
	
	BankMain bank = BankMain.getInstance();
	//BankLogin login = BankLogin.getInstance(fileData.getUserFile(), fileData.getUserInfoFile());
	
	@Nested
	class InitializationTests{
		@Test
		void SingletonBankTest() {
			BankMain bank2 = BankMain.getInstance();
			assertEquals(bank.getInstance(), bank2.getInstance());
		}
		/*
		@Test
		void SingletonUserLoginTest() {
			BankLogin login2 = BankLogin.getInstance(fileData.getUserFile(),fileData.getUserInfoFile());
			assertEquals(login.getInstance(null, null), login2.getInstance(null, null));
		}
		*/
	}
	
	@Nested
	class SQLTest{

		@Nested
		class RetrieveUserInfoTest {
			@Test
			void incorrectUserAccNum() throws SQLException {
				assertEquals(null, bank.getUserInfo(1));
			}
			
			@Test
			void correctUserAccNum() throws SQLException {
				assertTrue(cust1.toString().equals(bank.getUserInfo(999999999).toString()));
				assertTrue(cust2.toString().equals(bank.getUserInfo(999999998).toString()));
				assertTrue(emp.toString().equals(bank.getUserInfo(999999997).toString()));
				assertTrue(admin.toString().equals(bank.getUserInfo(999999996).toString()));
			}
		}
		
		@Nested
		class RetrieveUserListTest {
			@Test
			void failedGettingUser() throws SQLException {
				assertEquals(null, bank.getUserList(0));
			}
			
			@Test
			void wrongInputUserLevel() throws SQLException {
				assertEquals(null, bank.getUserList(4));
			}
			
			@Test
			void getAllUsers() throws SQLException {
				List<UserAccountInfo> expectedUserAccountList = new ArrayList<UserAccountInfo>();;
				expectedUserAccountList.add(cust1);
				expectedUserAccountList.add(cust2);
				expectedUserAccountList.add(emp);
				expectedUserAccountList.add(admin);
				assertTrue(expectedUserAccountList.toString().equals(bank.getUserList(3).toString()));
			}
		}
		
		@Nested
		class RetrieveUserBankAccountTest {
			@Test
			void userDoesNotExist() throws SQLException {
				assertEquals(null, bank.getUserBankAccounts(1));
			}
			
			@Test
			void userHasNoBankAccounts() throws SQLException {
				assertEquals(null, bank.getUserBankAccounts(999999997));
			}
			
			@Test
			void userWithPrimaryAndJointEach() throws SQLException {
				List<BankAccounts> accountsTest = new ArrayList<BankAccounts>();
				accountsTest.add(bankAcc98_99Active);
				accountsTest.add(bankAcc99_98_96Joint);
				accountsTest.add(bankAcc99_98_95Empty);
				assertTrue(accountsTest.toString().equals(bank.getUserBankAccounts(999999998).toString()));
			}
			
			@Test
			void getWaitingApprovalList() throws SQLException {
				List<String []> expectedList = new ArrayList<String []>();
				List<String []> actualList = bank.getWaitingApproval();
				expectedList.add(new String [] {"1999999998","John Doe", "50000.0"});
				
				assertArrayEquals(expectedList.toArray(), actualList.toArray());
			}
		}
		
		@Nested
		class GetBankAccountBalanceTest {
			@Test
			void userAccDoesNotExist() throws SQLException {
				assertEquals(-1, bank.getBankAccountBalance(1, 1999999998));
			}
			
			@Test
			void bankAccountDoesNotExist() throws SQLException {
				assertEquals(-1, bank.getBankAccountBalance(999999999, 1));
			}
			
			@Test
			void zeroBalanceAccount() throws SQLException {
				assertEquals(0, bank.getBankAccountBalance(999999999, 1999999995));
			}
			
			@Test
			void accountFoundNotWaitingApproval() throws SQLException {
				assertEquals(1000, bank.getBankAccountBalance(999999999, 1999999997));
			}
			
			@Test
			void accountFoundWaitingApproval() throws SQLException {
				assertEquals(-1, bank.getBankAccountBalance(999999999, 1999999998));
			}
		}
		
		@Nested
		class BankTransactionTest {
			@Test
			void invalidAmountEntered() throws SQLException {
				assertEquals(TransactionStatus.INVALID_AMOUNT, bank.transaction(TransactionType.WITHDRAW, 
								999999999, 1999999995, 0, -500));
				assertEquals(TransactionStatus.INVALID_AMOUNT, bank.transaction(TransactionType.DEPOSIT, 
						999999999, 1999999995, 0, -500));
			}
			
			@Test
			void insufficientFundsForWithdraw() throws SQLException {
				assertEquals(TransactionStatus.NOT_ENOUGH_FUNDS, bank.transaction(TransactionType.WITHDRAW, 
								999999999, 1999999995, 0, 500));
			}
			
			@Test
			void invalidUserAccNumWithdraw() throws SQLException {
				assertEquals(TransactionStatus.FAILED, bank.transaction(TransactionType.WITHDRAW, 
								1, 1999999997, 0, 500));
				assertEquals(TransactionStatus.FAILED, bank.transaction(TransactionType.DEPOSIT, 
						1, 1999999997, 0, 500));
			}
			
			@Test
			void notAccountHolderTranscationAttempts() throws SQLException {
				assertEquals(TransactionStatus.FAILED, bank.transaction(TransactionType.WITHDRAW, 
						999999999, 1999999999, 0, 100));
				assertEquals(TransactionStatus.FAILED, bank.transaction(TransactionType.DEPOSIT, 
						999999999, 1999999999, 0, 100));
			}
			
			@Test
			void successfulWithdrawDeposit() throws SQLException {
				assertEquals(TransactionStatus.SUCCESS, bank.transaction(TransactionType.WITHDRAW, 
						999999999, 1999999997, 0, 500));
				assertEquals(TransactionStatus.SUCCESS, bank.transaction(TransactionType.DEPOSIT, 
						999999999, 1999999997, 0, 500));
				assertEquals(TransactionStatus.SUCCESS, bank.transaction(TransactionType.WITHDRAW, 
						999999998, 1999999996, 0, 500));
				assertEquals(TransactionStatus.SUCCESS, bank.transaction(TransactionType.DEPOSIT, 
						999999998, 1999999996, 0, 500));
			}
			
			@Test
			void invalidFundsForTransfer () throws NumberFormatException, SQLException {
				assertEquals(TransactionStatus.NOT_ENOUGH_FUNDS, bank.transaction(TransactionType.TRANSFER, 
						999999999, 1999999995, 1999999996, 500));
			}
			
			@Test
			void failedTransferFundsReturned () throws NumberFormatException, SQLException {
				double startBalance = bank.getBankAccountBalance(999999999, 1999999996);
				bank.transaction(TransactionType.TRANSFER, 999999999, 1999999996, 1, 500);
				assertEquals(startBalance, bank.getBankAccountBalance(999999999, 1999999996));
			}
			
			@Test
			void successfulTransfer () throws SQLException {
				double withdrawInitialBalance = bank.getBankAccountBalance(999999999, 1999999996);
				double depositInitialBalance = bank.getBankAccountBalance(999999999, 1999999995);
				double transferAmount = 1250;
				assertEquals(TransactionStatus.SUCCESS, 
						bank.transaction(TransactionType.TRANSFER, 999999999, 1999999996, 1999999995, transferAmount));
				assertEquals(withdrawInitialBalance - transferAmount, bank.getBankAccountBalance(999999999, 1999999996));
				assertEquals(depositInitialBalance + transferAmount, bank.getBankAccountBalance(999999999, 1999999995));
				bank.transaction(TransactionType.TRANSFER, 999999999, 1999999995, 1999999996, transferAmount);
			}
		}
		
		@Nested
		class BankAccountManagementTest {
			@Test
			void invalidInitialDeposit() throws SQLException {
				assertEquals(NewBankAccountStatus.INVALID_DEPOSIT, bank.newBankAccount(1999999999, 999999998, 0, -1));
			}
			
			@Test
			void userPrimaryAccDoesNotExist() throws SQLException {
				assertEquals(NewBankAccountStatus.INVALID_PRIMARY, bank.newBankAccount(1999999999, 1, 0, 100));
			}
			
			@Test
			void openAccountNotAsCustomer() throws SQLException {
				assertEquals(NewBankAccountStatus.INVALID_USER_TYPE, bank.newBankAccount(1000000001, 999999997,0,0));
			}

			@Test
			void cannotCloseAccountWithFunds() throws SQLException {
				assertEquals(CloseStatus.ACTIVE_FUNDS, bank.closeUserBankAccount(999999999, bankAcc99_97Active.getAccountNumber()));
			}
			
			@Test
			void closingNonExistentAccount() throws SQLException {
				assertEquals(CloseStatus.ERROR, bank.closeUserBankAccount(999999999, 1));
			}
			
			@Test
			void closingAccountAsNonPrimaryHolder() throws SQLException {
				assertEquals(CloseStatus.ERROR, bank.closeUserBankAccount(1, 1999999995));
			}
			
			@Test
			void SuccessOpenCloseAccountWithZeroDeposit() throws SQLException {
				assertEquals(NewBankAccountStatus.SUCCESS, bank.newBankAccount(1000000001, 999999999, 0, 0));
				assertEquals(CloseStatus.SUCCESS, bank.closeUserBankAccount(999999999, 1000000001));
			}
		}

		@Nested
		class LoginTest {
			@Test
			void incorrectUsernamePassword() throws SQLException {
				assertEquals(0, bank.login(1, "user", "pass"));
				assertEquals(0, bank.login(1, "user01", "pass"));
				assertEquals(0, bank.login(1, "user", "pass01"));
				assertEquals(0, bank.login(2, "emp", "pass"));
				assertEquals(0, bank.login(2, "emp01", "pass"));
				assertEquals(0, bank.login(2, "emp", "emppass"));
				assertEquals(0, bank.login(3, "ad", "pass"));
				assertEquals(0, bank.login(3, "admin01", "pass"));
				assertEquals(0, bank.login(3, "admin", "adpass"));
			}
			
			@Test
			void incorrectUserLevel() throws SQLException {
				assertEquals(0, bank.login(1, "emp01", "emppass"));
				assertEquals(0, bank.login(2, "user01", "pass01"));
				assertEquals(0, bank.login(3, "emp01", "emppass"));
			}
			
			@Test
			void correctCustomerLogin() throws SQLException {
				assertEquals(cust1.getUserAccNum(), bank.login(1, "user01", "pass01"));
				assertEquals(cust2.getUserAccNum(), bank.login(1, "user02", "pass02"));
			}
			
			@Test
			void correctEmployeeLogin() throws SQLException {
				assertEquals(emp.getUserAccNum(), bank.login(2, "emp01", "emppass"));
			}
			
			@Test
			void correctAdminLogin() throws SQLException {
				assertEquals(admin.getUserAccNum(), bank.login(3, "admin01", "adpass"));
			}
		}
			
		@Nested
		class CreateUpdateDeleteTest {
			UserAccountInfo tmpCust = new UserAccountInfo("900000001,One,One,oneTest@one.com,111-111-1111,1111-11-11,111 One Lane,ON,11111,".split(","));
			
			@Nested
			class CreateNewUserTest {
				
				@Nested
				class CreateTest {
					@Test
					void noUsernameForNewUser () throws SQLException {
						assertEquals(NewUser.INVALID_USERNAME, bank.createUserID(900000001, null, "pass01", tmpCust, 1));
						assertEquals(NewUser.INVALID_USERNAME, bank.createUserID(900000001, "", "pass01", tmpCust, 1));
					}
					
					@Test
					void noPasswordForNewUser () throws SQLException {
						assertEquals(NewUser.INVALID_PASSWORD, bank.createUserID(900000001, "user03", null, tmpCust, 1));
						assertEquals(NewUser.INVALID_PASSWORD, bank.createUserID(900000001, "user03", "", tmpCust, 1));
					}
					
					@Test
					void noFirstName () throws SQLException {
						tmpCust.setFirstName(null);
						assertEquals(NewUser.NO_FIRST, bank.createUserID(900000001, "user03", "pass03", tmpCust, 1));
						tmpCust.setFirstName("");
						assertEquals(NewUser.NO_FIRST, bank.createUserID(900000001, "user03", "pass03", tmpCust, 1));
						tmpCust.setFirstName("One");
					}
					
					@Test
					void noLastName () throws SQLException {
						tmpCust.setLastName(null);
						assertEquals(NewUser.NO_LAST, bank.createUserID(900000001, "user03", "pass03", tmpCust, 1));
						tmpCust.setLastName("");
						assertEquals(NewUser.NO_LAST, bank.createUserID(900000001, "user03", "pass03", tmpCust, 1));
						tmpCust.setLastName("One");
					}
					
					@Test
					void userNameExists () throws SQLException {
						assertEquals(NewUser.EXISTING_USERNAME, bank.createUserID(900000001, "user01", "pass03", tmpCust, 1));
					}
					
					@Test
					void accountIDExists () throws SQLException {
						assertEquals(NewUser.INVALID_USER_ACC_NUM, bank.createUserID(999999999, "user03", "pass03", tmpCust, 1));
					}
				}
			
				@Nested
				class UpdateTest {
					UserAccountInfo tmpCust2;
					/*
					@BeforeAll
					void setup() throws SQLException {
						bank.createUserID(900000001, "user03", "pass03", tmpCust, 1);
						tmpCust2 = new UserAccountInfo("900000001,Two,Two,twoTest@one.com,222-222-2222,2222-02-02,222 Two Lane,TW,22222,".split(","));				
					}
					@AfterAll
					void removeTestUser() throws SQLException {
						bank.deleteUserAccount(900000001);
					}
					*/
					@Test
					void updateUserInfo() throws SQLException {
						bank.createUserID(900000001, "user03", "pass03", tmpCust, 1);
						tmpCust2 = new UserAccountInfo("900000001,Two,Two,twoTest@one.com,222-222-2222,2222-02-02,222 Two Lane,TW,22222,".split(","));				
					
						assertEquals(NewUser.SUCCESS, bank.updatePersonalInfo(tmpCust2, 1));
						assertEquals(NewUser.SUCCESS, bank.updatePersonalInfo(tmpCust2, 2));
						assertEquals(NewUser.SUCCESS, bank.updatePersonalInfo(tmpCust2, 3));
						assertEquals(NewUser.SUCCESS, bank.updatePersonalInfo(tmpCust2, 4));
						assertEquals(NewUser.SUCCESS, bank.updatePersonalInfo(tmpCust2, 5));
						assertEquals(NewUser.SUCCESS, bank.updatePersonalInfo(tmpCust2, 6));
						assertEquals(NewUser.SUCCESS, bank.updatePersonalInfo(tmpCust2, 7));
						assertEquals(NewUser.SUCCESS, bank.updatePersonalInfo(tmpCust2, 8));
						assertEquals(NewUser.FAILED, bank.updatePersonalInfo(tmpCust2, 9));
						bank.deleteUserAccount(900000001);
					}
					
					@Test
					void nullFirstLastName() throws SQLException {
						bank.createUserID(900000001, "user03", "pass03", tmpCust, 1);
						tmpCust2 = new UserAccountInfo("900000001,,,twoTest@one.com,222-222-2222,2222-02-02,222 Two Lane,TW,22222,".split(","));				
						
						assertEquals(NewUser.NO_FIRST, bank.updatePersonalInfo(tmpCust2, 1));
						tmpCust2.setFirstName(null);
						assertEquals(NewUser.NO_FIRST, bank.updatePersonalInfo(tmpCust2, 1));
						tmpCust2.setFirstName("Two");
						assertEquals(NewUser.NO_LAST, bank.updatePersonalInfo(tmpCust2, 2));
						tmpCust2.setLastName(null);
						assertEquals(NewUser.NO_LAST, bank.updatePersonalInfo(tmpCust2, 2));

						bank.deleteUserAccount(900000001);
					}
					
					@Test
					void invalidUsernameAndPassword() throws SQLException{
						bank.createUserID(900000001, "user03", "pass03", tmpCust, 1);
						assertEquals(NewUser.INVALID_USERNAME, bank.updateLoginInfo(900000001, "", "newPass"));
						assertEquals(NewUser.INVALID_USERNAME, bank.updateLoginInfo(900000001, null, "newPass"));
						assertEquals(NewUser.INVALID_PASSWORD, bank.updateLoginInfo(900000001, "newUsername", ""));
						assertEquals(NewUser.INVALID_PASSWORD, bank.updateLoginInfo(900000001, "newUsername", null));
						bank.deleteUserAccount(900000001);
					}
					
					@Test
					void userNameExists () throws SQLException {
						bank.createUserID(900000001, "user03", "pass03", tmpCust, 1);
						assertEquals(NewUser.EXISTING_USERNAME, bank.updateLoginInfo(900000001, "user01", "newPass"));			
						bank.deleteUserAccount(900000001);
					}
					
					@Test
					void invalidUserAccID () throws SQLException {
						assertEquals(NewUser.INVALID_USER_ACC_NUM, bank.updateLoginInfo(1, "newUser", "newPass"));
						assertEquals(NewUser.INVALID_USER_ACC_NUM, bank.updateLoginInfo(0, "newUser", "newPass"));
						assertEquals(NewUser.INVALID_USER_ACC_NUM, bank.updateLoginInfo(2000000001, "newUser", "newPass"));
					}
					
					@Test
					void updateUsernameAndPassword() throws SQLException{
						bank.createUserID(900000001, "user03", "pass03", tmpCust, 1);
						assertEquals(NewUser.SUCCESS, bank.updateLoginInfo(900000001, "newUsername", "newPass"));			
						bank.deleteUserAccount(900000001);
					}
				}
			}
		}
	}
	
	/*
	@Nested
	class LoginTest{
		@Test 
		void BankServiceLoginSuccess() {
			UserAccountInfo userInfo = new UserAccountInfo("9123456780", "Customer", "John Doe", "jDoe@fake.com",
					"123-456-7890", "1/1/1990", "123 Fake st", "NW", "11223");
			assertTrue(userInfo.toString().equals(bank.login(1, "user01", "pass01").toString()));
		}
		@Test
		void UserServiceLoginSuccess() throws Exception {
			UserAccountInfo userInfo = new UserAccountInfo("9123456780", "Customer", "John Doe", "jDoe@fake.com",
					"123-456-7890", "1/1/1990", "123 Fake st", "NW", "11223");
			assertEquals("9123456780", login.checkLogin("user01", "pass01").toString());
		}
		
		@Test
		void IncorrectPassword() throws Exception {
			assertEquals(null, bank.login(1, "user01", "password"));
		}
		
		@Test
		void InvalidLogin() throws Exception {
			assertEquals(null, bank.login(1, "asdfasdfasdf", "password"));
		}
		@Test
		void SuccessCreateNewUser() {
			assertEquals(newLogin.SUCCESS, bank.createUser("newUser01", "newPass01"));
		}
		@Test
		void GetCustomerData() throws Exception {
			UserAccountInfo accountInfo = new UserAccountInfo("9123456780", "Customer", "John Doe", "jDoe@fake.com",
					"123-456-7890", "1/1/1990", "123 Fake st", "NW", "11223");
			//assertEquals(accountInfo.toString(), bank.getUserInfo("9123456780").toString());
		}
	}

	@Nested
	class UserTests{
		@Nested
		class CustomerTests{
			@Test
			void GetUserBankAccounts() throws Exception {
				List<BankAccounts> accountsTest = new ArrayList<BankAccounts>();
				accountsTest.add(new BankAccounts("9123456780,,1234567890,1000.00,false,".split(",")));
				accountsTest.add(new BankAccounts("9123456780,,1234567891,3000.00,false,".split(",")));
				assertEquals(accountsTest.toString(),  bank.getUserBankAccounts("9123456780","0").toString());
			}
			@Test
			void SuccessfulCustomerLogin() throws Exception {
				UserAccount user = new CustomerAccount().login("user01", "pass01");
				UserAccountInfo testUser = new UserAccountInfo("9123456780", "Customer", "John Doe", "jDoe@fake.com",
						"123-456-7890", "1/1/1990", "123 Fake st", "NW", "11223"); 
				assertEquals(testUser.toString(), user.getAccountInfo().toString());
			}
			@Test
			void BadCustomerLogin() throws Exception {
				assertEquals(null, new CustomerAccount().login("user99", "pass99"));
			}
			@Test
			void FailedUserRegistration() throws Exception {
				assertFalse(new CustomerAccount().registerUserLogin("user01", "pass01"));
			}
		}

		@Nested
		class EmployeeFunctionalityTests{
			@Test
			void ApproveNewAccountRequest() {
				assertEquals(null, bank.getUserBankAccounts("9123456789", "2234567891"));
				bank.approvedAccount("1234567899","2234567891");
				assertEquals(false, bank.getUserBankAccounts("9123456789", "2234567891").get(0).getWaitingApproval());
			}
			@Test
			void FailedGettingAccountInformation() {
				assertEquals(null, login.getUserPersonalInfo("1234567822", "Customer"));
			}
			@Test
			void GetSingleCustomerAccountInformation() {
				UserAccountInfo userInfo = new UserAccountInfo("9123456780", "Customer", "John Doe", "jDoe@fake.com",
						"123-456-7890", "1/1/1990", "123 Fake st", "NW", "11223");
				assertEquals(userInfo.toString(), (login.getUserPersonalInfo("9123456780", "Customer").get(0)).toString());
			}
			@Test
			void GetAllCustomerAccountInformation() {
				ArrayList<UserAccountInfo> userInfo = new ArrayList<UserAccountInfo>();
				
				userInfo.add(new UserAccountInfo("9123456780,Customer,John Doe,jDoe@fake.com,123-456-7890,1/1/1990,123 Fake st,NW,11223,".split(",")));
				userInfo.add(new UserAccountInfo("9123456789,Customer,Jane Doe,janeDoe@fake.com,987-654-3210,2/2/1991,321 Fake Blvd,NW,33221,".split(",")));				
				assertTrue(login.getUserPersonalInfo("0","Customer").toString().equals(userInfo.toString()));
			}
			@Test
			void GetAllUserAccountInformation() {
				ArrayList<UserAccountInfo> userInfo = new ArrayList<UserAccountInfo>();
				
				userInfo.add(new UserAccountInfo("9123456780,Customer,John Doe,jDoe@fake.com,123-456-7890,1/1/1990,123 Fake st,NW,11223,".split(",")));
				userInfo.add(new UserAccountInfo("9123456789,Customer,Jane Doe,janeDoe@fake.com,987-654-3210,2/2/1991,321 Fake Blvd,NW,33221,".split(",")));
				userInfo.add(new UserAccountInfo("1234567899,Employee,Jack Doe,jackDoe123@fake.com,111-222-333,12/23/1980,321 Impossible Blvd,VD,22331,".split(",")));
				userInfo.add(new UserAccountInfo("9987654321,Admin,Elis Doe,eDoe@fake.com,444-555-666,5/15/1985,456 Rich Lane,VD,995511,".split(",")));
				assertEquals(true, login.getUserPersonalInfo("0","0").toString().equals(userInfo.toString()));
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
			assertEquals(990.00, bank.getUserBankAccounts("9123456780", "1234567890").get(0).getAmount());
		}
		@Test
		void SuccessfulDeposit() {
			bank.transaction(transactionType.DEPOSIT, "9123456780","1234567890", "", 10.00);
			assertEquals(1000.00, bank.getUserBankAccounts("9123456780", "1234567890").get(0).getAmount());
		}	
		@Test
		void SuccessfulTransfer() {
			bank.transaction(transactionType.TRANSFER, "9123456780","1234567890", "1234567891", 10.00);
			assertEquals(3010.00, bank.getUserBankAccounts("9123456780", "1234567891").get(0).getAmount());
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
			assertEquals(accountsTest.get(1).toString(), bank.getUserBankAccounts("9123456780","1234567891").get(0).toString());
		}
	}
	@Test
	void CreateNewBankAccount() {
		String newAccountNumber = bank.newBankAccount("9123456789","",2222.00);
		assertEquals(true, bank.getApprovalStatus(newAccountNumber));
	}
	*/
}
