package Jbdc.dao;

import java.sql.SQLException;

public interface transactionsDAO {
public abstract void doWithdraw(double withdraw) throws SQLException;
public abstract void doDeposit(double deposit) throws SQLException;
}
