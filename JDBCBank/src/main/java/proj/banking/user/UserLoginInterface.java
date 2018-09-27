package proj.banking.user;

import java.sql.SQLException;
import proj.banking.utils.Enums.NewUser;

public interface UserLoginInterface {
	abstract UserAccount checkLogin(int accountLevel, String userID, String password) throws SQLException, Exception;
	abstract NewUser registerUserLogin(String userID, String userPassword);
}
