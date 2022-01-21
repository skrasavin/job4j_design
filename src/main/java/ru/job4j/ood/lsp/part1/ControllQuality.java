package ru.job4j.ood.lsp.part1;

import java.time.LocalDateTime;
import java.util.*;

public class ControllQuality {
    public List<Storage> objStorage;

    public ControllQuality(List objStorage) {
        this.objStorage = objStorage;
    }

    public void distribution() {

    }



    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        Calendar lastDelivery = new GregorianCalendar(2022, Calendar.JANUARY, ldt.getDayOfMonth() - 4);
        Food apple = new Milk("Willey Milk", lastDelivery,
                20, 120, 50);
        Food mango = new Milk("Willey Milk", lastDelivery,
                40, 100, 50);
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(apple);
        foods.add(mango);

    }

}
