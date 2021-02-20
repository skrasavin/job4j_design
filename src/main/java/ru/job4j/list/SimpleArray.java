package ru.job4j.list;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    Object[] container = new Object[0];
    int modCount;
    int size;

    public void add(T model) {
        if (container.length == 0) {
            container = new Object[1];
        }else {
            container = Arrays.copyOf(container, size+1);
        }
        container[size] = model;
        size++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }


    public void replace(int index, T model) {
        Objects.checkIndex(index, size);
        container[index] = model;
        modCount++;
    }

    public T  remove(int index) {
        Objects.checkIndex(index, size);
        Object var = container[index];
        for (int x = index; x < container.length - 1; x++) {
            container[x] = container[x+1];
        }
        container = Arrays.copyOf(container, size);
        size--;
        modCount++;
        return (T) var;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            int expectedModCount = modCount;
            private int current;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[current++];
            }
        };
    }
}