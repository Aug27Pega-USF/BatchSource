package com.trf.util;

import java.sql.Connection;
import java.sql.Timestamp;

import oracle.sql.TIMESTAMP;

public class DeleteThisTestDriver {
	public static ConnFactory cf = ConnFactory.getInstance();
	public static void main(String[] args) {
		
		Connection conn= cf.getConnection();
		System.out.println(conn);
		System.out.println(System.getProperty("user.dir"));
	}

}
