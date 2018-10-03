package com.trf.DAO;

import java.util.List;

import com.trf.beans.Employee;

public interface EmployeeDao {
	public List<Employee> selectBasicInfoById(int id);
}
