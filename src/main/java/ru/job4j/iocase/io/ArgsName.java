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
            String[] arr = st.split("=");
            if (arr.length != 2) {
                throw new IllegalArgumentException("Argument Error");
            }
            values.put(arr[0].substring(1), arr[1]);
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