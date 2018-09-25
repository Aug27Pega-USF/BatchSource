package com.revature.hw;

public class Question16 {

    public static void main(String[] args) {
        if(args.length > 0)
            System.out.println("Number of characters in string input is " + args[0].length());
        else
            System.out.println("There were no command line arguments");
    }
}