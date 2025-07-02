package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> square=new HashSet<>();
        Set<Integer> cube=new HashSet<>();

        for (int i=1;i<=100;i++){
            square.add(i*i);
            cube.add(i*i*i);
        }
        System.out.println(" square element in set : " +square.size());
        System.out.println(" cube element in set : " +cube.size());

        Set<Integer> union=new HashSet<>(square);
        union.addAll(cube);
        System.out.println(" element in union "+union.size());

        Set<Integer> intersection=new HashSet<>(square);
        intersection.retainAll(cube);
        System.out.println(" element in intersection "+intersection.size());
        for (int i: intersection){
           System.out.println(i+" is square of "+Math.sqrt(i)+" --> "+i+" is cube root of "+Math.cbrt(i));
        }

        //Asymmetric difference
        //here in asymmetric difference(A|B) is a set which contain all element of one which are  not element of two ex-A={1,2,3} & B={2,4} them A|B={1,3}
        Set<String> one=new HashSet<>();
        String[] arrayOfOneWords={"hi","hello","nice","to","have","you"};
        one.addAll(Arrays.asList(arrayOfOneWords));//Arrays.asList() is use to add a list of element in Sets

        Set<String> two=new HashSet<>();
        String[] arrayOfTwoWord={"no","hello","to"};
        two.addAll(Arrays.asList(arrayOfTwoWord));

        System.out.println();
        System.out.println("one which does not contain two elements :- ");
        Set<String> oneButNotInvolveTwo=new HashSet<>(one);
        oneButNotInvolveTwo.removeAll(two);
        printA(oneButNotInvolveTwo);

        System.out.println("");

        System.out.println("two which does not contain one elements :- ");
        Set<String> twoButNotInvolveOne=new HashSet<>(two);
        twoButNotInvolveOne.removeAll(one);
        printA(twoButNotInvolveOne);


        //symmetric set
        //is a set which does not contain intersection of element ex A={1,2,3,4} &B={2,3,6,7} them symmetric set ={1,4,6,7}
        //java does not give method for symmetric but we can do this operation by (union of method - intersection of method)
       Set<String> unionO=new HashSet<>(one);
       unionO.addAll(two);

       Set<String> intersection0=new HashSet<>(one);
       intersection0.retainAll(two);

        System.out.println("symmetric diff ");
        Set<String> sym=new HashSet<>(unionO);
        sym.removeAll(intersection0);
        printA(sym);


    }
    public static void printA(Set<String> set){
        for (String s: set){
            System.out.print(s);
            System.out.print(" ");

        }



    }
}
