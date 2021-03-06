package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class  MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        this.mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int ind = findIndexById(id);
        if (ind != -1) {
            this.mem.set(ind, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int ind = findIndexById(id);
        if (ind == -1) {
            return false;
        }
        this.mem.remove(ind);
        return true;
    }

    @Override
    public T findById(String id) {
        for (T item : mem) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public int findIndexById(String id) {
        for (int x = 0; x < mem.size(); x++) {
            if (mem.get(x).getId().equals(id)) {
                return x;
            }
        }
        return -1;
    }
}