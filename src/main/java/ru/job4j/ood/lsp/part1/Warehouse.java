package ru.job4j.ood.lsp.part1;

import java.util.ArrayList;

public class Warehouse implements Storage {

    private ArrayList<Food> storage = new ArrayList<>();

    public ArrayList<Food> getStorage() {
        return new ArrayList<Food>(storage);
    }

    @Override
    public boolean accept(Food food) {
        return percentageCalculation(food) < 25;
    }

    @Override
    public void addToStorage(Food food) {
            storage.add(food);
    }
}
