package com.company;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Location implements Serializable {
//    Here is your challenge and the challenges to work out
//    what is wrong with the location constructor that would allow the program to compile and
//    crash at runtime so when you identify the problem modify the code to fix it
//    so I just i’ll just say that again your challenge here is to work out what is wrong with the location constructor
//    that you can see on screen line 14 that will allow the program to compile but crash on run time
//    when you identify the problem modify the code to fix it.

    //when we put exits for key 0 in locationMap to null it compile but crash at run time so fix that issue
    private final int locationId;
    private final String description;
    private final Map<String,Integer> exits;

    private long serialVersionUID=1L;

    public Location(int locationId, String description,Map<String,Integer> exits) {
        this.locationId = locationId;
        this.description = description;
        if (exits!=null) {
            this.exits = new LinkedHashMap<>(exits);
        }else {
            this.exits=new LinkedHashMap<>();//here exist is null so we pass empty map so the program did not crash
        }
        this.exits.put("Q",0);
    }
   public void addExist(String direction,int location){
     exits.put(direction,location);
    }
    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<>(exits);//here we use new HashMap<>(exits); because we create new copy of exits so any changes can be done to copy only
    }
}
