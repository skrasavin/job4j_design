package ru.job4j.ood.lsp.parking;


import java.util.ArrayList;
import java.util.List;

public class ParkingControl {
    private ParkingPlace parkingPlace;

    public ParkingControl(ParkingPlace parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public void distribution(List<Car> cars) {
        for (var car : cars) {
            if (parkingPlace.accept(car)) {
                parkingPlace.addToParkingPlace(car);
            }
        }
    }

    public static void main(String[] args) {
        ParkingPlace parkingPlace = new ParkingPlace(50);
        Car bmw = new PassengerCar("BMW", 1);
        List<Car> cars = new ArrayList<>();
        cars.add(bmw);
        new ParkingControl(parkingPlace).distribution(cars);
    }
}
