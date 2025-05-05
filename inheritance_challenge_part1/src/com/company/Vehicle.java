package com.company;

public class Vehicle {
    private String name;
    private int doors;
    private int wheels;

    public String getName() {
        return name;
    }

    public Vehicle(String name, int doors, int wheels) {
        this.name = name;
        this.doors = doors;
        this.wheels = wheels;

    }

    public void speed(double speed){
        System.out.println(+speed+" km/h");
    }

    public int getDoors() {
        return doors;
    }

    public int getWheels() {
        return wheels;
    }
}
