package Jbdc.dao;

import java.sql.SQLException;

public interface transactionsDAO {
public abstract void doWithdraw(int account_id, double amount,  String username) throws SQLException;
public abstract void doDeposit(int account_id, double amount,  String username) throws SQLException;
}
