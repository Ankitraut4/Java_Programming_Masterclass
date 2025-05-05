package com.company;

public class Car extends Vehicle {




    public Car(String name, int doors) {
        super(name, doors, 4);

    }

    public void _0to60(int sec){
        System.out.println(" 0 to 60 in sec : "+sec+" sec");
    }

    @Override
    public void speed(double speed) {
        super.speed(speed);
    }

}

