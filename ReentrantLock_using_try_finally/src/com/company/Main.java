package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.Main.EOF;
//using try finally to implement reentrantlock avoid commonyed statement

public class Main {
    public static final String EOF ="EOF";

    public static void main(String[] args) {
     List<String> buffer=new ArrayList<String>();
        ReentrantLock reentrantLock=new ReentrantLock();
     MyProducer producer=new MyProducer(buffer,ThreadColor.ANSI_GREEN,reentrantLock);
     MyConsumer consumer1=new MyConsumer(buffer,ThreadColor.ANSI_BLUE,reentrantLock);
     MyConsumer consumer2=new MyConsumer(buffer,ThreadColor.ANSI_RED,reentrantLock);


        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }

}
class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock reentrantLock;

    public MyProducer(List<String> buffer, String color,ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.color = color;
        this.reentrantLock=reentrantLock;
    }

    public void run(){
        Random random=new Random();
        String[] numbers={"1","2","3","4","5"};
        for (String num:numbers){
            try {
                System.out.println(color+"Adding  "+num);
                reentrantLock.lock();
            try {
                 //reentrantLock.lock();
                 buffer.add(num);
                 //reentrantLock.unlock();
                 }finally {
                   reentrantLock.unlock();
            }

                Thread.sleep(random.nextInt(1000));
            }catch (InterruptedException e){
                System.out.println("interrupted ");
            }
        }
        System.out.println(color+"adding EOF and exiting");
        reentrantLock.lock();
        try {
            //reentrantLock.lock();
            buffer.add("EOF");
            //reentrantLock.unlock();
        }finally {
            reentrantLock.unlock();
        }

    }
}
class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock reentrantLock;

    public MyConsumer(List<String> buffer, String color,ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.color = color;
        this.reentrantLock=reentrantLock;
    }
    public void run(){
    while (true) {
       reentrantLock.lock();
       try {
           if (buffer.isEmpty()) {
               //reentrantLock.unlock();
               continue;
           }
           if (buffer.get(0).equals(EOF)) {
               System.out.println(color + "exiting");
               // reentrantLock.unlock();
               break;
           } else {
               System.out.println(color + "removing " + buffer.remove(0));

           }
           // reentrantLock.unlock();
       }finally {
           reentrantLock.unlock();//we commented all the reentrantLock.unlock(); because we are using try and finally ,where in finally block is executed regardless what happen in
           //in try block hence the lock would unlock and we have unlock in only one place
           //and in critical section we are not handling some errors in catch block ocuress due to lock same object multiple time
       }


    }
    }
}
