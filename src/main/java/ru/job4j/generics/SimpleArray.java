package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T>{
    Object[] list;
    int cursor;
    private Object IndexOutOfBoundsException;

    public SimpleArray(int length) {
        list = new Object[length];
    }

    //добавляет указанный элемент (model) в первую свободную ячейку;
    public void add(T model) {
        for(int x = 0; x < list.length; x++) {
            if (list[x] == null) {
                list[x] = model;
                break;
            }
        }
    }

    // заменяет указанным элементом (model) элемент, находящийся по индексу index;
    public void set(int index, T model) {
        if (index >= 0 || index < list.length - 1) {
            list[index] = model;
        }
    }

    //удаляет элемент по указанному индексу, все находящиеся справа элементы
    //при этом необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек);
    public void remove(int index) {
        System.arraycopy(list, index + 1, list, index, list.length - (index+1));
    }

    //возвращает элемент, расположенный по указанному индексу;
    public T get(int index) {
        if (index >= 0 || index < list.length - 1) {
            return (T) list[index];
        }else return (T) IndexOutOfBoundsException;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return cursor < list.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) list[cursor++];
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
        a.remove(2);
        
        System.out.println(a.iterator().next());
        System.out.println(a.iterator().next());
        System.out.println(a.iterator().next());


        for (int x = 0; x < a.list.length; x++) {
            System.out.println(x + " : " + a.get(10));
        }
    }

}
