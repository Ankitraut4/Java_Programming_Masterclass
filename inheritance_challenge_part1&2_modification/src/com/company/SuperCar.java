package com.company;

public class SuperCar extends Car{
    private int topSpeed;



    public SuperCar( int topSpeed) {
        super("Aventador SVJ", 2034, 2, 4,6);
        this.topSpeed = topSpeed;


    }

    public void Acclaration(int rate){

        int newvelocity=rate;
        if(newvelocity==0){
            stop();
        }else if(newvelocity<=20){
            gear(1);
        }else if(newvelocity>20 && newvelocity<=50){
            gear(2);
        }else if(newvelocity>50 && newvelocity<=101){
            gear(3);
        }else if(newvelocity>101 && newvelocity<=165){
            gear(4);
        }else if(newvelocity>165&&newvelocity<=202){
            gear(5);
        }else if(newvelocity>202 && newvelocity<=280){
            gear(6);
        }
        if (newvelocity>0){
            changeinmove(newvelocity,getDirection());
        }
    }

    public int getTopSpeed() {
        return topSpeed;
    }
}
