package proj.banking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proj.banking.utils.Enums.*;
import proj.banking.bean.BankAccounts;
import proj.banking.bean.UserAccountInfo;
import proj.banking.log.TransactionLog;
import proj.banking.utils.Banking;
import proj.banking.utils.DB_ConnectionFactory;
import proj.banking.utils.DataFiles;

public class BankMain implements Banking{
	private static BankMain instance;
	private Connection dbConnection;
	static TransactionLog log;
	protected DataFiles files;
	
	public BankMain(){
		dbConnection = DB_ConnectionFactory.getConnection();
		
		log = new TransactionLog();
	}
	public static synchronized BankMain getInstance() {
		if(instance == null) {
			instance = new BankMain();
		}
		return instance;
	}

	@Override
	public List<UserAccountInfo> getUserList(int userLevels) throws SQLException {
		List<UserAccountInfo> tmpUserAccData = null;
		if(userLevels >= 1 && userLevels <= 3) {
			tmpUserAccData = new ArrayList<UserAccountInfo>();
			PreparedStatement ps;
			ResultSet rs;
			
			ps = dbConnection.prepareStatement("SELECT USER_ACC_NUM, FIRSTNAME, LASTNAME, EMAIL, PHONE, DOB, ADDRESS, STATE, ZIP " 
					+ "FROM USER_INFORMATION " 
					+ "WHERE USERTYPE<=?");
			ps.setInt(1, userLevels);
			rs =  ps.executeQuery();
			while(rs.next()) {
				tmpUserAccData.add(new UserAccountInfo(rs));
			}
		}
		if(tmpUserAccData != null && tmpUserAccData.size() > 0) {
			return tmpUserAccData;
		} else {
			return null;
		}
	}
	
	@Override
	public List<String []> getWaitingApproval() throws SQLException {
		List<String []> tmpWaitingApprovalList = new ArrayList<String []>();
		PreparedStatement ps;
		ResultSet rs;
		
		ps = dbConnection.prepareStatement("SELECT BANK_ACC_NUM, FIRSTNAME || ' ' || LASTNAME, BALANCE " 
				+ "FROM BANK_ACCOUNTS, USER_INFORMATION "
				+ "WHERE WAITINGAPPROVAL='Y' AND PRIMARYHOLDERID=USER_ACC_NUM");
		rs = ps.executeQuery();
		
		while(rs.next()) {
			tmpWaitingApprovalList.add(
					new String[] { Integer.toString(rs.getInt(1)), rs.getString(2), Double.toString(rs.getDouble(3)) });
		}

		if(tmpWaitingApprovalList.size() > 0) {
			return tmpWaitingApprovalList;
		} else {
			return null;
		}
	}
	
	@Override
	public NewBankAccountStatus newBankAccount(int newAccNum, int primaryID, int jointID, double initialDeposit) throws SQLException {
		//String newAccStatus;
		CallableStatement cs;
		
		cs = dbConnection.prepareCall("{call CREATE_NEW_BANK_ACCOUNT(?, ?, ?, ?, ?)}");
		cs.setInt(1, newAccNum);
		cs.setInt(2, primaryID);
		cs.setInt(3, jointID);
		cs.setDouble(4, initialDeposit);
		cs.registerOutParameter(5, java.sql.Types.VARCHAR);
		cs.executeQuery();
		//newAccStatus = call.cs.getString(5);
		
		switch(cs.getString(5)) {
		case "SUCCESS":
			return NewBankAccountStatus.SUCCESS;
		case "INVALID_DEPOSIT":
			return NewBankAccountStatus.INVALID_DEPOSIT;
		case "INVALID_PRIMARY":
			return NewBankAccountStatus.INVALID_PRIMARY;
		case "INVALID_USER_TYPE":
			return NewBankAccountStatus.INVALID_USER_TYPE;
		default:
			return NewBankAccountStatus.FAILED;
		}
	}
	
