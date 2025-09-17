package com.company;

import java.util.Locale;

public class Utilities {

    // Returns a char array containing every nth char. When
    // sourceArray.length < n, returns sourceArray
    public char[] everyNthChar(char[] sourceArray, int n) {

        if (sourceArray == null || sourceArray.length < n) {
            System.out.println("sourceArray.length < n or sourceArray==null");
            return sourceArray;
        }

        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;

        for (int i = n - 1; i < sourceArray.length; i += n) {
            result[index++] = sourceArray[i];//here when first itaration of loop index=0 and it will store value of index[0] and then increment it by 1(index++)
           // index++;// we increment index in above step so index++ is not required
        }

        return result;
    }

    // Removes pairs of the same character that are next
    // to each other, by removing one occurrence of the character.
    // "ABBCDEEF" -> "ABCDEF"
    // "ABCBDEEF" -> "ABCBDEF" (the two B's aren't next to each other, so they
    // aren't removed)
    public String removePairs(String source) {

        // If length is less than 2, there won't be any pairs
        if (source==null || source.length() < 2) {
            System.out.println("source should be greater than 2 OR not null");
            return source;
        }

        StringBuilder sb = new StringBuilder();
        char[] string = source.toUpperCase(Locale.ROOT).toCharArray();

        for (int i = 0; i < string.length-1; i++) {//we want to check to length -1 because last element/character is allways safe , if we do not do length-1 then for last element there would we no next element so we get index out of bound exception
            if (string[i] != string[i+1]) {
                sb.append(string[i]);
            }
        }

        //we have to add last character ti stringBuilder as it is not added to builder
        sb.append(string[string.length-1]);

        return sb.toString();
    }

    // performs a conversion based on some internal
    // business rule
    public int converter(int a, int b) {
        if (b==0){
            throw new ArithmeticException("divided by xero");
        }
        return (a/b) + (a * 30) - 2;
    }

    public String nullIfOddLength(String source) {
        if (source.length() % 2 == 0) {
            return source;
        }

        return null;
    }
}
