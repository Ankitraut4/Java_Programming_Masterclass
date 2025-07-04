package com.company;

public class Planet extends HeavenlyBody{
    public Planet(String name, double orbitalPeriods) {
        super(name, orbitalPeriods, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyTypes()==BodyTypes.MOON){
            return super.addSatellite(moon);
        }else {
            return false;
        }


    }
}
