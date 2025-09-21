package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try(ServerSocket serverSocket=new ServerSocket(5000)){
            Socket socket=serverSocket.accept();
            System.out.println("client connected ");
            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter responce=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

            while (true){
               String echo=input.readLine();


               if (echo.equals("exit")){
                   break;
               }else {
                   responce.println("echo string : "+echo);
               }
            }

        }catch (IOException e){
            System.out.println("server error  "+e.getMessage());
        }



    }
}
