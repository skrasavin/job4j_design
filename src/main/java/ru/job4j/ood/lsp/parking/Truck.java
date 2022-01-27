package ru.job4j.ood.lsp.parking;

public class Truck implements Car {
    public String name;
    public int mass;

    public Truck(String name, int mass) {
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
