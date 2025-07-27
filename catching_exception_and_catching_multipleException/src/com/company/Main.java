package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {//here in main method we decide / give final decision for what to do of exception
	try {
        int result=divide();
        System.out.println(result);
    }catch (ArithmeticException | NoSuchElementException e){
       System.out.println(e.toString());//e.toString is used to display which exception is catch
        System.out.println("Unable to load ");//here we  catch the exception  and load the print statement

    }

    }

    public static int divide(){
        int x,y;
    try {//#1
       x=getInt();
       y=getInt();
       System.out.println("x is "+x+" y is "+y);
       return x/y;
    }catch (NoSuchElementException e){//#2
       throw  new NoSuchElementException(" the value should be of integer here unwanted input is used");//#3
    }catch (ArithmeticException e){//#4
       throw new ArithmeticException("you are try to divide by 0");//#5
    }//#6 here we can ignore #1 to #6 , we use this to throw exception and print some massage with exception if we deselect this #1 to #6 we would only see the
        //exception but not the masseage : like the value should be of integer here unwanted input is used  or : you are try to divide by 0 infront of exception
        //which we can  do, to simplify the code

    }
    public static int   getInt(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter the number ");
      while (true) {
          try {
              return scanner.nextInt();
          } catch (InputMismatchException e) {
              scanner.nextLine();
              System.out.println("please enter the value from 0 to 9");
          }
      }
    }
}
