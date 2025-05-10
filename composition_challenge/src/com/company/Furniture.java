package com.company;

public class Furniture {

    private String manifacture;
    private Typeoffurniture typeoffurniture;

    public Furniture( String manifacture, Typeoffurniture typeoffurniture) {

        this.manifacture = manifacture;
        this.typeoffurniture = typeoffurniture;
    }


    public String getManifacture() {
        return manifacture;
    }

    public Typeoffurniture getTypeoffurniture() {
        return typeoffurniture;
    }
}
