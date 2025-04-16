package com.company;

public class Main {

    public static void main(String[] args) {

         String valueAsString ="2112";
        System.out.println("string value = " +valueAsString);



        //here for adding number to string we have to convert the string into number by parsing
        int number=Integer.parseInt(valueAsString);
        System.out.println("number = " +number);

        valueAsString +=1;
        System.out.println("string after adding =  " +valueAsString);
        //here on line 16 we add 1 but our data type is string so in just concated the string i.e merge

        //here from line 13 we convert string to number
        number+=1;
        System.out.println("number after adding = " +number);

        //similarly we can do for other data types

        String value="2018";
        System.out.println("value = " +value);

        double num=Double.parseDouble(value);
        System.out.println("num = "+num);

        value+=567;
        System.out.println("after add = "+value);

        num+=567.23;
        System.out.println("after add = "+num);

    }
}
