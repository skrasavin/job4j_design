package ru.job4j.list;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container = new Object[0];
    private int modCount;
    private int size;

    public void enlargeContainer() {
        container = Arrays.copyOf(container, size * 2);
    }

    public void add(T model) {
        if (container.length == 0) {
            container = new Object[1];
        } else {
            enlargeContainer();
        }
        container[size] = model;
        size++;
        modCount++;
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

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(container, index + 1,
                container, index, container.length - (index + 1));
        size--;
        modCount++;
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