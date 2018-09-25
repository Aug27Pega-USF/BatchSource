package proj.banking;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proj.banking.utils.Enums.*;
import proj.banking.bean.BankAccounts;
import proj.banking.bean.UserAccountInfo;
import proj.banking.log.TransactionLog;
import proj.banking.utils.Banking;
import proj.banking.utils.DataFiles;

public class BankMain implements Banking{
	static TransactionLog log;
	private static BankMain instance;
	protected DataFiles files;
	private static SqlQuery query;
	private static SqlUpdate update;
	private static SqlCall call;
	
	private class SqlQuery{
		private Connection dbConnection;
		private ResultSet rs;
		private PreparedStatement ps;
		
		public SqlQuery() {
			this.dbConnection = getConnection();
		}
		
		public void close() throws SQLException {
			rs.close();
			rs = null;
			ps.close();
			ps = null;
			dbConnection.close();
			dbConnection = null;
		}
	}
	
	private class SqlUpdate{
		private Connection dbConnection;
		private PreparedStatement ps;
		
		public SqlUpdate() {
			this.dbConnection = getConnection();
		}
		
		public void close() throws SQLException {
			ps.close();
			ps = null;
			dbConnection.close();
			dbConnection = null;
		}
	}
	
	private class SqlCall {
		private Connection dbConnection;
		private ResultSet rs;
		private CallableStatement cs;
		
		public SqlCall() {
			this.dbConnection = getConnection();
		}
		
		public void close() throws SQLException {
			rs.close();
			rs = null;
			cs.close();
			cs = null;
			dbConnection.close();
			dbConnection = null;
		}
	}
	
	protected void finalize() throws SQLException {
		query.close();
		update.close();
		call.close();
	}
	
