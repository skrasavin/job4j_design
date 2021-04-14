package ru.job4j.iocase.io;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> logs = Collections.emptyList();
        try (BufferedReader in = new BufferedReader(new FileReader("iofiles/log.txt"))) {
            logs = in.lines().filter(a -> a.contains("404"))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logs;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            log.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("iofiles/log.txt");
        log.forEach(System.out::println);
        save(log, "iofiles/404.txt");
    }
}