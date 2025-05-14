package com.company;

public class Main {

    public static void main(String[] args) {
        Printer printer=new Printer(20,true);


        int Pages= printer.printPages(4);//here 4 is a number of print not pages
        System.out.println("page printed was = "+ Pages+" new total no of print count for printer="+printer.getPagesPrinted() );

        Pages= printer.printPages(2);
        System.out.println("page printed was = "+ Pages+" new total no of print count for printer ="+printer.getPagesPrinted() );
    }
}
