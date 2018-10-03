package com.trf.DAOImpl;

import java.util.List;

import com.trf.DAO.EmployeeDao;
import com.trf.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	static {
		try {
			Class.forName("oracle.jbdc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Employee> selectBasicInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int login(String username, String password) {
		//login process here.
		return 0;
	}

}
