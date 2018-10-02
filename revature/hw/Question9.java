package com.revature.hw;

import java.util.ArrayList;

class Question9 {
   static boolean primeno(int n) {
       boolean flag=false;
       for(int i=2;i<=n/2;i++) {
           if(n%i==0) {
               flag=true;
               break;
           }
       }
       if(flag==false)
           return true;
       else
           return false;
   }
   public static void main(String[] args) {
       // size of ArrayList
       int n = 100,m;
       //declaring ArrayList with initial size n
       ArrayList<Integer> arrli = new ArrayList<Integer>(n);
       // Appending the new element at the end of the list
       for (int i=1; i<=n; i++)
           arrli.add(i);
       // Printing elements
       System.out.println(arrli);     
       for(int i=0;i<arrli.size();i++) {
           m=arrli.get(i);
           if(primeno(m))
               System.out.print(m+" ");         
       }
   }
}