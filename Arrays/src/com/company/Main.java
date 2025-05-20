package com.company;

public class Main {

    public static void main(String[] args) {
        //way 1
//        int[]  arrayOfint= new int[5];
//        arrayOfint[4]=33;
//        arrayOfint[0]=13;
//        arrayOfint[1]=43;
//        System.out.println(arrayOfint[4]);

        //way 2
//        int[]  arrayOfint= {13,43,22,33,55};
//        System.out.println(arrayOfint[4]);

        //way 3
//        int[]  arrayOfint=new int[5];
//        for (int i=0;i<arrayOfint.length;i++){
//                arrayOfint[i]=i*10;
//        }
//        for (int i=0;i<arrayOfint.length;i++){
//            System.out.println("element "+i+" ,value of "+arrayOfint[i]);
//        }


        //way 4
        int[] arrayOfint = new int[5];
        for (int i=0;i<arrayOfint.length;i++){
            arrayOfint[i]=i*10;

        }
        printArray(arrayOfint);
    }
    public static void printArray(int[] array){
        for (int i=0;i<array.length;i++){

            System.out.println("element "+i+" ,value "+array[i]);
        }
    }
}
