package ru.job4j.ood.lsp.part1;

import java.util.ArrayList;

public class Shop implements Storage {

    private ArrayList<Food> storage = new ArrayList<>();

    public ArrayList<Food> getStorage() {
        return new ArrayList<Food>(storage);
    }

    @Override
    public boolean accept(Food food) {
        double percent = percentageCalculation(food);
        if (percent >= 25 && percent < 75) {
            return true;
        } else if (percent >= 75 && percent < 100) {
            double discount = ((food.getPrice() * food.getDiscount()) / 100);
            double priceWithDiscount = food.getPrice() - discount;
            food.setPrice(priceWithDiscount);
            return true;
        } else {
            return false;
        }

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
