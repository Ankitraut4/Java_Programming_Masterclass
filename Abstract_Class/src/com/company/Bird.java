package com.company;

public abstract  class Bird extends Animal{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName()+" is eating ");
    }

    @Override
    public void breath() {
        System.out.println(getName()+ " breat in , out");
    }

    public abstract void canTalk();
}
