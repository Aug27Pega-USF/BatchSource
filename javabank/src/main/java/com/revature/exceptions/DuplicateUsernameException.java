package com.revature.exceptions;

public class DuplicateUsernameException extends Exception 
{ 
    public DuplicateUsernameException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
}
