package APP;

import java.sql.SQLException;
import java.util.Scanner;

public interface bankMain {
	
public abstract void newUser() throws SQLException;
public abstract void Login() throws SQLException;
public abstract void AccountInfo() throws SQLException;
}
