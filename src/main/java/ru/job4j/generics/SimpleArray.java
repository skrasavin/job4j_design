package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] list;
    private int cursor;

    public SimpleArray(int length) {
        list = new Object[length];
    }

    public void add(T model) {
        list[cursor++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, cursor);
        list[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, cursor);
        System.arraycopy(list, index + 1, list,
                index, list.length - (index + 1));
        cursor--;
    }

    public T get(int index) {
        Objects.checkIndex(index, cursor);
        return (T) list[index];
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int current;
            @Override

            public boolean hasNext() {
                return current < cursor;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) list[current++];
            }
        };
    }

    public static void main(String[] args) {
        SimpleArray a = new SimpleArray(10);
        a.add(new Animal());
        a.add(new Predator());
        a.add(new Tiger());
        a.add(new Animal());
        a.add(new Tiger());
        a.add(new Tiger());
        a.remove(2);

        System.out.println(a.iterator().next());
        System.out.println(a.iterator().next());
        System.out.println(a.iterator().next());
    }

}
