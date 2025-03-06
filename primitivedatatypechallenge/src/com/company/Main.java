package com.company;

public class Main {

    public static void main(String[] args) {
        byte mynumberforbyte=10;
        short mynumberforshort=20;
        int mynumberforint =50;
        long mynumberforlong = 50000L+ 10L* (mynumberforint + mynumberforbyte + mynumberforshort);
         //basically here the inside main parantesiss it is considered as int datatype(for line no9)
        //here on line 9 long work best with int(because int maxvalue is smaller than longvalue) here there is no requirement of casting as requred for short and byte
        System.out.println( mynumberforlong);

        //short shorttotal= 1000 + 10 * (mynumberforint+mynumberforbyte+mynumberforshort);//
        //here on 14 we have to give short//

        short shorttotal = (short) (1000+ 10*(mynumberforint+mynumberforbyte+mynumberforshort));
        System.out.println(shorttotal);

        //basically in this chanllenge we understand that int best datatype from byte/short/long//
    }
}
