package com.company;


import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriods;
    private final Set<HeavenlyBody> satellite;

    public enum BodyTypes{
        PLANET,
        STARS,
        MOON,
        DWARF_PLANET,
    }

    public HeavenlyBody(String name, double orbitalPeriods, BodyTypes bodyTypes) {
        this.key=new Key(name,bodyTypes);
        this.orbitalPeriods = orbitalPeriods;
        this.satellite = new HashSet<>();

    }
    public static Key makeKey(String name,BodyTypes bodyTypes){
        return new Key(name,bodyTypes);
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriods() {
        return orbitalPeriods;
    }

    public Set<HeavenlyBody> getSatellite() {
        return new HashSet<>(this.satellite);
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
       if (this==obj){
           return true;
       }

       if (obj instanceof HeavenlyBody){
           HeavenlyBody theObject=(HeavenlyBody) obj;
           return this.key.equals(theObject.getKey());
       }
       return false;
    }

    public boolean addSatellite(HeavenlyBody moon){
        return this.satellite.add(moon);


    }

    @Override
    public String toString() {
        return this.key.name+" : "+this.key.bodyTypes+" , "+this.orbitalPeriods;
    }

    public static final class Key{
        private  String name;
        private  BodyTypes bodyTypes;

        public Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyTypes = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyTypes() {
            return bodyTypes;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode()+57+this.bodyTypes.hashCode();
        }

        @Override
        public final boolean equals(Object obj) {

            Key key=(Key) obj;
            if (this.name.equals(key.getName())){
                return this.bodyTypes.equals(key.getBodyTypes());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name+" : "+this.bodyTypes;
        }
    }
}
