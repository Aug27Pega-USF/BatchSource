package proj.banking;

public class BankLogin{
	/*
	private List<LoginInfo> loginList; //to be removed
	private List<UserAccountInfo> userInfoList; //to be removed
	private String loginFileLocation, userInfoFileLocation; //to be removed
	private static BankLogin instance;
	
	public BankLogin(String loginFileLocation, String userInfoFileLocation) {
		if(loginFileLocation != null && this.loginFileLocation == null && instance == null) {
			this.loginFileLocation = loginFileLocation;
			loginList = loadFileInformation(loginList, loginFileLocation, "LoginInfo");
			this.userInfoFileLocation = userInfoFileLocation;
			userInfoList = loadFileInformation(userInfoList, userInfoFileLocation, "UserAccountInfo");
		}
	}

	public static synchronized BankLogin getInstance(String userLoginFile,String userInfoFileLocation) {
		if(instance == null) {
			instance = new BankLogin(userLoginFile, userInfoFileLocation);
		}
		return instance;
	}
	
	//method to be removed
	@SuppressWarnings("unchecked")
	private <T> List<T> loadFileInformation(List<T> dataList, String fileLocation, String classType){
		List<T> newData = new ArrayList<T>();
		File file = new File(fileLocation);
		
		if(dataList == null && file.exists()) {
			String str;
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				while((str = reader.readLine()) != null) {
					if(classType.equals("LoginInfo")) {
						newData.add((T) new LoginInfo(str.split(",")));
					} else if(classType.equals("UserAccountInfo")) {
						newData.add((T) new UserAccountInfo(str.split(",")));
					}
				}
				reader.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newData;
	}
	
	//method to be removed
	@SuppressWarnings("unchecked")
	public <T> List<T> getUserPersonalInfo(int accountID, String userType) {
		if(accountID == 0 && userType.equals("0")){
			return (ArrayList<T>) userInfoList;
		} else {
			List<T> newData = new ArrayList<T>();
			for(UserAccountInfo customer : userInfoList) {
				if(customer.getUserAccNum() == accountID && customer.getAccountType().equals(userType)) {
					newData.add((T) customer);
					return newData;
				} else if(accountID == 0 && customer.getAccountType().equals(userType)) {
					newData.add((T) customer);
				}
			}
			if(newData.size() > 0) {
				return newData;
			} else {
				return null;
			}
		}
	}
	
	public newLogin createUser(String userID, String userPassword) {
		Random rand = new Random();
		int randNum;	
		String userAccountNumber = "";
		
		while(userAccountNumber.length() < 10) {
			randNum = rand.nextInt(10);
			if(userAccountNumber.length() > 0 || randNum != 0) {
				userAccountNumber += Integer.toString(randNum);
			}
		}
		
		loginList.add(new LoginInfo(userID, userPassword, userAccountNumber));
		return newLogin.SUCCESS;
	}
	
	//method to be removed
	public String checkLogin(String userID, String pass) {
		for(LoginInfo login : loginList) {
			if(login.getLoginID().equals(userID)) {
				if(login.getPassword().equals(pass)) {
					return login.getAccountNumber();
				}
				else return null;
			} else continue;
		}
		return null;
	}
	*/
}
