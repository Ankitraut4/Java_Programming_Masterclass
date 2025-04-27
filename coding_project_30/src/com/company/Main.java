package com.company;

public class Main {

    public static void main(String[] args) {

        Person person=new Person();

        person.setFirstName("Ankit");
        person.setLastName("Raut");
        person.setAge(18);
        System.out.println("first name is: " +person.getFirstName());
        System.out.println("last name is: " +person.getLastName());
        System.out.println("age of the person is: "+person.getAge());
        System.out.println("the person is teenager: "+person.isTeen());
        System.out.println("the fullname of person is: "+person.getFullName());
    }
}
