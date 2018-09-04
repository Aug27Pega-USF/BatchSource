package proj.banking.utils;

public class Enums {
	public enum transactionType {WITHDRAW, DEPOSIT, TRANSFER};
	public enum userType {CUSTOMER, EMPLOYEE, ADMIN};
	public enum transactionStatus {SUCCESS, FAILED, INVALID_ACCOUNT, INVALID_AMOUNT, NOT_ENOUGH_FUNDS};
	public enum login {SUCCESS, BAD_LOGIN};
	public enum newLogin {SUCCESS, FAILED, USERID_EXIST};
}
