package org.example.VechileFactoryPackage;

public class VechileFactory {
    public static Vechile createVechile(String vechileType, String licensePlate, ParkingStrategy feeStrategy)
    {
        if(vechileType.equalsIgnoreCase("Car")){
            return new carVechile(vechileType,licensePlate,feeStrategy);
        }
        else if(vechileType.equalsIgnoreCase("Bike")){
            return new bikeVechile(vechileType, licensePlate, feeStrategy);
        }
        return new otherVechile(vechileType,licensePlate,feeStrategy);
    }
}
