package ru.job4j.iocase.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            for (Scanner sc = new Scanner(Path.of(this.path)); sc.hasNext();) {
                String testSc = sc.nextLine();
                if (!testSc.contains("#")
                        && testSc.split("=").length < 2
                        && !testSc.isEmpty()) {
                    throw new IllegalArgumentException();
//                    throw new IllegalArgumentException("Проверьте правильность заполнения свойств");
                }
            }
            this.values = read.lines().filter(a -> a.contains("=") && a.split("=").length > 1)
                    .map(i -> i.split("="))
                    .collect(Collectors.toMap(a -> a[0], a -> a[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return this.values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}