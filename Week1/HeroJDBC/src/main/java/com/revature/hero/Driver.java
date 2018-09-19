package com.revature.hero;

import java.sql.SQLException;

import com.revature.daoimpl.PowersDAOImpl;
import com.revature.daoimpl.SuperHeroDAOImpl;

public class Driver {

	public static void main(String[] args)
	{
		SuperHeroDAOImpl shdi= new SuperHeroDAOImpl();
		PowersDAOImpl pdi= new PowersDAOImpl();
		
		try {
		//	shdi.createSuperHero("Superman");
			System.out.println(shdi.getSuperHeroList());
			pdi.createPower("Invunerable");
			System.out.println(pdi.getPowersList());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
