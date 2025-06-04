package com.company;

import java.util.ArrayList;

public class Branch {
    private String name;
    ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers=new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public boolean newCustomer(String nameofcustomer,double initialtransaction){
      // Customer customerrecord=findCustomer(nameofcustomer);
        if (findCustomer(nameofcustomer)==null){
            this.customers.add(new Customer(nameofcustomer,initialtransaction));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String nameCustomer,double transaction){
        Customer customer=findCustomer(nameCustomer);
        if (customer!=null){
            customer.addTransactions(transaction);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String Customer){
        for (int i=0;i<this.customers.size();i++){
            Customer checkCustomer=this.customers.get(i);
            if (checkCustomer.getName().equals(Customer)){
                return checkCustomer;
            }
        }
        return null;
    }
}
