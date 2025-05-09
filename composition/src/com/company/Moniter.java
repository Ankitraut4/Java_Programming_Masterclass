package com.company;

public class Moniter {
    private String name;
    private String manifacture;
    private int size;
    private Resolution resolution;

    public Moniter(String name, String manifacture, int size, Resolution resolution) {
        this.name = name;
        this.manifacture = manifacture;
        this.size = size;
        this.resolution = resolution;
    }

 public void drawPixel(int x,int y,String color){
     System.out.println(" pixel at "+x+" , "+y+" :color " +color);
 }

    public String getName() {
        return name;
    }

    public String getManifacture() {
        return manifacture;
    }

    public int getSize() {
        return size;
    }

    public Resolution getResolution() {
        return resolution;
    }
}
