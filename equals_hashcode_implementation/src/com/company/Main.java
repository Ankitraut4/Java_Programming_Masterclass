package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    //when use add another object of same name earth but different orbitperiod then it is add to planet set but this should not happen,
    //because set does not contain duplication so to avoid that we have to override the hashcode and equals method
private static Map<String,HeavenlyBody> solarSystems=new HashMap<>();
private static Set<HeavenlyBody> planets=new HashSet<>();
    public static void main(String[] args) {

        HeavenlyBody earth=new HeavenlyBody("Earth",88);
        planets.add(earth);
        solarSystems.put("Earth",earth);

        HeavenlyBody mars=new HeavenlyBody("Mars",22);
        planets.add(mars);
        solarSystems.put("Mars",mars);

        HeavenlyBody marsMoon=new HeavenlyBody("Phobos",2);
        solarSystems.put("Phobos",marsMoon);
        mars.addMoon(marsMoon);

        marsMoon=new HeavenlyBody("Denimos",4);
        solarSystems.put("Denimos",marsMoon);
        mars.addMoon(marsMoon);



        HeavenlyBody jupiter=new HeavenlyBody("Jupiter",5555);
        planets.add(jupiter);
        solarSystems.put("Jupiter",jupiter);
        HeavenlyBody jupiterMoon=new HeavenlyBody("europa",33);
        solarSystems.put("europa",jupiterMoon);
        jupiter.addMoon(jupiterMoon);

        jupiterMoon=new HeavenlyBody("ganymede",33);
        solarSystems.put("ganymede",jupiterMoon);
        jupiter.addMoon(jupiterMoon);

        jupiterMoon=new HeavenlyBody("Io",33);
        solarSystems.put("Io",jupiterMoon);
        jupiter.addMoon(jupiterMoon);

        HeavenlyBody neptune=new HeavenlyBody("Neptune",5555);
        planets.add(neptune);
        solarSystems.put("Neptune",neptune);

        HeavenlyBody saturn=new HeavenlyBody("Saturn",5555);
        planets.add(saturn);
        solarSystems.put("Saturn",saturn);

        HeavenlyBody venus=new HeavenlyBody("Venus",5555);
        planets.add(venus);
        solarSystems.put("Venus",venus);

        HeavenlyBody uranus=new HeavenlyBody("Uranus",5555);
        planets.add(uranus);
        solarSystems.put("Uranus",uranus);

        HeavenlyBody mercury=new HeavenlyBody("Mercury",5555);
        planets.add(mercury);
        solarSystems.put("Mercury",mercury);

        HeavenlyBody moon=new HeavenlyBody("Moon",27);
        solarSystems.put("Moon",moon);
        earth.addMoon(moon);


        System.out.println("Planets are ");
        for (HeavenlyBody planet: planets){
            System.out.println(" : "+ planet.getName());
        }
        System.out.println("");

        HeavenlyBody planet=solarSystems.get("Jupiter");
        System.out.println("Moon on Planet : " +planet.getName());
        for (HeavenlyBody mo: planet.getInSatellite() ){
            System.out.println(": "+mo.getName());
        }

        System.out.println("");



        //dispaly all moon by union as set of union(addAll() is commond/operation in java for union) is all similar element where duplication is not allowed
       Set<HeavenlyBody> moons=new HashSet<>();
       for (HeavenlyBody pl : planets ){
           moons.addAll(pl.getInSatellite());
       }
        System.out.println("All moons in solar System ");
       for (HeavenlyBody mo:moons){
           System.out.println(": "+mo.getName());
       }

       HeavenlyBody earth1=new HeavenlyBody("Earth",1000);
       planets.add(earth1);
       solarSystems.put("Earth",earth1);

       for (HeavenlyBody p: planets){
           System.out.println(p.getName()+"   "+p.getOrbitPeriod());//to avoid this we override equals and hashcode method
       }
    }



}
