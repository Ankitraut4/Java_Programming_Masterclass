package com.company;

public class Account {

    private String number;
    private String customername;
    private double balance;
    private String email;
    private int phonenumber;

    //for defining object we use constructor
    public Account(String number, String customername,double balance,String email,int phonenumber){
        this.number=number;
        this.customername=customername;
        this.balance=balance;
        this.email=email;
        this.phonenumber=phonenumber;
    }
    //here we another constructor if there is no value/parameter pass so defult value will use by mean of class overloading
    public Account(){
        this("Acount number ","customer naame ",0,"customer email" , 9400);
        System.out.println("empty constructor");
    }

    //if we want to use only customername , email , phonenumber then we have defalut other field
    public Account(String customername,String email, int phonenumber){
        this("22222",customername,1000,email,phonenumber);
        System.out.println("required data");
    }




    public void deposit(double deposit){
        this.balance +=deposit;
        System.out.println("the amount deposite = "+this.balance);
    }

    public void withdraw(double withdraw) {
        if (this.balance - withdraw < 0) {
            System.out.println("total balance = " + this.balance + " withdraw of this amount is not possible");
        } else {

            this.balance -=withdraw;
            System.out.println("the amount withdraw = " + withdraw+ " and the balance amount = " +this.balance);
        }
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
}
