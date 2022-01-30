package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ParkingControlTest {

    @Test
    public void whenOneSmallCarIsParked() {
        ParkingPlace parkingPlace = new ParkingPlace(50);
        List cars = new ArrayList<>();
        Car bmw = new PassengerCar("BMW");
        cars.add(bmw);
        new ParkingControl(parkingPlace).distribution(cars);
        assertThat(parkingPlace.getCount(), is(1));
    }

    @Test
    public void whenTwoSmallCarAreParked() {
        ParkingPlace parkingPlace = new ParkingPlace(50);
        List cars = new ArrayList<>();
        Car bmw = new PassengerCar("BMW");
        Car bmwX1 = new PassengerCar("BMWx1");
        cars.add(bmw);
        cars.add(bmwX1);
        new ParkingControl(parkingPlace).distribution(cars);
        assertThat(parkingPlace.getCount(), is(2));
    }

    @Test
    public void whenOneTruckIsParked() {
        ParkingPlace parkingPlace = new ParkingPlace(50);
        List cars = new ArrayList<>();
        Car bmw = new PassengerCar("BMW");
        Car volvo = new Truck("Volvo", 3);
        cars.add(bmw);
        cars.add(volvo);
        new ParkingControl(parkingPlace).distribution(cars);
        assertThat(parkingPlace.getCount(), is(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenParkingIsFull() {
        ParkingPlace parkingPlace = new ParkingPlace(6);
        List cars = new ArrayList<>();
        Car bmw = new PassengerCar("BMW");
        Car volvo = new Truck("Volvo", 6);
        Car ram = new Truck("RAM", 6);
        Car toyota = new Truck("TOYOTA TRUCK", 6);
        Car mercedes = new Truck("MERCEDES T1", 6);
        cars.add(bmw);
        cars.add(volvo);
        cars.add(ram);
        cars.add(toyota);
        cars.add(mercedes);
        new ParkingControl(parkingPlace).distribution(cars);
    }
}