package com.company;

import java.util.LinkedHashMap;
import java.util.Map;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quatityOfStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quatityOfStock=0;
    }
    public StockItem(String name, double price,int quatityOfStock) {
        this.name = name;
        this.price = price;
        this.quatityOfStock=quatityOfStock;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuatityOfStock() {
        return quatityOfStock;
    }

    public void setPrice(double price) {
        if (price>0) {
            this.price = price;
        }
    }


    public void adjustQuantity(int quatity) {//it like similiar to setQuantity setter
        int newQuantity = this.quatityOfStock + quatity;
        if (newQuantity > 0) {
            this.quatityOfStock = newQuantity;
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+33;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj==this){//checking against if there is same object in memory
            return true;//return true because it is same instance of the object or same object in memory
        }
        if ((obj==null)||(this.getClass()!=obj.getClass())){//class is different to , the present class to object class
            return false;
        }
        StockItem theObj=(StockItem)obj;
        return this.name.equals(theObj.getName());

    }

    @Override
    public String toString() {
        return this.name+" : price :- "+this.price;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("entering stockItem compareTo");
        if (this==o){//checking this object which is already present  in the memory
            return 0;
        }
        if (o!=null){
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }
}
