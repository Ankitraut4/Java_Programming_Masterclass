package com.company;

import java.util.function.Function;
import java.util.function.Supplier;

public class challenge2 {
    public static void main(String[] args) {
//    public static String fuction(String source){
//        StringBuilder returnVa1=new StringBuilder();
//        for (int i=0;i<source.length();i++){
//            if (i%2==1){
//                returnVa1.append(source.charAt(i));
//            }
//        }
//        return returnVa1.toString();
//    }
        Function<String,String> function=(String source)->{
            StringBuilder returnVa1=new StringBuilder();
            for (int i=0;i<source.length();i++){
                if (i%2==1){
                    returnVa1.append(source.charAt(i));
                }
            }
            return returnVa1.toString();

        };
        //System.out.println( function.apply("1234567890"));
        System.out.println(everySecondCharacter(function,"1234567890"));


        Supplier<String> iLoveJava= () -> "i Love java";
        String supplierResult=iLoveJava.get();
        System.out.println(supplierResult);
    }
    public static String everySecondCharacter(Function<String,String> f,String source){
        return f.apply(source);
    }



}
