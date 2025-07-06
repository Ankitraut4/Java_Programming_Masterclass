package com.company;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


public class StockList {
   private final Map<String,StockItem> list;

    public StockList() {
        this.list=new LinkedHashMap<>();
    }

    public int addStock(StockItem item){
        if (item!=null){
            StockItem inStock=list.getOrDefault(item.getName(),item);
            if (inStock!=item){
                item.adjustQuantity(inStock.avilableQuantity());

            }
            list.put(item.getName(),item);
            return item.avilableQuantity();
        }
        return 0;
    }

    public int sellStock(String item,int quantity){
        StockItem inStock=list.get(item);

        if (quantity>0 && inStock!=null ){
            inStock.finaliseStock(quantity);
            return quantity;
        }
        return 0;
    }

    public int reserveStock(String item,int quantity){
        StockItem item1=list.get(item);
        if (item1!=null && quantity>0){
            return item1.reserveQuantity(quantity);
        }
        return 0;
    }

    public int unreserveStock(String item,int quantity){
        StockItem item1=list.get(item);
        if (item1!=null && quantity>0){
            return item1.unreserveQuantity(quantity);
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String,StockItem> items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.avilableQuantity();

            s = s + stockItem + ". There are " + stockItem.avilableQuantity() + " in stock. Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value " + totalCost;
    }
}
