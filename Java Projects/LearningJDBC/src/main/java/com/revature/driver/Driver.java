package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.SuperHeroDAOImpl;

public class Driver {

	
	public static void main(String [] args)	 {
		SuperHeroDAOImpl shdi = new SuperHeroDAOImpl();
		
		try {
			shdi.createSuperHero("NUTMAN");
			System.out.println(shdi.getSuperHeroList());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
