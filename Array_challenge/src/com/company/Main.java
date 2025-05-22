package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        // Create a program using arrays that sorts a list of integers in descending order.
        // Descending order is highest value to lowest.
        // In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
        // ultimately have an array with 106,81,26, 15, 5 in it.
        // Set up the program so that the numbers to sort are read in from the keyboard.
        // Implement the following methods - getIntegers, printArray, and sortIntegers
        // getIntegers returns an array of entered integers from keyboard
        // printArray prints out the contents of the array
        // and sortIntegers should sort the array and return a new array containing the sorted numbers
        // you will have to figure out how to copy the array elements from the passed array into a new
        // array and sort them and return the new sorted array.
        int[] array=getIntegers(5);
printArray(array);
        System.out.println("");
        sortIntegers(array);
        printArray(sortIntegers(array));

    }

    public static int[] getIntegers(int number){
        System.out.println("enter #"+number+" numbers :\r");
        int[] value= new int[number];
        for (int i=0;i<value.length;i++){
            value[i]=scanner.nextInt();
        }
        return value;
    }
    public static void printArray(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.println("element #"+i+" is with value : "+array[i]);
        }
    }
    public static int[] sortIntegers(int[] unsortedArray){

//        int[] sortedarray=new int[unsortedArray.length];
//
//        for (int i=0;i<sortedarray.length;i++){
//            sortedarray[i]=unsortedArray[i];//here we copy the array
//        }
        int[] sortedarray = Arrays.copyOf(unsortedArray,unsortedArray.length);//this is short cut or java in build to copy class (line 43 to 47)
        boolean flag=true;
        int temp;
        while (flag){
            //exmaple
            //element 0 = 44
            //element 1 = 77
            //element 2 = 423
           flag=false;
            for (int i=0;i<sortedarray.length-1;i++){ //for first time index = 0
                if (sortedarray[i]<sortedarray[i+1]){  //44<77
                    temp=sortedarray[i];//temp=44
                    sortedarray[i]=sortedarray[i+1];//sortedarray[i]=77
                    sortedarray[i+1]=temp;//sortedarray[i+1]=44
                   flag=true;
                }


            }


        }
        return sortedarray;
    }
}
