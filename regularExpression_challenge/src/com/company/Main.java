package com.company;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String challenge1="I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));//using string litral regEx to match the challenge1 string

        String challenge2="I want a ball.";
        String regEx="I want a \\w+.";//creating new regular expression which matches both chalenge 1&2
        System.out.println(challenge1.matches(regEx));
        System.out.println(challenge2.matches(regEx));

        String regEx2="I want a (bike|ball).";//another solution of challenge 2
        System.out.println(challenge1.matches(regEx));
        System.out.println(challenge2.matches(regEx));
        System.out.println("---");
        Pattern pattern=Pattern.compile("I want a \\w+.");
        Matcher matcher=pattern.matcher(challenge1);
        System.out.println(matcher.matches());

         matcher=pattern.matcher(challenge2);
        System.out.println(matcher.matches());

        String challenge4="Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s","_"));
        System.out.println(challenge4.replaceAll(" ","_"));// \\s is use to replace or match all spaces between String

        System.out.println("-----------");
        String challenge5="aaabccccccccdddefffg";
        System.out.println(challenge5.matches("aa.*"));//writing regular expression which match challenge5 string entirly
        System.out.println(challenge5.matches("[abcdefg]*"));
        System.out.println(challenge5.matches("[a-z]+"));// or [a-g]+ or [a-g]* or [a-z]*
        System.out.println("---");

        //write a regEx that will only match the challenge 5 string entirety
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        System.out.println(challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g$","Replaced"));//repacing exact string
        System.out.println("-----");

        String challenge7="abcd.135";
        String challenge7_1="kJisl.22";
        String challenge7_2="f5.12a";
        System.out.println("challenge7 matches = "+challenge7.matches("^[a-zA-Z]{0,9}[\\.][0-9]{0,9}$"));
        System.out.println("challenge7_1 matches = "+challenge7_1.matches("^[a-zA-Z]{0,9}[\\.][0-9]{0,9}$"));
        System.out.println("challenge7_2 matches = "+challenge7_2.matches("^[a-zA-Z]{0,9}[\\.][0-9]{0,9}$"));
        System.out.println("----");

        //print all the digit occures in a string that contains multiple occurrence of the pattern.write code required to
        //accomplish this, then the output of three occurence of the pattern should be 135,7 and 999 printed on console.
        String challenge8="abcd.135uvqz.7tzik.999";
        Pattern pattern8=Pattern.compile("[a-zA-z]*\\.(\\d*)");// or ("[a-zA-z]+\\.(\\d+)")
        Matcher matcher8=pattern8.matcher(challenge8);
        while (matcher8.find()){
            System.out.println("occurence "+matcher8.group(1));
        }
        System.out.println("------");

        String challenge9="abcd.135\tuvqz.7\tttzik.999\n";
        Pattern pattern9=Pattern.compile("[A-Za-z]*\\.(\\d*)\\s");// or ("[A-Za-z]*\\.(\\d*)\\t\\n") \\s is use to accomodate all space and nextline tags
        Matcher matcher9=pattern9.matcher(challenge9);
        while (matcher9.find()){
            System.out.println("occurence "+matcher9.group(1));
        }
        System.out.println("*****************");

        //printing end index to -1 position before it end, at next index after it end
        Pattern pattern10=Pattern.compile("([A-Za-z]*)(\\.)(\\d*)(\\s)");
        Matcher matcher10=pattern10.matcher(challenge9);
        while (matcher10.find()){
            System.out.println("occurence "+matcher10.group(3)+" range:- "+matcher10.start(3)+" to "+(matcher10.end(3)-1));
        }

        System.out.println("------");
        //suppose we have the following string containing points on graph curly braces.Extract what's in the curly braces.
        String challenge11="{0,2},{0,5},{1,3},{2,4}";
        Pattern pattern11=Pattern.compile("\\{(.+?)\\}");
        Matcher matcher11=pattern11.matcher(challenge11);
        while (matcher11.find()){
            System.out.println("occurence "+matcher11.group(1));
        }
        System.out.println("------------------------");
        String challenge11a="{0,2},{0,5},{1,3},{2,4},{x,y},{12,44}";//when we use our previous code we get x,y as occurence
        Pattern pattern11a=Pattern.compile("\\{(\\d*,\\d*)\\}");//to avoid that and print only digit we use
        Matcher matcher11a=pattern11a.matcher(challenge11a);
        while (matcher11a.find()){
            System.out.println("occurence "+matcher11a.group(1));
        }
        System.out.println("--------");

        String challenge12="11111";
        Pattern pattern12=Pattern.compile("[0-9]{5}");
        Matcher matcher12=pattern12.matcher(challenge12);
        System.out.println(matcher12.matches());
        //or for above code
        System.out.println(challenge12.matches("\\d{5}"));
        System.out.println(challenge12.matches("[0-9]{5}"));
        System.out.println("-------------");

        String challenge13="11111-1111";
        System.out.println(challenge13.matches("^\\d{5}\\-\\d{4}$"));//("^\\d{5}-\\d{4}$"))
        System.out.println(challenge13.matches("[0-9]{5}\\-[0-9]{4}"));

        System.out.println("--------------");

        //write a regEx that will match 5-digit us zip codes, and zip code that containd th optional 4 digit
        //preceded by dash
        String challenge14="11111";
        String challenge14a="11111-1111";
        String challenge14b="11111-11";
        System.out.println(challenge14.matches("^\\d{5}(\\-\\d{4})?$"));
        System.out.println(challenge14a.matches("^\\d{5}(\\-\\d{4})?$"));
        System.out.println(challenge14b.matches("^\\d{5}(\\-\\d{4})?$"));
    }
}
