package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        try {
            DatagramSocket socket=new DatagramSocket(5000);

            while (true){
                byte[] buffer= new byte[50];
                DatagramPacket packet=new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                System.out.println("Text received is "+new String(buffer,0, packet.getLength()));

                //here we using packet we recive from from client to send back the datagram/getting responce
                //because there is no end-to-end encryption between client and server in UDP
                String returnString="Echo "+new String(buffer,0, packet.getLength());
                byte[] buffer2=returnString.getBytes();
                InetAddress address=packet.getAddress();
                int port=packet.getPort();
                packet=new DatagramPacket(buffer2, buffer2.length,address,port);
                socket.send(packet);


            }


        }catch (SocketTimeoutException e){
            System.out.println(e.getMessage());
        }catch (IOException e1){
            System.out.println(e1.getMessage());
        }

    }
}
