package ru.job4j.ood.lsp.part1;


import java.util.ArrayList;

public class Trash implements Storage {
    private ArrayList<Food> storage = new ArrayList<>();

    public ArrayList<Food> getStorage() {
        return storage;
    }

    @Override
    public void addToStorage(Food food) {
        storage.add(food);
    }
}
