package com.company;

public class Wall {
    private int height;
    private int width;
    private Color color;

    public Wall(int height, int width, Color color) {
        this.height = height;
        this.width = width;

    }
    public void Area(){
        System.out.println("Area of wall =" +(height*width));

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }
}
