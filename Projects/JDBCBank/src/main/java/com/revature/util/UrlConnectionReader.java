package com.revature.util;
import java.net.*;
import java.io.*;

public class UrlConnectionReader {
    public static void main(String[] args) throws Exception {
        URL oracle = new URL("../logging.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}