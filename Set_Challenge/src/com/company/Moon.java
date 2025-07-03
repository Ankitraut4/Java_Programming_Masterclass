package com.company;

public class Moon extends HeavenlyBody{
    public Moon(String name, double orbitPeriod) {
        super(name, orbitPeriod, BodyTypes.MOON);
    }
}
