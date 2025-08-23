package com.example.packagechallange;
public class Series {

 public static long nSum(int n){
 return n*(n+1)/2;
}

public static long nFactorial(int n) {
 long fact =1;
 if (n == 0) {
  return 1;
 } else {
  for (int i = 1; i <= n; i++) {
   fact = fact * i;
  }
  return fact;
 }
 }
public static long nFibonacci(int n){
  if (n==0){
   return 0;
  }else if (n==1){
   return 1;
  }else {
   long nMinus1=1;
   long nMinus2=0;
   long fibo=0;
  for (int i=1;i<n;i++){
   fibo=nMinus1+nMinus2;
   nMinus2=nMinus1;
   nMinus1=fibo;
  }
  return fibo;
  }
}


}
