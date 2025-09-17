package com.company;

import static org.junit.Assert.*;

public class UtilitiesTest {
private Utilities utilities;

    @org.junit.Before
    public void setup(){
       utilities=new Utilities();
    }

    @org.junit.Test
    public void everyNthChar() {
        char[] s=utilities.everyNthChar(new char[]{'h','e','l','z','0'},2);
        assertArrayEquals(new char[]{'e','z'},s);
        System.out.println(s);
        assertArrayEquals(new char[]{'h','e','l','z','o'},utilities.everyNthChar(new char[]{'h','e','l','z','o'},6));
    }

    @org.junit.Test
    public void removePairs_firstInput() {
        String string= utilities.removePairs("ABCDDEFF");
        assertEquals("ABCDEF",string);
        System.out.println(string);
    }
    @org.junit.Test
    public void removePairs_secondInput() {
        String string= utilities.removePairs("ABCCABDEEF");//we can check this condition in above removePairs_firstInput , just for simplicity we use second test method
        assertEquals("ABCABDEF",string);
        assertNotEquals("ABCDE",string);
        assertNull("did not get null",utilities.removePairs(null));
        assertEquals("",utilities.removePairs(""));
        assertEquals("A",utilities.removePairs("A"));

    }

    @org.junit.Test
    public void converter() {
       int output= utilities.converter(10,5);
       assertEquals(300,output);
    }

    @org.junit.Test(expected =  ArithmeticException.class )
    public void converter_forArithmeticException() {
        utilities.converter(10,0);

    }

    @org.junit.Test
    public void nullIfOddLength() {
// @1       String evenLength= utilities.nullIfOddLength("abcd");
//        System.out.println(evenLength);
//@1        assertEquals("abcd",evenLength);
//or for @1 which is assertNotNull

        assertNotNull("it is not even Length",utilities.nullIfOddLength("abcd"));
        assertNull("it is not odd length",utilities.nullIfOddLength("abcde"));
    }
}