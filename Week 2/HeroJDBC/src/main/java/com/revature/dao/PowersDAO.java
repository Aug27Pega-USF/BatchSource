package com.revature.dao;

import java.sql.SQLException;

public interface PowersDAO {
	public abstract void createPower(String powerName) throws SQLException;
}
