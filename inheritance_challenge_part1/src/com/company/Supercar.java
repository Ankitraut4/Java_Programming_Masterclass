package com.company;

public class Supercar extends Car{
private int topspeed;
private int gear;
    public Supercar(String name,int gear, int topspeed) {
        super(name,gear);
        this.topspeed=topspeed;
        this.gear=gear;
    }

    public int getTopspeed() {
        return topspeed;
    }

    public int getGear() {
        return gear;
    }

    public void _0to60insec() {
        _0to60(6);
    }

    public void speedatcomfornt_mode(){
        System.out.println("top speed in comfort mode : " );
        speed(180);
    }

    public void speedatsport_mode(){
        System.out.println("top speed in sport mode : ");
        speed(300);
    }

}
