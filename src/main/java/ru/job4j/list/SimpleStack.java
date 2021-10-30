package ru.job4j.list;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();

    public T pop() {
        if (linked.getSize() == 1) {
            return linked.deleteFirst();
        }
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
    }
}