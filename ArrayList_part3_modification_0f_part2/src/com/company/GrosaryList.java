package com.company;

import java.util.ArrayList;

public class GrosaryList {

    private ArrayList<String> grosaryList=new ArrayList<String>();

    public ArrayList<String> getGrosaryList() {
        return grosaryList;
    }

    public void addItemInGrosaryList(String item){
        grosaryList.add(item);
    }

    public int findItem(String item){
        return grosaryList.indexOf(item);

    }
    public void modifyGrosaryList(String currentItem,String item){
        int position=findItem(currentItem);
        if(position>=0){
          modifyGrosaryList(position,item);
        }
    }
    private void modifyGrosaryList(int position,String item){
        grosaryList.set(position,item);
        System.out.println("item "+item+" is modified");
    }
    public void removeItem(String currentItem){
        int position=findItem(currentItem);
        removeItem(position);
    }
    private void removeItem(int position){
        grosaryList.remove(position);
    }

    public void printGrosaryList(){
        System.out.println("you cart has "+grosaryList.size()+ " items");
        for (int i=0;i<grosaryList.size();i++){
            System.out.println((i+1)+" . "+grosaryList.get(i));
        }
    }

    public boolean searchItem(String name){
       int position= findItem(name);
        if (position>=0){
            return true;
        }
        return false;
    }
}
