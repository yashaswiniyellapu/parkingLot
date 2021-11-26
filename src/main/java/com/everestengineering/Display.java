package com.everestengineering;

import com.everestengineering.design.ParkingLot;

public class Display {
    private final ParkingLot parkLot;
    private final String vehicleName;

    public Display(String vehicleName, ParkingLot parkLot) {
        this.vehicleName = vehicleName;
        this.parkLot = parkLot;
    }

    public void displayCount(String countType) {
        int freeCount, occupiedCount;
        for (int i = 0; i < parkLot.getNumOfFloors(); i++) {
            freeCount = 0;
            occupiedCount = 0;
            for (int j = 0; j < parkLot.getNumOfSlots(); j++) {
                if (vehicleName.equalsIgnoreCase(parkLot.getFloorList().get(i).get(j).getSlotType().toString())) {
                    if (parkLot.getFloorList().get(i).get(j).getStatus().equals("unparked")) {
                        freeCount = freeCount + 1;
                    } else {
                        occupiedCount = occupiedCount + 1;
                    }
                }
            }
            if (countType.equals("free_count")) {
                System.out.println("The no of free slots for " + vehicleName + "on Floor " + i + " is: " + freeCount);
            } else {
                System.out.println("The no of occupied slots for " + vehicleName + "on Floor " + i + " is: " + occupiedCount);
            }

        }
    }

    public void displaySlots(String slotsType) {
        StringBuilder freeSlots;
        StringBuilder occupiedSlots;
        for (int i = 0; i < parkLot.getNumOfFloors(); i++) {
            freeSlots = new StringBuilder(" ");
            occupiedSlots = new StringBuilder();
            for (int j = 0; j < parkLot.getNumOfSlots(); j++) {
                if (vehicleName.equalsIgnoreCase(parkLot.getFloorList().get(i).get(j).getSlotType().toString())) {
                    if (parkLot.getFloorList().get(i).get(j).getStatus().equals("unparked")) {
                        freeSlots.append(j);
                    } else {
                        occupiedSlots.append(j);
                    }
                }
            }
            if (slotsType.equals("free_slots")) {
                System.out.println("The free slot for " + vehicleName + " on Floor " + i + " is: " + freeSlots);
            } else {
                System.out.println("The occupied slot for " + vehicleName + "on Floor " + i + " is: " + occupiedSlots);
            }

        }
    }
}

