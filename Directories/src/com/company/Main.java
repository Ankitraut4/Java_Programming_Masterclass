package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        try {

//            DirectoryStream.Filter<Path> filter=new DirectoryStream.Filter<Path>() {
//                @Override
//                public boolean accept(Path entry) throws IOException {
//                    return Files.isRegularFile(entry);
//                }
//            };
            //using lambada expression
            DirectoryStream.Filter<Path> filter=p ->Files.isRegularFile(p);


          //  Path directory= FileSystems.getDefault().getPath("FileTree"+File.separator+"Dir2");//by creating File.separator the file will open or process on any os
            Path directory= FileSystems.getDefault().getPath("FileTree\\Dir2");
            DirectoryStream<Path> content= Files.newDirectoryStream(directory,filter);
            for (Path value: content){
                System.out.println(value.getFileName());
            }
        }catch (IOException | DirectoryIteratorException e){
            System.out.println(e.getMessage());
        }

       String seperator= File.separator;
        System.out.println(seperator);
        String sep=FileSystems.getDefault().getSeparator();
        System.out.println(sep);


        try {
            //creating temperary file
            Path tempPath=Files.createTempFile("myFile",".jdg");//here myFile is prefix and .jdg is suffix which can we any type depend on user
            System.out.println(tempPath.toAbsolutePath());
        }catch (IOException e){
            e.printStackTrace();
        }

        Iterable<FileStore> stores=FileSystems.getDefault().getFileStores();
        for (FileStore store:stores){
            System.out.println("Volume / drive letter = "+store);
            System.out.println("file store = "+store.name());
        }
        System.out.println();
        Iterable<Path> paths=FileSystems.getDefault().getRootDirectories();
        for (Path path:paths){
            System.out.println(path);
        }


        System.out.println();
        System.out.println("*****************************walking the file**************************");
        Path dir2path=FileSystems.getDefault().getPath("FileTree"+File.separator+"Dir2");
        try {
            Files.walkFileTree(dir2path,new PrintName());

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("***********************copy dir*****************");
        Path copyPath=FileSystems.getDefault().getPath("FileTree"+File.separator+"Dir4"+File.separator+"CopyDir2");
        try {
            Files.walkFileTree(dir2path,new CopyD(dir2path,copyPath));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
