package com.revature.exceptions;

public class NotEmptyException extends Exception 
{ 
    public  NotEmptyException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
}
