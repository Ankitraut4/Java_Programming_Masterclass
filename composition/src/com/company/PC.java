package com.company;

public class PC {
    private Case aCase;
    private Moniter amoniter;
    private Motherbord amotherbord;

    public PC(Case aCase, Moniter amoniter, Motherbord amotherbord) {
        this.aCase = aCase;
        this.amoniter = amoniter;
        this.amotherbord = amotherbord;
    }

    public void powerup(){
        aCase.pressPowersetup();
        drawlogo();
    }

    private void drawlogo(){
        System.out.println("*******WINDOW********");
        amoniter.drawPixel(720,480,"RED");
    }


    private Case getACase() {
        return aCase;
    }

    private Moniter getAmoniter() {
        return amoniter;
    }

    private Motherbord getAmotherbord() {
        return amotherbord;
    }
}
