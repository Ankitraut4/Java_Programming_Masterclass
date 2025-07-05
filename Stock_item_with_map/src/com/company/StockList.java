package com.company;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private Map<String,StockItem> lists;

    public StockList() {
        this.lists=new LinkedHashMap<>();//in linkedHashMap the item are display in order they are stored in Map
    }

    public int addStock(StockItem item){
        if (item!=null){
            // check if already have quantities of this item
            StockItem inStoch=lists.getOrDefault(item.getName(),item);
            // If there are already stocks on this item, adjust the quantity
            if (inStoch!=item){//here by putting in stock not equal to item we are checking to see did we actually get the
                // list of the item out of our map and is that the same as stock item that has been pass so by checking where they are
                //seperate we can determine basically whether the item was already exisiting in the map,if is already in map then we just modify the quantity
                item.adjustQuantity(inStoch.getQuatityOfStock());
            }
            //there item is new elemnet in map then
            lists.put(item.getName(),item);
            return item.getQuatityOfStock() ;

        }
        return 0;
    }

    public  int sellStock(String item,int quantity){
        StockItem inStock=lists.getOrDefault(item,null);
        if (inStock!=null &&  inStock.getQuatityOfStock()>=quantity && quantity>0){
            inStock.adjustQuantity(-quantity);
            return quantity;
        }
        return 0;
    }

    //creating method for printing item name and cost
    public Map<String,Double> priceList(){
        Map<String,Double> price=new LinkedHashMap<>();
        for (Map.Entry<String,StockItem> item: lists.entrySet() ){
            price.put(item.getKey(),item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(price);
    }

    public StockItem get(String key){//this is a getter for stockitem which is created by passing the name of stock item and return
        //the stock item as object
        return lists.get(key);
    }

    public Map<String,StockItem> Items(){
        return Collections.unmodifiableMap(lists);
    }

    @Override
    public String toString() {
        String s = "\nstock List\n";
        double totalValue=0.0;
        for (Map.Entry<String,StockItem> item: lists.entrySet()){
            StockItem instock=item.getValue();

             double itemValue=instock.getPrice()*instock.getQuatityOfStock();

            s=s+instock+" there are "+instock.getQuatityOfStock()+" elements in Stock, The Value of item = ";
            s=s+itemValue+"\n";
            totalValue+=itemValue;
        }
        return s + " total value = "+totalValue;
    }
}
