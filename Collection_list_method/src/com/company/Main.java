package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	Threater threater=new Threater("oly",6,8);
	//threater.getSeats();

        //creating copy on line 14
        List<Threater.Seat> copySeat=new ArrayList<>(threater.seats);
        printCopy(copySeat);

        //reversing the list
        Collections.reverse(copySeat);
        System.out.println("printing reverse of copyseat");
        printCopy(copySeat);
        System.out.println("printing threater seat class");
        printCopy(threater.seats);

        //printing the copyseat by sorted
//        Collections.sort(copySeat);//this method is in bulid we can do same by swap method
//        printCopy(copySeat);

        //printing by any order
        Collections.shuffle(copySeat);
        printCopy(copySeat);

        //finding min and max in the list
        Threater.Seat minSeat=Collections.min(copySeat);
        Threater.Seat maxSeat=Collections.max(copySeat);
        System.out.println("min seat is = "+minSeat.getSeatNumbers());
        System.out.println("max seat is = "+maxSeat.getSeatNumbers());

        System.out.println("=============================================================================");
        //sorted list by using method
        sortList(copySeat);
        System.out.println("sorted copyseat ");
        printCopy(copySeat);

    }
    public static void printCopy(List<Threater.Seat> list){
        for (Threater.Seat seat:list){
            System.out.print(" "+seat.getSeatNumbers());
        }
        System.out.println();
        System.out.println("========================================================================================================");
    }
    public static void sortList(List<? extends Threater.Seat> list){
        for (int i=0;i<list.size()-1;i++){
            for (int j=i+1;j<list.size();j++) {
                if (list.get(i).compareTo(list.get(j))>0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
