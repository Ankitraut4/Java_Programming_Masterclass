package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            Path file= FileSystems.getDefault().getPath("data.txt");
            Files.write(file,"\nLine 41".getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);//every time you run it will add the line 41//here we use StandardOpenOption.APPEND,
            //because we want to write line 41 in the given file but we does not use StandardOpenOption.APPEND the program think that we want to create fresh file / if the file is already there then it would delete all
            //information in file and add line 41 only
            List<String> lines= Files.readAllLines(file);//here readAllLines(file) by default contain UTF_8.INSTANCE here it is not requred to use StandardCharsets.UTF_8
            for (String li: lines){
                System.out.println(li);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
