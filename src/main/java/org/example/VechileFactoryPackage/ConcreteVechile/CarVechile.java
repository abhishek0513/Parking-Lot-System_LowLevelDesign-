package org.example.VechileFactoryPackage.ConcreteVechile;

import org.example.VechileFactoryPackage.Vechile;

public class CarVechile extends Vechile {
    public CarVechile(String licensePlate, String vechileType, ParkingFeeStrategy feeStrategy) {
        super(licensePlate, vechileType, feeStrategy);
    }
}
