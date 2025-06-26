package com.company;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> langauge = new HashMap<>();
        if (langauge.containsKey("Java")){
            System.out.println("Java key contains");

        }else {
            System.out.println("does not contains ");
        }
        langauge.put("Java","is best to learn");
        langauge.put("Python","depends on person");
        langauge.put("C++","is basic language");
        langauge.put("Algo","contains algorithms");

        if (langauge.containsKey("Java")){
            System.out.println("Java key contains");
        }else {
            System.out.println("does not contains ");
        }
        System.out.println("=======");
        System.out.println(langauge.get("Java"));
        langauge.put("Java","Best ");
        System.out.println(langauge.get("Java"));
        System.out.println(" ");
        //System.out.println("00000000000000");

//        langauge.remove("Java");
//        System.out.println(langauge.get("Java"));
//
//        System.out.println("999999999999999999999999");
//        if (langauge.remove("C++","is dependent")){
//            System.out.println("is removed");
//        }else {
//            System.out.println("not removed");
//        }
//
//        if (langauge.remove("C++","is basic language")){
//            System.out.println("is basic language is removed");
//        }else {
//            System.out.println("not removed");
//        }
        System.out.println(langauge.replace("Algo","agorithms helps to solve pattern "));//it first print previous value and then change vale
        System.out.println(langauge.get("Algo"));

        langauge.replace("Java","use for higher learning ");
        langauge.replace("Python","depends on person","person");//another way of replacing value
        System.out.println("---------------------------------------------");
        for(String key: langauge.keySet()){
            System.out.println(key+" :  "+langauge.get(key));
        }



    }
}
