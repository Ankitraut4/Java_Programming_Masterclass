package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {

            InetAddress address=InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();

            Scanner scanner=new Scanner(System.in);
            String echoString;


            do {
                System.out.println("enter the echo string ");
                echoString=scanner.nextLine();
                byte[] buffer=echoString.getBytes();
                DatagramPacket packet=new DatagramPacket(buffer,buffer.length,address,5000);
                socket.send(packet);

                //here we use create the byte to recive response fron server
                //but in UDP the responce is not use in real world application (we use this for demo purpose)
                byte[] buffer2=new byte[50];
                packet=new DatagramPacket(buffer2, buffer2.length);
                socket.receive(packet);
                System.out.println("Text recived "+new String(buffer2,0, packet.getLength()));





            }while (!echoString.equals("exit"));

        }catch (SocketTimeoutException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
