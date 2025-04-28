package com.company;

public class Main {

    public static void main(String[] args) {
        // Create a new class for a bank account
        // Create fields for the account number, balance, customer name, email and phone number.
        //
        // Create getters and setters for each field
        // Create two additional methods
        // 1. To allow the customer to deposit funds (this should increment the balance field).
        // 2. To allow the customer to withdraw funds. This should deduct from the balance field,
        // but not allow the withdrawal to complete if their are insufficient funds.
        // You will want to create various code in the Main class (the one created by IntelliJ) to
        // confirm your code is working.
        // Add some System.out.println's in the two methods above as well.

        Account ankit=new Account("A12","Ankit",0.0,"an@gmail",94231);

//  here on line 18 with help of constructor we give parameter dirrectly and ther is no requirement of "set" for setting value for object
//        ankit.setNumber("1234");
//        ankit.setBalance(0.0);
//        ankit.setCustomername("ankit");
//        ankit.setEmail("an@gmail.com");
//        ankit.setPhonenumber(9423);

    //if there we do not use constructor of line 18 or not pass parameter this will execute
     // Account ankit=new Account();

        System.out.println("account number is = " +ankit.getNumber());
        System.out.println("account holder name : "+ankit.getCustomername());
        System.out.println("balance amount = "+ankit.getBalance());
        ankit.deposit(25);
        ankit.withdraw(5);

        //required data
        Account mohit=new Account("mohit","mo@",88);
        System.out.println("customer name: " +mohit.getCustomername()+" ,email : " +mohit.getEmail()+ " , customer phonenumber" + mohit.getPhonenumber());
        System.out.println("balance = "+mohit.getBalance());
    }
}
