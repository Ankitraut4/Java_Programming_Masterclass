package com.company;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Location implements Serializable {

    private final int locationId;//the  primitive type and string does not required to serialize because it is deafult serialized but object required serialization
    private final String description;
    private final Map<String,Integer> exits;//but map is object which required serialization but here we are getting data from LinkedHashMap which implements Serializable hence here yhe object is serialize

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
