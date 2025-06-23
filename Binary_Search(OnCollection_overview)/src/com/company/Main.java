package com.company;

public class Main {

    public static void main(String[] args) {
	Threater threater=new Threater("oly",12,5);
	if (threater.reserveSeat("l01")){
        System.out.println("pay");
    }else {
        System.out.println("seat is already exist ");
    }
        if (threater.reserveSeat("l01")){
            System.out.println("pay");
        }else {
            System.out.println("seat is already exist ");
        }
    }
}
