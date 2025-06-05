package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(2);//index 0
        list.add(3);//index 1
        list.add(4);//index 2

        for (int i=0;i<list.size();i++){
            System.out.println(i+" --> "+list.get(i));
        }

        list.add(1,5);//here we add value 5 to index position 1 and we move the element 3 to index 2
        for (int i=0;i<list.size();i++){
            System.out.println(i+" --> "+list.get(i));
        }
    }
}
