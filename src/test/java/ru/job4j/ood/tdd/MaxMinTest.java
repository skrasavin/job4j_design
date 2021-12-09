package ru.job4j.ood.tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMinTest {

    @Test
    public void testMax() {
        List<Integer> value = new ArrayList<>();
        MaxMin maxMin = new MaxMin();
        value.add(7);
        value.add(11);
        value.add(6);
        value.add(3);
        value.add(3);
        value.add(5);

        int result = maxMin.max(value, Comparator.naturalOrder());
        assertThat(11, is(result));
    }

    @Test
    public void testMin() {
        List<Integer> value = new ArrayList<>();
        MaxMin maxMin = new MaxMin();
        value.add(7);
        value.add(11);
        value.add(6);
        value.add(3);
        value.add(3);
        value.add(5);

        int result = maxMin.min(value, Comparator.naturalOrder());
        assertThat(3, is(result));
    }
}