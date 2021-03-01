package ru.job4j.list.revert;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
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
    public T getLastElement(Node<T> tail, int num) {
        while (num != 0) {
            tail = tail.next;
            num--;
        }
        return tail.value;
    }

    public void revert() {
        Node<T> elements = head;
        int count = 0;
        while (elements.next != null) {
            elements = elements.next;
            count++;
        }
        Node<T> newNode = head;
        head = null;
        for(int x = count; x != -1; x--) {
            add(getLastElement(newNode, x));
        }
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