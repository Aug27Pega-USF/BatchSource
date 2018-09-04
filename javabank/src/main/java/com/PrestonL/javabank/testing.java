package com.PrestonL.javabank;

import java.io.*;
import java.util.ArrayList;
 
class Emp implements Serializable {
private static final long serialversionUID =
                                 129348938L;
    private int a;
    private int b;
    private String name;
    private int age;
 
    // Default constructor
public Emp(String name, int age, int a, int b)
    {
        this.name = name;
        this.age = age;
        this.a = a;
        this.b = b;
    }

public String getName() {return name;}
public int getAge() {return age;}
public int getA() {return a;}
public int getB() {return b;}

}
 
public class testing {
public static void printdata(Emp object1)
    {
 
        System.out.println("name = " + object1.getName());
        System.out.println("age = " + object1.getAge());
        System.out.println("a = " + object1.getA());
        System.out.println("b = " + object1.getB());
    }
 
public static void main(String[] args)
    {
		ArrayList<Emp> objectList = new ArrayList<Emp>();
        Emp object = new Emp("ab", 20, 2, 1000);
        Emp object2 = new Emp("bc", 12, 133, 1020);
        objectList.add(object);
        objectList.add(object2);
        String filename = "shubham.txt";
 
        // Serialization
        try {
 
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream
                                           (filename);
            ObjectOutputStream out = new ObjectOutputStream
                                           (file);
 
            // Method for serialization of object
            out.writeObject(objectList);
 
            out.close();
            file.close();
 
            System.out.println("Object has been serialized\n"
                              + "Data before Deserialization.");
            printdata(object);
            printdata(object2);
 
        }
 
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
 
        object = null;
 
        // Deserialization
        try {
 
            // Reading the object from a file
            FileInputStream file = new FileInputStream
                                         (filename);
            ObjectInputStream in = new ObjectInputStream
                                         (file);
 
            // Method for deserialization of object
            objectList = (ArrayList<Emp>)in.readObject();
 
            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                                + "Data after Deserialization.");
            printdata(objectList.get(0));
            printdata(objectList.get(1));
            // System.out.println("z = " + object1.z);
        }
 
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
 
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                                " is caught");
        }
    }
}
