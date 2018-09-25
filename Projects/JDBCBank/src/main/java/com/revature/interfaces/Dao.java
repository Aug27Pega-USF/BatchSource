package com.revature.interfaces;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface Dao<T> {
    
    @SuppressWarnings("hiding")
	public <T> T get(int id);
    
    List<T> getAll() throws SQLException;
    
    boolean checkExistence(String col, String value) throws SQLException;
         
    void create(T t) throws SQLException;
    
    void read(T t) throws SQLException;
     
    void update(T t, HashMap<String,String> params) throws SQLException;
     
    void delete(T t) throws SQLException;
    
}
