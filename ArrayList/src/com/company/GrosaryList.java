package com.company;


import java.util.ArrayList;

public class GrosaryList {

private ArrayList<String> grosaryList =new ArrayList<String>();

public  void addGrosaryitem(String item){
    grosaryList.add(item);
}

public void printGrosaryList(){
    System.out.println("you cart has "+grosaryList.size()+ " items");
    for (int i=0;i<grosaryList.size();i++){
        System.out.println((i+1)+" . "+grosaryList.get(i));
    }
}

public void removeItem(int position){
    String theitem=grosaryList.get(position);//use to store the item which wee are removing
    grosaryList.remove(position);
}

public void modifyItem(int position,String newitem){
    grosaryList.set(position,newitem);
    System.out.println("item is modified at "+(position+1)+ " position");
}

public String findItem(String searchItem){
    int position=grosaryList.indexOf(searchItem);
    if (position>=0){
        return grosaryList.get(position);
    }
    return null;
}
}
