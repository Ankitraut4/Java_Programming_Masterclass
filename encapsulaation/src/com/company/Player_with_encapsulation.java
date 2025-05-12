package com.company;

public class Player_with_encapsulation {

    private String name;
    //here on 7 if we change the varible name the method would return same output without changing constructor parameter name and getmethod name
    private int healing = 100;//here we initilised value to 100(here health deadult value if 100 is any put greater value then 100 there deafult value would return 100)
    private String weapon;

    public Player_with_encapsulation(String name, int health, String weapon) {
        this.name = name;
        if (health>0 && health<=100){
            this.healing = health;

        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.healing = this.healing - damage;
        if(this.healing <=0) {
            System.out.println("Player knocked out");

        }
    }

    public int getHealth() {
        return healing;
    }
}
