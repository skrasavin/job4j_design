package ru.job4j.ood.lsp.part1;

import java.util.Calendar;

public class Fruit extends Food {

    public Fruit(String name, Calendar createDate, int expiryDate, double price, int discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
