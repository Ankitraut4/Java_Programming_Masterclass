package com.company;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location> locations=new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
      //using try with resource for two writting two files
//        try (BufferedWriter locFile=new BufferedWriter(new FileWriter("location.txt"));
//             BufferedWriter dirFile=new BufferedWriter(new FileWriter("directory.txt"))){
//            for (Location location: locations.values()){
//                locFile.write(location.getLocationId()+","+location.getDescription()+"\n");
//           for (String direction: location.getExits().keySet()) {
//               if (!direction.equalsIgnoreCase("Q")) {
//                   dirFile.write(location.getLocationId() + "," + direction + "," + location.getExits().get(direction) + "\n");
//               }
//           }
//            }
//
//        }


        try (DataOutputStream locFile=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("location.dat")))){
            for (Location location:locations.values()){
                locFile.writeInt(location.getLocationId());
                locFile.writeUTF(location.getDescription());
                System.out.println("writing "+location.getLocationId()+" : "+location.getDescription());
                System.out.println("writing "+(location.getExits().size()-1)+" exists");
                locFile.writeInt(location.getExits().size()-1);
                for (String direction: location.getExits().keySet()){
                    if (!direction.equalsIgnoreCase("Q")){
                        System.out.println("\t\t"+direction+" , "+location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }

    }
    static {

        //by using @1 we use locations_big.txt and direction_big to convert the data into binary data by loading / runing it in
        //loactions main to convert the file
//    // @1   //try(Scanner scanner=new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()){
//                int loc=scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String destination=scanner.nextLine();
//                System.out.println("--->"+loc+" : "+destination);
//                Map<String,Integer> tempMap=new HashMap<>();
//                locations.put(loc,new Location(loc,destination,tempMap));
//
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        // Now read the exits
//   //@1     //try(Scanner scanner=new Scanner(new BufferedReader(new FileReader("directions_big.txt")))) {
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()){
//                int loc=scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String direction=scanner.next();
//                scanner.skip(scanner.delimiter());
//                String dest=scanner.nextLine();
//                int destination=Integer.parseInt(dest);
//
//                System.out.println(loc+" : "+direction+" : "+destination);
//                Location location=locations.get(loc);
//                location.addExist(direction,destination);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }

//this read the converted location.dat(binary data) and load in main.java to run program
    try(DataInputStream locFile=new DataInputStream(new BufferedInputStream(new FileInputStream("location.dat")))) {
    boolean eof=false;
    while (!eof) {
        try {
            Map<String, Integer> exits = new LinkedHashMap<>();
            int locId = locFile.readInt();
            String description = locFile.readUTF();
            int numExit = locFile.readInt();
            System.out.println("file read " + locId + "  : " + description);
            System.out.println("reading " + numExit + " exists");
            for (int i = 0; i < numExit; i++) {
                String direction = locFile.readUTF();
                int destination = locFile.readInt();
                exits.put(direction, destination);
            }
            locations.put(locId, new Location(locId, description, exits));

        } catch (EOFException e) {
            System.out.println("file is finished ");
            eof = true;
        }
    }
    }catch (IOException io){
    System.out.println("ioe exception, may cause due to file not present in directory");
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
