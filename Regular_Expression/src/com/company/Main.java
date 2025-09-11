package com.company;

public class Main {

    public static void main(String[] args) {

        String name="My name is ankit, my last name is raut";
        String replace=name.replaceAll("My","your");//refEX (regular expression) is case sensitive
        System.out.println(replace);

        String me="My name is ankit, My last name is raut";
        String place=me.replaceAll("My","your");
        System.out.println(place);

        System.out.println(me.replaceAll(".","Y"));// "." means it will map with every element

        String alphabets="avbdehjhjheeFiiiFggavbdehgFkjkjgh";
        System.out.println(alphabets.replaceAll("^avbdeh","No"));//it will replace only starting string
        System.out.println(alphabets.replaceAll("jkjgh$","Yes"));//it will replace only from end string

        String newString="avbdehjhjheeFiiiFggavbdehgFkjkjghjhjhgfsjrsgfcdrt";
        System.out.println(newString.replaceAll("[esi]","Z"));//e or s or i or is replaced by Z
        System.out.println(newString.replaceAll("[esi][jh]","O"));//the albhabet j(e or s or i) and h(e or s or i) will replace when it is followed by e or s or i

        System.out.println("-------------------------------------");
        System.out.println("harry".replaceAll("[H|h]arry","Harry"));//the input h of harry is in lowercase , so to check or give condition the value that if the first letter is H or h replace it with capital"H"(Harry)
        String newAlpha="agfgvDhghEgjjhFbvgg132354aa677a";
        System.out.println(newAlpha.replaceAll("[^fb]","X"));//in side bracket the carrot[^fb] will neglect the value in side the bracket which is f,b and convert other alphbets and number to X
        System.out.println(newAlpha.replaceAll("[abcdefg1234567]","Z"));
        System.out.println(newAlpha.replaceAll("[a-g1-7]","Z"));//[a-g1-7] is the range of alphabets and numbers
        System.out.println(newAlpha.replaceAll("[a-gA-G1-7]","Z"));//it will replace small and Large alphabets into Z
        System.out.println(newAlpha.replaceAll("(?i)[a-g1-7]","Z"));//(?i) this will niglacted the case sensitivity
        System.out.println(newAlpha.replaceAll("\\d","T"));//it  replace all the digit(numbers)
        System.out.println(newAlpha.replaceAll("\\D","T"));//it will replaace all non-digit(alphabets)

        System.out.println("----------------------------------");
        String hasWhitespaces="i my good or\tbad bad\n";
        System.out.println(hasWhitespaces);
        System.out.println(hasWhitespaces.replaceAll("\\s",""));//  "\\s" is use to remove whiteSpaces
        System.out.println(hasWhitespaces.replaceAll("\t","@"));//  \t is repalce
        System.out.println(newAlpha.replaceAll("\\S",""));//  "\\S" is use to bring whitespaces so only tab,space & newline is remain
        System.out.println(hasWhitespaces.replaceAll("\\w","X"));//non-whitespace is replace by X
        System.out.println(hasWhitespaces.replaceAll("\\W","X"));// whitespace is replace by X

        System.out.println(hasWhitespaces.replaceAll("\\b","X"));// so each word is surrounded by replacement string


        System.out.println("-----------------------------Quantifiers----------------------------");
        String hee="abcDeeeeeghfvhfffgcgdgfhhft";
        System.out.println(hee.replaceAll("abcDe+","hello"));//one or more occurence of e
        String hee2="abcDghfvhfgcgdgfhhft";
        System.out.println(hee2.replaceAll("abcDe*","hello"));//zero or more occurence of e
        System.out.println(hee.replaceAll("abcDe{3}","hello"));//3c occurence of e
        System.out.println(hee.replaceAll("abcDe{1,5}","hello"));
        System.out.println(hee.replaceAll("f+g*c","3"));// occures of f is one or more , occures of g is zero or more which is fallowed by c







    }
}
