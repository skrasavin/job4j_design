package ru.job4j.ood.lsp.parking;

public class PassengerCar implements Car {
    public String name;
    public int mass = 1;

    public PassengerCar(String name) {
        this.name = name;
    }

    public int getMass() {
        return mass;
    }
}
