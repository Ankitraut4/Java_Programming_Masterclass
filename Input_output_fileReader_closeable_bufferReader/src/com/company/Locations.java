package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location> locations=new HashMap<>();

    public static void main(String[] args) throws IOException {
      //using try with resource for two writting two files

        try (FileWriter locFile=new FileWriter("location.txt");
        FileWriter dirFile=new FileWriter("directory.txt")){
            for (Location location: locations.values()){
                locFile.write(location.getLocationId()+","+location.getDescription()+"\n");
           for (String direction: location.getExits().keySet()){
               dirFile.write(location.getLocationId()+","+direction+","+location.getExits().get(direction)+"\n");
           }
            }

        }


    }
    static {
        Scanner scanner=null;
        try {
            scanner=new Scanner(new FileReader("locations_big.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()){
                int loc=scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String destination=scanner.nextLine();
                System.out.println("--->"+loc+" : "+destination);
                Map<String,Integer> tempMap=new HashMap<>();
                locations.put(loc,new Location(loc,destination,tempMap));

            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (scanner!=null){
                scanner.close();
            }
        }

        // Now read the exits
        try {
            scanner=new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()){
                int loc=scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String direction=scanner.next();
                scanner.skip(scanner.delimiter());
                String dest=scanner.nextLine();
                int destination=Integer.parseInt(dest);

                System.out.println(loc+" : "+direction+" : "+destination);
                Location location=locations.get(loc);
                location.addExist(direction,destination);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (scanner!=null){
                scanner.close();
            }
        }


//        Map<String,Integer> tempMap=new HashMap<>();
//        locations.put(0, new Location(0,"you are at fresh start",null));
//
//        tempMap=new HashMap<>();
//        tempMap.put("N",5);
//        tempMap.put("S",4);
//        tempMap.put("W",2);
//        tempMap.put("E",3);
//        locations.put(1,new Location(1,"you are standing at the end of the road ",tempMap));
//
//        tempMap=new HashMap<>();
//        tempMap.put("N",5);
//        locations.put(2,new Location(2,"you are at the top of a hill",tempMap));
//
//        tempMap=new HashMap<>();
//        tempMap.put("W",1);
//        locations.put(3,new Location(3,"you are inside a building , a well house ",tempMap));
//
//        tempMap=new HashMap<>();
//        tempMap.put("W",2);
//        tempMap.put("N",1);
//        locations.put(4,new Location(4,"you are in a valley beside a stream",tempMap));
//
//        tempMap=new HashMap<>();
//        tempMap.put("W",2);
//        tempMap.put("S",1);
//        locations.put(5,new Location(5,"you are in the forest",tempMap));
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
