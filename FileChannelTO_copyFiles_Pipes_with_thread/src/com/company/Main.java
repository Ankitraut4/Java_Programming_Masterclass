package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

        //using pipe

        try {
            Pipe pipe=Pipe.open();

            Runnable writer=new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel=pipe.sink();
                        ByteBuffer buffer=ByteBuffer.allocate(77);

                        for (int i=0;i<10;i++){
                            String currenttime="the time is "+System.currentTimeMillis();

                            buffer.put(currenttime.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining()){
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };

               Runnable reader=new Runnable() {
                   @Override
                   public void run() {

                       try {

                           Pipe.SourceChannel sourceChannel=pipe.source();
                           ByteBuffer buffer=ByteBuffer.allocate(77);

                           for (int i=0;i<10;i++) {
                            int byteRead=   sourceChannel.read(buffer);
                               byte[] timeString =new byte[byteRead];
                               buffer.flip();
                               buffer.get(timeString);
                               System.out.println("read thread = "+new String(timeString));
                           buffer.flip();
                           Thread.sleep(100);

                           }




                       }catch (Exception e){
                           e.printStackTrace();
                       }
                   }
               } ;

            new Thread(writer).start();
            new Thread(reader).start();

        }catch (IOException e){
            e.printStackTrace();
        }































//        try(FileOutputStream diFile=new FileOutputStream("data_nio.dat");
//            FileChannel channel=diFile.getChannel()) {
//
//            ByteBuffer buffer=ByteBuffer.allocate(100);
//            byte[] outputByte="Hello World".getBytes();
//            buffer.put(outputByte);
//            long pos1=outputByte.length;
//            buffer.putInt(20);
//            long pos2=pos1+Integer.BYTES;
//            buffer.putInt(-65);
//            byte[] outputByte2="Nice".getBytes();
//            buffer.put(outputByte2);
//            long pos3= pos2+Integer.BYTES +outputByte2.length;
//            buffer.putInt(25);
//            buffer.flip();
//            channel.write(buffer);
//
//
//            RandomAccessFile ra=new RandomAccessFile("data_nio.dat","rwd");
//            FileChannel channel1=ra.getChannel();
//
//            ByteBuffer readBuffer=ByteBuffer.allocate(Integer.BYTES);
//            channel1.position(pos3);
//            channel1.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int 3 =" +readBuffer.getInt());
//
//            readBuffer.flip();
//            channel1.position(pos2);
//            channel1.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int 2 ="+readBuffer.getInt());
//
//            readBuffer.flip();
//            channel1.position(pos1);
//            channel1.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int 1="+readBuffer.getInt());//here after this line it is not required to flip because it is relative read
//
//            //copyFiles using channel
//            RandomAccessFile copyRandom=new RandomAccessFile("data_nio_copy.dat","rw");
//            FileChannel copyChannel=copyRandom.getChannel();
//            channel1.position(0);
////            long numbytes=copyChannel.transferFrom(channel1,0,channel1.size());
////            System.out.println("numbyte = "+numbytes);
//            long numbytes=channel1.transferTo(0,channel1.size(),copyChannel);
//            System.out.println("numbyte = "+numbytes);
//
//
//
//
//
//
//
//
//            byte[] outPutString="Hello World".getBytes();
//            long strpos1=0;
//            long newpos1=outPutString.length;
//            long newpos2=newpos1+Integer.BYTES;
//            byte[] outPutString2="Nice".getBytes();
//            long strpos2=newpos2+Integer.BYTES;
//            long newpos3=strpos2+outPutString2.length;
//
//            ByteBuffer newBuffer=ByteBuffer.allocate(Integer.BYTES);
//            newBuffer.putInt(20);
//            newBuffer.flip();
//            channel.position(newpos1);
//            channel.write(newBuffer);
//
//            newBuffer.flip();
//            newBuffer.putInt(-65);
//            newBuffer.flip();
//            channel.position(newpos2);
//            channel.write(newBuffer);
//
//            newBuffer.flip();
//            newBuffer.putInt(25);
//            newBuffer.flip();
//            channel.position(newpos3);
//            channel.write(newBuffer);
//
//            channel.position(strpos1);
//            channel.write(ByteBuffer.wrap(outPutString));
//            channel.position(strpos2);
//            channel.write(ByteBuffer.wrap(outPutString2));
//
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }
    }
}
