package com.company;

public class MobilePhone implements ITelephone{


    private int myNumber;
    private boolean isRinging=true;
    private boolean isON;

    public MobilePhone(int myNumber,boolean isON) {
        this.myNumber = myNumber;
        this.isON=isON;

    }

    @Override
    public void powerOn() {

       if (isON)
       {System.out.println("MobilePhone is on  ");
    }else {
           System.out.println("mobilePhone is switch off ");
       }
    }


    @Override
    public void dial(int phoneNumber) {
        if (isON ) {
            System.out.println("diaLING --> "+phoneNumber);
            isON=false;
        }
        System.out.println("");
    }

    @Override
    public void answer() {
        if (isON){
            System.out.println("Answering the call ");

        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (myNumber==phoneNumber && isON){
            System.out.println("calling the number present in directory --> "+phoneNumber);
            return true;
        }else if (isON)
        System.out.println("Number does not match to directory "+phoneNumber);
        return false;
    }

    @Override
    public boolean isRinging() {
        if (isRinging){
            return true;
        }
        return false;
    }


}
