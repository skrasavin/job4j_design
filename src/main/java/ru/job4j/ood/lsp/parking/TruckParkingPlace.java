package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;

public class TruckParkingPlace implements ParkingPlace {
    ArrayList<Car> parkingPlace = new ArrayList<>();
    private int quantity = 20;

    public int getQuantity() {
        return quantity;
    }

    public ArrayList<Car> getParkingPlace() {
        return parkingPlace;
    }

    public void setParkingPlace(ArrayList<Car> parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public boolean accept(Car car) {
        return car.getMass() < 1;
    }

    @Override
    public boolean addToParkingPlace(Car car) {
        boolean value = accept(car);
        if (value) {
            parkingPlace.add(car);
        }
        return value;
    }
}
