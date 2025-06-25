package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	Threater threater=new Threater("oly",6,8);
	printCopy(threater.getSeats());

	ArrayList<Threater.Seat> reverse=new ArrayList<>(threater.getSeats());
	Collections.reverse(reverse);
	printCopy(reverse);

	ArrayList<Threater.Seat> priceSeat=new ArrayList<>(threater.getSeats());
	priceSeat.add(threater.new Seat("A00",55));
	priceSeat.add(threater.new Seat("B00",55));
	Collections.sort(priceSeat,Threater.Price_order);
        System.out.println("on price ");
	printCopy(priceSeat);


    }
    public static void printCopy(List<Threater.Seat> list){
        for (Threater.Seat seat:list){
            System.out.print(" "+seat.getSeatNumbers()+" --> "+seat.getPrice()+"rs");
        }
        System.out.println();
        System.out.println("========================================================================================================");
    }

}
