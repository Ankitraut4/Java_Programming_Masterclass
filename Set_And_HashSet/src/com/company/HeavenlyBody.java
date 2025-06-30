package com.company;

import java.util.HashSet;
import java.util.Set;

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
}
