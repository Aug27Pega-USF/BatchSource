package proj.banking.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import proj.banking.BankMain;
import proj.banking.bean.UserAccountInfo;
import proj.banking.utils.Banking;
import proj.banking.utils.DB_ConnectionFactory;
import proj.banking.utils.Enums.NewUser;

public class Login implements UserLoginInterface{
	Banking bankService;
	Connection dbConnection;
	
	@Override
	public UserAccount checkLogin(int accountLevel, String userID, String password) throws SQLException, Exception{
		if(accountLevel >= 1 && accountLevel <= 3) {
			Connection newConnection = DB_ConnectionFactory.getConnection();
			ResultSet rs;
			PreparedStatement ps = newConnection.prepareStatement("SELECT USER_ACC_NUM FROM USER_INFORMATION WHERE "
					+ "USERNAME=? AND PASSWORD=? AND USERTYPE=?");
			ps.setString(1, userID);
			ps.setString(2, password);
			ps.setInt(3, accountLevel);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dbConnection = newConnection;
				bankService = BankMain.getInstance();
				switch(accountLevel) {
				case 1:
					return new CustomerAccount(dbConnection, bankService, bankService.getUserInfo(rs.getInt(1)));
				case 2:
					return new EmployeeAccount(dbConnection, bankService, bankService.getUserInfo(rs.getInt(1)));
				case 3:
					return new AdminAccount(dbConnection, bankService, bankService.getUserInfo(rs.getInt(1)));
				}
			}
		}
		return null;
	}
	@Override
	public NewUser registerUserLogin(String userID, String userPassword){
		return registerUserLogin(userID, userPassword, 1);
	}
	
	NewUser registerUserLogin(String userID, String userPassword, int userLevel){
		UserAccountInfo newUser = new UserAccountInfo();
		setNewUserInfo(newUser, 1);
		setNewUserInfo(newUser, 2);
		setNewUserInfo(newUser, 3);
		setNewUserInfo(newUser, 4);
		setNewUserInfo(newUser, 5);
		setNewUserInfo(newUser, 6);
		setNewUserInfo(newUser, 7);
		setNewUserInfo(newUser, 8);
		
		try {
			return BankMain.getInstance().createUserID(0, userID, userPassword, newUser, userLevel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NewUser.FAILED;
	}
	
	void setNewUserInfo(UserAccountInfo userInfo, int selection) {
		Scanner scan = new Scanner(System.in);
		switch(selection) {
		case 1:
			System.out.print("Enter your first name: ");
			userInfo.setFirstName(scan.nextLine());
			break;
		case 2:
			System.out.print("Enter your last name: ");
			userInfo.setLastName(scan.nextLine());
			break;
		case 3:
			System.out.print("Enter your e-mail address: ");
			userInfo.setEmail(scan.nextLine());
			break;
		case 4:
			System.out.print("Enter your date of birth (YYYY-MM-DD): ");
			userInfo.setDob(scan.nextLine());
			break;
		case 5:
			System.out.print("Enter your phone number: ");
			userInfo.setPhone(scan.nextLine());
			break;
		case 6:
			System.out.print("Enter your street address: ");
			userInfo.setStreetAddress(scan.nextLine());
			break;
		case 7:
			System.out.print("Enter the State for the address: ");
			userInfo.setState(scan.nextLine());
			break;
		case 8:
			System.out.print("Enter the zip code for your address: ");
			userInfo.setZip(scan.nextLine());
			break;
		}
	}
}
