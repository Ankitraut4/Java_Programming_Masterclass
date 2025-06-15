package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    public String name;

    public League(String name) {
        this.name = name;
    }

    ArrayList<T> league=new ArrayList<>();
public void addTeam(T teams){
    if (league.contains(teams)){
        System.out.println(teams.getName()+" already exist");
    }else {
        league.add(teams);
    }
}
    public void print(){
        Collections.sort(league);
        for (T  t: league){
            System.out.println(t.getName()+" --> "+t.rating()+" POINTS");
        }
    }
}
