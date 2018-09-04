package MyBank;


enum Status
{
	PENDING, ACTIVE, DENY, CLOSED;
}
public class Account {
	public String user;
	public String acc_type;
	public int acc_num;
	public int acc_balance = 0;
	
	void createAcc()
	{
		acc_num = (int)((Math.random() * 90000000)+ 10000000);
		//Status stat = Status.PENDING;
		System.out.println("Your Account number is: " + acc_num);
	}
	
	public void deposit (int money)
	{
		if (money >=0)
		acc_balance = acc_balance + money;
	}
	int withdraw(int take)
	{
		if (acc_balance != 0)
		acc_balance = acc_balance - take;
		System.out.println("Current Balance is: "+ acc_balance);

		return take;
	}
	//transfer between accounts
	int transfer(int amount)
	{
		withdraw(amount);
		deposit(amount);
		return amount;
	}
	void checkBal()
	{
		System.out.println("got this far");
		//System.out.println("Your Balance is:" + acc_balance);
	}
	void display()
	{
		System.out.println("Acount User: " + user);
		System.out.println("Account Number: " + acc_num);
		System.out.println("Account Balance: " + acc_balance);
		System.out.println("Account Type: " + acc_type);
	}
}
