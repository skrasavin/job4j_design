package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;

public class ParkingControl {
    public ArrayList<ParkingPlace> places;

    public ParkingControl(ArrayList<ParkingPlace> places) {
        this.places = places;
    }

    public void distribution(Car car) {
        for (var p : places) {
            p.addToParkingPlace(car);
        }
    }

    public static void main(String[] args) {
        ArrayList<ParkingPlace> parkingPlaces = new ArrayList<>();
        parkingPlaces.add(new PassengerParkingPlace());
        parkingPlaces.add(new TruckParkingPlace());
        Car bmw = new PassengerCar("BMW", 0.8);
        new ParkingControl(parkingPlaces).distribution(bmw);
    }
}
