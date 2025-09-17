package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UtilitiesParameterizedTest {

    public Utilities util;
    private String source;
    private String output;

    public UtilitiesParameterizedTest(String source, String output) {
        this.source = source;
        this.output = output;
        util=new Utilities();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testParameters() {
        return Arrays.asList(new Object[][]{
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG","AB8EFG"},
                {"112233445566","123456"},
                {"ZYZQQB","ZYZQB"},
                {"A","A"}
        });
    }
        @org.junit.Test
        public void removePairs(){
            assertEquals(output,util.removePairs(source));

        }

}
