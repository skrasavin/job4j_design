package ru.job4j.ood.lsp.part1;

import java.util.ArrayList;

public interface Storage {
    public void addToStorage(Food food);
    public ArrayList<Food> getStorage();
}
