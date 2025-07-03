package com.company;

import java.util.HashSet;
import java.util.Set;
public  class HeavenlyBody {
    private final Set<HeavenlyBody> inSatellite;
    private final Key key;
    private final double orbitPeriod;


    public enum BodyTypes{
        PLANET,
        DWARF_PLANET,
        MOON,
        ASTRONOD,
        STAR,

    }

    public HeavenlyBody(String name, double orbitPeriod,BodyTypes bodyTypes) {
        this.key=new Key(name,bodyTypes);
        this.orbitPeriod = orbitPeriod;
        this.inSatellite=new HashSet<>();

    }

    public Key getKey() {
        return key;
    }

    public static Key makeKey(String name,BodyTypes bodyTypes){//here we use static to use this method without creating instance for HeavenlyBody
        return new Key(name,bodyTypes);
    }

    public double getOrbitPeriod() {
        return orbitPeriod;
    }


    public boolean addSatellite(HeavenlyBody satellite){
        return this.inSatellite.add(satellite);
    }

    public Set<HeavenlyBody> getInSatellite() {
        return new HashSet<>(this.inSatellite);
    }
    @Override
    public final boolean equals(Object obj){
        if (this==obj){
            return true;
        }
        if (obj instanceof HeavenlyBody){
            HeavenlyBody theObj=(HeavenlyBody) obj;
            return this.key.equals(theObj.getKey());
        }
        return false;

    }
    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.name+" : "+this.key.bodyTypes+" , "+this.orbitPeriod;
    }
    public static final class Key{
        private String name;
        private BodyTypes bodyTypes;

        public Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyTypes = bodyTypes;
        }

        public String getName() {
            return name;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode()+57+this.bodyTypes.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj==this){
                return true;
            }
            Key key=(Key) obj;
            if (this.name.equals(key.getName())){
                return (this.bodyTypes==key.getBodyTypes());
            }
            return false;
        }


        public String toString() {
            return this.name+" : "+this.bodyTypes;
        }

        public BodyTypes getBodyTypes() {
            return bodyTypes;
        }
    }

}

