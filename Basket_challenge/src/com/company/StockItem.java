package com.company;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private  double price;
    private  int quantity;
    private int reserve=0;

    public StockItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int avilableQuantity() {
        return quantity - reserve;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void adjustQuantity(int quantity) {
        int newQuantity=this.quantity+quantity;
        if (quantity>0){
            this.quantity=newQuantity;
        }
    }

    public  int reserveQuantity(int quantity){
        if (quantity<=avilableQuantity()){
            reserve+=quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveQuantity(int quantity){
        if (quantity<=reserve){
            reserve-=quantity;
            return quantity;
        }
        return 0;
    }
    public int finaliseStock(int quantity){
        if (quantity<=reserve){
            reserve-=quantity;
            this.quantity-=quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public  int hashCode() {
        return this.name.hashCode()+33;
    }

    @Override
    public  boolean equals(Object obj) {
      if (this==obj){
          return true;
      }
      if ((obj==null)||(this.getClass()!=obj.getClass())){
          return false;
      }

      String theObj=((StockItem) obj).getName();
      return this.name.equals(theObj);
    }

    @Override
    public String toString() {
        return this.name+" : "+this.price+" . Reserved: "+this.reserve;
    }

    @Override
    public int compareTo(StockItem o) {
        if (o==this){
            return 0;
        }
       if (o !=null){
           return this.name.compareTo(o.getName());
       }
        throw new NullPointerException();
    }
}
