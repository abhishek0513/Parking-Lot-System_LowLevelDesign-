package org.example.FareStrategyPackage;

import org.example.CommonEnum.DurationType;
public interface ParkingFeeStrategy {
    double calculateFee(String vechile , int duration, DurationType durationType);
}
