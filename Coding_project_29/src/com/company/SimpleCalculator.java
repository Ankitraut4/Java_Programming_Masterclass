package com.company;

public class SimpleCalculator {

    private double firstNumber=0;
    private double secondNumber=0;

    public double getFirstNumber(){
        return this.firstNumber;
    }

    public double getSecondNumber(){
        return this.secondNumber;
    }

    public void setFirstNumber(double firstNumber){
        this.firstNumber=firstNumber;
    }
    public void setSecondNumber(double secondNumber){
        this.secondNumber=secondNumber;
    }
    public double getAdditionResult(){
        return (firstNumber+secondNumber);
    }
    public double getSubtractionResult(){
        return (firstNumber-secondNumber);
    }

    public double getMultiplicationResult(){
        return (firstNumber*secondNumber);
    }

    public double getDivisionResult(){
        if(secondNumber==0){
            return 0;
        }
        return firstNumber/secondNumber;
    }

}
