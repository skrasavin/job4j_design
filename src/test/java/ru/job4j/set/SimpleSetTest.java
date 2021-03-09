package ru.job4j.set;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Iterator;

public class SimpleSetTest {
    @Test
    public void whenAddDublicate() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("one");
        simpleSet.add("two");
        assertThat(false, is(simpleSet.add("two")));
    }

    @Test()
    public void whenAddNull() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("one");
        simpleSet.add("two");
        simpleSet.add(null);
    }
}