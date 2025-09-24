package com.company;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try(Socket socket=new Socket("localhost",5500)) {
           // socket.setSoTimeout(5000);//this will cause socketTimeOut Exception if the socket is not excecuted in given time

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter stringToEcho = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            Scanner scanner = new Scanner(System.in);
            String s;
            String responseRead;

            do {
                System.out.println("enter string to be ecohoed: ");
                s = scanner.nextLine();
                stringToEcho.println(s);

                if (!s.equals("exit")) {
                    responseRead = bufferedReader.readLine();
                     System.out.println(responseRead);
                }


            }while (!s.equals("exit"));
//        }catch (SocketTimeoutException e){
//            System.out.println("Time-out exception");
        }catch (IOException e){
            System.out.println("server error: "+e.getMessage());

        }
    }
}
