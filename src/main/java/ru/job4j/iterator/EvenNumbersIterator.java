package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * EvenNumbersIterator
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int point;

    /**
     * constructor
     * @param data tag
     */
    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        System.out.println("point: " + point);
        if (point == data.length - 1 && data[point] % 2 != 0) {
            return false;
        }
        while (data[point] % 2 != 0) {
            point++;
        }
        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return data[point++];
    }
}
