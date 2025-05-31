package com.company;

public class Contacts {
    private String name;
    private String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public  static  Contacts createContact(String name,String phoneNumber){//this we give static because it is simple/factory method so it is convenience method as in addContact method we want to create a new contact record without having to create new contact class.
        return new Contacts(name,phoneNumber);
    }
}
