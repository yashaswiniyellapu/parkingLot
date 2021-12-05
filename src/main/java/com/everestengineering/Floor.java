package com.everestengineering;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final int numOfSlots;
    private List<Slot> spaceList = new ArrayList<>();

    Floor(int numOfSlots) {
        this.numOfSlots = numOfSlots;
        createTruckSpace();
        createBikeSpace();
        createCarSpace();
    }

    public void createTruckSpace() {
        for (int i = 0; i < 1; i++) {
            spaceList.add(i,new Slot(SlotType.TRUCK, "unparked"));
        }
    }

    public void createBikeSpace() {
        for (int i = 1; i <= 2; i++) {
            spaceList.add(i,new Slot(SlotType.BIKE, "unparked"));
        }
    }

    public void createCarSpace() {
        for (int i = 3; i < numOfSlots; i++) {
            spaceList.add(i,new Slot(SlotType.CAR, "unparked"));
        }
    }
    public List<Slot> getSpaceList()
    {
        return spaceList;
    }
}
