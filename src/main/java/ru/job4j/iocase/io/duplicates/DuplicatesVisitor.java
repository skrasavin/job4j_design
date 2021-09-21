package ru.job4j.iocase.io.duplicates;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final List<FileProperty> duplicates = new ArrayList<>();

    public Set<FileProperty> findDublicate() {
        Set<FileProperty> dublicate = new HashSet<>();
        return duplicates.stream()
                .filter(e -> !dublicate.add(e))
                .collect(Collectors.toSet());
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        duplicates.add(new FileProperty(file.toFile().length(),
                file.toFile().getName(),
                file.toFile().getAbsolutePath()));
        return super.visitFile(file, attrs);
    }

    public static void main(String[] args) throws IOException {
        DuplicatesVisitor dv = new DuplicatesVisitor();
        Path start = Paths.get("C:/Users/sskra/IdeaProjects/job4j_tracker_test");
        Files.walkFileTree(start, dv);
        dv.findDublicate()
                .forEach(
                a -> System.out.println(a.getName() + " - " + a.getAbsolutePath()));
    }
}


//    public List<FileProperty> findDublicate1() {
//        List<FileProperty> dublicate = new ArrayList<>();
//        for (int i = 0; i < duplicates.size(); i++) {
//            for (int x = i + 1; x < duplicates.size(); x++) {
//                if (duplicates.get(i).equals(duplicates.get(x))) {
//                    dublicate.add(duplicates.get(i));
//                    dublicate.add(duplicates.get(x));
//                }
//            }
//        }
//        return dublicate;
//    }