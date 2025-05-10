package com.company;

public class Typeoffurniture {
    private String name;


    public Typeoffurniture(String name) {
       this.name=name;
    }

    public void whichfurniture(){
        System.out.println("type of furniture in room :" +name);
    }

    public void Dimension(int height, int width){
        System.out.println("height = "+height+" width = "+width);
    }

    public String getName() {
        return name;
    }
}
