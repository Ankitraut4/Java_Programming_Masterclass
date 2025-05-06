package com.company;

public class Main {

    public static void main(String[] args) {
        // Challenge.
        // Start with a base class of a Vehicle, then create a Car class that inherits from this base class.
        // Finally, create another class, a specific type of Car that inherits from the Car class.
        // You should be able to hand steering, changing gears, and moving (speed in other words).
        // You will want to decide where to put the appropriate state and behaviours (fields and methods).
        // As mentioned above, changing gears, increasing/decreasing speed should be included.
        // For you specific type of vehicle you will want to add something specific for that type of car.


        SuperCar superCar=new SuperCar(280);
        System.out.println("Name of Car : " +superCar.getName());
        System.out.println("Top Speed of Car : " +superCar.getTopSpeed()+" km/h");


        superCar.direction_of_stering(0);
        superCar.Acclaration(220);
        //superCar.Acclaration(10);
    }
}
