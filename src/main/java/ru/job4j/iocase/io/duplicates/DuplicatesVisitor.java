package ru.job4j.iocase.io.duplicates;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final List<FileProperty> duplicates = new ArrayList<>();
    private Set<FileProperty> duplicatesForSet = new HashSet();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("==" + file.toAbsolutePath());

        duplicates.add(new FileProperty(file.toFile().length(),
                file.toFile().getName(),
                file.toFile().getAbsolutePath()));

        duplicates.stream()
                .filter(e -> !duplicatesForSet.add(e))
                .collect(Collectors.toSet());

        return super.visitFile(file, attrs);
    }

    public static void main(String[] args) throws IOException {
        DuplicatesVisitor dv = new DuplicatesVisitor();
        Path start = Paths.get("C:/Users/sskra/IdeaProjects/track_test");
        Files.walkFileTree(start, dv);

        for (var s : dv.duplicatesForSet) {
            System.out.println(s.getName() + s.getAbsolutePath());
        }
    }
}