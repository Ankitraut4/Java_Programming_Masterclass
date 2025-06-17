package com.example.game;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon="sward";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public List<String> write() {
     List<String> values=new ArrayList<>();
     values.add(0,name);
     values.add(1,""+hitPoints);//here int is required string so we use ""+hitpoint to convert it into string
     values.add(2,""+strength);
     values.add(3,weapon);
     return values;
    }

    @Override
    public void read(List<String> savedValues) {
if (savedValues!=null && savedValues.size()>0){
    this.name=savedValues.get(0);
    this.hitPoints=Integer.parseInt(savedValues.get(1));//here we use Integer.parseInt(savedValues.get(1)) because in write we convert it into String so it required to convert back to int
    this.strength=Integer.parseInt(savedValues.get(2));
    this.weapon=savedValues.get(3);

}
    }

    @Override
    public String toString() {
        return "Players{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
