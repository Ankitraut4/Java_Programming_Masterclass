package com.company;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyD extends SimpleFileVisitor<Path> {

    private Path sourceRoot;
    private Path targetRoot;

    public CopyD(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("error "+file.toAbsolutePath()+" "+exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path relativePath=sourceRoot.relativize(dir);
        System.out.println("realtive path "+relativePath);
        Path copyDir=targetRoot.resolve(relativePath);
        System.out.println("copy dir path "+copyDir);

        try {
            Files.copy(dir,copyDir);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativePath=sourceRoot.relativize(file);
        System.out.println("realtive path "+relativePath);
        Path copyFile=targetRoot.resolve(relativePath);
        System.out.println("copy dir path "+copyFile);

        try {
            Files.copy(file,copyFile);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return FileVisitResult.CONTINUE;
    }
}
