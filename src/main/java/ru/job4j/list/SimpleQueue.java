package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * код класса можно упростить, для этого оставьте в методе push
 * только помещение элемента в стек in. В методе poll надо сначала проверить,
 * что если в стеках нет переменных, то выбросить соответствующее исключение.
 * Потом, если стек out пуст, то переместите из стека in все элементы в стек out
 * @param <T>
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (in.getSize() == 0) {
            throw new NoSuchElementException();
        }
        if (out.getSize() == 0) {
            while (in.getSize() != 0) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }

//    public void push(T value) {
//        while (outCount > inCount) {
//            in.push(out.pop());
//            inCount++;
//            outCount--;
//        }
//        in.push(value);
//        inCount++;
//    }
}