	@Override
	public CloseStatus closeUserBankAccount(int userAccNumber, int bankAccountNumber) throws SQLException {
		PreparedStatement ps;
		int closeStatus = -1;
		
		if(getBankAccountBalance(userAccNumber, bankAccountNumber) > 0) {
			return CloseStatus.ACTIVE_FUNDS;
		}
		ps = dbConnection.prepareStatement("DELETE FROM BANK_ACCOUNTS WHERE BANK_ACC_NUM=? AND PRIMARYHOLDERID=?");
		ps.setInt(1, bankAccountNumber);
		ps.setInt(2, userAccNumber);
		closeStatus = ps.executeUpdate();
		
		if(closeStatus == 1) {
			return CloseStatus.SUCCESS;
		} else {
			return CloseStatus.ERROR;
		}
	}
	
	/*
	public boolean getApprovalStatus(int bankAccountNumber) {
		for(BankAccounts acc : approvalWaitingList) {
			if(acc.getAccountNumber() == bankAccountNumber) {
				return true;
			}
		}
		return false;
	}
	*/
	@Override
	public List<BankAccounts> getUserBankAccounts(int userAccountNumber) throws SQLException{
		PreparedStatement ps;
		ResultSet rs;
		List<BankAccounts> tmpAccountList = new ArrayList<BankAccounts> ();

		ps = dbConnection.prepareStatement("SELECT BANK_ACC_NUM, PRIMARYHOLDERID, JOINTHOLDERID, BALANCE FROM BANK_ACCOUNTS "
				+ "WHERE WAITINGAPPROVAL='N' AND (PRIMARYHOLDERID=? OR JOINTHOLDERID=?)");
		ps.setInt(1, userAccountNumber);
		ps.setInt(2, userAccountNumber);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			tmpAccountList.add(new BankAccounts(rs));
		}

