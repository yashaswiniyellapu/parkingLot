package com.everestengineering.model;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final int numOfSlots;
    private final List<Slot> spaceList = new ArrayList<>();

    public Floor(int numOfSlots) {
        this.numOfSlots = numOfSlots;
        createFloor(numOfSlots);
    }

    public void createFloor(int numOfSlots) {
        for (int i = 0; i < numOfSlots; i++) {
            if (i == 0) {
                spaceList.add(i, new Slot(SlotType.TRUCK, "unparked"));
            } else if (i == 1 || i == 2) {
                spaceList.add(i, new Slot(SlotType.BIKE, "unparked"));
            } else {
                spaceList.add(i, new Slot(SlotType.CAR, "unparked"));
            }
        }
    }

    public List<Slot> getSpaceList() {
        return spaceList;
    }
}
