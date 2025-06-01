package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){

        if (findContact(contact.getName())>=0){
            return false;
        }else {
            this.myContacts.add(contact);
            return true;
        }
    }
    public boolean updateContact(Contact oldcontact,Contact newcontact){
        int foundPosition=findContact(oldcontact);
        if (foundPosition<0){
            return false;
        }else if (findContact(newcontact.getName())!=-1){
return false;
        }else {
            this.myContacts.set(foundPosition,newcontact);
            return true;
        }
    }
    public boolean removeContact(Contact contact){
     if (findContact(contact)<0){
         return false;
     }else {
         this.myContacts.remove(contact);
         return true;
     }
    }
    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }
    private int findContact(String contactName){
        for (int i=0;i<myContacts.size();i++){
            Contact newContact=this.myContacts.get(i);
            if (newContact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }
    public Contact queryContact(String name){
        int position=findContact(name);
        if (position>=0){
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts(){
        System.out.println("Contact List: ");
        for (int i=0;i<myContacts.size();i++){
            System.out.println((i+1)+". "+myContacts.get(i).getName()+
                                      " -> "+myContacts.get(i).getPhoneNumber());
        }
    }

}
