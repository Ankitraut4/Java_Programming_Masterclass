package com.company;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {


//        int switchvalue=4;
//        switch (switchvalue){
//            case 1:
//                System.out.println("value is 1");
//                break;
//
//            case 2:
//                System.out.println("value is 2");
//                break;
//
//            case 3: case 4: case 5:
//                System.out.println("value is 3 Or 4 Or 5 ");
//                System.out.println("Be acurate value is " +switchvalue);
//                break;
//
//            default:
//                System.out.println("the value is nor 1,2,3,4 and 5");
//                break;
//        }


        char switchinchar = 'D';
        switch (switchinchar) {
            case 'A':
                System.out.println("value is A");
                break;

            case 'B':
            case 'C':
            case 'D':
            case 'E':
                System.out.println("value is " + switchinchar);
                break;

            default:
                System.out.println("VALUE NOT FOUND");
                break;

        }

        String month = "mARch ";
        switch (month.toLowerCase(Locale.ROOT)) {//here we use predefined named to lower case which convert value of string i.e month to lowercase

            case "january":
                System.out.println("month is jan");
                break;
            case "december":
                System.out.println("month is dec");
                break;
            case "march":
                System.out.println("month is march");
                break;
            default:
                System.out.println("iNVALID VALUE");
                break;
        }
    }
}
