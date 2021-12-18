package ru.job4j.ood.tdd;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T solution(List<T> value, Comparator<T> comparator) {
        T res = value.get(0);
        for (var val : value) {
            res = comparator.compare(res, val) > 0 ? res : val;
        }
        return res;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return solution(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return solution(value, comparator.reversed());
    }
}


