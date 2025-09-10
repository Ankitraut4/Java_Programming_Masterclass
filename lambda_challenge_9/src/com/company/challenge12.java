package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class challenge12 {
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


      List<String> counting=  topNames2015.stream()
                .map(name -> name.substring(0, 1).toUpperCase(Locale.ROOT) + name.substring(1))
                .filter(name->name.startsWith("A"))
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println(counting.stream().peek(System.out::println).count());


    }
}