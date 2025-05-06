package com.company;

public class Vehicle {
    private String name;
    private int weight;

    private int direction;
    private int speed;

    public Vehicle(String name, int weight) {
        this.name = name;
        this.weight = weight;

        this.direction=0;
        this.speed=0;
    }

    public void direction_of_stering(int direction){
        this.direction=direction;
       System.out.println("vehicle stering is at "+direction+" degree");
    }

    public void move(int speed,int direction){
        this.direction=direction;
        this.speed=speed;
        System.out.println("the vehicle is moving with speed :"+speed+" km/h in "+direction+" degree");
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }
}
