package com.company;

public class Main {

    public static void main(String[] args) {

        Utilities utilities=new Utilities();
        String s=utilities.removePairs("ABCDDEFF");
        System.out.println(s);

        char[] stt=utilities.everyNthChar(new char[]{'h','e','l','z','o'},2);
        System.out.println(stt);

    }
}
