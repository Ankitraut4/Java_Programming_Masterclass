package com.company;

import javax.net.ssl.SSLContext;

public class HealthyBurger extends Hamburger {
    private String Extra1Name;
    private double Extra1Price;

    private String Extra2Name;
    private double Extra2Price;

    public HealthyBurger( String meat,  double price) {
        super("Healthy ", meat, "Brown rye", price);
    }

    public void AdditioninHealthy1(String name,double price){
        this.Extra1Name=name;
        this.Extra1Price=price;
    }

    public void AdditioninHealthy2(String name,double price){
        this.Extra2Name=name;
        this.Extra2Price=price;
    }

    @Override
    public double initilizationHamburder() {
        double healthyprice= super.initilizationHamburder();
        if (this.Extra1Name!=null){
            healthyprice+=Extra1Price;
            System.out.println("Additional is : "+Extra1Name+" , with extra charge of " +Extra1Price+" rs");
        }
        if (this.Extra2Name!=null){
            healthyprice+=Extra2Price;
            System.out.println("Additional is : "+Extra2Name+" , with extra charge of " +Extra2Price+" rs");

        }
        return healthyprice;
    }
}
