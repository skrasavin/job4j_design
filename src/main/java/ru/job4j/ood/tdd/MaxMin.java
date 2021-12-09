package ru.job4j.ood.tdd;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        while (value.size() != 1) {
            if (comparator.compare(value.get(0), value.get(1)) < 1) {
                value.remove(value.get(0));
            } else {
                value.remove(value.get(1));
            }
        }
        return value.get(0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return max(value, comparator.reversed());
    }
}
