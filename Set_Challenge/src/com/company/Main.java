package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
private static Map<HeavenlyBody.Key,HeavenlyBody> solarSystems=new HashMap<>();
private static Set<HeavenlyBody> planets=new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody pluto=new Planet("Pluto",100);
        planets.add(pluto);
        solarSystems.put(pluto.getKey(),pluto);

        HeavenlyBody earth=new Planet("Earth",88);
        planets.add(earth);
        solarSystems.put(earth.getKey(),earth);

        HeavenlyBody mars=new Planet("Mars",22);
        planets.add(mars);
        solarSystems.put(mars.getKey(),mars);

        HeavenlyBody marsMoon=new Moon("Phobos",2);
        solarSystems.put(marsMoon.getKey(),marsMoon);
        mars.addSatellite(marsMoon);

        marsMoon=new Moon("Denimos",4);
        solarSystems.put(marsMoon.getKey(),marsMoon);
        mars.addSatellite(marsMoon);



        HeavenlyBody jupiter=new Planet("Jupiter",5555);
        planets.add(jupiter);
        solarSystems.put(jupiter.getKey(),jupiter);
        HeavenlyBody jupiterMoon=new Moon("europa",33);
        solarSystems.put(jupiter.getKey(), jupiterMoon);
        jupiter.addSatellite(jupiterMoon);

        jupiterMoon=new Moon("ganymede",33);
        solarSystems.put(jupiterMoon.getKey(), jupiterMoon);
        jupiter.addSatellite(jupiterMoon);

        jupiterMoon=new Moon("Io",33);
        solarSystems.put(jupiterMoon.getKey(), jupiterMoon);
        jupiter.addSatellite(jupiterMoon);

        HeavenlyBody neptune=new Planet("Neptune",5555);
        planets.add(neptune);
        solarSystems.put(neptune.getKey(),neptune);

        HeavenlyBody saturn=new Planet("Saturn",5555);
        planets.add(saturn);
        solarSystems.put(saturn.getKey(),saturn);

        HeavenlyBody venus=new Planet("Venus",5555);
        planets.add(venus);
        solarSystems.put(venus.getKey(),venus);

        HeavenlyBody uranus=new Planet("Uranus",5555);
        planets.add(uranus);
        solarSystems.put(uranus.getKey(),uranus);

        HeavenlyBody mercury=new Planet("Mercury",5555);
        planets.add(mercury);
        solarSystems.put(mercury.getKey(),mercury);

        HeavenlyBody moon=new Moon("Moon",27);
        solarSystems.put(moon.getKey(),moon);
        earth.addSatellite(moon);

        //5. Two bodies with the same name but different designations can be added to the
        // same set.(i.e Ankit as planet and Ankit as drawf_planet which are different bodyType)so
        // determine heavenlyBody as abstract class So we have to use specific class or bodyType
        HeavenlyBody p3=new Planet("Ankit",100);
        planets.add(p3);
        solarSystems.put(p3.getKey(),p3);

        HeavenlyBody p1=new Dwarf_Planets("Ankit",7);
        planets.add(p1);
        solarSystems.put(p1.getKey(),p1);



//Attempting to add a duplicate to a Map results in the original being replaced
//        by the new object.(pluto get change in solar system in map )
         pluto=new Planet("Pluto",300);
        planets.add(pluto);




        System.out.println("Planets are ");
        for (HeavenlyBody planet: planets){
            System.out.println(""+planet.getKey());
        }
        System.out.println("");

        HeavenlyBody planet=solarSystems.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moon on Planet : " +planet.getKey().getName());
        for (HeavenlyBody mo: planet.getSatellite() ){
            System.out.println(mo);
        }


        System.out.println();
        //dispaly all moon by union as set of union(addAll() is commond/operation in java for union) is all similar element where duplication is not allowed
       Set<HeavenlyBody> moons=new HashSet<>();
       for (HeavenlyBody pl : planets ){
           moons.addAll(pl.getSatellite());
       }
        System.out.println("All moons in solar System ");
       for (HeavenlyBody mo:moons){
           System.out.println(mo);
       }
        System.out.println();

       HeavenlyBody earth1=new Planet("Earth",1000);
       planets.add(earth1);
       solarSystems.put(earth1.getKey(),earth1);

       for (HeavenlyBody p: planets){
           System.out.println(p);
       }

        System.out.println("");
       //2. a.equals(b) must return the same result as b.equals(a) - equals is symmetric.
        HeavenlyBody earth4=new Planet("Earth",88);
        HeavenlyBody earth5=new Planet("Earth",1);
        System.out.println(earth5.equals(earth4));//here we are comparing name and bodyType which are equal hence it represent true as earth5 is instance of earth4
        System.out.println(earth4.equals(earth5));//here we are comparing name and bodyType which are equal hence it represent true as earth4 is instance of earth 5
        System.out.println(pluto.equals(earth4));
        System.out.println(earth4.equals(pluto));
        System.out.println();

        solarSystems.put(pluto.getKey(), pluto);
        System.out.println(solarSystems.get(HeavenlyBody.makeKey("Pluto",HeavenlyBody.BodyTypes.PLANET)));
        System.out.println(solarSystems.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET)));


        System.out.println();
        System.out.println("solar system:--> ");
        for (HeavenlyBody heavenlyBody:solarSystems.values()){
            System.out.println(heavenlyBody);
        }
    }




}
