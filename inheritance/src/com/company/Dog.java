package com.company;

public class Dog extends Animal {
    private int legs;
    private int eyes;
    private int tail;
    private String hairtype;

    public Dog(String name,  int size, int weight, int legs, int eyes, int tail, String hairtype) {
        super(name, 1, 1, size, weight);
        this.legs = legs;
        this.eyes = eyes;
        this.tail = tail;
        this.hairtype = hairtype;
    }

    private void chew(){
        System.out.println("dog.chew is called");
    }

    @Override
    public void eat() {
        chew();
        super.eat();
    }


   public void walk(){
        System.out.println("dog.walk called");
        move(2);

    }

 public void run(){
        System.out.println("dog.run called");
           move(7);
    }

    public void restatNight(){
        System.out.println("dog.restatNight is called");
        sleep(8);
    }
    public void restatday(){
        System.out.println("dog.restatday is called ");
        sleep(2);

    }

}
