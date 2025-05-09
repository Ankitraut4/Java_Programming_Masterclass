package com.company;

public class Main {

    public static void main(String[] args) {
     Dimension dimension=new Dimension(5,8,5);
	Case acase=new Case("A00","Dell",240,dimension);


	//Resolution resolution=new Resolution(2500,1400);
        //we can modify the line 10 in line 12 by
	Moniter amoniter=new Moniter("beast","Acer",4,new Resolution(2500,1400));

	Motherbord amotherbord=new Motherbord("gxt","b_22",4,2);

	PC pc=new PC(acase,amoniter,amotherbord);
	//pc.getACase().pressPowersetup();
	//pc.getAmoniter().drawPixel(720,480,"RED");
		//here line 17 & 18 is not useable because we made ACase / Amoniter etc because the field are private

		pc.powerup();
    }
}
