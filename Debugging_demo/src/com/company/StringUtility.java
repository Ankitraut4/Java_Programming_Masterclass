package com.company;

import java.util.Locale;

public class StringUtility {
   private StringBuilder stringBuilder=new StringBuilder();
    private int charAddedCounter =0;

    public void addChar(StringBuilder sBuilder,char c){
        sBuilder.append(c);
        charAddedCounter++;
    }

    public String upperAndPrefix(String str){
        String upper=str.toUpperCase(Locale.ROOT);
        return  "prefix_"+upper;

    }

    public String suffix(String str){
        return  str+"_suffix";
    }
}
