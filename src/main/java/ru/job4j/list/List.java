package ru.job4j.list;

public interface List<E> extends Iterable<E> {
    void add(E value);
    E get(int index);
}