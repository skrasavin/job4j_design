package ru.job4j.ood.lsp.part1;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

public interface Storage {
    void addToStorage(Food food);
    boolean accept(Food food);
    List<Food> getStorage();
    default Double percentageCalculation(Food food) {
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
