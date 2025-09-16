package com.company;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account=new BankAccount("ankit","raut",2000,BankAccount.CURRENT);
    private  static int counter=0;

    @org.junit.BeforeClass
    public static void beforeclass(){//if we want our same account instance should use by all test class we should use .BeforeClass but for each test it is right way to have fresh instance
        System.out.println("it will excecute once at starting, Count = "+counter++);
    }

    @org.junit.Before//method name is not important the key which we use after junit. is decide the behaviour of method
    public void setup(){
        account=new BankAccount("ankit","raut",2000,BankAccount.CURRENT);////so for each test case there wiil new instance of account
        System.out.println("when we use @org.unit.Before the method will excecute before each test case.. , Count = "+counter++);
    }

    @org.junit.Test
    public void deposit() {
        double a=account.deposit(400,true);
      assertEquals(2400,a,0);
    }

    @org.junit.Test
    public void withdraw_branch() {
        double amount=account.withdraw(100,true);
        assertEquals(1900,amount,0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)//this code inside the () will catch the exception thrown in withdrawmethod
     public void withdraw_Notbranch() {
        account.withdraw(100,false);

    }

    @org.junit.Test(expected = IllegalArgumentException.class)//this code inside the () will catch the exception thrown in withdrawmethod
    public void withdraw_MoreAmountthan1500() {
      double amount=  account.withdraw(1500,true);
       assertEquals(500,amount,0);
    }

    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(400,true);
        double total=account.getBalance();
        assertEquals(2400,total,0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(400,true);
        double total=account.getBalance();
        assertEquals(1600,total,0);
    }

    @org.junit.Test
    public void isChecking_true(){
        assertTrue(account.isCurrent());//or// assertEquals(true, account.isChecking());
    }

    @org.junit.After
    public void after(){//method name is not important the key which we use after junit. is decide the behaviour of method
        System.out.println("it excecute aafter each test case, Count = "+counter++);
    }

    @org.junit.AfterClass
    public static void afterClass(){//for before and after class it required static because same instance is carried out
        System.out.println(" it will excecute after every test case if excecuted only once, Count = "+counter++);
    }
}