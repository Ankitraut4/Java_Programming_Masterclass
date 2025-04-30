package com.company;

public class Main {

    public static void main(String[] args) {

           Wall an=new Wall(5,4);
        System.out.println("area = " +an.getArea());
        System.out.println("width = "+an.getWidth());
        System.out.println("height = "+an.getHeight());

        Wall a=new Wall();
        System.out.println("area = "+a.getArea()+ " height = " +a.getHeight());
    }
}
