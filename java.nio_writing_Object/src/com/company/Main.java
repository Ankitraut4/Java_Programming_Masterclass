package com.company;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
private static Locations locations=new Locations();
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        Map<String,String> vocablury=new HashMap<String,String>();
        vocablury.put("NORTH","N");
        vocablury.put("SOUTH","S");
        vocablury.put("WEST","W");
        vocablury.put("EAST","E");



        int loc=1;
        while (true){
            System.out.println(locations.get(loc).getDescription());
            if (loc==0){
                 break;
                }
                Map<String,Integer> exits=locations.get(loc).getExits();//here locationMap.get(loc) is creating instance of class i.e new Location(ex:-0,1,2,3,4,5,"------")); and .getExist() give all information of that instance class
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
