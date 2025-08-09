package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

        try(FileOutputStream diFile=new FileOutputStream("data.dat");
            FileChannel channel=diFile.getChannel()) {

            ByteBuffer buffer=ByteBuffer.allocate(100);
//            byte[] outputByte="Hello World".getBytes();
//            buffer.put(outputByte);
//            buffer.putInt(20);
//            buffer.putInt(-65);
//            byte[] outputByte2="Nice".getBytes();
//            buffer.put(outPutByte2);
//            buffer.putInt(25);
//            buffer.flip();//here we use one flip because we use only one buffer so we write data in single shot hence from changing
//            //read to write we have to use only one buffer

            //another way of writting above code
            byte[] outputByte="Hello World".getBytes();
            byte[] outputByte2="Nice".getBytes();
            buffer.put(outputByte).putInt(20).putInt(-65).put(outputByte2).putInt(25);//this order is order of writing in file
            buffer.flip();


            channel.write(buffer);

            RandomAccessFile ra=new RandomAccessFile("data.dat","rwd");
            FileChannel channel1=ra.getChannel();

            ByteBuffer readBuffer=ByteBuffer.allocate(100);//here we use new buffer so that we got fresh data
            channel1.read(readBuffer);
            readBuffer.flip();
            byte[]  inPutString=new byte[outputByte.length];
            readBuffer.get(inPutString);
            System.out.println("input String = "+new String(inPutString));
            System.out.println("int 1 = "+readBuffer.getInt());
            System.out.println("int 2 = "+readBuffer.getInt());
            byte[] inPutString2=new byte[outputByte2.length];
            readBuffer.get(inPutString2);
            System.out.println("input string 2 = "+new String(inPutString2));
            System.out.println("int 3 = "+readBuffer.getInt());


        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
