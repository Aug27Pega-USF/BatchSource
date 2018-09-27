package proj.banking.utils;

import java.sql.SQLException;
import java.util.List;

import proj.banking.bean.BankAccounts;
import proj.banking.bean.UserAccountInfo;
import proj.banking.utils.Enums.CloseStatus;
import proj.banking.utils.Enums.NewBankAccountStatus;
import proj.banking.utils.Enums.NewUser;
import proj.banking.utils.Enums.TransactionStatus;
import proj.banking.utils.Enums.TransactionType;

public interface Banking {
	List<UserAccountInfo> getUserList(int userLevels) throws SQLException;
	List<BankAccounts> getUserBankAccounts(int userAccountNumber) throws SQLException;
	double getBankAccountBalance(int userAccNum, int bankAccountNum) throws SQLException;
	//public int login(int UserLevel, String userID, String password) throws SQLException;
	UserAccountInfo getUserInfo(int userAccountNum) throws SQLException;
	List<String []> getWaitingApproval() throws SQLException;
	boolean approveAccount(int bankAccountNumber) throws SQLException;
	NewBankAccountStatus newBankAccount(int newAccNum, int primaryID, int jointID, double initialDeposit) throws SQLException;
	CloseStatus closeUserBankAccount(int userAccNumber, int bankAccountNumber) throws SQLException;
	TransactionStatus updateBalance(int userID, int accountNum, double newBalance) throws SQLException;
	TransactionStatus withdraw(int userID, int accountNum, double amount);
	TransactionStatus deposit(int userID, int accountNum, double amount);
	TransactionStatus transaction(TransactionType transaction, int userAccNum, int bankAccNum1, int bankAccNum2,
			double amount) throws NumberFormatException, SQLException;
	NewUser createUserID(int new_user_acc_id, String new_userID, String new_userPassword, UserAccountInfo newUserInfo,
			int userLevel) throws SQLException;
	NewUser updatePersonalInfo(UserAccountInfo newUserInfo, int selection) throws SQLException;
	NewUser updateLoginInfo(int userAccNum, String newUserName, String newPassword) throws SQLException;
	boolean deleteUserAccount(int userAccountNumber) throws SQLException;
}
