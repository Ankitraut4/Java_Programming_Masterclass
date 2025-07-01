package com.company;

import java.util.HashSet;
import java.util.Set;
//this code is not ideal for universe as there can be many planets,solarsystem,etc the best way is to extent from HeavenlyBody for different element like planets,astronods,etc
//but you can use this type of program for creating specific block for storing different mooms fpr sprcific planets
public final class HeavenlyBody {
    private final Set<HeavenlyBody> inSatellite;
    private final String name;
    private final double orbitPeriod;

    public HeavenlyBody(String name, double orbitPeriod) {
        this.name = name;
        this.orbitPeriod = orbitPeriod;
        this.inSatellite=new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitPeriod() {
        return orbitPeriod;
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.inSatellite.add(moon);
    }

    public Set<HeavenlyBody> getInSatellite() {
        return new HashSet<>(this.inSatellite);
    }
    @Override
    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }
        System.out.println("this.getClass is called "+this.getClass());//this is for testing only
        System.out.println("obj.getClass is called "+obj.getClass());//this is for testing only
        if ((obj==null)|| (obj.getClass()!=this.getClass())){
            return false;
        }
        String objName=((HeavenlyBody) obj).getName();//here we cast heavenlyBody to obj(object name)
        return this.name.equals(objName);

    }
    //if we override equals then it is required to overide the hashcode to implement the change or avoiding the duplication

    @Override
    public int hashCode() {
        System.out.println("hash is called ");
        return this.name.hashCode()+57;//here we use name because here we only want to compare name and add 57 as we want non-zero input for hashes
    }

    //after overiddeing both hashcode and equals(from 34 line  to 52) Earth 1000 is remove/not add to set
}
