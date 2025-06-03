package com.company;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactions;
    private String Name;

    public Customer( String name,double initialAmount) {

        this.transactions = new ArrayList<Double>();
        addtransaction(initialAmount);
        this.Name=name;
    }
    public void addtransaction(double amount){
        this.transactions.add(amount);//autoboxing
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getName() {
        return Name;
    }
}
