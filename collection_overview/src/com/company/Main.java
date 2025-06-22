package com.company;

public class Main {

    public static void main(String[] args) {
      Threater threater=new Threater("cinn",12,5);
      threater.getSeats();
      if(threater.reserveSeat("L01")){
          System.out.println("please pay ");
      }else {
          System.out.println("sit is already exist ");
      }
        if(threater.reserveSeat("B01")){//this we apply and the output is sit is already exist because reserve it first on line 8
            System.out.println("please pay ");
        }else {
            System.out.println("sit is already exist ");
        }


    }
}
