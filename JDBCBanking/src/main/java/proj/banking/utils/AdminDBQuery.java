package proj.banking.utils;

import java.util.List;

public interface AdminDBQuery {
	public abstract <T> List<T> viewUsersData(String dataType);
	public abstract <T> T createNewUserData(String dataType);
	public abstract <T> T updateUserData(String dataType);
	public abstract <T> T deleteUserData(String dataType);
}
