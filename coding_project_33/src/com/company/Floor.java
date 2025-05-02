package com.company;

public class Floor {

    //in this 3 classes some method are not need as given in the program like get & set because it is not ask in program
    private double width;
    private double length;

    public Floor(double width,double length){
        if (width<0){
            this.width=0;
        }else {
            this.width=width;
        }
        if (length<0){
            this.length=0;
        }else {
            this.length=length;
        }
    }

    public double getArea(){
        return width*length;
    }


}
