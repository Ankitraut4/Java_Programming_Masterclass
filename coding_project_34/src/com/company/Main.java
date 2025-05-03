package com.company;

public class Main {

    public static void main(String[] args) {
        ComplexNumber first = new ComplexNumber(10.0, 9);
        first.subtract(3,-3);
        System.out.println("add real num = "+first.getReal());
        System.out.println("sub imaginary num = "+first.getImaginary());

        ComplexNumber sec=new ComplexNumber(2,4);

        first.add(sec);
        System.out.println("add of first and sec of real num = "+first.getReal());

        first.add(sec);
        System.out.println("add of first and sec of imaginary num = "+first.getImaginary());
    }
}
