package ru.job4j.ood.lsp.parking;

public class PassengerCar implements Car {
    public String name;
    public double mass;

    public PassengerCar(String name, double mass) {
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
        System.out.println("Припарковаться на маленьком месте");
    }
}
