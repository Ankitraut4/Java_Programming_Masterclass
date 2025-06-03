package com.company;

import java.util.ArrayList;

public class Bank {
  private String name;
  private  ArrayList<Branches> branches;

  public Bank(String name) {
    this.name = name;
    this.branches=new ArrayList<Branches>();
  }

  public String getName() {
    return name;
  }

  public ArrayList<Branches> getBranches() {
    return branches;
  }

  public boolean addBranch(String branch){
   if (findbranch(branch)==null){
   this.branches.add(new Branches(branch));
   return true;
}
   return false;
  }

  public boolean addCustomer(String branch,String customerName,double initialAmount){
   Branches bran=findbranch(branch);
   if (bran!=null){
     bran.addNewCustomer(customerName,initialAmount);
     return true;
    }
   return false;
  }

  public boolean addTransaction(String branch,String customerName,double Amount){
    Branches br=findbranch(branch);
    if (br!=null){
      br.existingCustomer(customerName,Amount);
      return true;
    }
    return false;
  }

  private Branches findbranch(String name){
    for (int i=0;i<branches.size();i++){
      if(this.branches.get(i).getName().equals(name)){
        return this.branches.get(i);
      }
    }
    return null;
  }
  public void displayList(String branchName,boolean transation){
    Branches branchs=findbranch(branchName);
    if (branchs!=null) {
      System.out.println("Bank Name: "+getName()+"  ,the branch of the bank : " + branchs.getName());
      ArrayList<Customer> branchCustomer = branchs.getCustomers();
      for (int i = 0; i < branchCustomer.size(); i++) {
        Customer branchcustomer = branchCustomer.get(i);
        System.out.println((i + 1) + " . Customer Name : " + branchcustomer.getName());

        if (transation) {

          ArrayList<Double> transations = branchcustomer.getTransactions();
          for (int j = 0; j < transations.size(); j++) {
            System.out.println("Transation Amount --> "+transations.get(j)+" ["+(i+1)+"]");
          }
          System.out.println("");
        }
      }
    }
    return ;
  }
}
