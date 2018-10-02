package com.revature.util;

import com.revature.daoimpl.LoginInfoDaoImpl;
import com.revature.daoimpl.UserDaoImpl;

public class DAOFactory {
	
	public static UserDaoImpl getUserDAO() {
		return new UserDaoImpl();
	}
	public static LoginInfoDaoImpl getLoginDAO() {
		return new LoginInfoDaoImpl();
	}

}
