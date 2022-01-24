package ru.job4j.ood.lsp.part1;

import java.util.*;

public class ControllQuality {
    public List<Storage> objStorage;

    public ControllQuality(List<Storage> objStorage) {
        this.objStorage = objStorage;
    }

    public void distribution(Food food) {
        for (Storage storage : objStorage) {
            storage.addToStorage(food);
        }
    }
}
