package com.company;

import java.util.Map;

public class Main {
private static StockList stockList=new StockList();
    public static void main(String[] args) {


     StockItem   stockItem=new StockItem("cup",45,7);
	stockList.addStock(stockItem);

	stockItem=new StockItem("dan",66,9);
	stockList.addStock(stockItem);

        stockItem=new StockItem("v",6,5);
        stockList.addStock(stockItem);

        stockItem=new StockItem("Apple",9,1);
        stockList.addStock(stockItem);
        stockItem=new StockItem("Apple",4,4);
        stockList.addStock(stockItem);

        System.out.println(stockList);

        //printing items using items method which return unmodifiable maps using key which return item in stockItem list
        System.out.println("Items : ");
        for (String s: stockList.Items().keySet()){
            System.out.println(s);
        }


        Basket basket1=new Basket("ankit");
        //in sellItem method the item is sell and add to the basket
        sellItem(basket1,"cup",1);
        sellItem(basket1,"Apple",2);
        System.out.println(basket1);

        System.out.println(stockList);

        //if the item is not present in stock then it show the msg
        sellItem(basket1,"juice",3);
        //item quantity is less than required quantity it will not show anything as we  does not describe printout statement
        sellItem(basket1,"v",6);

        //use of unmodifiable map as it through exception when we want update or modify collection
//     StockItem  tem=new StockItem("pen",2);
//        stockList.Items().put(tem.getName(),tem);

        //but we can modify individual object from collection in unmodifiable map
        stockList.Items().get("Apple").adjustQuantity(80);
        stockList.get("v").adjustQuantity(2);
        System.out.println(stockList);

        System.out.println();
//printing method used to print the price and item
        System.out.println("Price List ");
        for (Map.Entry<String,Double> pr: stockList.priceList().entrySet()){
            System.out.println(pr.getKey()+" cost --> "+pr.getValue()+" rs");
        }

    }
    public static int sellItem(Basket basket,String item,int quantity){
        //retriving the items from stockList
        StockItem stockItem=stockList.get(item);
        if (stockItem==null){
            System.out.println("we did not sell this item "+stockItem);
        }
        if (stockList.sellStock(item,quantity)!= 0){
            basket.addInBasket(stockItem,quantity);
        }
        return 0;
    }
}
