package com.revature.hw;
import java.util.Scanner;

public class Question3 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input String: ");
        int len;
        String str = scanner.nextLine();
        len = str.length();
        for(int i = 0;i<len;i++){
            //appending each character in reverse order to its end
            str += str.charAt(len - i - 1);
        }
        //Getting string that we have appended
        str = str.substring(len);
        System.out.println("Reversed string: " + str);
    }
}