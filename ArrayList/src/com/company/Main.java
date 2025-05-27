package com.company;

import java.util.Scanner;

public class Main {
private static Scanner scanner=new Scanner(System.in);
private static GrosaryList grosaryList=new GrosaryList();


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
        grosaryList.addGrosaryitem(item);

    }
    public static void modifyItem(){
        System.out.println("enter the position :");
        int itenNo=scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter the new item : ");
        String newItem=scanner.nextLine();
        grosaryList.modifyItem(itenNo-1,newItem);
    }

    public static void removeItem(){
        System.out.println("enter the position to remove : ");
        int position=scanner.nextInt();
        scanner.nextLine();
        grosaryList.removeItem(position-1);
    }

    public static void finditem(){
        System.out.println("enter the item to search : ");
        String nameofitem=scanner.nextLine();
        if (grosaryList.findItem(nameofitem)!=null){
            System.out.println("the item "+nameofitem+" found in cart");
        }else {
            System.out.println("the item "+nameofitem+" is not found");
        }
    }
}
