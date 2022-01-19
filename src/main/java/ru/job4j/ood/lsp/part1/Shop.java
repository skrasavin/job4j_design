package ru.job4j.ood.lsp.part1;

import java.util.ArrayList;

public class Shop implements Storage {

    private ArrayList<Food> storage = new ArrayList<>();

    public ArrayList<Food> getStorage() {
        return storage;
    }

    @Override
    public void addToStorage(Food food) {
        storage.add(food);
    }

    public void makeDiscountAndAddToStorage(Food food) {
        Double discount = ((food.getPrice() * food.getDiscount()) / 100);
        double priceWithDiscount = food.getPrice() - discount;
        food.setPrice(priceWithDiscount);
        storage.add(food);
    }
}
