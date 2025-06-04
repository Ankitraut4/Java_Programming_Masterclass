package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String nameofthebranch) {
       // Branch newrecord = findBranch(nameofthebranch);
        if (findBranch(nameofthebranch) == null) {
            this.branches.add(new Branch(nameofthebranch));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String nameofthebranch, String nameofthecustomer, double initializations) {
        Branch newrecord = findBranch(nameofthebranch);
        if (newrecord != null) {
          return newrecord.newCustomer(nameofthecustomer, initializations);
         // return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String nameofthebranch, String nameofthecustomer, double initialtransaction) {
        Branch existingrecord = findBranch(nameofthebranch);
        if (existingrecord != null) {
            return existingrecord.addCustomerTransaction(nameofthecustomer, initialtransaction);
            //return true;
        }
        return false;
    }


    private Branch findBranch(String nameoftheBranch) {
        for (int i =0; i < this.branches.size(); i++) {
            if (this.branches.get(i).getName().equals(nameoftheBranch)) {
                return this.branches.get(i);

            }
        }
        return null;
    }
//
//    public boolean listCustomers(String nameoftheBranch, boolean printtransactions) {
//        Branch branch = findBranch(nameoftheBranch);
//        if (branch != null) {
//            System.out.println("Customer details for branch " + branch.getName());
//            ArrayList<Customer> branchCustomers = branch.getCustomers();
//            for (int i = 0; i < branchCustomers.size(); i++) {
//                Customer branchCustomer = branchCustomers.get(i);
//                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
//                if (printtransactions) {
//                    System.out.println("Transactions");
//                    ArrayList<Double> transaction = branchCustomer.getTransactions();
//                    for (int j = 0; j < transaction.size(); j++) {
//                        System.out.println("[" + (j + 1) + "] Amount " + transaction.get(j));
//                    }
//                }
//            }
//            return true;
//        } else {
//            return false;
//        }
//    }
    public boolean listCustomers(String nameoftheBranch, boolean printtransactions ) {
        Branch br = findBranch(nameoftheBranch);
        if (br != null) {
            System.out.println("Customer details for branch " + br.getName());

            ArrayList<Customer> branchCustomer = br.getCustomers();
            for (int i = 0; i < branchCustomer.size(); i++) {
                Customer branchCustomers = branchCustomer.get(i);
                System.out.println("Customer: " + branchCustomers.getName() + "[" + (i + 1) + "]");
                if (printtransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomers.getTransactions();

                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
