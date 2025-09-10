package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );


    List<String> listOfTopName=new ArrayList<>();
    topNames2015.forEach((String s) ->
            listOfTopName.add(s.substring(0,1).toUpperCase(Locale.ROOT)+s.substring(1)));
//            listOfTopName.sort((String s1,String s2)-> s1.compareTo(s2));
//            listOfTopName.forEach((String names)-> System.out.println(names));

        //for line 28 and 29 we can use method reference ex:-(class::methodName)
        listOfTopName.sort(String::compareTo);
        listOfTopName.forEach(System.out::println);


    }


}
