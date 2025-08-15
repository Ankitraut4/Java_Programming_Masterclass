package com.company;

import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_BLUE+"hello from main thread");//here ANSI_BLUE is color use to diffrentitate between thread

        Thread anotherThread=new AnotherThread();
        anotherThread.start();


        new Thread(){
           public void run(){
               System.out.println(ANSI_GREEN+"hello from anonymous class");
           }
        }.start();

        //way 3: use runnable method
//        Thread myRunnable=new Thread(new Myrunnable());
//        myRunnable.start();


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
