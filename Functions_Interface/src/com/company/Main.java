package com.company;

import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Employee ankit=new Employee("Ankit Raut",21);
        Employee mohit=new Employee("mohit Raut",16);
        Employee jhon=new Employee("jhon Cena",45);
        Employee ethan=new Employee("ethan bezinga",28);
        Employee ben=new Employee("Ben tom",56);


        List<Employee> employees=new ArrayList<>();
        employees.add(ankit);
        employees.add(mohit);
        employees.add(jhon);
        employees.add(ben);
        employees.add(ethan);

//        employees.forEach(employee -> { way of printing last name
//            System.out.println("Last name : "+employee.getName().substring(employee.getName().indexOf(' ')+1));
//        });

        //printing last name by function interface which take Employee as argument and String as parameter

        Function<Employee,String> getLastName= (employee)->{//here Function<Employee,String> //Employee is argument and String is a parameter/ its return type
            return employee.getName().substring(employee.getName().indexOf(' ')+1);
        };
//        String lastName=getLastName.apply(employees.get(2));
//        System.out.println(lastName);

        Function<Employee,String> getFirstName=(employee) ->{
            return employee.getName().substring(0,employee.getName().indexOf(' '));
        };
//        String firtName=getFirstName.apply(employees.get(2));
//        System.out.println(firtName);

        //printing in random order
        Random random=new Random();
        for (Employee employee: employees) {
            if (random.nextBoolean()) {
                System.out.println(printName(getFirstName, employee));
            }else {
                System.out.println(printName(getLastName,employee));
            }
        }


        Function<Employee,String> upperCase=employee -> employee.getName().toUpperCase(Locale.ROOT);//this fuction return get argument for firstName function interface
        Function<String,String> firstName= name -> name.substring(0,name.indexOf(' '));//the first String is argument as a String from upperCase return
        Function chainFunction=upperCase.andThen(firstName);
        System.out.println(chainFunction.apply(employees.get(0)));

        BiFunction<String,Employee,String> concatAge=(String name,Employee employee)->{
            return name.concat(" "+employee.getAge());
        };
        String upperName=upperCase.apply(employees.get(0));
        String concat=concatAge.apply(upperName,employees.get(0));
        System.out.println(concat);


        IntUnaryOperator incBy5=i-> i+5;
        System.out.println(incBy5.applyAsInt(10));
    }
    //we can use method to print last name or first name depend upon parameter passed
    public static String printName(Function<Employee,String> getName,Employee employee){
        return getName.apply(employee);
    }

}

