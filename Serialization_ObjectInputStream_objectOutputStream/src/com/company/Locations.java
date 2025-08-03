package com.company;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location> locations=new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
//        try (DataOutputStream locFile=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("location.dat")))){
//            for (Location location:locations.values()){
//                locFile.writeInt(location.getLocationId());
//                locFile.writeUTF(location.getDescription());
//                System.out.println("writing "+location.getLocationId()+" : "+location.getDescription());
//                System.out.println("writing "+(location.getExits().size()-1)+" exists");
//                locFile.writeInt(location.getExits().size()-1);
//                for (String direction: location.getExits().keySet()){
//                    if (!direction.equalsIgnoreCase("Q")){
//                        System.out.println("\t\t"+direction+" , "+location.getExits().get(direction));
//                        locFile.writeUTF(direction);
//                        locFile.writeInt(location.getExits().get(direction));
//                    }
//                }
//            }
//        }

        try(ObjectOutputStream locfile=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("location.dat")))) {
            for (Location location: locations.values()){
                locfile.writeObject(location);
            }
        }

    }
    static {

//        try(DataInputStream locFile=new DataInputStream(new BufferedInputStream(new FileInputStream("location.dat")))) {
//    boolean eof=false;
//    while (!eof) {
//        try {
//            Map<String, Integer> exits = new LinkedHashMap<>();
//            int locId = locFile.readInt();
//            String description = locFile.readUTF();
//            int numExit = locFile.readInt();
//            System.out.println("file read " + locId + "  : " + description);
//            System.out.println("reading " + numExit + " exists");
//            for (int i = 0; i < numExit; i++) {
//                String direction = locFile.readUTF();
//                int destination = locFile.readInt();
//                exits.put(direction, destination);
//            }
//            locations.put(locId, new Location(locId, description, exits));
//
//        } catch (EOFException e) {
//            System.out.println("file is finished ");
//            eof = true;
//        }
//    }
//    }catch (IOException io){
//    System.out.println("ioe exception, may cause due to file not present in directory");
//}

        try(ObjectInputStream locFile=new ObjectInputStream(new BufferedInputStream(new FileInputStream("location.dat")))){
            boolean eof=false;
            while (!eof){
                try {
                    Location location=(Location) locFile.readObject();
                    System.out.println("read location "+location.getLocationId()+" : "+location.getDescription());
                    System.out.println("read "+location.getExits().size()+" exits");

                    locations.put(location.getLocationId(),location);
                }catch (EOFException e){
                    System.out.println(e.getMessage());
                    eof=true;
                }
            }
        }catch (IOException io){
            System.out.println("io exception"+io.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("class  not found"+e.getMessage());
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
