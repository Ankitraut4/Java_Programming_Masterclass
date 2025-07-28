package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location> locations=new HashMap<>();

    public static void main(String[] args) {
        FileWriter locFile=null;
        try {
            locFile =new FileWriter("location.txt");
            for (Location location: locations.values()){
                locFile.write(location.getLocationId()+" , "+location.getDescription()+"\n");
            }
        }catch (IOException e){
            System.out.println("we are in catch");
            e.printStackTrace();
        }finally {
            System.out.println(" we are in finally block");
            try {
                if (locFile!=null){
                    System.out.println("closing file ");

                    locFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
    static {
        //for avoiding reference we create temperory map which take key and value for direction and location and put it into main map i.e locationMap
        Map<String,Integer> tempMap=new HashMap<>();
        locations.put(0, new Location(0,"you are at fresh start",null));

        tempMap=new HashMap<>();
        tempMap.put("N",5);
        tempMap.put("S",4);
        tempMap.put("W",2);
        tempMap.put("E",3);
        locations.put(1,new Location(1,"you are standing at the end of the road ",tempMap));

        tempMap=new HashMap<>();
        tempMap.put("N",5);
        locations.put(2,new Location(2,"you are at the top of a hill",tempMap));

        tempMap=new HashMap<>();
        tempMap.put("W",1);
        locations.put(3,new Location(3,"you are inside a building , a well house ",tempMap));

        tempMap=new HashMap<>();
        tempMap.put("W",2);
        tempMap.put("N",1);
        locations.put(4,new Location(4,"you are in a valley beside a stream",tempMap));

        tempMap=new HashMap<>();
        tempMap.put("W",2);
        tempMap.put("S",1);
        locations.put(5,new Location(5,"you are in the forest",tempMap));
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
