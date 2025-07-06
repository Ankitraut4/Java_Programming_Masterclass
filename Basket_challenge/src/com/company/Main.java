package com.company;

import java.util.Locale;
import java.util.Map;

public class Main {
private static StockList stockList=new StockList();

    public static void main(String[] args) {

        StockItem temp=new StockItem("cup",40,100);
        stockList.addStock(temp);

        temp =new StockItem("apple",30,45);
        stockList.addStock(temp);

        temp =new StockItem("car",100,4);
        stockList.addStock(temp);

        temp =new StockItem("bus",120,55);
        stockList.addStock(temp);

        temp =new StockItem("juice",45,75);
        System.out.println(stockList);

        Basket ankit=new Basket("Ankit");
        addItemInBasket(ankit,"apple",20);
        addItemInBasket(ankit,"cup",11);
        addItemInBasket(ankit,"bus",20);
        addItemInBasket(ankit,"cips",20);
        removeItemFrombasket(ankit,"cup",10);

        System.out.println(ankit);

        Basket mohit =new Basket("mohit");
        addItemInBasket(mohit,"apple",2);
        addItemInBasket(mohit,"cup",50);
        addItemInBasket(mohit,"bus",25);
        removeItemFrombasket(mohit,"bus",4);
        removeItemFrombasket(mohit,"apple",2);
        System.out.println(mohit);


        System.out.println(stockList);

     checkOut(mohit);
     checkOut(ankit);

        System.out.println(stockList);







    }
    public static int addItemInBasket(Basket basket,String item,int quantity) {
        // retrieve the item from stock list
        StockItem inStock = stockList.get(item);
        if (inStock == null) {
            System.out.println("we did not sell this item " + item);
            return 0;
        } else if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addInBasket(inStock, quantity);
        }
            return 0;

    }

    public static int removeItemFrombasket(Basket basket,String item,int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("we did not sell this item " + item);
        } else if (stockItem.unreserveQuantity(quantity) != 0) {
            return basket.removeInBaske(stockItem, quantity);
        }
            return 0;

    }

    public static void checkOut(Basket basket){
        for (Map.Entry<StockItem,Integer> item : basket.items().entrySet()){
            stockList.sellStock(item.getKey().getName(),item.getValue());
        }
        basket.clearBasket();
    }
}
