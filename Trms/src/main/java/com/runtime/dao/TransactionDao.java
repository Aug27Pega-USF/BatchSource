package com.runtime.dao;

import java.sql.SQLException;
import java.util.List;

import com.runtime.bean.Transaction;


public interface TransactionDao {
	public Transaction getTransList(int userId);

}
