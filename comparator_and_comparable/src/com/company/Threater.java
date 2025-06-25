package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;



public class Threater {
    private final String threaterName;
    private List<Seat> seats=new ArrayList<Seat>();

     static final  Comparator<Seat> Price_order=new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if (seat1.getPrice()<seat2.getPrice()){
                return -1;
            }else if (seat1.getPrice()>seat2.getPrice()){
                return 1;
            }else {
                return 0;
            }
        }
    };

    public Threater(String threaterName, int numOfRows,int seatsPerRow) {
        this.threaterName = threaterName;

        int lastRow='A'+(numOfRows-1);
        for (char row='A';row<=lastRow;row ++){
            for (int numOfSeat=1;numOfSeat<=seatsPerRow;numOfSeat++){

                double price=40;
                if (row>'C' && numOfSeat>2 && numOfSeat<6){
                    price=80;
                }else if (row>'E' && numOfSeat>1 && numOfSeat<7){
                    price=120;
                }
                Seat seat=new Seat(row+String.format("%02d",numOfSeat),price);
                seats.add(seat);
            }
        }

    }
    public boolean reserveSeat(String setNum,double price){
        Seat requestedSeat=new Seat(setNum,price);//we create new Seat because we are using comparision
        int foundSeat= Collections.binarySearch(seats,requestedSeat,null);//we use null because we want to use internal functionality by java
       if (foundSeat>=0){
           return seats.get(foundSeat).reserve();
       }else {
           System.out.println("There is no seat "+setNum);
           return false;
       }
    }
    //for display of seat
    public List<Seat> getSeats(){
        return seats;
    }

    public class Seat implements Comparable<Seat>{//Comparable<Seat> is like a interface
        private final String seatNumbers;
        private double price;
        private boolean reserved=false;

        public Seat(String seatNumbers, double price) {
            this.seatNumbers = seatNumbers;
            this.price=price;
        }

        @Override
        public int compareTo(Seat seat) {//after creating this interface we can create a different type of set for searching
            return this.seatNumbers.compareToIgnoreCase(seat.getSeatNumbers());//it will return >0 value if the object is greater than to which it compare to
            
        }

        public boolean reserve(){
            if (!this.reserved){
                this.reserved=true;
                System.out.println("seat "+seatNumbers+ " is reserved");
                return true;
            }else {
                return false;
            }
        }

        public String getSeatNumbers() {
            return seatNumbers;
        }

        public double getPrice() {
            return price;
        }
    }
}
