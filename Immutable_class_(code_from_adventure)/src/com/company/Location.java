package com.company;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationId;
    private final String description;
    private final Map<String,Integer> exits;

    public Location(int locationId, String description,Map<String,Integer> exits) {
        this.locationId = locationId;
        this.description = description;
        this.exits=new HashMap<>(exits);
        this.exits.put("Q",0);
    }
//    public void addExist(String direction,int location){//we remove this method because it provide reference to main class which is not immutable
//     exits.put(direction,location);
//    }
    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);//here we use new HashMap<>(exits); because we create new copy of exits so any changes can be done to copy only
    }
}
