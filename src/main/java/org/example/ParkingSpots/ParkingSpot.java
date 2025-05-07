package org.example.ParkingSpots;

import org.example.VechileFactoryPackage.Vechile;

public abstract class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private Vechile vechile;
    private String spotType;

    public ParkingSpot(int spotNumber, String spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isOccupied = false;
    }
    private boolean isOccupied(){
        return isOccupied;
    }

    public abstract boolean canParkVechile(Vechile vechile);
    public void parkVechile(){
        if(isOccupied){
            throw new IllegalArgumentException("Spot already occupied");
        }
        if(!canParkVechile(vechile)){
            throw new IllegalArgumentException("This spot is not suitable for "+ vechile.getVechileType());
        }
        this.vechile = vechile;
        this.isOccupied= true;
    }
    public void vacate(){
        if(!isOccupied){
            throw new IllegalArgumentException("Spot is already vacant");
        }

        this.vechile = null;
        this.isOccupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vechile getVechile() {
        return vechile;
    }

    public String getSpotType() {
        return spotType;
    }
}
