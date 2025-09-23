package com.company;

import java.io.*;
import java.net.Socket;

public class Echoer extends Thread{

    private Socket socket;

    public Echoer(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter output=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            while (true){
                String echo=input.readLine();
                System.out.println("input retrived : "+echo+" || From "+currentThread().getName());
                if (echo.equals("exit")){
                    break;
                }else {
//                    try {
//                        Thread.sleep(10000);
//                    }catch (InterruptedException e){
//                        System.out.println("Thread interrupted "+e.getMessage());
//                    }
                    output.println("echo string : "+echo);
                }
            }


        }catch (IOException e){
            System.out.println("Server error : "+e.getMessage());
        }finally {
           try {
               socket.close();

           }catch (IOException e){
               System.out.println("server error "+e.getMessage());
           }
        }
    }
}
