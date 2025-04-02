package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("10,000 at 2% interest rate = "+calculateinterest(10000,2));
        System.out.println("10,000 at 3% interest rate = "+calculateinterest(10000,3));
        System.out.println("10,000 at 4% interest rate = "+calculateinterest(10000,4));
        System.out.println("10,000 at 5% interest rate = "+calculateinterest(10000,5));
        System.out.println("10,000 at 6% interest rate = "+calculateinterest(10000,6));
        System.out.println("10,000 at 7% interest rate = "+calculateinterest(10000,7));

        //for(initillisation,termination,increment)
        //for loop is use to loop the value
        for (int i=0;i<5;i++){
            System.out.println("loop "+i+" hello");


        }

        //similarly we can use for loop for line 7 to 12
        for (int i=2;i<8;i++){
            //System.out.println("10,000 at "+i+"% interest rate = "+calculateinterest(10000,i));
            //where we can simplify the above output to one,two or as many as you want decimal by i.e for line 24 by using String.format("%.2f,....)
            System.out.println("10,000 at "+i+"% interest rate = "+String.format("%.2f",calculateinterest(10000,i)));
        }
        System.out.println("______________________________________________");

        //task
        //how would you modify the for loop above to do same
        //shown but to start from 8% and work back to 2%
        for (int i=7;i>=2;i--){
            //System.out.println("10,000 at "+i+"% interest rate = "+calculateinterest(10000,i));
            //where we can simplify the above output to one,two or as many as you want decimal by i.e for line 24 by using String.format("%.2f,....)
            System.out.println("10,000 at "+i+"% interest rate = "+String.format("%.2f",calculateinterest(10000,i)));
        }

        System.out.println(isPrime(6));
        int count=0;
        for (int i=1;i<50;i++){
            if(isPrime(i)){
                count++;
                System.out.println("number "+i+ " is a prime number");
                if(count==9){
                    System.out.println("exiting loop as count = "+count);
                    break;
                }
            }
        }
    }

    //task--3
    // Create a for statement using any range of numbers
    // Determine if the number is a prime number using the isPrime method
    // if it is a prime number, print it out AND increment a count of the
    // number of prime numbers found
    // if that count is 3 exit the for loop
    // hint:  Use the break; statement to exit

    public static boolean isPrime(int n){
        if(n==1){
            return false;
        }
        for (int i=2;i<n/2;i++){
            if (n%i==0){
                return false;
            }

        }
        return true;
    }

    public static double calculateinterest(double amount,double interestrate){
        return (amount*(interestrate/100));
    }
}
