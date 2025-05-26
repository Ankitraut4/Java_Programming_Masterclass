package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        -Write a method called reverse() with an int array as a parameter.
//-The method should not return any value. In other words, the method is allowed to modify the array parameter.
//-In main() test the reverse() method and print the array both reversed and non-reversed.
//-To reverse the array, you have to swap the elements, so that the first element is swapped with the last element and so on.
//-For example, if the array is {1, 2, 3, 4, 5}, then the reversed array is {5, 4, 3, 2, 1}.
//Tip:
//        -Create a new console project with the name ReverseArrayChallenge

        int[] numofarray=getArray(4);
        printArray(numofarray);
        reverse(numofarray);
        System.out.println("");
        printArray(reverse(numofarray));
        }
        private static Scanner scanner=new Scanner(System.in);
    private static int[] getArray(int number ){
        System.out.println("enter #"+number+" numbers :- \r");
        int[] elements=new int[number];
        for (int i=0;i<elements.length;i++){
            elements[i]=scanner.nextInt();
        }
        return elements;
    }
    private static int[] reverse(int[] array) {
        int[] copyArray = Arrays.copyOf(array, array.length);
        int maxIndex=copyArray.length-1;
        int halfLength=copyArray.length/2;


            for (int i = 0; i < halfLength ; i++) {
                int temp = copyArray[i];
                copyArray[i]=copyArray[maxIndex-i];
                copyArray[maxIndex-i]=temp;


            }
        return copyArray;

    }
    private static void printArray(int[] num){
        for (int i=0;i<num.length;i++){
            System.out.println("number  #"+(i+1)+" is " +num[i]);
        }
    }
}
