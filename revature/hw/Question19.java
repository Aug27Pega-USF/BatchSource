package com.revature.hw;

import java.util.ArrayList;

public class Question19 {

    private static boolean isPrime(int n){
        for(int i = 2;i<n;i++){
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        int evenSum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                evenSum += list.get(i);
            }
        }
        System.out.println("Sum of even numbers in the array list: " + evenSum);

        int oddSum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 1) {
                oddSum += list.get(i);
            }
        }
        System.out.println("Sum of odd numbers in the array list: " + oddSum);

        for (int i = 0; i < list.size(); i++) {
            if (isPrime(list.get(i))) {
                list.remove(i);
                i--;
            }
        }
        System.out.println("Array list after remove the prime numbers:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}