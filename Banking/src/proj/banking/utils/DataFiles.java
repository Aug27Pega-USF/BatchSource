package proj.banking.utils;

public class DataFiles {
	private String transactionFile;
	private String userFile;
	private String userInfoFile;
	private String bankAccountFile;
	
	public DataFiles(String transactionFile, String userFile, String userInfoFile, String bankAccountFile) {
		super();
		this.transactionFile = transactionFile;
		this.userFile = userFile;
		this.userInfoFile = userInfoFile;
		this.bankAccountFile = bankAccountFile;
	}

	public String getUserInfoFile() {
		return userInfoFile;
	}
	public String getTransactionFile() {
		return transactionFile;
	}
	public String getUserFile() {
		return userFile;
	}
	public String getBankAccountFile() {
		return bankAccountFile;
	}
	
}
