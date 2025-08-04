package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
private static Locations locations=new Locations();
    public static void main(String[] args) throws IOException {

        Scanner scanner=new Scanner(System.in);
        //for creating or getting output by split
        Map<String,String> vocablury=new HashMap<String,String>();
        vocablury.put("NORTH","N");
        vocablury.put("SOUTH","S");
        vocablury.put("WEST","W");
        vocablury.put("EAST","E");




        Location currentLocation=locations.getLocation(1);
        while (true){
            System.out.println(currentLocation.getDescription());
            if (currentLocation.getLocationId()==0){
                 break;
                }
                Map<String,Integer> exits=currentLocation.getExits();//here locationMap.get(loc) is creating instance of class i.e new Location(ex:-0,1,2,3,4,5,"------")); and .getExist() give all information of that instance class
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
                currentLocation=locations.getLocation(currentLocation.getExits().get(direction));
            }else {
                System.out.println("you can not go in that direction");
            }

            }
        locations.close();
    }
}
