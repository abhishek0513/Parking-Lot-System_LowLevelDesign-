package org.example.VechileFactoryPackage.ConcreteVechile;

import org.example.FareStrategyPackage.ParkingFeeStrategy;
import org.example.VechileFactoryPackage.Vechile;

public class BikeVechile extends Vechile {
    public BikeVechile(String licensePlate, String vechileType, ParkingFeeStrategy feeStrategy) {
        super(licensePlate, vechileType, feeStrategy);
    }
}
