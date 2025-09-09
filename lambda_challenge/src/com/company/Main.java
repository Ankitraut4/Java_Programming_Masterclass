package com.company;

public class Main {

    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                String mystring="Let split this us into an array";
                String[] parts=mystring.split(" ");
                for (String part: parts){
                    System.out.println(part);
                }
            }
        };
Thread thread=new Thread(runnable);
thread.start();

  Runnable runnable1 = () -> {
      String mystring = "Let split this us into an array";
      String[] parts = mystring.split(" ");
      for (String part : parts) {
          System.out.println(part);
      }
  };
        System.out.println("");

        Thread thread1=new Thread(runnable1);
  thread1.start();
    }
}
