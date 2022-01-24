package ru.job4j.ood.lsp.part1;


import java.util.ArrayList;

public class Trash implements Storage {
    private ArrayList<Food> storage = new ArrayList<>();

    public ArrayList<Food> getStorage() {
        return new ArrayList<Food>(storage);
    }

    @Override
    public boolean accept(Food food) {
        return percentageCalculation(food) >= 100;
    }

    @Override
    public boolean addToStorage(Food food) {
        boolean value = accept(food);
        if (value) {
            storage.add(food);
        }
        return value;
    }
}
