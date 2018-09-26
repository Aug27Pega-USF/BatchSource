package proj.banking.user;

import java.sql.SQLException;
import proj.banking.utils.Enums.NewUser;

public interface UserLogin {
	abstract UserAccount checkLogin(String userID, String password, int accountLevel) throws SQLException, Exception;
	abstract NewUser registerUserLogin(String userID, String userPassword);
}
