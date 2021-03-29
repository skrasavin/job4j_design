package ru.job4j.iocase.io.duplicates;

import ru.job4j.iocase.io.file.SearhFiles;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toAbsolutePath());
        return super.visitFile(file, attrs);
    }

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("/home/serg/IdeaProjects/job4j_design/.idea/");
        Files.walkFileTree(start, new DuplicatesVisitor());
//        System.out.println(start.getParent());
    }
}