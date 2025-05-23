package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        int[] array=getInteger(3);
	printInt(array);
	sortIntegers(array);
	printInt(sortIntegers(array));
    }

    public static int[] getInteger(int number){
        int[] value= new int[number];
        System.out.println("enter "+number+" numbers : ");
        for (int i=0;i<value.length;i++){
            value[i]=scanner.nextInt();
        }
        return value;
    }

    public static void printInt(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.println("element #1 "+i+" value , : "+a[i]);
        }
    }

    public static int[] sortIntegers(int[] unsorted){
        int[] sorted=new int[unsorted.length];
        for (int i=0;i<sorted.length;i++){
            sorted[i]=unsorted[i];
        }
        boolean flag=true;
        int temp;
        while (flag){
            flag=false;
            for (int i=0;i<sorted.length-1;i++){
                if (sorted[i]<sorted[i+1]){
                    temp=sorted[i];
                    sorted[i]=sorted[i+1];
                    sorted[i+1]=temp;
                    flag=true;
                }
            }
        }
        return sorted;
    }
}
