package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
            try(FileOutputStream binaryFile=new FileOutputStream("data.dat");
                FileChannel channel=binaryFile.getChannel()) {

                byte[] outputByte="hello world".getBytes(StandardCharsets.UTF_8);
                ByteBuffer buffer=ByteBuffer.wrap(outputByte);//here we goes not need to use flip method because wrap method rest the position to zero
               int numByte= channel.write(buffer);
                System.out.println("num byte = "+numByte);


                ByteBuffer intBuffer=ByteBuffer.allocate(Integer.BYTES);
                intBuffer.putInt(23);
                intBuffer.flip();
                numByte= channel.write(intBuffer);//channel.write(intBuffer) method go to read buffer content it will start read at
                //buffer position so we have to reset the position to zero if we  want channel.write method to start read the buffer from beginning
                //so we use flip method
                System.out.println("num byte = "+numByte);

               // ByteBuffer intbuffer=ByteBuffer.allocate(Integer.BYTES);//we use as many buffer we want but in this we want to use privious buffer for example
               intBuffer.flip();//here we required to use flip before putInt to avoid bufferoverflow as buffer is at 4bytes
                intBuffer.putInt(-125678);
                intBuffer.flip();
                numByte=channel.write(intBuffer);
                System.out.println("num byte = "+numByte);

                //RandomAcessFile using java.io
//                RandomAccessFile ra=new RandomAccessFile("data.dat","rwd");
//                byte[] r=new  byte[outputByte.length];
//                ra.read(r);
//                System.out.println(new String(r));
//                int int1= ra.readInt();
//                int int2= ra.readInt();
//                System.out.println(int1);
//                System.out.println(int2);

                //randomAcessFile using java.nio

                RandomAccessFile ra=new RandomAccessFile("data.dat","rwd");
                FileChannel channel1=ra.getChannel();
                outputByte[0]='a';//if we does not use buffer.flip the h from fellow will replace by a
                buffer.flip();
                long numofBytess= channel1.read(buffer);
                if (buffer.hasArray()){
                    System.out.println("array = "+new String(buffer.array()));
                }
                //absolte method
                intBuffer.flip();
                channel1.read(intBuffer);
                System.out.println(intBuffer.getInt(0));
                intBuffer.flip();
                channel1.read(intBuffer);
               //@2 //intBuffer.flip();//for testing of position condition
                System.out.println(intBuffer.getInt(0));
               //@2 // System.out.println(intBuffer.getInt());//for testing//the abosulte read does not change buffer position so it read second integer by using intBuffer.flip(); so using relative and abosolute read will cause the error of one position refering other using relative read

                //relative method(code @1)
                //relative method is where we does not define index and always use flip to reset location
//@1//                intBuffer.flip();
//                channel1.read(intBuffer);
//                intBuffer.flip();
//                System.out.println(intBuffer.getInt());
//                intBuffer.flip();
//                channel1.read(intBuffer);
//                intBuffer.flip();
//@1//                System.out.println(intBuffer.getInt());
                 channel1.close();
                 ra.close();



            }catch (IOException e){
                e.printStackTrace();
            }
    }
}
