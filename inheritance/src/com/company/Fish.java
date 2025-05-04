package com.company;

public class Fish extends Animal {
    private int fin;
    private int eyes;
    private int teeth;

    public Fish(String name, int size, int weight, int fin, int eyes, int teeth) {
        super(name, 1, 1, size, weight);
        this.fin = fin;
        this.eyes = eyes;
        this.teeth = teeth;
    }

   public void rest(){
        System.out.println("fissh.rest is called ");
    }

    private void musucles(){
        System.out.println("fish.musuvles is called");
    }

    private void fin(){
        System.out.println("fish.fin is called");
    }

    public void moving(){
        musucles();
        fin();
        move(15);
    }

    private void slow(){
        System.out.println("fish.slow is called");
    }
    private void bit(){
        System.out.println("fish.bit is called ");
    }

    public void restatNight(){
        System.out.println("fish.restatNight is called");
        sleep(10);
    }
    public void restatday(){
        System.out.println("fish.restatday is called ");
        sleep(4);

    }
}
