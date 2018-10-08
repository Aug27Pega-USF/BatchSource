package com.trf.DAO;

import java.util.ArrayList;

import com.trf.beans.TRFMessage;

public interface TRFMessageDAO {
    public ArrayList<TRFMessage> getMessageById(int id);

}