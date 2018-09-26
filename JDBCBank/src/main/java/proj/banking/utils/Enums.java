package proj.banking.utils;

public class Enums {
	public enum TransactionType {WITHDRAW, DEPOSIT, TRANSFER};
	public enum UserType {CUSTOMER, EMPLOYEE, ADMIN};
	public enum TransactionStatus {SUCCESS, FAILED, INVALID_ACCOUNT, INVALID_AMOUNT, NOT_ENOUGH_FUNDS};
	public enum NewUser {SUCCESS, FAILED, EXISTING_USERNAME, INVALID_USER_ACC_NUM, INVALID_USERNAME, INVALID_PASSWORD, NO_FIRST, NO_LAST};
	public enum CloseStatus {ERROR, SUCCESS, ACTIVE_FUNDS, NOT_PRIMARY};
	public enum NewBankAccountStatus {SUCCESS, FAILED, INVALID_PRIMARY, INVALID_USER_TYPE, INVALID_DEPOSIT};
}
