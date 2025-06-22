package com.company;

import java.util.ArrayList;
import java.util.List;

public class Threater {
    private final String threaterName;
    private List<Seat> seats=new ArrayList<Seat>();

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
        Seat requestedSeat=null;
        for (Seat st:seats) {
            System.out.print(".");//this dot is just for purpose to check how many times it take to search the element so to reduce the time we Comparable and binary search
            if (st.getSeatNumbers().equals(setNum)) {

                requestedSeat = st;
                break;

            }
        }
        if (requestedSeat==null){
            System.out.println("there is no seat "+setNum);
        }
        return requestedSeat.reserve();
    }
    //for display of seat
    public void getSeats(){
        for (Seat s: seats){
            System.out.println(s.getSeatNumbers());
        }
    }

    private class Seat{
        private final String seatNumbers;
        private boolean reserved=false;

        public Seat(String seatNumbers) {
            this.seatNumbers = seatNumbers;
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
