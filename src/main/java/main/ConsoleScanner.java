package main;

import java.util.Scanner;

public class ConsoleScanner {
    private static final Scanner scan = new Scanner(System.in);

    /**
     * This method input and then return the student and teacher
     * information as a String Array with 3 length.
     * array[0] = firstName , array[1] = lastName , array[2] = id
     * This Methods Has no Parameters
     */
    public static String[] getInf() {
        String[] inf = new String[4];
        // exception for input different type error
        try {
            System.out.println("Please Enter Your First Name : ");
            inf[0] = scan.next();
            System.out.println("Please Enter Last Name : ");
            inf[1] = scan.next();
            System.out.println("Please Enter ID : ");
            inf[2] = scan.next();
            return inf;
        }
        catch (Exception e){
            System.out.println("Something Went Wrong Try Again...");
        }
        return null;

    }

    /**
     * This method input and then return the student and teacher
     * new information as a String Array with 3 length to update new inf.
     * array[0] = firstName , array[1] = lastName , array[2] = id
     * This Methods Has no Parameters
     */
    public static String[] getInfUpdate() {
        String[] inf = new String[4];
        // exception for input different type error
        try {
            System.out.println("Please Enter ID Do You Want To Update : ");
            inf[2] = scan.next();
            System.out.println("Please Enter New First Name : ");
            inf[0] = scan.next();
            System.out.println("Please Enter New Last Name : ");
            inf[1] = scan.next();
            return inf;
        }
        catch (Exception e){
            System.out.println("Something Went Wrong Try Again...");
        }
        return null;

    }


    /**
     * This method input and then return the student or teacher id
     * And This Methods Has no Parameters.
     */
    public static Integer getInfDelete() {
        // exception for input different type error
        try {
            System.out.println("Please Enter The ID You Want To Delete : ");
            return scan.nextInt();
        }
        catch (Exception e){
            System.out.println("Something Went Wrong Try Again...");
        }
        return null;
    }


    /**
     * This method input and then return the student and teacher id
     * array[0] = teacher ID , array[1] = student ID
     * And This Methods Has no Parameters.
     */
    public static Integer[] getInfSet(){
        Integer[] ids = new Integer[2];
        try {
            System.out.println("Please Enter Teacher ID : ");
            ids[0] = scan.nextInt();
            System.out.println("Please Enter Student ID : ");
            ids[1] = scan.nextInt();
            return ids;
        }
        catch (Exception e){
            System.out.println("Something Went Wrong Try Again...");
        }
        return null;
    }


    /**
     * This method input and then return the teacher id
     * And This Methods Has no Parameters.
     */
    public static Integer getShowStudentsInf(){
        // exception for input different type error
        try {
            System.out.println("Please Enter The Teacher ID To Show Students : ");
            return scan.nextInt();
        }
        catch (Exception e){
            System.out.println("Something Went Wrong Try Again...");
        }
        return null;
    }
}
