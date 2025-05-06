package com.company;

public class Car extends Vehicle {
    private int door;
    private int wheels;
    private int numofgear;
    private int changeinspeed;
    private int changeinderection;
    private int changeingear;

    public Car(String name, int weight, int door, int wheels,int numofgear) {
        super(name, weight);
        this.door = door;
        this.wheels = wheels;
        this.numofgear=numofgear;

        this.changeingear=0;
        this.changeinderection=0;


    }


    public void changeinmove(int speed,int direction){

        System.out.println("Car is moving with velocity :"+speed+" km/h in "+direction+" degree");

        move(speed,direction);
    }

    public int getDoor() {
        return door;
    }

    public int getWheels() {
        return wheels;
    }

    public void stop(){
        System.out.println("Car is in neutral //please change the gear");
    }

    public void gear(int changeingear){
        System.out.println("Car is in "+changeingear+" gear");
        this.changeingear +=changeingear;

    }
}
