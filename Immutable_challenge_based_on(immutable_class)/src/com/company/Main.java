package com.company;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
private static Map<Integer,Location> locationMap=new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        //for avoiding reference we create temperory map which take key and value for direction and location and put it into main map i.e locationMap
        Map<String,Integer> tempMap=new HashMap<>();
        locationMap.put(0, new Location(0,"you are at fresh start",null));

        tempMap=new HashMap<>();
        tempMap.put("N",5);
        tempMap.put("S",4);
        tempMap.put("W",2);
        tempMap.put("E",3);
        locationMap.put(1,new Location(1,"you are standing at the end of the road ",tempMap));

        tempMap=new HashMap<>();
        tempMap.put("N",5);
        locationMap.put(2,new Location(2,"you are at the top of a hill",tempMap));

        tempMap=new HashMap<>();
        tempMap.put("W",1);
        locationMap.put(3,new Location(3,"you are inside a building , a well house ",tempMap));

        tempMap=new HashMap<>();
        tempMap.put("W",2);
        tempMap.put("N",1);
        locationMap.put(4,new Location(4,"you are in a valley beside a stream",tempMap));

        tempMap=new HashMap<>();
        tempMap.put("W",2);
        tempMap.put("S",1);
        locationMap.put(5,new Location(5,"you are in the forest",tempMap));


//        locationMap.get(1).addExist("N",5);
//        locationMap.get(1).addExist("S",4);
//        locationMap.get(1).addExist("W",2);
//        locationMap.get(1).addExist("E",3);
//
//        locationMap.get(2).addExist("N",5);
//
//        locationMap.get(3).addExist("W",1);
//
//        locationMap.get(4).addExist("W",2);
//        locationMap.get(4).addExist("N",1);
//
//        locationMap.get(5).addExist("W",2);
//        locationMap.get(5).addExist("S",1);

        //for creating or getting output by split
        Map<String,String> vocablury=new HashMap<String,String>();
        vocablury.put("NORTH","N");
        vocablury.put("SOUTH","S");
        vocablury.put("WEST","W");
        vocablury.put("EAST","E");


        int loc=1;
        while (true){
            System.out.println(locationMap.get(loc).getDescription());

           tempMap.remove("S");//this will remove S i.e south direction so to avoid the updateing in program or make it immutable we have initiate this.exits=new HashMap<>(exits); which contain (exits); i.e all the element of map but it create copy of that so any change to that i.e tempMap.remove("S"); will not apply

             if (loc==0){
                 break;
                }
                Map<String,Integer> exits=locationMap.get(loc).getExits();//here locationMap.get(loc) is creating instance of class i.e new Location(ex:-0,1,2,3,4,5,"------")); and .getExist() give all information of that instance class
            System.out.print("Avalibale action are -> ");
            for (String exit : exits.keySet()){
                System.out.print(exit+" , ");
            }
            System.out.println("");
            String direction=scanner.nextLine().toUpperCase(Locale.ROOT);
            String[] words=direction.split(" ");
            for (String word: words){
                if (vocablury.containsKey(word)){
                    direction=vocablury.get(word);
                    break;
                }
            }
            if (exits.containsKey(direction)){
                loc=exits.get(direction);
            }else {
                System.out.println("you can not go in that direction");
            }

            }

    }
}
