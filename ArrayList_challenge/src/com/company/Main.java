package com.company;

import java.util.Scanner;

public class Main {
private static Scanner scanner=new Scanner(System.in);
private static MobilePhone mobilePhone=new MobilePhone();
    public static void main(String[] args) {
        // Create a program that implements a simple mobile phone with the following capabilities.
        // Able to store, modify, remove and query contact names.
        // You will want to create a separate class for Contacts (name and phone number).
        // Create a master class (MobilePhone) that holds the ArrayList of Contacts
        // The MobilePhone class has the functionality listed above.
        // Add a menu of options that are available.
        // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
        // and search/find contact.
        // When adding or updating be sure to check if the contact already exists (use name)
        // Be sure not to expose the inner workings of the Arraylist to MobilePhone
        // e.g. no ints, no .get(i) etc
        // MobilePhone should do everything with Contact objects only.
        boolean quit = true;
        getinfo();

        while (quit) {
            System.out.println("enter your choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    quit=false;
                    break;

                case 1:
                    mobilePhone.printContactList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    getinfo();
                    break;
            }
        }
    }
   private static void addContact() {
       System.out.println("enter the contact name ");
       String name = scanner.nextLine();
       System.out.println("enter the contact phoneNumber ");
       String num = scanner.nextLine();
       Contacts newcontact = Contacts.createContact(name, num);
       if (mobilePhone.addContact(newcontact)) {
           System.out.println("New Name " + name + " phoneNumber " + num + " is added ");
       } else {
           System.out.println("name " + name + " does not exist ");
       }
   }
   private static void updateContact() {
       System.out.println("enter the existing contact name ");
       String existname = scanner.nextLine();
       Contacts existContactrecord = mobilePhone.search(existname);
       if (existContactrecord == null) {
           return;
       }
       System.out.println("enter new contact name ");
       String name = scanner.nextLine();
       System.out.println("enter new contact phonenumber ");
       String num = scanner.nextLine();
       Contacts newcontact = Contacts.createContact(name, num);
       if (mobilePhone.updateContact(existContactrecord, newcontact)) {
           System.out.println("successfully updated");
       } else {
           System.out.println("error in updating");
       }
   }

   private static void remove() {
       System.out.println("enter the existing contact name ");
       String exist = scanner.nextLine();
       Contacts existingRecord = mobilePhone.search(exist);
       if (existingRecord == null) {
           System.out.println("contact not found ");
           return;
       }
       if (mobilePhone.remove(existingRecord)) {
           System.out.println(existingRecord.getName()+" and "+existingRecord.getPhoneNumber() + " has been deleted");
       }else {
           System.out.println("error deleting ");
       }
   }

   private static void search() {
       System.out.println("enter existing name ");
       String name = scanner.nextLine();
       Contacts existRecord = mobilePhone.search(name);
       if (existRecord == null) {
           System.out.println("record not found ");
           return;
       } else {

           System.out.println("Name: " + existRecord.getName() + " phoneNumber: " + existRecord.getPhoneNumber());
       }
   }
    private static void getinfo() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
    }
}
