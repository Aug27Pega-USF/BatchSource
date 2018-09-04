package proj.banking.user.bean;

import proj.banking.utils.Enums.*;

public class UserAccountInfo{
	private String accountType;
	private String name;
	private String dob;
	private String accountNumber;
	private String streetAddress;
	private String state;
	private int zip;
	private String email;
	private String phone;

	public UserAccountInfo(String ...args) {
		int counter = 0;
		for(String s : args) {
			switch(counter) {
			case 0:
				this.accountNumber = s;
				break;
			case 1:
				this.accountType = s;
				break;
			case 2:
				this.name = s;
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
				this.zip = Integer.parseInt(s);
				break;
			default:
				break;
			}
			counter++;
		}
	}
	
	@Override
	public String toString() {
		return "UserAccountInfo [accountType=" + accountType + ", name=" + name + ", dob=" + dob + ", accountNumber="
				+ accountNumber + ", streetAddress=" + streetAddress + ", state=" + state + ", zip=" + zip + ", email="
				+ email + ", phone=" + phone + "]";
	}
	
	public String getAccountType() {
		return this.accountType;
	}

	public String getName() {
		return this.name;
	}

	public String getDob() {
		return this.dob;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public String getState() {
		return this.state;
	}

	public int getZip() {
		return this.zip;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhone() {
		return this.phone;
	}
}
