package ru.job4j.ood.lsp.part1;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;

public class ControllQuality {
    public Storage objStorage;

    public ControllQuality(Storage objStorage) {
        this.objStorage = objStorage;
    }
    public ControllQuality() {

    }

    public ControllQuality distribution(Food food) {
        Double percent = percentageCalculation(food);
        ControllQuality stor;
        if (percent < 25) {
            stor = new ControllQuality(new Warehouse());
        } else if (percent >= 25 && percent < 75) {
            stor = new ControllQuality(new Shop());
        } else if (percent >= 75 && percent < 100) {
            Shop shop = new Shop();
            shop.makeDiscountAndAddToStorage(food);
            return new ControllQuality(shop);
        } else {
            stor = new ControllQuality(new Trash());
        }
        stor.objStorage.addToStorage(food);
        return stor;
    }

    public Double percentageCalculation(Food food) {
        Calendar nowDate = Calendar.getInstance();
        LocalDate start = Instant.ofEpochMilli(food.getCreateDate().getTimeInMillis())
                .atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end = Instant.ofEpochMilli(nowDate.getTimeInMillis())
                .atZone(ZoneId.systemDefault()).toLocalDate();
        Period prd = Period.between(start, end);
        Double percent = Double.parseDouble(
                String.valueOf(((prd.getDays() * 100) / food.getExpiryDate())));
        return percent;
    }
}
