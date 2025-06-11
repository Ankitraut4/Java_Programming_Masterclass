package com.company;

public class Parrot extends Bird implements canFly{
    public Parrot(String name) {
        super(name);
    }

    @Override
    public void canTalk() {
        System.out.println(getName()+" can talk");
    }

    @Override
    public void fly() {
        System.out.println(getName()+" can also fly ");
    }
}
