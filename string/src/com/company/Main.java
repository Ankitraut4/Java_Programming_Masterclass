package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String mystring ="this is my string ";
        System.out.println(" first line of my string is " +mystring);
        mystring = mystring + ",more in this line ";
        System.out.println(" first line of my string is " +mystring);
        mystring= mystring + "\u00A9 2019";
        System.out.println(" first line of my string is " +mystring);

        String mystringinnumber = "112";
        System.out.println(mystringinnumber);
        //here on line 14 the number is treated like a character/string of letter//
        mystringinnumber= mystringinnumber + "33";
        System.out.println(mystringinnumber);
        //here on line 17 when we add 112 with 33 it does not means we are adding number it means we are joining a string , the except as character//


        String newstring = "313";
        int number=50;
        newstring = newstring + number;
        System.out.println(newstring);
        //here on line 24, 50 is decclared as number by int but when we applied string to it whole is concidered as string//

        String a="1";
        System.out.println(a);
        double b= 5.56d;
        a = a+ b;
        System.out.println(a);

        String aaa = "2";
                int r = 4;
        aaa= aaa+4;
        System.out.println(aaa);






    }
}
