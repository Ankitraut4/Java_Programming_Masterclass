package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.company.Main.EOF;

public class Main {
    public static final String EOF ="EOF";

    public static void main(String[] args) {
     List<String> buffer=new ArrayList<String>();
        ReentrantLock reentrantLock=new ReentrantLock();
        ExecutorService executorService= Executors.newFixedThreadPool(3);
     MyProducer producer=new MyProducer(buffer,ThreadColor.ANSI_GREEN,reentrantLock);
     MyConsumer consumer1=new MyConsumer(buffer,ThreadColor.ANSI_BLUE,reentrantLock);
     MyConsumer consumer2=new MyConsumer(buffer,ThreadColor.ANSI_RED,reentrantLock);


//        new Thread(producer).start();//here we use Executor service so we have to define thread in delop way
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

     //when we want to recive value back from thread we use submit method which accept callable object & return the value of object of type future
       //here our class is runnable call(Roducer and consumer )we can not use them in this senario so here we use anonymous callable class
        //to show how it works
        Future<String> future=executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_WHITE+"print for callable");
                return ThreadColor.ANSI_WHITE+"this is callable result ";
            }
        });
        try {
            System.out.println(future.get());//here we use it main method so it block the code until it is executed, if we use fixedthreadpool to more than three the
            //the code of future will excecute first //here 3 it the number of thread in pool i.e producer,consumer1,consumer2
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }catch (ExecutionException e){
            System.out.println("something wrong");
        }



    executorService.shutdown();
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
                 buffer.add(num);
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
            buffer.add("EOF");
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
        int count=0;
    while (true) {
      if (reentrantLock.tryLock()){
            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                System.out.println(color+"the count = "+count);
                count=0;
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "exiting");
                    break;
                } else {
                    System.out.println(color + "removing " + buffer.remove(0));

                }
            } finally {
                reentrantLock.unlock();
            }
        }else {
          count++;
      }

    }
    }
}
