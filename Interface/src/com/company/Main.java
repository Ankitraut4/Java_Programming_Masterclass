package com.company;

public class Main {

    public static void main(String[] args) {
 ITelephone ankitDirectory;
 ankitDirectory=new Desktop(77);
 ankitDirectory.powerOn();
 ankitDirectory.answer();
 ankitDirectory.callPhone(77);
        System.out.println("===========================================");
 ITelephone an;
 an=new MobilePhone(24,true);
 an.powerOn();
 an.answer();
 an.callPhone(24);

    }
}
