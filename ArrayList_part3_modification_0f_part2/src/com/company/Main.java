package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
private static GrosaryList grosaryList=new GrosaryList();
private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        boolean quit=true;
        int choice;
        printinfo();
        while (quit){
            System.out.println("enter you choice ");
            choice= scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    printinfo();
                    break;
                case 1:
                    grosaryList.printGrosaryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    modifyItem();
                    break;
                case 5:
                    finditem();
                    break;
                case 6:
                    quit=false;
                    break;
            }
        }
    }
    public static  void printinfo(){
        System.out.println("press your option: ");
        System.out.println("press 0 - print the information ");
        System.out.println("press 1- print the list");
        System.out.println("press 2- add item in list ");
        System.out.println("press 3- remove item from list ");
        System.out.println("press 4- modify item from list ");
        System.out.println("press 5- find item in list ");
        System.out.println("press 6 - to exit");
    }
    public static void addItem(){
        System.out.println("enter the item to add : ");
        String item=scanner.nextLine();
        grosaryList.addItemInGrosaryList(item);

    }
    public static void modifyItem(){
        System.out.println("enter the current item :");
        String itenNo=scanner.nextLine();

        System.out.println("enter the new item : ");
        String newItem=scanner.nextLine();
        grosaryList.modifyGrosaryList(itenNo,newItem);
    }

    public static void removeItem(){
        System.out.println("enter the name of item to remove : ");
    String item=scanner.nextLine();

        grosaryList.removeItem(item);
    }

    public static void finditem(){
        System.out.println("enter the item to search : ");
        String nameofitem=scanner.nextLine();
        if (grosaryList.searchItem(nameofitem)){
            System.out.println("the item "+nameofitem+" found in cart");
        }else {
            System.out.println("the item "+nameofitem+" is not found");
        }
    }

    public static void processArrayList(){
        //to copy array to another we can use way 1
        ArrayList<String> newArray=new ArrayList<String>();
        newArray=grosaryList.getGrosaryList();

        //to copy array to another we can use way 2
        ArrayList<String> newArray1=new ArrayList<String>(grosaryList.getGrosaryList());

        //way to convert arrayList into simple Array
        String[] myArray=new String[grosaryList.getGrosaryList().size()];
        myArray=grosaryList.getGrosaryList().toArray(myArray);

    }
}
