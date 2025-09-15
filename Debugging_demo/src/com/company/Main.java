package com.company;

public class Main {

    public static void main(String[] args) {
      StringUtility stringUtility=new StringUtility();
      StringBuilder sb=new StringBuilder();

      while (sb.length()<10){
          stringUtility.addChar(sb,'a');
      }
        System.out.println(sb);

      String str="abcdefg";
      String result=stringUtility.upperAndPrefix(stringUtility.suffix(str));

    }
}
