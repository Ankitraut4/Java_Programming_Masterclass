package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountParameterizedTest {

    private  BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountParameterizedTest(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void before(){
        account=new BankAccount("ankit","raut",1000,BankAccount.CURRENT);
        System.out.println("before every test case");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions(){
        return Arrays.asList(new Object[][]{
                {200.00,true,1200},
                {325.14,true,1325.14},
                {345.5776,true,1345.5776},
                {401.156,true,1401.156}

        });
    }

    @org.junit.Test
    public void deposite(){
        account.deposit(amount,branch);
        assertEquals(expected,account.getBalance(),0.01);
    }
}
