package com.company;

public class Main {

    public static void main(String[] args) {
//        Player_without_encapsulation player = new Player_without_encapsulation();
//        player.name = "Tim";
//        player.health = 20;
//        player.weapon = "Sword";
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("Remaining health =  " + player.healthRemaining());
//
//        damage = 11;
//        player.health = 200;
//        player.loseHealth(damage);
//        System.out.println("Remaining health =  " + player.healthRemaining());

        //this code  from line 6 to 20 is not in proper encapsulation because player.health=200;is any where this should not modify any where in code and if we change the name in Player_without_encapslation class there is error so we have to change name in main class


        Player_with_encapsulation pl=new Player_with_encapsulation("any",78,"gun");
        System.out.println("initial health = " +pl.getHealth());
        pl.loseHealth(77);
        System.out.println("health = "+pl.getHealth());

    }
}
