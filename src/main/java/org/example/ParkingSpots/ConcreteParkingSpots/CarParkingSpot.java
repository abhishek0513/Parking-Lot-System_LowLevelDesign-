package org.example.ParkingSpots.ConcreteParkingSpots;

import org.example.ParkingSpots.ParkingSpot;
import org.example.VechileFactoryPackage.Vechile;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVechile(Vechile vehicle) {
        return "Car".equalsIgnoreCase(vehicle.getVechileType());
    }
}