package com.company;

public class Main {

    public static void main(String[] args) {

        SimpleCalculator calculator=new SimpleCalculator();

        calculator.setFirstNumber(7.0);
        calculator.setSecondNumber(3.0);
        System.out.println("first num = "+calculator.getFirstNumber());
        System.out.println("second num = "+calculator.getSecondNumber());
        System.out.println("Addition  = " +calculator.getAdditionResult());
        System.out.println("Subtraction = " +calculator.getSubtractionResult());
        System.out.println("mul = " +calculator.getMultiplicationResult());
        System.out.println("Div = " +calculator.getDivisionResult());


    }
}
