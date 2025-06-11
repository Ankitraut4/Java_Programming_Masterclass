package com.company;

public class Penguin extends Bird implements canFly{
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void canTalk() {
        System.out.println(getName()+" can not talk");
    }

    @Override
    public void fly() {
        System.out.println(getName()+ " can not fly they use there wing to swim");
    }
}
