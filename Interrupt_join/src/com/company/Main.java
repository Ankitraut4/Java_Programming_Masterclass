package com.company;

import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_BLUE+"hello from main thread");

        Thread anotherThread=new AnotherThread();
        anotherThread.start();


        new Thread(){
           public void run(){
               System.out.println(ANSI_GREEN+"hello from anonymous class");
           }
        }.start();


        Thread myrunnable=new Thread(new Myrunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_CYAN+"helo from anonymous class implementing runnable method");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_CYAN+"runnable thread wait for another thread to complete/terminate or time out of limit(2 sec) ");
                }catch (InterruptedException e){
                    System.out.println(ANSI_CYAN+"runable thread was interrupted");
                }
            }
        });
        myrunnable.start();
       // anotherThread.interrupt();//this will interrupt the thread to throw InterruptedException


        System.out.println(ANSI_BLUE+"hello again from main thread");
    }

}