	public static synchronized BankMain getInstance() {
		if(instance == null) {
			instance = new BankMain();
			query = instance.new SqlQuery();
			update = instance.new SqlUpdate();
			call = instance.new SqlCall();
			log = new TransactionLog();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
	
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("userName"), prop.getProperty("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/*
	public void loadBankAccounts() {
		try {
			File file = new File(files.getBankAccountFile());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String str;
			
			while((str = reader.readLine()) != null) {
				BankAccounts acc = new BankAccounts(str.split(","));
				if(acc.getWaitingApproval() == true) {
					approvalWaitingList.add(acc);
				} else {
					bankAccountList.add(acc);
				}
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	int findUserExist(int userAccNumber) throws SQLException {
		SqlQuery query = new SqlQuery();
		
		query.ps = query.dbConnection.prepareStatement("SELECT COUNT(*) FROM USER_INFORMATION WHERE USER_ACC_NUM=?");
		query.ps.setInt(1, userAccNumber);
		query.rs = query.ps.executeQuery();
		
		if(query.rs.next()) {
			return query.rs.getInt(1);
		} else {
			return 0;
		}
	}
	
	int findUserAccountType(int userAccNumber) throws SQLException {
		SqlQuery query = new SqlQuery();
		
		query.ps = query.dbConnection.prepareStatement("SELECT USERTYPE FROM USER_INFORMATION WHERE USER_ACC_NUM=?");
		query.ps.setInt(1, userAccNumber);
		query.rs = query.ps.executeQuery();
		
		if(query.rs.next()) {
			return query.rs.getInt(1);
		} else {
			return 0;
		}
	}
	*/
	@Override
	public List<UserAccountInfo> getUserList(int userLevels) throws SQLException {
		List<UserAccountInfo> tmpUserAccData = null;
		if(userLevels >= 1 && userLevels <= 3) {
			tmpUserAccData = new ArrayList<UserAccountInfo>();
			
			query.ps = query.dbConnection.prepareStatement("SELECT USER_ACC_NUM, FIRSTNAME, LASTNAME, EMAIL, PHONE, DOB, ADDRESS, STATE, ZIP " 
					+ "FROM USER_INFORMATION " 
					+ "WHERE USERTYPE<=?");
			query.ps.setInt(1, userLevels);
			query.rs =  query.ps.executeQuery();
			while(query.rs.next()) {
				tmpUserAccData.add(new UserAccountInfo(query.rs));
			}
		}
		if(tmpUserAccData != null && tmpUserAccData.size() > 0) {
			return tmpUserAccData;
		} else {
			return null;
		}
	}
	
	public List<String []> getWaitingApproval() throws SQLException {
		List<String []> tmpWaitingApprovalList = new ArrayList<String []>();

		query.ps = query.dbConnection.prepareStatement("SELECT BANK_ACC_NUM, FIRSTNAME || ' ' || LASTNAME, BALANCE " 
				+ "FROM BANK_ACCOUNTS, USER_INFORMATION "
				+ "WHERE WAITINGAPPROVAL='Y' AND PRIMARYHOLDERID=USER_ACC_NUM");
		query.rs = query.ps.executeQuery();
		
		while(query.rs.next()) {
			tmpWaitingApprovalList.add(
					new String[] { Integer.toString(query.rs.getInt(1)), query.rs.getString(2), Double.toString(query.rs.getDouble(3)) });
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
		
		call.cs = call.dbConnection.prepareCall("{call CREATE_NEW_BANK_ACCOUNT(?, ?, ?, ?, ?)}");
		call.cs.setInt(1, newAccNum);
		call.cs.setInt(2, primaryID);
		call.cs.setInt(3, jointID);
		call.cs.setDouble(4, initialDeposit);
		call.cs.registerOutParameter(5, java.sql.Types.VARCHAR);
		call.rs = call.cs.executeQuery();
		//newAccStatus = call.cs.getString(5);
		
		switch(call.cs.getString(5)) {
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
		/*boolean jointExist = false;
		int newBankAccStatus = -1;
		
		if(initialDeposit < 0) {
			return NewBankAccountStatus.INVALID_DEPOSIT;
		} else if(findUserExist(primaryID) != 1) {
			return NewBankAccountStatus.INVALID_PRIMARY;
		} else if(findUserExist(jointID) == 1) {
			jointExist = true;
		}
		
		update.ps = update.dbConnection.prepareStatement("INSERT INTO BANK_ACCOUNTS(BANK_ACC_NUM, PRIMARYHOLDERID, "
				+ "JOINTHOLDERID, BALANCE) VALUES (BANK_ACC_NUM_SEQ.NEXTVAL, ?, ?, ?)");
		update.ps.setInt(1, primaryID);
		if(jointExist) {
			update.ps.setInt(2, jointID);
		} else {
			update.ps.setNull(2, jointID);
		}
		update.ps.setDouble(3, initialDeposit);
		newBankAccStatus = update.ps.executeUpdate();
		
		if(newBankAccStatus == 1) {
			return NewBankAccountStatus.SUCCESS;
		} else {
			return NewBankAccountStatus.FAILED;
		}
		
		BankAccounts newAccount = new BankAccounts(accountHolderID, jointAccountHolderID, "", initialDeposit, true);
		approvalWaitingList.add(newAccount);
		return newAccount.getAccountNumber();
		*/
	}
	
	@Override
	public CloseStatus closeUserBankAccount(int userAccNumber, int bankAccountNumber) throws SQLException {
		int closeStatus = -1;
		
		if(getBankAccountBalance(userAccNumber, bankAccountNumber) > 0) {
			return CloseStatus.ACTIVE_FUNDS;
		}
		update.ps = update.dbConnection.prepareStatement("DELETE FROM BANK_ACCOUNTS WHERE BANK_ACC_NUM=? AND PRIMARYHOLDERID=?");
		update.ps.setInt(1, bankAccountNumber);
		update.ps.setInt(2, userAccNumber);
		closeStatus = update.ps.executeUpdate();
		
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
		List<BankAccounts> tmpAccountList = new ArrayList<BankAccounts> ();

		query.ps = query.dbConnection.prepareStatement("SELECT BANK_ACC_NUM, PRIMARYHOLDERID, JOINTHOLDERID, BALANCE FROM BANK_ACCOUNTS "
				+ "WHERE WAITINGAPPROVAL='N' AND (PRIMARYHOLDERID=? OR JOINTHOLDERID=?)");
		query.ps.setInt(1, userAccountNumber);
		query.ps.setInt(2, userAccountNumber);
		query.rs = query.ps.executeQuery();
		
		while(query.rs.next()) {
			tmpAccountList.add(new BankAccounts(query.rs));
		}

		if(tmpAccountList.size() > 0) {
			return tmpAccountList;
		} else {
			return null;
		}
		
		/*
		ArrayList<BankAccounts> accountList = new ArrayList<BankAccounts>();
		for(BankAccounts acc : bankAccountList) {
			if(userBankAccountNumber == "0" && (acc.getAccountHolderID().equals(userAccountNumber) || acc.getJointHolderID().equals(userAccountNumber))) {
				accountList.add(acc);
			}else if(acc.getAccountNumber().equals(userBankAccountNumber)){
				accountList.add(acc);
				return accountList;
			}
		}
		if(accountList.size() > 0)
			return accountList;
		return
				null;
		*/
	}
	
	@Override
	public double getBankAccountBalance(int userAccNum, int bankAccountNum) throws SQLException {
		double currentBalance = -1;
		
		query.ps = query.dbConnection.prepareStatement("SELECT BALANCE FROM BANK_ACCOUNTS "
				+ "WHERE BANK_ACC_NUM=? AND WAITINGAPPROVAL='N' AND (PRIMARYHOLDERID=? OR JOINTHOLDERID=?)");
		query.ps.setInt(1, bankAccountNum);
		query.ps.setInt(2, userAccNum);
		query.ps.setInt(3, userAccNum);
		query.rs = query.ps.executeQuery();
		
		if(query.rs.next()) {
			currentBalance =  query.rs.getDouble(1);
		}
		
		return currentBalance;
	}
	
	@Override
	public TransactionStatus updateBalance(int userID, int accountNum, double newBalance) throws SQLException {
		int updateBalanceStatus = -1;
		
		update.ps = update.dbConnection.prepareStatement("UPDATE BANK_ACCOUNTS SET BALANCE=?"
				+ "WHERE BANK_ACC_NUM=? AND WAITINGAPPROVAL='N' AND (PRIMARYHOLDERID=? OR JOINTHOLDERID=?)");
		update.ps.setDouble(1, newBalance);
		update.ps.setInt(2, accountNum);
		update.ps.setInt(3, userID);
		update.ps.setInt(4, userID);
		updateBalanceStatus = update.ps.executeUpdate();
		
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
				return updateBalance(userID, accountNum, currentBalance - amount );
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
		/*
		double newBalance = account.getAmount() - amount;
		if(newBalance >= 0) {
			account.setAmount(newBalance);
			return transactionStatus.SUCCESS;
		} else {
			return transactionStatus.NOT_ENOUGH_FUNDS;
		}
		*/
	}
	
	@Override
	public TransactionStatus deposit(int userID, int accountNum, double amount) {
		try {
			double newBalance = getBankAccountBalance(userID, accountNum) + amount;
			
			return updateBalance(userID, accountNum, newBalance);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return TransactionStatus.FAILED;
	}
	
	@Override
	public synchronized TransactionStatus transaction(TransactionType transaction, int userAccNum, int bankAccNum1, int bankAccNum2, double amount) throws NumberFormatException, SQLException {
		log.loggerLevel("This is a test");
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
		*/
	}
	
	@Override
	public UserAccountInfo getUserInfo(int userAccountNum) throws SQLException{
		query.ps = query.dbConnection.prepareStatement("SELECT * FROM USER_INFORMATION WHERE USER_ACC_NUM=?");
		query.ps.setInt(1, userAccountNum);
		query.rs = query.ps.executeQuery();

		
		if(query.rs.next()) {
			return new UserAccountInfo(query.rs);
		} else {
			return null;
		}
		/*
		BufferedReader reader = null;
		File file = new File(files.getUserInfoFile());
		String str;

		reader = new BufferedReader(new FileReader(file));
		while((str = reader.readLine()) != null) {
			if(str.startsWith(accountNumber)) {
				user = new UserAccountInfo(str.split(","));

				break;
			}
		}
		reader.close();
		
		return user;
		*/
	}
	
	@Override
	public NewUser createUserID(int new_user_acc_id, String new_userID, String new_userPassword, UserAccountInfo newUserInfo, int userLevel) throws SQLException {
		if(new_userID == null || new_userID.equals("")) {
			return NewUser.INVALID_USERNAME;
		} else if (new_userPassword == null || new_userPassword.equals("")) {
			return NewUser.INVALID_PASSWORD;
		} else if (newUserInfo.getFirstName() == null || newUserInfo.getFirstName().equals("")) {
			return NewUser.NO_FIRST;
		} else if(newUserInfo.getLastName() == null || newUserInfo.getLastName().equals("")) {
			return NewUser.NO_LAST;
		}
		
		call.cs = call.dbConnection.prepareCall("{call CREATE_NEW_USER_ACCOUNT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
		call.cs.setInt(1, new_user_acc_id);
		call.cs.setString(2, new_userID);
		call.cs.setString(3, new_userPassword);
		call.cs.setString(4, newUserInfo.getFirstName());
		call.cs.setString(5, newUserInfo.getLastName());
		call.cs.setString(6, newUserInfo.getEmail());
		call.cs.setString(7, newUserInfo.getPhone());
		call.cs.setDate(8, Date.valueOf(newUserInfo.getDob()));
		call.cs.setString(9, newUserInfo.getStreetAddress());
		call.cs.setString(10, newUserInfo.getState());
		call.cs.setString(11, newUserInfo.getZip());
		call.cs.setInt(12, userLevel);
		call.cs.registerOutParameter(13, java.sql.Types.VARCHAR);
		call.rs = call.cs.executeQuery();
		
		switch(call.cs.getString(13)) {
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
	/*
	private <T> void statementSetter(PreparedStatement ps, int parameterNum, T data) throws SQLException {
		switch(data.getClass().getName()) {
		case "java.lang.String":
			ps.setString(parameterNum, (String) data);
			break;
		case "int":
			ps.setInt(parameterNum, (int) data); 
			break;
		case "double":
			ps.setDouble(parameterNum, (double) data);
			break;
		case "java.sql.Date":
			ps.setDate(parameterNum, (Date) data);
			break;
		}
	}
	*/
	@Override
	public NewUser updatePersonalInfo(UserAccountInfo newUserInfo, int selection) throws SQLException {
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
			
			update.ps = update.dbConnection.prepareStatement("UPDATE USER_INFORMATION "
					+ "SET " + updateText
					+ " WHERE USER_ACC_NUM=?");
	
			switch(selection) {
			case 1:
				update.ps.setString(1, newUserInfo.getFirstName());
				break;
			case 2:
				update.ps.setString(1, newUserInfo.getLastName());
				break;
			case 3:
				update.ps.setString(1, newUserInfo.getEmail());
				break;
			case 4:
				update.ps.setString(1, newUserInfo.getPhone());
				break;
			case 5:
				update.ps.setDate(1, Date.valueOf(newUserInfo.getDob()));
				break;
			case 6:
				update.ps.setString(1, newUserInfo.getStreetAddress());
				break;
			case 7:
				update.ps.setString(1, newUserInfo.getState());
				break;
			case 8:
				update.ps.setString(1, newUserInfo.getZip());
				break;
			}
			update.ps.setInt(2, newUserInfo.getUserAccNum());
			updatePersonalStatus = update.ps.executeUpdate();
		}
		if(updatePersonalStatus == 1) {
			return NewUser.SUCCESS;
		} else {
			return NewUser.FAILED;
		}
	}
	
	@Override
	public NewUser updateLoginInfo(int userAccNum, String newUserName, String newPassword) throws SQLException {
		if(newUserName == null || newUserName.equals("")) {
			return NewUser.INVALID_USERNAME;
		} else if (newPassword == null || newPassword.equals("")) {
			return NewUser.INVALID_PASSWORD;
		} else if(userAccNum <= 0 || userAccNum > 2000000000) {
			return NewUser.INVALID_USER_ACC_NUM;
		}
		
		call.cs = call.dbConnection.prepareCall("{call UPDATE_USER_LOGIN_INFO(?, ?, ?, ?)}");
		call.cs.setString(1, newUserName);
		call.cs.setString(2, newPassword);
		call.cs.setInt(3, userAccNum);
		call.cs.registerOutParameter(4, java.sql.Types.VARCHAR);
		call.rs = call.cs.executeQuery();
		
		switch(call.cs.getString(4)) {
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
		int deleteUserStatus = -1;
		
		update.ps = update.dbConnection.prepareStatement("DELETE FROM USER_INFORMATION "
				+ "WHERE USER_ACC_NUM=?");
		update.ps.setInt(1, userAccountNumber);

		deleteUserStatus = update.ps.executeUpdate();
		
		if(deleteUserStatus == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	public boolean logout(UserAccountInfo user) {
		switch(user.getAccountType()) {
		case "CustomerAccount":
			
			break;
		case "EmployeeAccount":
			break;
		case "AdminAccount":
			break;
		default:
			break;
		};
		return true;
	}
	*/
}
