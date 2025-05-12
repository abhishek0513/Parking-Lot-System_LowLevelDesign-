package org.example;

import org.example.CommonEnum.DurationType;
import org.example.FareStrategyPackage.ConcreteStrategies.BasicHourlyRateStrategy;
import org.example.FareStrategyPackage.ConcreteStrategies.PremiumRateStrategy;
import org.example.FareStrategyPackage.ParkingFeeStrategy;
import org.example.ParkingController.ParkingLot;
import org.example.ParkingSpots.ConcreteParkingSpots.BikeParkingSpot;
import org.example.ParkingSpots.ConcreteParkingSpots.CarParkingSpot;
import org.example.ParkingSpots.ParkingSpot;
import org.example.PaymentStrategyPackage.ConcretePaymentStrategies.CashPayment;
import org.example.PaymentStrategyPackage.ConcretePaymentStrategies.CreditCardPayment;
import org.example.PaymentStrategyPackage.PaymentStrategy;
import org.example.VechileFactoryPackage.Vechile;
import org.example.VechileFactoryPackage.VechileFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Hello World!");
        List<ParkingSpot>parkingSpots = new ArrayList<>();
        parkingSpots.add(new CarParkingSpot(1, "Car"));
        parkingSpots.add(new CarParkingSpot(2, "Car"));
        parkingSpots.add(new BikeParkingSpot(3, "Bike"));
        parkingSpots.add(new BikeParkingSpot(4, "Bike"));
        ParkingLot parkingLot = new ParkingLot(parkingSpots);
        ParkingFeeStrategy basicHourlyRateStrategy = new BasicHourlyRateStrategy();
        ParkingFeeStrategy premiumRateStrategy = new PremiumRateStrategy();
        // Create vehicles using Factory Pattern with fee strategies
        Vechile car1 = VechileFactory.createVechile("Car", "CAR123", basicHourlyRateStrategy);
        Vechile car2 = VechileFactory.createVechile("Car", "CAR345", basicHourlyRateStrategy);

        Vechile bike1 = VechileFactory.createVechile("Bike", "BIKE456", premiumRateStrategy);
        Vechile bike2 = VechileFactory.createVechile("Bike", "BIKE123", premiumRateStrategy);


        ParkingSpot carSpot = parkingLot.parkVechile(car1);
        ParkingSpot bikeSpot = parkingLot.parkVechile(bike1);

        ParkingSpot carSpot2 = parkingLot.parkVechile(car2);
        ParkingSpot bikeSpot2 = parkingLot.parkVechile(bike2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select payment method for your vehicle:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        int paymentMethod = scanner.nextInt();

        if (carSpot != null) {
            // Calculate fee using the specific strategy for the vehicle
            double carFee = car1.calculateFee(2, DurationType.HOURS);
            PaymentStrategy carPaymentStrategy =
                    getPaymentStrategy(paymentMethod, carFee);
            carPaymentStrategy.processPayment(carFee);
            parkingLot.vacateSpot(carSpot, car1);
        }
        if (bikeSpot != null) {
            // Calculate fee using the specific strategy for the vehicle
            double bikeFee = bike1.calculateFee(3, DurationType.HOURS);
            PaymentStrategy bikePaymentStrategy =
                    getPaymentStrategy(paymentMethod, bikeFee);
            bikePaymentStrategy.processPayment(bikeFee);
            parkingLot.vacateSpot(bikeSpot, bike1);
        }
        scanner.close();
    }
    private static PaymentStrategy getPaymentStrategy(
            int paymentMethod, double fee) {
        switch (paymentMethod) {
            case 1:
                return new CreditCardPayment(fee);
            case 2:
                return new CashPayment(fee);
            default:
                System.out.println("Invalid choice! Default to Credit card payment.");
                return new CreditCardPayment(fee);
        }

    }
}
