package ru.job4j.iocase.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String st : args) {
            if (st.split("=").length == 1) {
                throw new IllegalArgumentException("Empty value");
            }
            System.out.println(st.split("=")[1]);
            values.put(st.substring(1).split("=")[0], st.split("=")[1]);
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("List is empty");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}