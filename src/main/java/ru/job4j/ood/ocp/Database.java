package ru.job4j.ood.ocp;

import ru.job4j.list.List;

public class Database<T> {
    public void addToBase(List<T> list) {
        for (var l : list) {
            System.out.println("Добавление в базу запросов из списка");
        }
    }
}
