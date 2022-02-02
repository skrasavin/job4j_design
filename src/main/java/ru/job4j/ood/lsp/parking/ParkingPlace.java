package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.part1.Food;

import java.util.ArrayList;
import java.util.List;

public class ParkingPlace {
    private List<Car>  smallParkingPlace = new ArrayList<>();
    private List<Car> bigParkingPlace = new ArrayList<>();
    private int smallParkingCapacity;
    private int bigParkingCapacity;

    public ParkingPlace(int smallParkingCapacity, int bigParkingCapacity) {
        this.smallParkingCapacity = smallParkingCapacity;
        this.bigParkingCapacity = bigParkingCapacity;
    }

    public ArrayList<Car> getSmallParkingPlace() {
        return new ArrayList<>(smallParkingPlace);
    }
    public ArrayList<Car> getBigParkingPlace() {
        return new ArrayList<>(bigParkingPlace);
    }

    public int smallParkingCapacity() {
        return smallParkingCapacity;
    }
    public int bigParkingCapacity() {
        return bigParkingCapacity;
    }


    public boolean addToParkingPlace(Car car) {
        if (car.getMass() <= PassengerCar.MASS && smallParkingPlace.size() < smallParkingCapacity) {
            smallParkingPlace.add(car);
            return true;
        } else if (car.getMass() > PassengerCar.MASS && bigParkingPlace.size() < bigParkingCapacity) {
            bigParkingPlace.add(car);
            return true;
        } else if (car.getMass() > PassengerCar.MASS && bigParkingPlace.size() >= bigParkingCapacity) {
            if (smallParkingPlace.size() + car.getMass() >= smallParkingCapacity) {
                return false;
            }
            for (int a = 0; a < car.getMass(); a++) {
                smallParkingPlace.add(car);
            }
        }
        return true;
    }
}
