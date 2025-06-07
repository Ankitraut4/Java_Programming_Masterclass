package com.company;

public class Desktop implements ITelephone{

    private boolean isBepping=true;
    private int myNumber;
private boolean isRinging=true;

    public Desktop(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("desktop phone does not have power button , it is alway's on ");
    }

    @Override
    public void dial(int phoneNumber) {
        if (isBepping ) {
            System.out.println("diaLING --> "+phoneNumber);
        }
        System.out.println("");
    }

    @Override
    public void answer() {
        if (isRinging){
            System.out.println("Answering the call ");

        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (isBepping && myNumber==phoneNumber){
            System.out.println("calling the number present in directory --> "+phoneNumber);
            return true;
        }
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
