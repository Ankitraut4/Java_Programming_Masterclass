package com.company;

public class Main {

    public static void main(String[] args) {

        float mymaxvalueforfloat=Float.MAX_VALUE;
        float myminvalueforfloat=Float.MIN_VALUE;
        System.out.println("max value = " +mymaxvalueforfloat);
        System.out.println("min value = " +myminvalueforfloat);

        double mymaxvaluefordouble=  Double.MAX_VALUE;
        double myminvaluefordouble= Double.MIN_VALUE;
        System.out.println("max value = " +mymaxvaluefordouble);
        System.out.println("min value = " +myminvaluefordouble);

        int myintvalue  =5/3;
        float myfloatvalue=5.24f/3f;
        double mydoublevalue=5.48d/3d;
        System.out.println("***************************************************************");
        //here writting is d after a number is not required double but it is good habit to write d after  the number//

        System.out.println("int value = " +myintvalue);
        System.out.println("float value = " +myfloatvalue);
        System.out.println("double value = " +mydoublevalue);
        System.out.println("**********************************************************");

        //*****challenge convert pound to kilogram*****//
        //1 pound = 0.45359237//

        double inpound= 200d;
        double convertintokilogram = inpound *  0.45359237d;
        System.out.println("converted pound into kilogram = " +convertintokilogram);


    }
}
