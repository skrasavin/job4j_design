package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        this.mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (Integer.parseInt(id) < mem.size()) {
            this.mem.set(Integer.parseInt(id), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (Integer.parseInt(id) < mem.size()) {
            this.mem.remove(Integer.parseInt(id));
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        if (Integer.parseInt(id) < mem.size()) {
            return this.mem.get(Integer.parseInt(id));
        }
        return null;
    }
}