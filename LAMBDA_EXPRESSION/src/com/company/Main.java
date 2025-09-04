package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//@1//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("way 1 of implementing runnable");
//                System.out.println("line 1");
//                System.out.println("hello");
//            }
//  @1//      }).start();

        //using lambda expresion for code @1
        new Thread(()-> { System.out.println("way 1 of implementing runnable");
                System.out.println("line 1");
                System.out.println("hello");
            }).start();


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

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        //above code to lambda
        Collections.sort(employees,(employee1,employee2) ->
                employee1.getName().compareTo(employee2.getName()));

//        for (Employee employee:employees){
//            System.out.println(employee.getName()+" : "+employee.getAge());
//        }
        //replacing the for loop to lambda contain iterator who iterate through loop
        employees.forEach(employee -> {
            System.out.println(employee.getName()+" : "+employee.getAge());
        });



//        String sillyString=doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase()+s2.toUpperCase();
//            }
//        },
//                employees.get(0).getName(),employees.get(1).getName());

        UpperConcat uc=(s1,s2) ->{String result= s1.toUpperCase(Locale.ROOT)+s2.toUpperCase(Locale.ROOT);
         return result;
        };
        String sillyString=doStringStuff(uc,employees.get(0).getName(),employees.get(1).getName());

        System.out.println(sillyString);

    }
    public final static String doStringStuff(UpperConcat uc,String s1,String s2){
        return uc.upperAndConcat(s1, s2);
    }

    }

    class Employee {
    private String name;
    private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    interface UpperConcat{
    public String upperAndConcat(String s1,String s2);
    }
