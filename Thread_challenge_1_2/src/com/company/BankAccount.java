package com.company;

public class BankAccount {


        private  double balance;
        private String accountNumber;

        public BankAccount(String accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }
//way 1 0f synchronizing code by synchronized the method
//        public synchronized void deposit(double amount) {
//            balance += amount;
//        }
//
//        public synchronized void withdraw(double amount) {
//            balance -= amount;
//        }

    //way 2 by synchronizing code block
    public  void deposit(double amount) {
        synchronized (this) {//we synchronized current object(this) //generally we have to synchronized smallest amount of code possible
            //here this wat of synchronized the code block rather than method has smallest code so it is good practise
            balance += amount;
        }
    }

    public  void withdraw(double amount) {
        synchronized (this) {
            balance -= amount;
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

