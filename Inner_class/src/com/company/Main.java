package com.company;

import java.util.Scanner;

public class Main {
private static Scanner scanner=new Scanner(System.in);
private static Button buttonPrint=new Button("PRINT");
    public static void main(String[] args) {
        Gearbox lamborgini=new Gearbox(8);
      //  Gearbox.Gear first=lamborgini.new Gear(1,5.6);//here we Define Gear inner class private because we want outerclass to create instance
//        Gearbox.Gear second=new Gearbox.Gear(2,4.55);//this two decleration(line 8,9) is wrong as .new should be required to create an instance of Gear class
//        Gearbox.Gear third=new  Gearbox.Gear(3,7);
      //  System.out.println("DriveSpeed = "+first.driveSpeed(1000));



//        lamborgini.addGear(1,4.5);//for creating simplicity as change gear at ratio by car manifacture is define so we give a for loop to predefine ratio for each gear change
//        lamborgini.addGear(2,6.6);
//        lamborgini.addGear(3,9);
      lamborgini.clutchIn(true);
        lamborgini.changeGear(2);
        lamborgini.clutchIn(false);
        System.out.println("Wheel Speed = "+lamborgini.wheelSpeed(1000));
        lamborgini.changeGear(3);
        lamborgini.clutchIn(true);
        lamborgini.changeGear(3);
        lamborgini.clutchIn(false);
        System.out.println("Wheel Speed = " +lamborgini.wheelSpeed(2000));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
      //  System.out.println("below output for local class from button class");

//        class ClickListner implements Button.OnClickListener{
//            public ClickListner() {
//                System.out.println("Constructor call");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title+" was clicked");
//            }
//
//        }
//buttonPrint.setOnClickListener(new ClickListner());//from line 32 to 43 is a local class use for perticular button and this code is limited to this scope only
//here below we are using anonyymous class
        System.out.println("below output for anonymous class");
        buttonPrint.setOnClickListener(new Button.OnClickListener() {//here new object has no name and is declared in the expression passed as parameter to button set on click listner method.
            @Override
            public void onClick(String title) {
                System.out.println(title+"was clicked ");
            }
        });
        listen();
    }
    private static void listen(){
        boolean quit=false;

        while (!quit){
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    quit=true;
                    break;
                case 1:
                    buttonPrint.onClick();
                    break;
            }
        }
    }
}
