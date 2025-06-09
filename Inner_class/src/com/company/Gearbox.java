package com.company;

import java.util.ArrayList;

public class Gearbox {
    private int numberOfGear;
    private int currentGear=0;
    private ArrayList<Gear> gears;
    private boolean clutchIn;

    public Gearbox(int numberOfGear) {
        this.numberOfGear = numberOfGear;
        this.gears=new ArrayList<Gear>();
        for (int i=0;i<numberOfGear;i++){
            addGear(i,i*1.5);
        }
    }
    public void clutchIn(boolean in){
        this.clutchIn=in;
    }
    public void addGear(int gearNum,double ratio){
        if (gearNum>0 && gearNum<numberOfGear){
            this.gears.add(new Gear(gearNum,ratio));
        }
    }
    public void changeGear(int gearNumber){
        if (clutchIn && gearNumber>0 && gearNumber<gears.size()){
            this.currentGear=gearNumber;
            System.out.println("Gear changed to "+gearNumber);
        }else {
            System.out.println("clutch is not press for changing gear into #"+gearNumber+ " or gear number is out of limit");
        }

    }
    public double wheelSpeed(int revs) {
        if (clutchIn) {
            System.out.println("please remove foot from clutch ");
        }
            return revs * this.gears.get(currentGear).getRatio();

    }

    private class Gear{
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int revs){
            return this.ratio*(revs);
        }
    }
}
