package com.company;

import com.sun.jdi.Value;

public class Main {

    public static void main(String[] args) {

        int myintegermaxvalue = Integer.MAX_VALUE;
        int myintegerminvalue = Integer.MIN_VALUE;
        System.out.println("integer max value = " +myintegermaxvalue);
        System.out.println("integer min value = " +myintegerminvalue);


        System.out.println("busted value for max value when we add 1 = " +(myintegermaxvalue + 1));
        System.out.println("busted value for min value when we sub 1 = " +(myintegerminvalue - 1));


        byte mybytemaxvalue = Byte.MAX_VALUE;
        byte mybyteminvalue = Byte.MIN_VALUE;
        System.out.println("byte max value  = " + mybytemaxvalue);
        System.out.println("byte min value = " + mybyteminvalue);

        short myshortmaxvalue = Short.MAX_VALUE;
        short myshortminvalue = Short.MIN_VALUE;
        System.out.println("Short max value  = " + myshortmaxvalue);
        System.out.println("Short min value = " + myshortminvalue);

        long mylongvalue = 100L;
        long mylongmaxvalue = Long.MAX_VALUE;
        long mylongminvalue = Long.MIN_VALUE;
        System.out.println("long max value  = " + mylongmaxvalue);
        System.out.println("long min value = " + mylongminvalue);
        //WHEN WE DECLARE LONG VALUE AFTER "=" THEN WE HAVE TO USE CAPITALE "L"//

        //here when we does not give L then it is considered as int value//
        //long lastvalue = 2147483648;//


        long a = 2147483648L;
        System.out.println("long value = " +a);


        int myanothervalue = (myintegermaxvalue/2);

        //byte myanothervalueforbyte = (mybyteminvalue/2);//
        //in line  n0 46 we require casting because deahult value consider by java is int //

        byte myanothervalueforbyte = (byte) (mybytemaxvalue/2);
        System.out.println(myanothervalueforbyte);

        short myanothervalueforshort = (short) (myshortmaxvalue/2);
        System.out.println(myanothervalueforshort);


    }
}
