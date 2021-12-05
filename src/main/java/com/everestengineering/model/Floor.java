package com.everestengineering.model;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final int numOfSlots;
    private final List<Slot> spaceList = new ArrayList<>();

    public Floor(int numOfSlots) {
        this.numOfSlots = numOfSlots;
        truckSpace();
        bikeSpace();
        carSpace();
    }

    public void truckSpace() {
        for (int i = 0; i < 1; i++) {
            spaceList.add(i, new Slot(SlotType.TRUCK, "unparked"));
        }
    }

    public void bikeSpace() {
        for (int i = 1; i <= 2; i++) {
            spaceList.add(i, new Slot(SlotType.BIKE, "unparked"));
        }
    }

    public void carSpace() {
        for (int i = 3; i < numOfSlots; i++) {
            spaceList.add(i, new Slot(SlotType.CAR, "unparked"));
        }
    }

    public List<Slot> getSpaceList() {
        return spaceList;
    }
}
