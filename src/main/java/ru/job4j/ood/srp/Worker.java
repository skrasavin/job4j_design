package ru.job4j.ood.srp;

public class Worker {
    private static Worker instance;

    private Worker() {
    }

    public static Worker getInstance(String value) {
        if (instance == null) {
            instance = new Worker();
        }
        return instance;
    }
}
