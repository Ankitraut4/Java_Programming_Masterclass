package com.company;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {

try {
//    //to check if if is exist or not
//    Path path=FileSystems.getDefault().getPath("file1.txt");
//    System.out.println("exist = "+Files.exists(path));
//
//    //to copy file
//    Path sourceFile= FileSystems.getDefault().getPath("example","Dir1","file2.txt");
//    Path copyFile=FileSystems.getDefault().getPath("example", "copyfile2.txt");
//    Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);//if we use this parameter "StandardCopyOption.REPLACE_EXISTING" if the file with same name if present  then it would replace the file if we does not use this parameter it will not copy because of same name

//    //to copy directory
//    Path sourceFile= FileSystems.getDefault().getPath("example","Dir3");
//    Path copyFile=FileSystems.getDefault().getPath("example", "Dir1","Dir2","Dir3");
//    Files.copy(sourceFile,copyFile);//when we copy directory there content(like files) does not copied to that directory

//    //moving files
//    Path sourceFile= FileSystems.getDefault().getPath("example","Dir1","copyfile1.txt");
//    Path copyFile=FileSystems.getDefault().getPath("example", "Dir3","copyfile1.txt");//to move you have to specify the full path of file upto the file name(here it is copyfile1.txt) which you want to move ,not only upto directory
//    Files.move(sourceFile,copyFile);

    //rename file
//    Path sourceFile= FileSystems.getDefault().getPath("example","Dir3","file1.txt");
//    Path copyFile=FileSystems.getDefault().getPath("example","Dir3","renameFile1.txt");
//    Files.move(sourceFile,copyFile);

    //delete file
//    Path delete= Paths.get(".","file1.txt");//Paths.get(".")refer to present directory or folder you are in here it is CopyFile_exist_move_deleteusing_java.nio.file
//   Files.deleteIfExists(delete);

//creating file
//    Path creatingFile=FileSystems.getDefault().getPath("example","file2.txt");
//    Files.createFile(creatingFile);

    //creating Directory
//    Path createDirectory=FileSystems.getDefault().getPath("example","Dir4");
//    Files.createDirectory(createDirectory);

//    //create many directories
//    Path createDirectories=FileSystems.getDefault().getPath("example", "Dir1\\Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
//    Files.createDirectories(createDirectories);

    //create attribute
    Path attr=FileSystems.getDefault().getPath("example","Dir3\\copyfile1.txt");
    long size=Files.size(attr);
    System.out.println("size = "+size);
    System.out.println("last modified = "+Files.getLastModifiedTime(attr));

    //using class
    BasicFileAttributes attributes=Files.readAttributes(attr,BasicFileAttributes.class);
    System.out.println("size = "+attributes.size());
    System.out.println("last modified time and date = "+attributes.lastModifiedTime());
    System.out.println("creation time = "+attributes.creationTime());
    System.out.println("is directory = "+attributes.isDirectory());
    System.out.println("is file = "+attributes.isRegularFile());


}catch (Exception e){
    System.out.println(e.getMessage());
}

    }
}
