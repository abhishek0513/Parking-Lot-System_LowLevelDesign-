package org.example.ParkingSpots.ConcreteParkingSpots;

import org.example.ParkingSpots.ParkingSpot;
import org.example.VechileFactoryPackage.Vechile;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVechile(Vechile vechile) {
        return "Bike".equalsIgnoreCase(vechile.getVechileType());
    }
}
