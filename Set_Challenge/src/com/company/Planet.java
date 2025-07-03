package com.company;

public class Planet extends HeavenlyBody{
    public Planet(String name, double orbitPeriod) {
        super(name, orbitPeriod,BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (satellite.getKey().getBodyTypes()==BodyTypes.MOON){
            return super.addSatellite(satellite);
        }else {
            return false;
        }
    }

}
