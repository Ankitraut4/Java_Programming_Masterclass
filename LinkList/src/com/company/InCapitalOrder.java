package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class InCapitalOrder {
    public static void main(String[] args) {
        //create a linkilist which process the input and print it into a alphabetic order
        LinkedList<String> placetovisit=new LinkedList<String>();
        addInorder(placetovisit,"pune");
        addInorder(placetovisit,"mumbai");
        addInorder(placetovisit,"Akola");
        addInorder(placetovisit,"Nagpur");
        addInorder(placetovisit,"Aurangabad");
        addInorder(placetovisit,"Nagar");
        printlist(placetovisit);
       addInorder(placetovisit,"Banglore");
        printlist(placetovisit);
placetovisit.remove(2);
addInorder(placetovisit,"Nagpur");
        printlist(placetovisit);


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
}
