package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingPlace {
    List<Car> parkingPlace = new ArrayList<>();
    private int quantity;
    private int count;

    public ParkingPlace(int quantity) {
        this.quantity = quantity;
    }

    public List<Car> getParkingPlace() {
        return parkingPlace;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCount() {
        return count;
    }

    public boolean accept(Car car) {
        if (count > quantity) {
            throw new IllegalArgumentException("No parking spaces");
        }

        if (car.getMass() < 3) {
            count++;
            return true;
        } else if (car.getMass() >= 3 && car.getMass() <= 7) {
            count += 2;
            return true;
        } else {
            throw new IllegalArgumentException("More than 7 tons is not provided");
        }
    }

    public void addToParkingPlace(Car car) {
        parkingPlace.add(car);
    }
}
