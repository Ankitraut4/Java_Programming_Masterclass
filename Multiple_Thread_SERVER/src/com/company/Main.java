package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try(ServerSocket serverSocket=new ServerSocket(5500)){
            while (true){
//           Socket socket=serverSocket.accept();
//           Echoer echoer=new Echoer(socket);
//           echoer.start();
                new Echoer(serverSocket.accept()).start();//above three line in short
                System.out.println("client connected ");
            }

        }catch (IOException e){
            System.out.println("server error  "+e.getMessage());
        }



    }
}
