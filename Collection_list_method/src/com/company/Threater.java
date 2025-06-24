package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

//to reduce the time we use binary search by using comparable function to implement seats

public class Threater {
    private final String threaterName;
    public List<Seat> seats=new ArrayList<Seat>();//we are making this public just for using it in main(just for this example) otherwise it should be private

    public Threater(String threaterName, int numOfRows,int seatsPerRow) {
        this.threaterName = threaterName;

        int lastRow='A'+(numOfRows-1);
        for (char row='A';row<=lastRow;row ++){
            for (int numOfSeat=1;numOfSeat<=seatsPerRow;numOfSeat++){
                Seat seat=new Seat(row+String.format("%02d",numOfSeat));
                seats.add(seat);
            }
        }

    }
    public boolean reserveSeat(String setNum){
        Seat requestedSeat=new Seat(setNum);//we create new Seat because we are using comparision
        int foundSeat= Collections.binarySearch(seats,requestedSeat,null);//we use null because we want to use internal functionality by java
       if (foundSeat>=0){
           return seats.get(foundSeat).reserve();
       }else {
           System.out.println("There is no seat "+setNum);
           return false;
       }
    }
    //for display of seat
    public void getSeats(){
        for (Seat s: seats){
            System.out.println(s.getSeatNumbers());
        }
    }

    public class Seat implements Comparable<Seat>{//Comparable<Seat> is like a interface//we are making this public just for using it in main(just for this example) otherwise it should be private
        private final String seatNumbers;
        private boolean reserved=false;

        public Seat(String seatNumbers) {
            this.seatNumbers = seatNumbers;
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
    }
}
