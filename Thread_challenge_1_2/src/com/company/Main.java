package com.company;

public class Main {

    public static void main(String[] args) {
    final BankAccount bankAccount=new BankAccount("17878",1000);

     // the bankAccount is use by two person as it is join bankaccount so use can use two threads

        //way 1 of creating two thread and using one object i.e bankaccount
//        Thread thread1=new Thread(){
//            public void run(){
//                bankAccount.deposit(150);
//                bankAccount.withdraw(50);
//                System.out.println("available balance after thread 1 : "+bankAccount.getBalance());;
//            }
//
//        };
//        Thread thread2=new Thread(){
//            public void run(){
//                bankAccount.deposit(200);
//                bankAccount.withdraw(45);
//                System.out.println("available balance after thread 2 : "+bankAccount.getBalance());
//
//
//            }
//        };
//        thread1.start();
//        thread2.start();
//        System.out.println("available balance : "+bankAccount.getBalance());


        //way 2

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
