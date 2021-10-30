package ru.job4j.iocase.io;

import ru.job4j.iocase.io.file.Search;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    //java -jar pack.jar -d=/home/serg/IdeaProjects/job4j_tracker -e=class
    // -o=/home/serg/IdeaProjects/job4j_tracker.zip
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toFile().getAbsolutePath()));

                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(String.valueOf(path)))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//"C:/Users/sskra/IdeaProjects/job4j_design"
//"class"

    public static void main(String[] args) throws IOException {
        Search search = new Search();
        List<Path> result = Search.newSearch(
                "C:/Users/sskra/IdeaProjects/job4j_design", "class"
        );
        new Zip().packFiles(result, new File("C:/Users/sskra/IdeaProjects/test.zip"));


//        Search search = new Search();
//        List<Path> result = search.search(Paths.get("/home/serg/IdeaProjects/job4j_tracker"),
//                p -> !p.toFile().getName().endsWith("class"));
//        new Zip().packFiles(result, new File("/home/serg/IdeaProjects/job4j_tracker.zip"));


//        new Zip().packSingleFile(
//                new File("/home/serg/IdeaProjects/job4j_tracker"),
//                new File("/home/serg/IdeaProjects/job4j_tracker.zip")
//        );
    }
}