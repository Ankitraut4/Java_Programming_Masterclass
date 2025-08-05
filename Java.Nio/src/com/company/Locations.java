package com.company;

import java.io.*;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location> locations=new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
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
//        }

        Path locPath= FileSystems.getDefault().getPath("locations_big.txt");
        Path dirPath=FileSystems.getDefault().getPath("directions_big.txt");

        try(BufferedWriter locFile= Files.newBufferedWriter(locPath);
        BufferedWriter dirFile=Files.newBufferedWriter(dirPath)) {
           for (Location location: locations.values()){
               locFile.write(location.getLocationId()+","+location.getDescription()+"\n");
               for (String direction : location.getExits().keySet()){
                  if (!direction.equalsIgnoreCase("Q")){
                      dirFile.write(location.getLocationId()+","+direction+","+location.getExits().get(direction)+"\n");
                  }
               }
           }
        }catch (IOException e){
            System.out.println("ioe "+e.getMessage());
        }



    }
    static {
//        try(Scanner scanner=new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {
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
//
//        try(Scanner scanner=new Scanner(new BufferedReader(new FileReader("directions_big.txt")))) {
//            //scanner=new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
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

        Path locPath= FileSystems.getDefault().getPath("locations_big.txt");
        Path dirPath=FileSystems.getDefault().getPath("directions_big.txt");

        try(Scanner scanner=new Scanner(Files.newBufferedReader(locPath))) {
              scanner.useDelimiter(",");
              while (scanner.hasNextLine()){
                  int locartionID=scanner.nextInt();
                  scanner.skip(scanner.delimiter());
                  String description=scanner.nextLine();
                  System.out.println("read file "+locartionID+ " : "+description);
                  locations.put(locartionID,new Location(locartionID,description,null));
              }

        } catch (IOException e){
            e.printStackTrace();
        }

        try(BufferedReader dirFile=Files.newBufferedReader(dirPath)) {
            String input;
            while ((input=dirFile.readLine())!=null){
                String[] data=input.split(",");
                int loc= Integer.parseInt(data[0]);
                String direction=data[1];
                int destination=Integer.parseInt(data[2]);
                System.out.println(loc+" : "+direction+" : "+destination);
                Location location=locations.get(loc);
                location.addExist(direction,destination);
            }
        }catch (IOException e){
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
