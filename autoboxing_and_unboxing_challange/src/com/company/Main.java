package com.company;

public class Main {

    public static void main(String[] args) {
        // You job is to create a simple banking application.
        // There should be a Bank class
        // It should have an arraylist of Branches
        // Each Branch should have an arraylist of Customers
        // The Customer class should have an arraylist of Doubles (transactions)
        // Customer:
        // Name, and the ArrayList of doubles.
        // Branch:
        // Need to be able to add a new customer and initial transaction amount.
        // Also needs to add additional transactions for that customer/branch
        // Bank:
        // Add a new branch
        // Add a customer to that branch with initial transaction
        // Add a transaction for an existing customer for that branch
        // Show a list of customers for a particular branch and optionally a list
        // of their transactions
        // Demonstration autoboxing and unboxing in your code
        // Hint: Transactions
        // Add data validation.
        // e.g. check if exists, or does not exist, etc.
        // Think about where you are adding the code to perform certain actions
      Bank bank=new Bank("axis");
      bank.addBranch("akola");
      bank.addCustomer("akola","ankit",77);
      bank.addCustomer("akola","mohit",66);
      bank.addBranch("pune");
      System.out.println("");
      bank.addCustomer("pune","suresh",55);
      bank.addCustomer("pune","sangita",421);
      bank.displayList("pune",true);
      bank.displayList("akola",false);
      Bank bank1=new Bank("hDFC");
      bank1.addBranch("rahit");
      bank1.addCustomer("rahit","s.k",33);
      bank1.displayList("rahit",true);

        }
}
