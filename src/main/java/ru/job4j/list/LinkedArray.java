package ru.job4j.list;

import java.util.*;

public class LinkedArray<T> implements Iterable {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int modCount;
    private int size;

    public int getSize() {
        return size;
    }

    public LinkedArray() {
        lastNode = new Node<>(null, firstNode, null);
        firstNode = new Node<>(null, null, lastNode);
    }

    public void add(T model) {
        Node<T> prev = lastNode;
        prev.setCurrentElement(model);
        lastNode = new Node<T>(null, prev, null);
        prev.setNextElement(lastNode);
        modCount++;
        size++;
    }

    public T get(int index) {
        Node<T> target = firstNode.getNextElement();
        for(int x = 0; x < index; x++) {
               target = target.getNextElement();
        }
        return target.getCurrentElement();
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int current;
            int expectedModCount = modCount;
            Node<T> node = firstNode;

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
                T value = (T) node.next.getCurrentElement();
                node = node.next;
                return value;

            }
        };
    }

    private static class Node<T>
    {
        T element;
        Node<T> next;
        Node<T> prev;

        Node(T element, Node<T> prev, Node<T> next)
        {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public T getCurrentElement() {
            return element;
        }

        public void setCurrentElement(T el) {
            element = el;
        }

        public Node<T> getNextElement() {
            return next;
        }

        public void setNextElement(Node el) {
            next = el;
        }
    }
}
