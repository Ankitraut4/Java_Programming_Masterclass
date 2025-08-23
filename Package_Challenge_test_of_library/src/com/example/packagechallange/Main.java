package com.example.packagechallange;

public class Main {

    public static void main(String[] args) {
        for (int i=0;i<=10;i++){
            System.out.println(Series.nSum(i));
        }
        System.out.println("");
        for (int i=0;i<=10;i++){
            System.out.println(Series.nFactorial(i));
        }
        System.out.println("");
        for (int i=0;i<=10;i++){
            System.out.println(Series.nFibonacci(i));
        }
    }
}
