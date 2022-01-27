package ru.job4j.ood.lsp.parking;

public class PassengerCar implements Car {
    public String name;
    public int mass;

    public PassengerCar(String name, int mass) {
        this.name = name;
        this.mass = mass;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}
