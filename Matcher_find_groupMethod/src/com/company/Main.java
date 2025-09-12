package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {


StringBuilder htmltext=new StringBuilder();
htmltext.append("<h1>heading<h1>");
        htmltext.append("<h2>Sub-Heading</h2>");
        htmltext.append("<p>first paragraph</p>");
        htmltext.append("<p>secong paragraph</p>");
        htmltext.append("<h2>summary</h2>");
        htmltext.append("<p>summary paragraph</p>");

        Pattern pattern= Pattern.compile("<h2>");
        Matcher matcher=pattern.matcher(htmltext);
        System.out.println(matcher.matches());//here we use matcher for printing true or false
//once we use matcher once then for reusing it we have to reset it
        matcher.reset();
        int count=0;
        while (matcher.find()){
            count++;
            System.out.println("occurence "+count+" : "+" range "+matcher.start()+" -- "+matcher.end());
        }

        System.out.println("--------------------");

        Pattern groupPattern=Pattern.compile("(<h2>)");
        Matcher groupMatcher=groupPattern.matcher(htmltext);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();
        while (groupMatcher.find()){
            System.out.println("occurence : "+groupMatcher.group(1)+" range:- "+groupMatcher.start(1)+" to "+groupMatcher.end(1));
        }

        System.out.println("----------Group Matcher-------------");

        Pattern groupPattern1=Pattern.compile("(<h2>.*?</h2>)");//? will convert greedy to lazy quantifer by limiting its reach of more ocuurence
        Matcher groupMatcher1=groupPattern1.matcher(htmltext);
        System.out.println(groupMatcher1.matches());
        groupMatcher1.reset();
        while (groupMatcher1.find()){
            System.out.println("occurence : "+groupMatcher1.group(1)+" range:- "+groupMatcher1.start(1)+" to "+groupMatcher1.end(1));
        }

        System.out.println("------------GroupMatcher for only text-----------------");
        Pattern groupPattern2=Pattern.compile("(<h2>)(.*?)(</h2>)");//? will convert greedy to lazy quantifer by limiting its reach of more ocuurence
        Matcher groupMatcher2=groupPattern2.matcher(htmltext);
        System.out.println(groupMatcher2.matches());
        groupMatcher2.reset();
        while (groupMatcher2.find()){
            System.out.println("occurence : "+groupMatcher2.group(2)+" range :-"+groupMatcher2.start(2)+" to "+groupMatcher2.end(2));
        }

        System.out.println("-------------------and----or------not--------------");
        //"abc" = a and b and c

        //or operation

        System.out.println("Harry".replaceAll("[H|h]arry","Larry"));
        System.out.println("harry".replaceAll("[H|h]arry","Larry"));

        //Not operation
        String name="abecdetfdge";
       // System.out.println(name.replaceAll("e[^t]","Z"));//from e[^t] we are not getting replace of last e even it it not fallowed by t
        System.out.println(name.replaceAll("e(?!t)","Z"));

       // Pattern pattern1=Pattern.compile("e[^t]");
        Pattern pattern1=Pattern.compile("e(?!t)");
        Matcher matcher1=pattern1.matcher(name);
        int counter=0;
        while (matcher1.find()){
            counter++;
            System.out.println("occurence "+counter+" range:- "+matcher1.start()+" to "+matcher1.end()
            );
        }

        //check where the phone number is of usa number // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        String phone1="1432342";
        String phone2="(888) 456-7777";
        String phone3="(123)456-7777";

        System.out.println("phone 1 = "+phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ][0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone 2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone 3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));



        // ^4[0-9]{12}([0-9]{3})?$
        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));

    }
}
