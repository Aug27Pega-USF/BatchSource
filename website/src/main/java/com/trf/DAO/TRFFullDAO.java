package com.trf.DAO;

import java.util.ArrayList;

import com.trf.beans.TRFFull;

public interface TRFFullDAO {
    public ArrayList<TRFFull> getTRFFullbyID_BC(String Level);
    public ArrayList<TRFFull> getTRFFullbyID_DS(int employeeid);
    public ArrayList<TRFFull> getTRFFullbyID_DH(int employeeid);
}