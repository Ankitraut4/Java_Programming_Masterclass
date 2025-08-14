package com.company;

import static com.company.ThreadColor.ANSI_CYAN;

public class Myrunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_CYAN+"helo from implementing runnable method");
    }
}
