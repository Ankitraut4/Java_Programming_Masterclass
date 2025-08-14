package com.company;

import static com.company.ThreadColor.ANSI_RED;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ANSI_RED+"hello from another thread");
    }
}
