package org.example.FareStrategyPackage.ConcreteStrategies;

import org.example.CommonEnum.DurationType;
import org.example.FareStrategyPackage.ParkingFeeStrategy;

public class BasicHourlyRateStrategy implements ParkingFeeStrategy {
    @Override
    public double calculateFee(String vechile, int duration, DurationType durationType) {
        switch (vechile.toLowerCase()){
            case "car":
                return  durationType == DurationType.HOURS
                        ? duration *10.0 : duration * 10.0 * 24;
            case "bike":
                return durationType == DurationType.HOURS
                        ? duration * 5.0    // $5 per hour for bikes
                        : duration * 5.0 * 24;  // Daily rate
            default:
                return durationType == DurationType.HOURS
                        ? duration * 15.0   // $15 per hour for other vehicles
                        : duration * 15.0 * 24;  // Daily rate
        }
    }
}
