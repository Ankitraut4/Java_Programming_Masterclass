package com.company;

public class Color {
    private String nameofmanifacture;
    private String color;
    private int cost;

    public Color(String nameofmanifacture, String color,int cost) {
        this.nameofmanifacture = nameofmanifacture;
        this.color = color;
        this.cost=cost;
    }



    public int getCost() {
        return cost;
    }

    public String getNameofmanifacture() {
        return nameofmanifacture;
    }

    public String getColor() {
        return color;
    }
}
