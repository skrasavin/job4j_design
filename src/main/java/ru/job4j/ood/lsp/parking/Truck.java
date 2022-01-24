package ru.job4j.ood.lsp.parking;

public class Truck implements Car {
    public String name;
    public double mass;

    public Truck(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public void takeParkingSpace() {
        System.out.println("Припарковаться на большом месте");
    }
}
