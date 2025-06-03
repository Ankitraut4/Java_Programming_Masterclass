package com.company;

import java.util.ArrayList;

public class Branches {
    private String name;

    private ArrayList<Customer> customers;

    public Branches(String name) {
        this.name = name;
        this.customers=new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addNewCustomer (String newCustomerName, double amount){
        Customer newCus=findcustomer(newCustomerName);
        if (newCus == null){
             this.customers.add(new Customer(newCustomerName,amount));
        return true;
        }
        return false;
    }

    public boolean existingCustomer(String name,double amount){
        Customer existingname=findcustomer(name);
        if (existingname!=null){
             existingname.addtransaction(amount);
             return true;
        }
        return false;
    }
    public Customer findcustomer(String name){
        for (int i=0;i<customers.size();i++){
            if (this.customers.get(i).getName().equals(name)){
                return this.customers.get(i);
            }
        }
        return null;
    }
}
