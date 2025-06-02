package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> stringarraylist=new ArrayList<String>();
        stringarraylist.add("ankit");//this will add this string in the arraylist
        System.out.println("name = " +stringarraylist);

        //ArrayList<int> intarraylist=new ArrayList<int>();//here int as primitive type is not accepted because it does not came under class,object,etc like string so we use
         ArrayList<Integer> intarraylist=new ArrayList<Integer>();
         for (int i=0;i<5;i++){
             intarraylist.add(Integer.valueOf(i));//autoboxing
         }
         for (int i=0;i<5;i++){
             int print=intarraylist.get(i).intValue();
             System.out.println(i+" -- > "+print);
         }

         Integer myintValue=56;//Integer.valueOf(56); during compilation the automatically convert 56 into Integer.valueOf(56); commond
        int myVal=myintValue;//myintValue.intValue();   during compilation the automatically convert myintValue to myintValue.intValue();

        //example of line 23 and 24(shortcuts) using other datatype

        ArrayList<Double> doublevalue=new ArrayList<Double>();
        for (double i=0.0;i<5;i++){
            doublevalue.add(i);//using shortcut Double.valueOf(i) replaced by i;
        }
        for (int i=0;i<doublevalue.size();i++){

            System.out.println(i+" --> "+doublevalue.get(i));//doublevalue.get(i).doubleValue() replaced by doublevalue.get(i)
        }
    }
}
