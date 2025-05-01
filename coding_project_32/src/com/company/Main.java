package com.company;

public class Main {

    public static void main(String[] args) {

        Point first=new Point(6,5);
        System.out.println("distance(0,0) = " +first.distance());

        //distance from  point
        System.out.println("distance(3,1) = " +first.distance(3,1));

        //case 3
        Point anotherpoint=new Point(3,1);
        System.out.println("distance(from first to anotherpoint i.e one constructor to another) = " +first.distance(anotherpoint));

        //for POint having no parameters
        Point p=new Point();
        System.out.println("distance(default) = " +p.distance());

    }
}
