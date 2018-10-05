package com.trf.DAO;

import com.trf.beans.Employee;

public interface EmployeeDao {
	public Employee getEmployeebyId(int id);
	public int login(String username, String password);
}
