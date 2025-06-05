package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> plaeTovisit=new LinkedList<String>();
        plaeTovisit.add("sydney");
        plaeTovisit.add("Melbourne");
        plaeTovisit.add("Brisbane");
        plaeTovisit.add("perth");
        plaeTovisit.add("Camberra");
        plaeTovisit.add("adelaide");
        plaeTovisit.add("Drawin");

        printlist(plaeTovisit);
        plaeTovisit.add(1,"alice Spring");
        printlist(plaeTovisit);

        plaeTovisit.remove(4);
        printlist(plaeTovisit);
    }
    private static void printlist(LinkedList<String> linkedList){
        Iterator<String> i=linkedList.iterator();
        while (i.hasNext()){
            System.out.println("now visiting "+i.next());
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$");
    }
}
