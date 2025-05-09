package com.company;

import java.awt.*;

public class Case {

    private String name;
    private String manifacture;
    private int powersupply;
    private Dimension dimension;

    public Case(String name, String manifacture, int powersupply, Dimension dimension) {
        this.name = name;
        this.manifacture = manifacture;
        this.powersupply = powersupply;
        this.dimension = dimension;
    }

    public void pressPowersetup(){
        System.out.println("power button is pressed ");
    }

    public String getName() {
        return name;
    }

    public String getManifacture() {
        return manifacture;
    }

    public int getPowersupply() {
        return powersupply;
    }

    public Dimension getDimension() {
        return dimension;
    }
}
