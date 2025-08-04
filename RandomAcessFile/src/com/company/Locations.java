package com.company;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location> locations=new LinkedHashMap<>();
    private static Map<Integer,IndexRecord> index=new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {


//        try(ObjectOutputStream locfile=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("location.dat")))) {
//            for (Location location: locations.values()){
//                locfile.writeObject(location);
//            }
//        }

        try(RandomAccessFile rao=new RandomAccessFile("location_rand.dat","rwd")) {
            rao.writeInt(locations.size());
            int indexSize= locations.size()* 3 *Integer.BYTES;//here we calculate index size by numberOflocation * numberofinteger(in this case it is 3)* Integer_bytes //each index record three record i.e (locationID),(location offset) ,(size or length)
            int locationStart=(int) (indexSize+ rao.getFilePointer() +Integer.BYTES);//here rao.getFilePointer() is current position of location pointer and here we cast as int because filepointer is long value
            rao.writeInt(locationStart);

            long indexStart=rao.getFilePointer();

            int startPointer=locationStart;
            rao.seek(startPointer);

            for (Location location: locations.values()){
                rao.writeInt(location.getLocationId());
                rao.writeUTF(location.getDescription());
                StringBuilder builder=new StringBuilder();
                for (String direction: location.getExits().keySet()){
                    if (!direction.equalsIgnoreCase("Q")){
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }
                rao.writeUTF(builder.toString());

                IndexRecord record=new IndexRecord(startPointer,(int)(rao.getFilePointer()-startPointer) );//here (rao.getFilePointer()-startPointer) means currentpointer vlaue - startPointer value
                index.put(location.getLocationId(),record);

                startPointer=(int) (rao.getFilePointer());//here we are updating startpointer
            }
           rao.seek(indexStart);
            for (Integer locationID: index.keySet()){
                rao.writeInt(locationID);
                rao.writeInt(index.get(locationID).getStartByte());
                rao.writeInt(index.get(locationID).getLength());
            }
        }

    }

    // 1. This first four bytes will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the locations section (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long.  It will start at byte 8 and end at byte 1699
    // 4. The final section of the file will contain the location records (the data). It will start at byte 1700


    static {
//        try(ObjectInputStream locFile=new ObjectInputStream(new BufferedInputStream(new FileInputStream("location.dat")))){
//            boolean eof=false;
//            while (!eof){
//                try {
//                    Location location=(Location) locFile.readObject();
//                    System.out.println("read location "+location.getLocationId()+" : "+location.getDescription());
//                    System.out.println("read "+location.getExits().size()+" exits");
//
//                    locations.put(location.getLocationId(),location);
//                }catch (EOFException e){
//                    System.out.println(e.getMessage());
//                    eof=true;
//                }
//            }
//        }catch (IOException io){
//            System.out.println("io exception"+io.getMessage());
//        }catch (ClassNotFoundException e){
//            System.out.println("class  not found"+e.getMessage());
//        }

        try {
            ra=new RandomAccessFile("location_rand.dat","rwd");
            int numLocation=ra.readInt();
            long locationStartPoint=ra.readInt();
            while (ra.getFilePointer()< locationStartPoint){
                int locationId=ra.readInt();
                int locationStart=ra.readInt();
                int locationLength=ra.readInt();

                IndexRecord indexRecord=new IndexRecord(locationStart, locationLength);
                index.put(locationId,indexRecord);

            }
        }catch (IOException e){
            System.out.println("ioe exception"+e.getMessage());
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

    public void close() throws IOException{
        ra.close();
    }

    public Location getLocation(int locationID) throws  IOException{
        IndexRecord record=index.get(locationID);
        ra.seek(record.getStartByte());
        int id=ra.readInt();
        String description=ra.readUTF();
        String exits= ra.readUTF();

        String[] exitPart=exits.split(",");

        Location location=new Location(locationID,description,null);
        if (locationID!=0){
            for(int i=0;i<exitPart.length;i++){
                System.out.println("exitPart = "+exitPart[i]);
                System.out.println("exitPart[+1] = "+exitPart[i+1]);
                String direction=exitPart[i];
                int destination=Integer.parseInt(exitPart[++i]);

                location.addExist(direction,destination);
            }
        }
        return location;
    }
}