		if(tmpAccountList.size() > 0) {
			return tmpAccountList;
		} else {
			return null;
		}
	}
	
	@Override
	public double getBankAccountBalance(int userAccNum, int bankAccountNum) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		double currentBalance = -1;
		
		ps = dbConnection.prepareStatement("SELECT BALANCE FROM BANK_ACCOUNTS "
				+ "WHERE BANK_ACC_NUM=? AND WAITINGAPPROVAL='N' AND (PRIMARYHOLDERID=? OR JOINTHOLDERID=?)");
		ps.setInt(1, bankAccountNum);
		ps.setInt(2, userAccNum);
		ps.setInt(3, userAccNum);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			currentBalance =  rs.getDouble(1);
		}
		
		return currentBalance;
	}
	
	@Override
	public TransactionStatus updateBalance(int userID, int accountNum, double newBalance) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		int updateBalanceStatus = -1;
		
		ps = dbConnection.prepareStatement("UPDATE BANK_ACCOUNTS SET BALANCE=?"
				+ "WHERE BANK_ACC_NUM=? AND WAITINGAPPROVAL='N' AND (PRIMARYHOLDERID=? OR JOINTHOLDERID=?)");
		ps.setDouble(1, newBalance);
		ps.setInt(2, accountNum);
		ps.setInt(3, userID);
		ps.setInt(4, userID);
		updateBalanceStatus = ps.executeUpdate();
		
		if(updateBalanceStatus == 1) {
			return TransactionStatus.SUCCESS;
		} else {
			return TransactionStatus.FAILED;
		}
	}
	
	@Override
	public TransactionStatus withdraw(int userID, int accountNum, double amount) {
		double currentBalance;
		
		try {
			currentBalance = getBankAccountBalance(userID, accountNum);
			
			if(currentBalance >= amount) {
				if(updateBalance(userID, accountNum, currentBalance - amount ) == TransactionStatus.SUCCESS) {
					log.transactionLog(TransactionType.WITHDRAW, accountNum, amount);
					return TransactionStatus.SUCCESS;
				} else {
					return TransactionStatus.FAILED;
				}
			} else if(currentBalance == -1) {
				return TransactionStatus.FAILED;
			} else {
				return TransactionStatus.NOT_ENOUGH_FUNDS;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return TransactionStatus.FAILED;
	}
	
	@Override
	public TransactionStatus deposit(int userID, int accountNum, double amount) {
		try {
			if(updateBalance(userID, accountNum, getBankAccountBalance(userID, accountNum) + amount) == TransactionStatus.SUCCESS) {
				log.transactionLog(TransactionType.DEPOSIT, accountNum, amount);
				return TransactionStatus.SUCCESS;
			} else {
				return TransactionStatus.FAILED;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return TransactionStatus.FAILED;
	}
	
	@Override
	public synchronized TransactionStatus transaction(TransactionType transaction, int userAccNum, int bankAccNum1, int bankAccNum2, double amount) throws NumberFormatException, SQLException {
		if(amount > 0) {
			TransactionStatus withdrawStatus;
			switch(transaction) {
				case DEPOSIT:
					return deposit(userAccNum, bankAccNum1, amount);
				case WITHDRAW:
					return withdraw(userAccNum, bankAccNum1, amount);
				case TRANSFER:
					withdrawStatus = withdraw(userAccNum, bankAccNum1, amount);
					if(withdrawStatus == TransactionStatus.SUCCESS) {
						if(deposit(userAccNum, bankAccNum2, amount) == TransactionStatus.SUCCESS) {
							return TransactionStatus.SUCCESS;
						} else {
							deposit(userAccNum,bankAccNum1, amount);
							return TransactionStatus.FAILED;
						}
					} else {
						return withdrawStatus;
					}
			}
			return TransactionStatus.FAILED;
		} else {
			return TransactionStatus.INVALID_AMOUNT;
		}
	}
	
	/*
	@Override
	public int login(int UserLevel, String userID, String password) throws SQLException{
		query.ps = query.dbConnection.prepareStatement("SELECT USER_ACC_NUM FROM USER_INFORMATION WHERE "
				+ "USERNAME=? AND PASSWORD=? AND USERTYPE=?");
		query.ps.setString(1, userID);
		query.ps.setString(2, password);
		query.ps.setInt(3, UserLevel);
		query.rs = query.ps.executeQuery();
		
		if(query.rs.next()) {
			return query.rs.getInt(1);
		} else {
			return 0;
		}

		/*
		System.out.println(accountInfo.getFetchSize());
		String acc = userLogin.checkLogin(userID,password);
		if(acc != null) {
			return getUserInfo(acc);
		} else return null;
		
	}
	*/
	@Override
	public UserAccountInfo getUserInfo(int userAccountNum) throws SQLException{
		PreparedStatement ps;
		ResultSet rs;
		
		ps = dbConnection.prepareStatement("SELECT * FROM USER_INFORMATION WHERE USER_ACC_NUM=?");
		ps.setInt(1, userAccountNum);
		rs = ps.executeQuery();

		
		if(rs.next()) {
			return new UserAccountInfo(rs);
		} else {
			return null;
		}
	}
	
	@Override
	public NewUser createUserID(int new_user_acc_id, String new_userID, String new_userPassword, UserAccountInfo newUserInfo, int userLevel) throws SQLException {
		CallableStatement cs;

		if(new_userID == null || new_userID.equals("")) {
			return NewUser.INVALID_USERNAME;
		} else if (new_userPassword == null || new_userPassword.equals("")) {
			return NewUser.INVALID_PASSWORD;
		} else if (newUserInfo.getFirstName() == null || newUserInfo.getFirstName().equals("")) {
			return NewUser.NO_FIRST;
		} else if(newUserInfo.getLastName() == null || newUserInfo.getLastName().equals("")) {
			return NewUser.NO_LAST;
		}
		
		cs = dbConnection.prepareCall("{call CREATE_NEW_USER_ACCOUNT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
		cs.setInt(1, new_user_acc_id);
		cs.setString(2, new_userID);
		cs.setString(3, new_userPassword);
		cs.setString(4, newUserInfo.getFirstName());
		cs.setString(5, newUserInfo.getLastName());
		cs.setString(6, newUserInfo.getEmail());
		cs.setString(7, newUserInfo.getPhone());
		cs.setDate(8, Date.valueOf(newUserInfo.getDob()));
		cs.setString(9, newUserInfo.getStreetAddress());
		cs.setString(10, newUserInfo.getState());
		cs.setString(11, newUserInfo.getZip());
		cs.setInt(12, userLevel);
		cs.registerOutParameter(13, java.sql.Types.VARCHAR);
		cs.executeQuery();
		
		switch(cs.getString(13)) {
			case "USERNAME_EXIST":
				return NewUser.EXISTING_USERNAME;
			case "INVALID_USER_ACC_NUM":
				return NewUser.INVALID_USER_ACC_NUM;
			case "SUCCESS":
				return NewUser.SUCCESS;
			default:
				return NewUser.FAILED;
		}
	}
	
	@Override
	public NewUser updatePersonalInfo(UserAccountInfo newUserInfo, int selection) throws SQLException {
		PreparedStatement ps;
		String updateText = null;
		int updatePersonalStatus = -1;
		
		if (newUserInfo.getFirstName() == null || newUserInfo.getFirstName().equals("")) {
			return NewUser.NO_FIRST;
		} else if(newUserInfo.getLastName() == null || newUserInfo.getLastName().equals("")) {
			return NewUser.NO_LAST;
		}
		if(selection >= 1 && selection <= 8) {
			switch(selection) {
			case 1:
				updateText = "FIRSTNAME=?";
				break;
			case 2:
				updateText = "LASTNAME=?";
				break;
			case 3:
				updateText = "EMAIL=?";
				break;
			case 4:
				updateText = "PHONE=?";
				break;
			case 5:
				updateText = "DOB=?";
				break;
			case 6:
				updateText = "ADDRESS=?";
				break;
			case 7:
				updateText = "STATE=?";
				break;
			case 8:
				updateText = "ZIP=?";
				break;
			}
			
			ps = dbConnection.prepareStatement("UPDATE USER_INFORMATION "
					+ "SET " + updateText
					+ " WHERE USER_ACC_NUM=?");
	
			switch(selection) {
			case 1:
				ps.setString(1, newUserInfo.getFirstName());
				break;
			case 2:
				ps.setString(1, newUserInfo.getLastName());
				break;
			case 3:
				ps.setString(1, newUserInfo.getEmail());
				break;
			case 4:
				ps.setString(1, newUserInfo.getPhone());
				break;
			case 5:
				ps.setDate(1, Date.valueOf(newUserInfo.getDob()));
				break;
			case 6:
				ps.setString(1, newUserInfo.getStreetAddress());
				break;
			case 7:
				ps.setString(1, newUserInfo.getState());
				break;
			case 8:
				ps.setString(1, newUserInfo.getZip());
				break;
			}
			ps.setInt(2, newUserInfo.getUserAccNum());
			updatePersonalStatus = ps.executeUpdate();
		}
		if(updatePersonalStatus == 1) {
			return NewUser.SUCCESS;
		} else {
			return NewUser.FAILED;
		}
	}
	
	@Override
	public NewUser updateLoginInfo(int userAccNum, String newUserName, String newPassword) throws SQLException {
		CallableStatement cs;
		
		if(newUserName == null || newUserName.equals("")) {
			return NewUser.INVALID_USERNAME;
		} else if (newPassword == null || newPassword.equals("")) {
			return NewUser.INVALID_PASSWORD;
		} else if(userAccNum <= 0 || userAccNum > 2000000000) {
			return NewUser.INVALID_USER_ACC_NUM;
		}
		
		cs = dbConnection.prepareCall("{call UPDATE_USER_LOGIN_INFO(?, ?, ?, ?)}");
		cs.setString(1, newUserName);
		cs.setString(2, newPassword);
		cs.setInt(3, userAccNum);
		cs.registerOutParameter(4, java.sql.Types.VARCHAR);
		cs.executeQuery();
		
		switch(cs.getString(4)) {
		case "SUCCESS":
			return NewUser.SUCCESS;
		case "INVALID_USER_ACC_NUM":
			return NewUser.INVALID_USER_ACC_NUM;
		case "EXISTING_USERNAME":
			return NewUser.EXISTING_USERNAME;
		default:
			return NewUser.FAILED;
		}
	}
	
	@Override
	public boolean deleteUserAccount(int userAccountNumber) throws SQLException {
		PreparedStatement ps;
		int deleteUserStatus = -1;
		
		ps = dbConnection.prepareStatement("DELETE FROM USER_INFORMATION "
				+ "WHERE USER_ACC_NUM=?");
		ps.setInt(1, userAccountNumber);

		deleteUserStatus = ps.executeUpdate();
		
		if(deleteUserStatus == 1) {
			return true;
		} else {
			return false;
		}
	}
}
