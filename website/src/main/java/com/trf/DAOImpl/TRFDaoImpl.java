package com.trf.DAOImpl;

import java.sql.Connection;

import com.trf.DAO.TRFDao;
import com.trf.beans.TRF;
import com.trf.util.ConnFactory;

public class TRFDaoImpl implements TRFDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public int insertTRF(TRF t) {
		Connection conn= cf.getConnection();
		
		return 0;
	}
	
}
