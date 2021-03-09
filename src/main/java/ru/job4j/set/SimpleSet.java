package ru.job4j.set;

import ru.job4j.list.SimpleArray;

import java.awt.*;
import java.util.*;

public class SimpleSet<E> implements Iterable<E>{
    private SimpleArray<E> container = new SimpleArray<>();

    public boolean add(E e) {
        for (int x = 0; x != container.getSize(); x++) {
            if (Objects.equals(e, container.get(x))) {
                return false;
            }
        }
        this.container.add(e);
        return true;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<>() {
            private int current;

            @Override
            public boolean hasNext() {
                return current < container.getSize();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return container.get(current++);
            }
        };
    }
}
