package com.company;

import java.util.ArrayList;

public class MobilePhone {
   private ArrayList<Contacts> myContact;

    public MobilePhone() {
        this.myContact = new ArrayList<Contacts>();
    }

    public boolean addContact(Contacts contacts){
        if (findContact(contacts.getName())>=0){
            System.out.println(contacts.getName()+" , was already on Contact List ");
            return false;
        }
        this.myContact.add(contacts);
        System.out.println(contacts.getName()+" was add to contact list ");
        return true;
    }

private int findContact(String name){
    for(int i=0;i<myContact.size();i++){
        Contacts fincontact=this.myContact.get(i);//this will give all exisiting value to fincontact as we go through loop
        if (fincontact.getName().equals(name)){//this will check if there is any existing contact is equal to the name pass to it
            return i;
        }
    }
    return -1;
}

public boolean updateContact(Contacts oldContact,Contacts newContact){
        int foundPosition=findContact(oldContact);
        if (foundPosition<0){
            System.out.println(oldContact.getName()+" does not exist in contact list ");
            return false;
        }else if (findContact(newContact.getName())!= -1){
            System.out.println(newContact.getName()+" , already exist in list ");
            return false;
        }
        else {
            this.myContact.set(foundPosition,newContact);
            return true;
        }

}

private int findContact(Contacts contacts){
        return this.myContact.indexOf(contacts);
}

public boolean remove(Contacts contacts){
        if (findContact(contacts)<0){
            System.out.println(contacts.getName()+" does not exist in list ");
            return false;
        }
        this.myContact.remove(contacts);
    System.out.println(contacts.getName()+" , was removed from list ");
    return true;
}

public String search(Contacts contacts){
        int foundposition=findContact(contacts);
        if (foundposition<0){
            System.out.println(contacts+" does not exist ");
        }
        return contacts.getName();
}

public void  printContactList(){
    System.out.println("Contact list : ");
    for (int i=0;i<myContact.size();i++){
        System.out.println((i+1)+" . "+myContact.get(i).getName()+
                                   "  --> "+myContact.get(i).getPhoneNumber());
    }
}
public Contacts search(String name){//this methos is use in main class
        int position=findContact(name);
        if (position>=0){
            return this.myContact.get(position);
        }
    System.out.println("contact does not exist");
        return null;
}

}