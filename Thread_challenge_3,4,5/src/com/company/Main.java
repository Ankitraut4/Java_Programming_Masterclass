package com.company;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
//#Challenge 4 use reentrantlock , instead of using synchronized keyword ,make bankaccount class threadsafe by reentrantlock class
//#challenge 5 use tryLock with a timeout value of 1

    public static void main(String[] args) {

    final BankAccount bankAccount=new BankAccount("17878",1000);

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(150);
                bankAccount.withdraw(50);
           System.out.println("available balance after thread 1 : "+bankAccount.getBalance()+" thread name "+Thread.currentThread().getName());
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(200);
                bankAccount.withdraw(45);
              System.out.println("available balance after thread 2 : "+bankAccount.getBalance()+" thread name "+Thread.currentThread().getName());
            }
        });
        thread1.start();
        thread2.start();
        System.out.println("balance : "+bankAccount.getBalance()+" thread name "+Thread.currentThread().getName());
    }
}
