package ru.job4j.list;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();

    //должен возвращать значение и удалять его из коллекции.
    public T pop() {
        if (linked.getSize() == 1) {
            return linked.deleteFirst();
        }
        return linked.deleteLast();
    }

    //помещает значение в коллекцию.
    public void push(T value) {
        linked.add(value);
    }
}