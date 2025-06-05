package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class going_forward_backward {
    public static void main(String[] args) {
        LinkedList<String> placetovisit=new LinkedList<String>();
        addInorder(placetovisit,"pune");
        addInorder(placetovisit,"mumbai");
        addInorder(placetovisit,"Akola");
        addInorder(placetovisit,"Nagpur");
        addInorder(placetovisit,"Aurangabad");
        addInorder(placetovisit,"Nagar");
        addInorder(placetovisit,"Banglore");
        visit(placetovisit);
    }
    private static void printlist(LinkedList<String> linkedList){
        Iterator<String> i=linkedList.iterator();
        while (i.hasNext()){
            System.out.println("now visiting "+i.next());
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$");
    }
    private static boolean addInorder(LinkedList<String> linkedList,String newCity){
        ListIterator<String> listiterator=linkedList.listIterator();//when we create list iterator like this ,it is not actual point to first record so you have to use listiterator.next() to go to first record
        while (listiterator.hasNext()){
            int comparision=listiterator.next().compareTo(newCity);
            if (comparision==0){
                //city already exist
                System.out.println(newCity+" already exist");
                return false;
            }else if (comparision>0){
                //new city akola  and other is pune so akola should implemented first as a>p in alphabetical order
                listiterator.previous();//here we use previous because .next is use which print as well as increment the value on line 23 we incremented value by using .next
                listiterator.add(newCity);
                return true;
            }else if (comparision<0){
                //move on to next city
            }
        }
        listiterator.add(newCity);//this is use if the city name came from z then is should we last in list
        return true;
    }
    private static void visit(LinkedList cities){
        Scanner scanner=new Scanner(System.in);
        boolean quit=false;
        boolean goingForward=true;
        ListIterator<String> i= cities.listIterator();
        if(cities.isEmpty()) {
            System.out.println("No cities in the List");
            return;
        } else {
            System.out.println("Now visiting " + i.next());
            printaction();
        }


        while (!quit){
            System.out.println("enter the choice ");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    System.out.println("holiday over ");
                    quit=true;
                    break;
                case 1:
                    if (!goingForward){
                        if (i.hasNext()){
                            i.next();
                        }
                        goingForward=true;
                    }
                    if (i.hasNext()){
                        System.out.println("now visiting--> "+i.next());

                    }else {
                        System.out.println("end of the list ");
                        goingForward=false;

                    }
                    break;
                case 2:
                    if (goingForward){
                        if (i.hasPrevious()){
                            i.previous();
                        }
                        goingForward=false;
                    }
                    if(i.hasPrevious()){
                        System.out.println("now visiting--> "+i.previous());
                    }else {
                        System.out.println("At start of the list ");
                      goingForward=true;

                    }
                    break;
            }
        }
    }
    private static void printaction(){
        System.out.println("press");
        System.out.println("0-quit ");
        System.out.println("1-go forward ");
        System.out.println("2-go backward ");

    }
}
