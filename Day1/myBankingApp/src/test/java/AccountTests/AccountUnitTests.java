package AccountTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import myBankingApp.Bank.Account;

class AccountUnitTests {
	
	// CONSTRUCTOR TESTS
	@Nested
	class ConstructorTests{
		@Test
		void testAccountArrayListOfStringStringInt() {
		//	fail("Not yet implemented");
		}
	
		@Test
		void testAccountStringStringInt() {
		//	fail("Not yet implemented");
		}
	}
	
	
	// DEPOSIT TESTS
	@Nested
	class DepositTests{
		@Test
		void testDepositToPendingAccount() {
			// Test if one can deposit to Pending Account
			Account A = new Account("Luis:Doi","Savings",11);
			A.deposit(100.00f);
			// Should be zero if the account has yet to be approved
			assertEquals(A.getBalance(), 0.00f);	
		}
		@Test
		void testDepositToClosedAccount() {
			// Test if one can deposit to Pending Account
			Account A = new Account("Luis:Doi","Savings",11);
			A.changeStatusToACTIVE();
			A.deposit(100.00f);
			A.changeStatusToCLOSED();
			A.deposit(150.00f);
			// Should be 100.00 if the account has been cancelled
			assertEquals(A.getBalance(), 100.00f);		
		}
		@Test
		void testDepositToActiveAccount() {
			// Test if one can deposit to Pending Account
			Account A = new Account("Luis:Doi","Savings",11);
			A.changeStatusToACTIVE();
			A.deposit(100.00f);
			// Should be 100.00 if the account has been approved
			assertEquals(A.getBalance(), 100.00f);		
		}
	}
	
	// WITHDRAW TESTS
	@Nested
	class WithdrawTests{
		@Test
		void testWithdraw() {
			//fail("Not yet implemented");
		}
	}


	
	// TRANSFER TESTS
	@Nested
	class Transfer {
		@Test
		void testTransfer() {
			//fail("Not yet implemented");
		}
	}

	// 
	@Test
	void testAddAccountHolder() {
		//fail("Not yet implemented");
	}

	@Test
	void testChangeStatusToACTIVE() {
		//fail("Not yet implemented");
	}

	@Test
	void testChangeStatusToCLOSED() {
	//	fail("Not yet implemented");
	}

	@Test
	void testChangeStatusToPENDING() {
	//	fail("Not yet implemented");
	}

	@Test
	void testGetAccountHolders() {
	//	fail("Not yet implemented");
	}

	@Test
	void testSetAccountHolders() {
	//	fail("Not yet implemented");
	}

	@Test
	void testSetOverDrawing() {
	//	fail("Not yet implemented");
	}

	@Test
	void testIsOverDrawn() {
	//	fail("Not yet implemented");
	}

	@Test
	void testSetOverDrawn() {
	//	fail("Not yet implemented");
	}

	@Test
	void testGetStat() {
	//	fail("Not yet implemented");
	}

	@Test
	void testSetStat() {
	//	fail("Not yet implemented");
	}

	@Test
	void testToString() {
	//	fail("Not yet implemented");
	}

}
