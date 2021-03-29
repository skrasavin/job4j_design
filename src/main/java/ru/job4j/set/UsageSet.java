package ru.job4j.set;

import java.util.*;

public class UsageSet {
    public static void main(String[] args) {
        Set<String> strings1 = new TreeSet<>(Comparator.reverseOrder());
        strings1.addAll(List.of("one", "four", "fives", "s"));
        for (String s : strings1) {
            System.out.println("Текущий элемент: " + s);
        }
    }
}