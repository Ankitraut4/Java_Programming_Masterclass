package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
//        -Write a method called readIntegers() with a parameter called count that represents how many integers the user needs to enter.
//-The method needs to read from the console until all the numbers are entered, and then return an array containing the numbers entered.
//-Write a method findMin() with the array as a parameter. The method needs to return the minimum value in the array.
//-In the main() method read the count from the console and call the method readIntegers() with the count parameter.
//-Then call the findMin() method passing the array returned from the call to the readIntegers() method.
//
// -Finally, print the minimum element in the array.
//Tips:
//        -Assume that the user will only enter numbers, never letters
//                -For simplicity, create a Scanner as a static field to help with data input
//        -Create a new console project with the name MinElementChallenge

        System.out.println("enter the count : ");
       int count= scanner.nextInt();
        scanner.nextLine();

        int[] array=readInteger(count);
        print(array);
        System.out.println("min number is : " +findMin(array));

    }

    public static int[] readInteger(int count){
       int[] value=new int[count];
       for (int i=0;i<value.length;i++){
        System.out.println("enter the number : " );
        value[i]=scanner.nextInt();
        scanner.nextLine();
       }
       return value;

    }

    public static void print(int[] values){
        for (int i=0;i<values.length;i++){
            System.out.println("numbers entered at index "+i+" is "+values[i]);
        }
    }

    public static int findMin(int[] arrayofnumbers){
        int min=Integer.MAX_VALUE;
        while (true){
            for (int i=0;i<arrayofnumbers.length;i++){
                if (min>arrayofnumbers[i]){
                    min=arrayofnumbers[i];
                }
            }
            return min;
        }

    }
}
