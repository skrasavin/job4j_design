package ru.job4j.map.simple;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int modCount = 0;
    private int size = 0;
    private int count = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = true;
        expand();
        int keyIndex = indexFor(hash(key));
        if (table[keyIndex] != null) {
            result = false;
        }
        if (result) {
            table[keyIndex] = new MapEntry<>(key, value);
            modCount++;
            size++;
        }
        return result;
    }

    private void expand() {
        MapEntry<K, V>[] oldTable = table;
        capacity *= 2;
        table = new MapEntry[capacity];
        count = 0;
        for (var entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    private int hash(K key) {
        return (key == null) ? 0 : (key.hashCode()) ^ (key.hashCode() >> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    @Override
    public V get(K key) {
        V result = null;
        int keyIndex = indexFor(hash(key));
        if (key != null && table[keyIndex] != null) {
            if (table[keyIndex].getKey().equals(key)) {
                result = table[keyIndex].getValue();
                modCount++;
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int keyIndex = indexFor(hash(key));
        if (key != null && table[keyIndex] != null) {
            if (table[keyIndex].getKey().equals(key)) {
                table[keyIndex] = null;
                size--;
                result = true;
                modCount++;
            }
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (count < capacity && table[count] == null) {
                    count++;
                }
                return count < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[count++].key;
            }
        };
    }
    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}