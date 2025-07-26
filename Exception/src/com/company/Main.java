package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//	int x=12;
//	int y=0;
//
//        System.out.println(divideEAFP(x,y));
//        System.out.println(divideLBYL(x,y));

       int x=0;
        System.out.println("x = "+getIntLBYL());
        System.out.println("x = "+getTntEAFP());
        System.out.println("x = "+getInt(x));//this terminate /corrupt the program as it does not use exception handling or does not handle exception

    }

  public  static  int getInt(int x){//it will terminate or corrupt program
      Scanner scanner=new Scanner(System.in);
      System.out.println("please enter integer ");
      return x=scanner.nextInt();

  }
  public static int getIntLBYL(){
        Scanner scanner=new Scanner(System.in);
        boolean isValid=true;
      System.out.println("please enter integer ");
        String input=scanner.next();
        for (int i=0;i<input.length();i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
                return Integer.parseInt(input);
            }

       return 0;
  }

 public static int getTntEAFP(){
     Scanner scanner=new Scanner(System.in);
     System.out.println("please enter integer ");
    try {
        return scanner.nextInt();
    }catch (InputMismatchException e){
        return 0;
    }

    }





    public static int divide(int x, int y){//this method will through exception and that will corrupt program if y is put as 0
        //so we use to below method to handle exception
        return x/y;
    }

    public static int divideLBYL(int x , int y){//this initially check if y=0 then perform operation
        if (y!=0){
            return x/y;
        }
        return 0;
    }

    public static int divideEAFP(int x,int y){//this method handle exception by performing operation and then catching the exception
        //in catch block
        try {
            return x/y;
        }catch (ArithmeticException e){
            return 0;
        }
    }
}
