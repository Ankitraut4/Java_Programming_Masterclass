package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {


        private  double balance;
        private String accountNumber;
   private Lock lock;

        public BankAccount(String accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
            this.lock=new ReentrantLock();
        }

    public  void deposit(double amount) {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    balance += amount;
                } finally {
                    lock.unlock();
                }
            }else {
                System.out.println("could not get the lock");
            }

        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public  void withdraw(double amount) {
    try {
     if (lock.tryLock(1, TimeUnit.SECONDS)) {
         try {
             balance -= amount;
         } finally {
             lock.unlock();
         }
     }else {
         System.out.println("could not get the lock");
     }

     }catch (InterruptedException e){
        System.out.println(e.getMessage());
    }
    }

    public double getBalance() {
            return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("Account Number = "+accountNumber);
    }
}

