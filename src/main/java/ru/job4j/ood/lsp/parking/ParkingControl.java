package ru.job4j.ood.lsp.parking;

import java.util.List;

public class ParkingControl {
    private ParkingPlace parkingPlace;

    public ParkingControl(ParkingPlace parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public void distribution(List<Car> cars) {
        for (var car : cars) {
            parkingPlace.addToParkingPlace(car);
        }
    }
}
