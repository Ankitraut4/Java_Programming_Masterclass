package com.company;


import java.util.concurrent.locks.ReentrantLock;
//in this worker class we want that each thread should synchrinized the class regularly not wait for one thread to finished it execution
public class Main {
public static ReentrantLock lock=new ReentrantLock(true);
    public static void main(String[] args) {
Thread t1=new Thread(new Worker(ThreadColor.ANSI_GREEN),"priority 10");
        Thread t2=new Thread(new Worker(ThreadColor.ANSI_GREEN),"priority 9");
        Thread t3=new Thread(new Worker(ThreadColor.ANSI_RED),"priority 8");
        Thread t4=new Thread(new Worker(ThreadColor.ANSI_WHITE),"priority 4");
        Thread t5=new Thread(new Worker(ThreadColor.ANSI_YELLOW),"priority 2");

        t1.setPriority(10);//setting priority is just givenig suggestion but excution may or may  not in priority order
        t2.setPriority(9);
        t3.setPriority(8);
        t4.setPriority(4);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


    }
    private static class Worker extends Thread{
        private int runCount=1;
        private String color;

        public Worker(String color) {
            this.color = color;
        }

        public void run() {

                for (int i = 0; i < 100; i++) {
                    lock.lock();
                    try {
                        System.out.println(color + Thread.currentThread().getName() + " run count = " + runCount++);
                        //excecute critical code here
                }finally {
                        lock.unlock();
                    }
            }
        }
    }
}
