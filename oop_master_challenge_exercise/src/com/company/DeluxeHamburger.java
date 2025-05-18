package com.company;

public class DeluxeHamburger extends Hamburger {


    public DeluxeHamburger( ) {
        super("Deluxe Hamburger", "swasegess & red meat", "Brown with extra veggies", 200);
        super.additionalinHamburger1("chips",20);
        super.additionalinHamburger2("soft Drink ",50);
    }

    @Override
    public void additionalinHamburger1(String name, double price) {
        System.out.println("we can not add aditionals in DeluxeHamburger");
    }

    @Override
    public void additionalinHamburger2(String name, double price) {
        System.out.println("we can not add aditionals in DeluxeHamburger");
    }

    @Override
    public void additionalinHamburger3(String name, double price) {
        System.out.println("we can not add aditionals in DeluxeHamburger");
    }

    @Override
    public void additionalinHamburger4(String name, double price) {
        System.out.println("we can not add aditionals in DeluxeHamburger");
    }
}
