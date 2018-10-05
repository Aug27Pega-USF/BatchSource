package com.trf.DAOImpl;

import java.sql.Connection;

import com.trf.DAO.TRFPacketDao;
import com.trf.beans.TRFPacket;
import com.trf.util.ConnFactory;

public class TRFPacketDaoImpl implements TRFPacketDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	public <List> TRFPacket getTRFPacketsbyID(int employeeID){
		
		Connection conn = cf.getConnection();
		try {
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
}
