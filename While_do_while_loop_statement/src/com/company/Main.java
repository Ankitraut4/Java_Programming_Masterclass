package com.company;

public class Main {

    public static void main(String[] args) {
//	int count=1;
//        while (count!=6){
//            System.out.println("loop is " +count);
//            count++;
//        }
//        //in while loop we have to increment the value to loop the condition upto given number of times
//        System.out.println("-----------------------");
//
//        count=1;
//        do {
//            System.out.println("loop is "+count);
//            count++;
//        }while (count!=6);

        //in do while loop the condition would we execute atleast once if it is false
        System.out.println("********************8");
        System.out.println(isEvenNumber(4));

//        int firstnumber=4;
//        int lastnumber=20;
//
//        while (firstnumber<=lastnumber){
//            firstnumber++;
//            if(!isEvenNumber(firstnumber)){
//                continue;
//            }
//            System.out.println("the even number is " +firstnumber);
//
//        }
        //task 2
        // Modify the while code above
        // Make it also record the total number of even numbers it has found
        // and break once 5 are found
        // and at the end, display the total number of even numbers found

        int firstnumber=4;
        int lastnumber=20;
        int count=0;
        while (firstnumber<=lastnumber){
            firstnumber++;
            if(!isEvenNumber(firstnumber)){
                continue;//if condition is true the continue statement skip all other code  (i.e line 49 to 52) in while and directly go back to while statement
            }
            System.out.println("the even number is " +firstnumber);
            count++;
            if (count==5){
                break;
            }
        }
        System.out.println("total even number count = "+count);
    }


    //task 1
    //create a method called isEvenNumber that takes a parameter of type int
    //its purpose is to determine if the argument passed to the method is
    //an even number or not
    //return true if an even number,otherwise return false;
    //call the method in main to check where the number is even for perticular range

    public static boolean isEvenNumber(int number){

        while (number%2==0){
            return true;

        }
        return false;
    }

}
