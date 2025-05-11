package com.company;

public class Main {

    public static void main(String[] args) {

        Wall wall1=new Wall("NORTH");
        Wall wall2=new Wall("SOUTH");
        Wall wall3=new Wall("EAST");
        Wall wall4=new Wall("WEST");

        Ceiling ceiling=new Ceiling(22,31);
        Lamp lamp=new Lamp("classic",false,1);
        Bed bed=new Bed("modern",4,3,1,1);

        Bedroom bedroom=new Bedroom("bedroom",wall1,wall2,wall3,wall4,ceiling,lamp,bed);
        bedroom.makeBed();
        bedroom.getLamp().turnOn();
    }
}
