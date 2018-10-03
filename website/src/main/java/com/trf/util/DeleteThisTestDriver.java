package com.trf.util;

import java.sql.SQLException;
import java.util.Date;
import oracle.sql.TIMESTAMP;

public class DeleteThisTestDriver {

	public static void main(String[] args) {
		byte[] ts= TIMESTAMP.toBytes("2011-10-02 18:48:00");
		
		try {
			System.out.println(TIMESTAMP.toTimestamp(ts));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
