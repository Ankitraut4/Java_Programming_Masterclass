package com.company;

public class Main {

    public static void main(String[] args) {
        // Create a single room of a house using composition.
        // Think about the things that should be included in the room.
        // Maybe physical parts of the house but furniture as well
        // Add at least one method to access an object via a getter and
        // then that objects public method as you saw in the previous video
        // then add at least one method to hide the object e.g. not using a getter
        // but to access the object used in composition within the main class
        // like you saw in this video.

        Color color=new Color("red","asian",3);
        Wall wall=new Wall(5,4,color);



        Typeoffurniture typeoffurniture=new Typeoffurniture("bed");
        Furniture furniture=new Furniture("ikei",typeoffurniture);

        Room room=new Room(furniture,wall,color);
        room.getAfurniture().getTypeoffurniture().whichfurniture();
        room.Area();



    }
}
