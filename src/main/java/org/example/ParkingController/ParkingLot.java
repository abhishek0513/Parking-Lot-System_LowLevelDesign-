package org.example.ParkingController;

import org.example.ParkingSpots.ParkingSpot;
import org.example.VechileFactoryPackage.Vechile;

import java.util.List;

public class ParkingLot {
    private List<ParkingSpot>parkingSpots;

    public ParkingLot(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpot findAvailableSpots(String vechileType) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isOccupied() && spot.getSpotType().equals(vechileType)) {
                return spot;
            }
        }
        return null;
    }

    public ParkingSpot parkVechile(Vechile vechile){
        ParkingSpot spot = findAvailableSpots(vechile.getVechileType());
        if(spot != null){
            spot.parkVechile(vechile);
            System.out.println("Vechile parked successfully in spot: " + spot.getSpotNumber());
            return spot;
        }
        System.out.println("No parking spot available for " + vechile.getVechileType() + " !");
        return null;
    }
    public void vacateSpot(ParkingSpot spot, Vechile vechile){
        if(spot != null && spot.isOccupied() && spot.getVechile().equals(vechile)){
            spot.vacate();
            System.out.println(vechile.getVechileType() + " vacted the spot " + spot.getSpotType());
        }else{
            System.out.println("Invalid operation");
        }
    }
    public ParkingSpot getSpotByNumber(int spotNumber){
        for(ParkingSpot spot : parkingSpots){
            if(spot.getSpotNumber() == spotNumber){
                return spot;
            }
        }
        return null;
    }
    public List<ParkingSpot>getParkingSpots(){
        return parkingSpots;
    }
}
