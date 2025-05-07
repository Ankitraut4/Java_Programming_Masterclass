package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Circle circle=new Circle(3.75);
        System.out.println("Circle Area = " +circle.getArea());

        Cylinder cylinder=new Cylinder(5.55,7.25);
        System.out.println("Cylinder Volume = "+cylinder.getVolume());

        System.out.println("Cylinder Area = "+cylinder.getArea());


    }
}
