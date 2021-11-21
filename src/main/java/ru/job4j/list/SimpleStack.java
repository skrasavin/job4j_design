package ru.job4j.list;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();
    private int size = 0;

    public T pop() {
        size--;
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
        size++;
    }

    public int getSize() {
        return size;
    }
}