package com.company;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Employee ankit=new Employee("Ankit",21);
        Employee mohit=new Employee("mohit",16);
        Employee jhon=new Employee("jhon",45);
        Employee ethan=new Employee("ethan",28);
        Employee ben=new Employee("Ben",56);


        List<Employee> employees=new ArrayList<>();
        employees.add(ankit);
        employees.add(mohit);
        employees.add(jhon);
        employees.add(ben);
        employees.add(ethan);

        Collections.sort(employees,(employee1,employee2) ->
                employee1.getName().compareTo(employee2.getName()));

//        System.out.println("employee age greater than 30");
//        employees.forEach(employee -> {
//            if (employee.getAge()>30) {
//                System.out.println(employee.getName() + " : " + employee.getAge());
//            }
//            });

        //using predicate to check the condition
        printAge(employees,"Age greater than 30",employee -> employee.getAge()> 30);//lambda predicate
        printAge(employees,"Age less than equal to 30",employee -> employee.getAge()<=30);
        printAge(employees, "Age less than 20 ", new Predicate<Employee>() {//here we use anyonomus Predicate class //but when working with interfaces in java.util.function package it is more common to use lambda expression but it depends on your choice to use anyonomus class or lambda
            @Override
            public boolean test(Employee employee) {
                return employee.getAge()<20;
            }
        });


        System.out.println("**********************************");
   //predicate(IntPredicate, longPredicate, doublePredicate,etc) can also reuse to check condition or chainning predicate using (and , or ,etc)
        IntPredicate greaterThan15= i -> i>15;
        System.out.println(greaterThan15.test(10));

        IntPredicate lessThan100=i -> i<100;
        System.out.println(lessThan100.test(90));

        //chaining the predicate
        System.out.println(greaterThan15.and(lessThan100).test(66));
        System.out.println(greaterThan15.and(lessThan100).test(15));
        System.out.println(greaterThan15.or(lessThan100).test(14));

//Supplier (IntSupplier,longSupplier,etc)
    Random random=new Random();
        Supplier<Integer> supplier = () -> random.nextInt(100); // here we use () because supplier does not accept any argument
    for (int i=0;i<10;i++){
        System.out.println(supplier.get());
    }

    }



    public static void printAge(List<Employee> employees, String ageDescription, Predicate<Employee> ageCondition){
        System.out.println(ageDescription);
        for (Employee employee:employees){
            if (ageCondition.test(employee)){
                System.out.println(employee.getName()+" : "+employee.getAge());
            }
        }
    }

}

