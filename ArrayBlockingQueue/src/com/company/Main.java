package com.company;

import java.util.Random;
import java.util.concurrent.*;

import static com.company.Main.EOF;


public class Main {
public static final String EOF="EOF";
    public static void main(String[] args) {
  ArrayBlockingQueue<String> buffer=new ArrayBlockingQueue<>(6);

        ExecutorService executorService= Executors.newFixedThreadPool(3);
   MyProducer producer=new MyProducer(buffer,ThreadColor.ANSI_YELLOW);
   MyConsumer consumer1=new MyConsumer(buffer,ThreadColor.ANSI_RED);
   MyConsumer consumer2=new MyConsumer(buffer,ThreadColor.ANSI_GREEN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future=executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_WHITE+"printing for collable class");
                return "this is collable result";
            }
        });
        try {
            System.out.println(future.get());
        }catch (InterruptedException e){
            System.out.println("thread was interrupted");
        }catch (ExecutionException e){
            System.out.println("some thing wrong");
        }



executorService.shutdown();
    }
}
class MyProducer implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }
    public void run() {
        Random random = new Random();
        String[] numbers = {"1", "2", "3", "4", "5"};

        for (String num : numbers) {
            System.out.println(color + "Adding " + num);
            try {
                buffer.put(num);
                Thread.sleep(random.nextInt(2000));

            } catch (InterruptedException e) {
                System.out.println("process way interrupted");
            }
        }
        System.out.println(color + "adding EOF and exiting ");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {
        }
    }
}
class MyConsumer implements  Runnable{
    private  ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run(){
        while (true){
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "removing EOF");
                        break;
                    } else {
                        System.out.println(color + "removing " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
