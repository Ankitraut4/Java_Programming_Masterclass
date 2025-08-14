package com.company;

import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_BLUE+"hello from main thread");//here ANSI_BLUE is color use to diffrentitate between thread

        //way 1(creating thread): way 1 is a regular way in which we create a class and we extend the thread and override run method
        //and then create instance of that thread class
        Thread anotherThread=new AnotherThread();
        anotherThread.start();//if you use run() method directly to run the anotherthread ,the thread will be run on currentthread(here which is main thread)

        //way 2: here we use anonymous class where we have to start the class after defining it
        new Thread(){
           public void run(){
               System.out.println(ANSI_GREEN+"hello from anonymous class");
           }
        }.start();

        //way 3: use runnable method
        Thread myRunnable=new Thread(new Myrunnable());
        myRunnable.start();

        //way 4:use anonymous to implement runnable
        Thread myrunnable=new Thread(new Myrunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_CYAN+"helo from anonymous class implementing runnable method");
            }
        });
        myrunnable.start();


        System.out.println(ANSI_BLUE+"hello again from main thread");
    }

}
