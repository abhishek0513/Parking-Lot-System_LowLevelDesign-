package org.example.VechileFactoryPackage;

import org.example.CommonEnum.DurationType;

public class Vechile {
    private String licensePlate;
    private String vechileType;
    private ParkingFeeStrategy feeStrategy;

    public Vechile(String licensePlate, String vechileType, ParkingFeeStrategy feeStrategy) {
        this.licensePlate = licensePlate;
        this.vechileType = vechileType;
        this.feeStrategy = feeStrategy;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVechileType() {
        return vechileType;
    }

    public double calculateFee(int duration, DurationType durationType){
        return feeStrategy.calculateFee(vechileType, duration, durationType);
    }
}
