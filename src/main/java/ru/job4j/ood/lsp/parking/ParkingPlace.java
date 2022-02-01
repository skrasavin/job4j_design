package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingPlace {
    List<Car>  smallParkingPlace = new ArrayList<>();
    List<Car> bigParkingPlace = new ArrayList<>();
    private int smallParkingCapacity;
    private int bigParkingCapacity;

    public ParkingPlace(int smallParkingCapacity, int bigParkingCapacity) {
        this.smallParkingCapacity = smallParkingCapacity;
        this.bigParkingCapacity = bigParkingCapacity;
    }

    public List<Car> getSmallParkingPlace() {
        return smallParkingPlace;
    }
    public List<Car> getBigParkingPlace() {
        return bigParkingPlace;
    }

    public int smallParkingCapacity() {
        return smallParkingCapacity;
    }
    public int bigParkingCapacity() {
        return bigParkingCapacity;
    }


    public void addToParkingPlace(Car car) {
        if (car.getMass() <= 1 && smallParkingPlace.size() < smallParkingCapacity) {
            smallParkingPlace.add(car);
        } else if (car.getMass() > 1 && bigParkingPlace.size() < bigParkingCapacity) {
            bigParkingPlace.add(car);
        } else if (car.getMass() > 1 && bigParkingPlace.size() >= bigParkingCapacity) {
            if (smallParkingPlace.size() + car.getMass() >= smallParkingCapacity) {
                throw new IllegalArgumentException();
            }
            for (int a = 0; a < car.getMass(); a++) {
                smallParkingPlace.add(car);
            }
        }
    }
}
