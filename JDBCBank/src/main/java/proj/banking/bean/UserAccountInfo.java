package proj.banking.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountInfo{
	//private String accountType; //to be removed
	private String firstName, lastName;
	private String dob;
	private int userAccNum; //to be changed to int
	private String streetAddress;
	private String state;
	private String zip;
	private String email;
	private String phone;
	
	public UserAccountInfo(ResultSet userInfo) throws SQLException{
		int colCount = userInfo.getMetaData().getColumnCount();
		for(int i = 1; i <= colCount; i++) {
			switch(i) {
			case 1:
				this.userAccNum = userInfo.getInt(i);
				break;
			case 2:
				this.firstName = userInfo.getString(i);
				break;
			case 3:
				this.lastName = userInfo.getString(i);
				break;
			case 4:
				this.email = userInfo.getString(i);
				break;
			case 5:
				this.phone = userInfo.getString(i);
				break;
			case 6:
				this.dob = userInfo.getDate(i).toString();
				break;
			case 7:
				this.streetAddress = userInfo.getString(i);
				break;
			case 8:
				this.state = userInfo.getString(i);
				break;
			case 9:
				this.zip = userInfo.getString(i);
				break;
			}
		}
	}
	//constructor to be removed
	public UserAccountInfo(String ...args) {
		int counter = 0;
		for(String s : args) {
			switch(counter) {
			case 0:
				this.userAccNum = Integer.parseInt(s);
				break;
			case 1:
				this.firstName = s;
				break;
			case 2:
				this.lastName = s;
				break;
			case 3:
				this.email = s;
				break;
			case 4:
				this.phone = s;
				break;
			case 5:
				this.dob = s;
				break;
			case 6:
				this.streetAddress = s;
				break;
			case 7:
				this.state = s;
				break;
			case 8:
				this.zip = s;
				break;
			}
			counter++;
		}
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getDob() {
		return this.dob;
	}

	public int getUserAccNum() {
		return this.userAccNum;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public String getState() {
		return this.state;
	}

	public String getZip() {
		return this.zip;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhone() {
		return this.phone;
	}
	
	@Override
	public String toString() {
		return "UserAccountInfo [firstName=" + firstName + ", lastName=" + lastName + ", dob=" 
				+ dob + ", user account #=" + userAccNum + ", streetAddress=" + streetAddress + ", state=" + state + ", zip=" 
				+ zip + ", email=" + email + ", phone=" + phone + "]";
	}
}
