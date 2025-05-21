package com.company;

import java.util.Scanner;

public class Main {



    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
	int[] arrayofNumber=getNumber(5);
	for (int i=0;i<arrayofNumber.length;i++){
        System.out.println("element : "+i+" , value = "+arrayofNumber[i]);

    }
        System.out.println("average of number : "+average(arrayofNumber));
    }

    public static int[] getNumber(int number){
        System.out.println("enter "+number+" numbers : \r");
        int[] values= new int[number];
        for (int i=0;i<values.length;i++){
            values[i]=scanner.nextInt();
        }
        return values;
    }

    public static double average(int[] value){
        int sum=0;
        for (int i=0;i<value.length;i++){
            sum+=value[i];
        }
        return (double) sum/(double) value.length;
    }
}
