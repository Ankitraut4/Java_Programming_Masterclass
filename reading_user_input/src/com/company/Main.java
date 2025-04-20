package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Scanner scanner= new Scanner(System.in);
//        System.out.println("enter your name : ");
//        String name=scanner.nextLine();//this take input from line 9 and store the value in name i.e string
//
//        System.out.println("your name is : "+name);
//
//
//        scanner.close();

        Scanner scanner= new Scanner(System.in);

        System.out.println("enter you birth year : ");

        boolean hasNextInt = scanner.hasNextInt();
        if(hasNextInt) {
            int age = scanner.nextInt();//scanner is class name of scanner which take input from user and nextInt is you to convert input to integer format
            scanner.nextLine();//handle next line character (enter key )if does not give scanner.nextline(); the input for name woulg not taken i.e it conceder the enter key as input

            System.out.println("enter your name : ");
            String name = scanner.nextLine();//this take input from line 24 and store the value in name i.e string
            int presentage = 2021 - age;
            System.out.println("your name is : " + name);
            if (presentage >= 0 && presentage <= 100) {
                System.out.println("your current age is " + presentage + "  year's old");
            }else {
                System.out.println("invalid range or negative input for year");
            }
        }
        else {
            System.out.println("invalid datatype");
        }
        scanner.close();
    }
}
