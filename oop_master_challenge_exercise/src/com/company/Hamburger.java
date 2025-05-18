package com.company;

public class Hamburger {
    private String name;
    private String meat;
    private String breadRoll_type;
    private double price;


    private String AdditionalitemName1;
    private double Additionalitemprice1;

    private String AdditionalitemName2;
    private double Additionalitemprice2;

    private String AdditionalitemName3;
    private double Additionalitemprice3;

    private String AdditionalitemName4;
    private double Additionalitemprice4;

    public Hamburger(String name, String meat, String breadRoll_type, double price) {
        this.name = name;
        this.meat = meat;
        this.breadRoll_type = breadRoll_type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void additionalinHamburger1(String name , double price ){
        this.AdditionalitemName1=name;
        this.Additionalitemprice1=price;
    }

    public void additionalinHamburger2(String name,double price){
        this.AdditionalitemName2=name;
        this.Additionalitemprice2=price;
    }

    public void additionalinHamburger3(String name,double price){
        this.AdditionalitemName3=name;
        this.Additionalitemprice3=price;
    }
    public void additionalinHamburger4(String name,double price){
        this.AdditionalitemName4=name;
        this.Additionalitemprice4=price;
    }

    public double initilizationHamburder(){
        double baseprice=this.price;
        System.out.println("Hamburger name : "+this.name+"\n Type of meat : " +this.meat+ "\n type of Bread roll : "+this.breadRoll_type
        +"\n Base price of : "+getName()+" Hambergerr , without any additional : " +this.price+" rs");
        if (this.AdditionalitemName1!=null){
            baseprice+=Additionalitemprice1;
            System.out.println("Additional is : "+AdditionalitemName1+" , with extra charge of " +Additionalitemprice1+" rs");
        }
        if (this.AdditionalitemName2!=null){
            baseprice+=Additionalitemprice2;
            System.out.println("Additional is : "+AdditionalitemName2+" , with extra charge of " +Additionalitemprice2+" rs");

        }
        if (this.AdditionalitemName3!=null){
            baseprice+=Additionalitemprice3;
            System.out.println("Additional is : "+AdditionalitemName3+" , with extra charge of " +Additionalitemprice3+" rs");

        }
        if (this.AdditionalitemName4!=null){
            baseprice+=Additionalitemprice4;
            System.out.println("Additional is : "+AdditionalitemName4+" , with extra charge of " +Additionalitemprice4+" rs");

        }
        return baseprice;
    }

}
