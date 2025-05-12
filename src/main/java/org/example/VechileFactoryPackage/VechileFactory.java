package org.example.VechileFactoryPackage;

import org.example.FareStrategyPackage.ParkingFeeStrategy;
import org.example.VechileFactoryPackage.ConcreteVechile.BikeVechile;
import org.example.VechileFactoryPackage.ConcreteVechile.CarVechile;
import org.example.VechileFactoryPackage.ConcreteVechile.OtherVechile;

public class VechileFactory {
    public static Vechile createVechile(String vechileType, String licensePlate, ParkingFeeStrategy feeStrategy)
    {
        if(vechileType.equalsIgnoreCase("Car")){
            return new CarVechile(vechileType,licensePlate,feeStrategy);
        }
        else if(vechileType.equalsIgnoreCase("Bike")){
            return new BikeVechile(vechileType, licensePlate, feeStrategy);
        }
        return new OtherVechile(vechileType,licensePlate,feeStrategy);
    }
}
