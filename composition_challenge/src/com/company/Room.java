package com.company;

import java.awt.geom.Area;

public class Room {

    private Furniture afurniture;
    private Wall awall;
    private Color color;

    public Room(Furniture afurniture, Wall awall, Color color) {
        this.afurniture = afurniture;
        this.awall = awall;
        this.color = color;
    }

    public void Area(){
        awall.Area();
        Cost();



    }
    public void Cost(){
        System.out.println("cost = " +color.getCost()+" /sq.feet");
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Furniture getAfurniture() {
        return afurniture;
    }

    private Wall getAwall() {
        return awall;
    }
}
