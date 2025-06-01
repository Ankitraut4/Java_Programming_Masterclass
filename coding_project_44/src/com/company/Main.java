package com.company;

import java.util.Scanner;

public class Main {
private static Scanner scanner=new Scanner(System.in);
private static MobilePhone mobilePhone=new MobilePhone("77 22");
    public static void main(String[] args) {
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
                    mobilePhone.printContacts();
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
    private static void addContact(){
        System.out.println("enter the contact name : ");
        String name=scanner.nextLine();
        System.out.println("enter the phone number : ");
        String num=scanner.nextLine();
        Contact newContact=Contact.createContact(name,num);
        if (mobilePhone.addNewContact(newContact)){
            System.out.println("name: "+name+" and phoneNumber: "+num);

        }else {
            System.out.println("contact already exist");
        }
    }
    private static void updateContact(){
        System.out.println("enter existing contact name: ");
        String name=scanner.nextLine();
        Contact existingCon=mobilePhone.queryContact(name);
        if (existingCon==null){
            return;
        }else {
            System.out.println("enter new contact name : ");
            String newName=scanner.nextLine();
            System.out.println("enter new contact phoneNumber : ");
            String newNUM=scanner.nextLine();
            Contact newContact=Contact.createContact(newName,newNUM);
            if (mobilePhone.updateContact(existingCon,newContact)){
                System.out.println("sucessfully updated");
            }else {
                System.out.println("error updating");
            }
        }

    }
    private static void search(){
        System.out.println("enter existing name ");
        String name = scanner.nextLine();
        Contact existRecord = mobilePhone.queryContact(name);
        if (existRecord == null) {
            System.out.println("record not found ");
            return;
        } else {

            System.out.println("Name: " + existRecord.getName() + " phoneNumber: " + existRecord.getPhoneNumber());
        }
    }
    private static void remove(){
        System.out.println("enter existing contact name: ");
        String name=scanner.nextLine();
        Contact existingCon=mobilePhone.queryContact(name);
        if (existingCon==null){
            System.out.println("no contact found ");
            return;
        }else {
            mobilePhone.removeContact(existingCon);
            System.out.println("Name: "+existingCon.getName()+" and phoneNumber: "+existingCon.getPhoneNumber()+" has been deleted");
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
