package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> someBingoNumber = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "O70"
        );

//  @1//      List<String> array=new ArrayList<>();
//        someBingoNumber.forEach(s->{
//            if (s.toUpperCase(Locale.ROOT).startsWith("G")){
//                array.add(s);
//            }
//        });
//
//        array.sort((String s1,String s2)-> s1.compareTo(s2));
// @1//        array.forEach( (String s)-> System.out.println(s));

//    }

        //using stream for code @1

        someBingoNumber
                .stream()
                .map(String::toUpperCase)  //or we can use .map(s-> s.toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);


        System.out.println();
        //creating stream without source
        Stream<String> abStream=Stream.of("A10","A11","A98","A04","B01","B11");
        Stream<String> bcStream=Stream.of("B01","B43","C22","C55");
        Stream<String> concatStream=Stream.concat(abStream,bcStream);
        System.out.println("using peek method to display the element of stream before counting ");//we use peek because conact method is static
        System.out.println(concatStream.distinct().peek(System.out::println).count());
        System.out.println();


        //using flat map
        System.out.println("using flat map which accept object as function  argument and return String contaning several object(stream value)");
        Employee ankit=new Employee("ankit Raut",21);
        Employee mohit=new Employee("mohit Raut",16);
        Employee suresh=new Employee("suresh Raut",45);
        Employee sangita=new Employee("sangita Raut",40);

        Department worker=new Department("elite");
        worker.addEmploye(ankit);
        worker.addEmploye(mohit);
        worker.addEmploye(suresh);

        Department manager=new Department("manager");
        manager.addEmploye(sangita);

        List<Department> departments=new ArrayList<>();
        departments.add(worker);
        departments.add(manager);

        departments.stream()
                .flatMap(s->s.getEmployees().stream())
                .forEach(System.out::println);


        System.out.println();
        //using collect
        System.out.println("collect is use to get value from list and store that value in another List");
        List<String> anotherList=someBingoNumber.stream()
                .map(String::toUpperCase)
                 .filter(s->s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());
        for (String an: anotherList){
            System.out.println(an);
        }

        System.out.println();

        //use of reduce method (we want to write younger employee)
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((Employee s1, Employee s2)-> s1.getAge() < s2.getAge() ? s1 : s2)
                .ifPresent(System.out::println);
    }
}