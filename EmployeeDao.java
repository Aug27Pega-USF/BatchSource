package com.revature.dao;

import java.awt.List;
import java.sql.SQLException;

public interface EmployeeDao {

	public abstract void createEmployee() throws SQLException;
	public abstract List<AReimbursement> getAReimbursementList() throws SQLException;
	public abstract void getLoginList(AccountLogin y) throws SQLException;
	public abstract List<GradingScale> getGradingScaleList() throws SQLException;
	public abstract void createGrades() throws SQLException;
}
