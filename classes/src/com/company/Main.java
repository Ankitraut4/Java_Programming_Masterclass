package com.company;

public class Main {

    public static void main(String[] args) {
	Car lamborgini=new Car();
		System.out.println("model is " +lamborgini.getModel());
        //here on line 7 "model is null" is return because be did on set the model



		lamborgini.setModel("aventador");
		System.out.println("model is " +lamborgini.getModel());

		lamborgini.setModel("centanario");
		System.out.println("model is " +lamborgini.getModel());

		lamborgini.setModel("seian");
		System.out.println("model is " +lamborgini.getModel());
    }
}
