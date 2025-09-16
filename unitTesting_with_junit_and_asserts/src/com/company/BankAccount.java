package com.company;

public class BankAccount {
    private String firstname;
    private  String lastName;
    private double balance;

    public static final int CURRENT=1;
    public static final int SAVING=2;

    private int accountType;

    public BankAccount(String firstname, String lastName, double balance,int typeOfAccount) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType=typeOfAccount;
    }

    public double deposit(double amount,boolean branch){//here when branch is true means the transaction from branch or false for atm
        balance+=amount;
        return balance;
    }

    public double withdraw(double amount,boolean branch){
        if (amount>=1500 || !branch){
            System.out.println("Exception is thrown because amount is more than or equal  1500 or branch == false");
            throw  new IllegalArgumentException();
        }
        balance-=amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isCurrent(){
        return accountType==CURRENT;
    }
}
