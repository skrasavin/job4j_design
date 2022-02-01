package ru.job4j.ood.lsp.parking;

public class PassengerCar implements Car {
    public String name;
    public static final int MASS = 1;

    public PassengerCar(String name) {
        this.name = name;
    }

    @Override
    public int getMass() {
        return MASS;
    }
}
