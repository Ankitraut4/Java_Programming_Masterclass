package com.company;

public class Main {

    public static void main(String[] args) {
        // Create a class and demonstate proper encapsulation techniques
        // the class will be called Printer
        // It will simulate a real Computer Printer
        // It should have fields for the toner Level, number of pages printed, and
        // also whether its a duplex printer (capable of printing on both sides of the paper).
        // Add methods to fill up the toner (up to a maximum of 100%), another method to
        // simulate printing a page (which should increase the number of pages printed).
        // Decide on the scope, whether to use constructors, and anything else you think is needed.

        Printer printer=new Printer(20,true);
        System.out.println("initial toner level = " +printer.getTonerLevel()+" %");
        printer.fillLevel(20);
        System.out.println("toner level = "+printer.getTonerLevel()+" %");

       int Pages= printer.PagesPrinted(4);//here 4 is a number of print not pages
        System.out.println("page printed was = "+ Pages+" new total no of print count for printer="+printer.getNumberOfPagesPrinted() );

        Pages= printer.PagesPrinted(2);
        System.out.println("page printed was = "+ Pages+" new total no of print count for printer ="+printer.getNumberOfPagesPrinted() );


    }
}
