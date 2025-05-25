package com.company;

import javax.swing.text.html.parser.Element;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] aa=readElements(readInteger());
        System.out.println("min = "+findMin(aa));
    }
    private static int readInteger(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the count : ");

        int element=scanner.nextInt();

scanner.nextLine();


        return element;


    }
    private static int[] readElements(int element){
        Scanner scanner=new Scanner(System.in);
        int[] value=new int[element];
        for (int i=0;i<value.length;i++){
            System.out.println("enter the number ");
            value[i]=scanner.nextInt();
            scanner.nextLine();
        }

        return value;

    }

    private static int findMin(int[] array) {

        int min = Integer.MAX_VALUE;
        while (true) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                }

            }
            return min;
        }
    }
}
