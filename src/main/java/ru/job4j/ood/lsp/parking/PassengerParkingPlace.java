package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;

public class PassengerParkingPlace implements ParkingPlace {
    ArrayList<Car> parkingPlace = new ArrayList<>();
    private int quantity = 100;

    public ArrayList<Car> getParkingPlace() {
        return parkingPlace;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean accept(Car car) {
        return car.getMass() == 1;
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
