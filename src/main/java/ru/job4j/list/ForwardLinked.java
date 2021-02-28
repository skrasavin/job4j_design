package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ForwardLinked<T> implements Iterable<T>{
    private Node<T> head;
    private int size;

    public int getSize() {
        return size;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException("Список пуст");
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;

    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException("Список пуст");
        }
        Node<T> tail = head;
        while (tail.next.next != null) {
            tail = tail.next;
        }
        T value = tail.next.value;
        tail.next = null;
        size--;
        return value;
    }

    public void add(T value) {
        size++;
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}