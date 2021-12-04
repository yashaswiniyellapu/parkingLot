package com.everestengineering;

public class ParkingLot {
    private String parklotId;
    private int numOfFloors;
    private int numOfSlots;

    public ParkingLot(String parklotId, int numOfFloors, int numOfSlots) {
        this.parklotId = parklotId;
        this.numOfFloors = numOfFloors;
        this.numOfSlots = numOfSlots;
    }

    public void build() {
        for (int i = 0; i < numOfFloors; i++) {
            new Floor(numOfSlots);
        }
    }
}
