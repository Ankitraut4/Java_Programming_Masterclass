package com.company;

import static com.company.ThreadColor.ANSI_RED;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ANSI_RED+"hello from another thread");

        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            System.out.println(ANSI_RED+"another thread way interupted to wake up");
            return;
        }

        System.out.println(ANSI_RED+"another thread is wake up after 3 sec");
    }
}
