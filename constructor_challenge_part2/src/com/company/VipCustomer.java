package com.company;

public class VipCustomer {

    private String name;
    private double creditlimit;
    private String email;



    public VipCustomer(){
        this("default name",0,"default@gmail");
    }

    public VipCustomer(String name,double creditlimit) {
        this(name,creditlimit,"abc@gm");

    }
    public VipCustomer(String name,double creditlimit,String email){
        this.name=name;
        this.creditlimit=creditlimit;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public double getCreditlimit() {
        return creditlimit;
    }

    public String getEmail() {
        return email;
    }
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setCreditlimit(double creditlimit) {
//        this.creditlimit = creditlimit;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
