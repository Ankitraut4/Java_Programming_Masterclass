package com.company;

public class Main {
public static Object lock1=new Object();
public static Object lock2=new Object();


    public static void main(String[] args) {
      new Thread(new Thread1()).start();
      new Thread(new Thread2()).start();

    }
    public static class Thread1 extends Thread{
        public void run(){

            synchronized (lock1){
                System.out.println("thread 1 : has lock 1");
                try {
                    Thread.sleep(200);

                }catch (InterruptedException e){
                    System.out.println("interrupt");
                }
                System.out.println("THREAD 1 : IS WATING FOR LOCK 2");
           synchronized (lock2){
               System.out.println("Thread 1 : has lock 1 & 2");
           }
                System.out.println("Thread 1 : relised lock 2");
            }
            System.out.println("Thread 1 : finally relesed lock 1 and exciting");

        }
    }
//to avoid deadlock make sure that thread 1 and thread 2 will try to obtain locks in same order like lock 1 and then lock 2
    public static class Thread2  extends Thread{
        public void run(){
            synchronized (lock1){
                System.out.println("thread 2 : has lock 1");
                try {
                    Thread.sleep(200);

                }catch (InterruptedException e){
                    System.out.println("interrupt");
                }
                System.out.println("THREAD 2 : IS WATING FOR LOCK 2");
                synchronized (lock2){
                    System.out.println("Thread 2 : has lock 1 & 2");
                }
                System.out.println("Thread 2 : relised lock 2");
            }
            System.out.println("Thread 2 : finally relesed lock 1 and exciting");
            }

    }
}
