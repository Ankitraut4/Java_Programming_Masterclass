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
            boolean status=false;//we write this before doing challenge 6 , for making status variable thread safe
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    balance += amount;
                    status=true;//we write this before doing challenge 6 , for making status variable thread safe
                } finally {
                    lock.unlock();
                }
            }else {
                System.out.println("could not get the lock");
            }

        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Transaction staus = "+status);//we write this before doing challenge 6 , for making status variable thread safe
    }

    public  void withdraw(double amount) {
            boolean status=false;//we write this before doing challenge 6 , for making status variable thread safe
    try {
     if (lock.tryLock(1, TimeUnit.SECONDS)) {
         try {
             balance -= amount;
             status=true;//we write this before doing challenge 6 , for making status variable thread safe
         } finally {
             lock.unlock();
         }
     }else {
         System.out.println("could not get the lock");
     }

     }catch (InterruptedException e){
        System.out.println(e.getMessage());
    }
        System.out.println("Transaction staus = "+status);//we write this before doing challenge 6 , for making status variable thread safe

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

