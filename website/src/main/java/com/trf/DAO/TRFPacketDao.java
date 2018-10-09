package com.trf.DAO;

import java.util.ArrayList;

import com.trf.beans.TRFPacket;

public interface TRFPacketDao {
    public ArrayList<TRFPacket> getTRFPacketsbyID(int employeeID);
}