package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Rectangle rectangle=new Rectangle(5,10);
        System.out.println("area of rectangle = "+rectangle.getArea());

        Cuboid cuboid=new Cuboid(5,10,5);
        System.out.println("volume of cuboid = "+cuboid.getVolume());
    }
}
