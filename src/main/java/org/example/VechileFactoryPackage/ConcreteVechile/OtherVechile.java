package org.example.VechileFactoryPackage.ConcreteVechile;

import org.example.VechileFactoryPackage.Vechile;

public class OtherVechile extends Vechile {
    public OtherVechile(String licensePlate, String vechileType, ParkingFeeStrategy feeStrategy) {
        super(licensePlate, vechileType, feeStrategy);
    }
}
