package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try(Socket socket=new Socket("localhost",5000)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter stringToEcho = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            Scanner scanner = new Scanner(System.in);
            String s;
            String responseRead;

            do {
                System.out.println("enter string to be ecohoed: ");
                s = scanner.nextLine();
                stringToEcho.println(s);

                if (!s.equals("exist")) {
                    responseRead = bufferedReader.readLine();
                     System.out.println(responseRead);
                }


            }while (!s.equals("exist"));


        }catch (IOException e){
            System.out.println("server error: "+e.getMessage());
        }
    }
}
