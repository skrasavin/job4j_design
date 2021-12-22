package ru.job4j.map.simple;

import org.junit.Test;


import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleMapTest {

    @Test
    public void whenPutOneElement() {
        SimpleMap<Integer, String> map = new SimpleMap();
        assertTrue(map.put(2, "two"));
    }

    @Test
    public void whenPutTwoElement() {
        SimpleMap<Integer, String> map = new SimpleMap();
        map.put(1, "one");
        map.put(2, "two");
        assertThat(map.get(2), is("two"));
    }

    @Test
    public void whenGetElement() {
        SimpleMap<Integer, String> map = new SimpleMap();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        assertThat(map.get(3), is("three"));
    }

    @Test
    public void whenGetNullElement() {
        SimpleMap<Integer, String> map = new SimpleMap();
        map.put(1, "one");
        assertThat(map.get(2), is(nullValue()));
    }

    @Test
    public void whenRemoveTrue() {
        SimpleMap<Integer, String> map = new SimpleMap();
        map.put(1, "one");
        assertTrue(map.remove(1));
    }

    @Test
    public void whenRemoveFalse() {
        SimpleMap<Integer, String> map = new SimpleMap();
        map.put(1, "one");
        assertFalse(map.remove(2));
    }
}