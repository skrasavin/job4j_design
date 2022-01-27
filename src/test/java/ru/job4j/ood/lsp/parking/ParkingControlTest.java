package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ParkingControlTest {

    public void whenOneSmallCarIsParked() {
        ParkingPlace parkingPlace = new ParkingPlace(50);
        List cars = new ArrayList<>();
        Car bmw = new PassengerCar("BMW", 1);
        cars.add(bmw);
        new ParkingControl(parkingPlace).distribution(cars);
        assertThat(parkingPlace.parkingPlace.size(), is(1));
    }

    public void whenTwoSmallCarAreParked() {
        ParkingPlace parkingPlace = new ParkingPlace(50);
        List cars = new ArrayList<>();
        Car bmw = new PassengerCar("BMW", 1);
        Car bmwX1 = new PassengerCar("BMWx1", 1);
        cars.add(bmw);
        cars.add(bmwX1);
        new ParkingControl(parkingPlace).distribution(cars);
        assertThat(parkingPlace.parkingPlace.size(), is(2));
    }

    public void whenOneTruckIsParked() {
        ParkingPlace parkingPlace = new ParkingPlace(50);
        List cars = new ArrayList<>();
        Car bmw = new PassengerCar("BMW", 3);
        Car volvo = new Truck("Volvo", 3);
        cars.add(bmw);
        cars.add(volvo);
        new ParkingControl(parkingPlace).distribution(cars);
        assertThat(parkingPlace.parkingPlace.size(), is(6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenParkingIsFull() {
        ParkingPlace parkingPlace = new ParkingPlace(15);
        List cars = new ArrayList<>();
        Car bmw = new PassengerCar("BMW", 1);
        Car volvo = new Truck("Volvo", 6);
        Car ram = new Truck("RAM", 6);
        Car toyota = new Truck("TOYOTA TRUCK", 6);
        cars.add(bmw);
        cars.add(volvo);
        new ParkingControl(parkingPlace).distribution(cars);
    }
}