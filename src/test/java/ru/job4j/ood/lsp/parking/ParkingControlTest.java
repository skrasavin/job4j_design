package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ParkingControlTest {

    @Test
    public void whenOneSmallCarIsParked() {
        ParkingPlace parkingPlace = new ParkingPlace(5, 5);
        List cars = new ArrayList<>();
        Car bmw = new PassengerCar("BMW");
        cars.add(bmw);
        new ParkingControl(parkingPlace).distribution(cars);
        assertThat(parkingPlace.getSmallParkingPlace().size(), is(1));
    }

    @Test
    public void whenTwoSmallCarAreParked() {
        ParkingPlace parkingPlace = new ParkingPlace(5, 5);
        List cars = new ArrayList<>();
        Car bmw = new PassengerCar("BMW");
        Car bmwX1 = new PassengerCar("BMWx1");
        cars.add(bmw);
        cars.add(bmwX1);
        new ParkingControl(parkingPlace).distribution(cars);
        assertThat(parkingPlace.getSmallParkingPlace().size(), is(2));
    }

    @Test
    public void whenOneTruckIsParked() {
        ParkingPlace parkingPlace = new ParkingPlace(5, 5);
        List cars = new ArrayList<>();
        Car volvo = new Truck("Volvo", 3);
        cars.add(volvo);
        new ParkingControl(parkingPlace).distribution(cars);
        System.out.println(parkingPlace.getSmallParkingPlace().size());
        assertThat(parkingPlace.getBigParkingPlace().size(), is(1));
    }

    @Test
    public void whenTwoTruckAreParked() {
        ParkingPlace parkingPlace = new ParkingPlace(10, 3);
        List cars = new ArrayList<>();
        Car bmw = new PassengerCar("BMW");
        Car volvo = new Truck("Volvo", 3);
        Car ram = new Truck("RAM", 3);
        Car toyota = new Truck("TOYOTA TRUCK", 3);
        Car mercedes = new Truck("MERCEDES T1", 2);
        cars.add(bmw);
        cars.add(volvo);
        cars.add(ram);
        cars.add(toyota);
        cars.add(mercedes);
        new ParkingControl(parkingPlace).distribution(cars);
        assertThat(parkingPlace.getSmallParkingPlace().size(), is(3));
    }

}