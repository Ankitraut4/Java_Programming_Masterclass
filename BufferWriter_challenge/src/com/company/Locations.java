package com.company;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location> locations=new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
      //using try with resource for two writting two files

        try (BufferedWriter locFile=new BufferedWriter(new FileWriter("location.txt"));
             BufferedWriter dirFile=new BufferedWriter(new FileWriter("directory.txt"))){
            for (Location location: locations.values()){
                locFile.write(location.getLocationId()+","+location.getDescription()+"\n");
           for (String direction: location.getExits().keySet()) {
               if (!direction.equalsIgnoreCase("Q")) {
                   dirFile.write(location.getLocationId() + "," + direction + "," + location.getExits().get(direction) + "\n");
               }
           }
            }

        }


    }
    static {
        try(Scanner scanner=new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {
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
        }


        // Now read the exits
        try(Scanner scanner=new Scanner(new BufferedReader(new FileReader("directions_big.txt")))) {
            //scanner=new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
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
        } catch (IOException e){
            e.printStackTrace();
        }




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
