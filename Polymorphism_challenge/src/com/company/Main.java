package com.company;


class Car{
    private String name;
    private boolean engine;
    private int cylinder;
    private int wheels;

    public Car(String name, int cylinder) {
        this.name = name;
        this.engine = true;
        this.cylinder = cylinder;
        this.wheels = 4;
    }public String startEngine(){
        return "car().Engine -> On";
    }
    public String accelarate(){
        return "car().Car is in Motion";
    }
    public  String brake(){
        return  "car().Car -> stop";
    }

    public String getName() {
        return name;
    }

    public int getCylinder() {
        return cylinder;
    }
}

class lambo extends Car{
    public lambo() {
        super("lambo svj", 4);
    }

    @Override
    public String startEngine() {
       return getClass().getSimpleName()+" -> on ";//here we use this  getClass().getSimpleName() to get name of class
    }

    @Override
    public String accelarate() {
        return getClass().getSimpleName()+" car is in speed of 50 km/h";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName()+" -> stop in 3sec";
    }

}
class mecc extends Car {
    public mecc() {
        super("mecc", 2);
    }



    @Override
    public String accelarate() {
        return "car is in speed 10km/h";
    }


}
public class Main {
    public static void main(String[] args) {
        // We are going to go back to the car analogy.
        // Create a base class called Car
        // It should have a few fields that would be appropriate for a generice car calss.
        // engine, cylinders, wheels, etc.
        // Constructor should initialize cylinders (number of) and name, and set wheels to 4
        // and engine to true. Cylinders and names would be passed parameters.
        //
        // Create appropriate getters
        //
        // Create some methods like startEngine, accelerate, and brake
        //
        // show a message for each in the base class
        // Now create 3 sub classes for your favorite vehicles.
        // Override the appropriate methods to demonstrate polymorphism in use.
        // put all classes in the one java file (this one).

        lambo  lambo=new lambo();
        System.out.println("car name = "+lambo.getName()+"\n"+"no.of cylinder "+lambo.getCylinder()+"\n"
                                    +"car engine status :"+lambo.startEngine()+"\n"+"car acc : "+lambo.accelarate()+"\n"+"car bake : "+lambo.brake());
        System.out.println("");
        mecc mecc=new mecc();
        System.out.println("car name = "+mecc.getName()+"\n"+"no.of cylinder "+mecc.getCylinder()+"\n"
                +"car engine status :"+mecc.startEngine()+"\n"+"car acc : "+mecc.accelarate()+"\n"+"car bake : "+mecc.brake());
    }


}
