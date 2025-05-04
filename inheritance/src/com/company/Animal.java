package com.company;

public class Animal {

    private String name;
    private int body;
    private int brain;
    private int size;
    private int weight;

    public Animal(String name, int body, int brain, int size, int weight) {
        this.name = name;
        this.body = body;
        this.brain = brain;
        this.size = size;
        this.weight = weight;
    }

    public void eat(){
        System.out.println("animal.eat() is called");
    }

    public void move(int speed){
        System.out.println("animal.move() is called with speed " +speed);
    }

    public void sleep(int hour){
        System.out.println("animal.sleep is called , "     +hour+ " hours");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public void setBrain(int brain) {
        this.brain = brain;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
