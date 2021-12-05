package com.everestengineering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.everestengineering.ParkingLot.floorSpace;

public class DisplayFreeSpace implements Display {
    private String typeOfSpace;
    private SlotType slotType;
    private List<Integer> slotSpace;
    private Map<Integer, List> floorMap;

    DisplayFreeSpace(String typeOfSpace, SlotType slotType) {
        this.typeOfSpace = typeOfSpace;
        this.slotType = slotType;
    }

    @Override
    public Map<Integer, List> getSlots1() {
        floorMap = new HashMap<>();
        for (int i = 0; i < floorSpace.size(); i++) {
            List<Integer> slotsList = getSlots2(floorSpace.get(i));
            floorMap.put(i, slotsList);
        }

        return floorMap;
    }

    @Override
    public List<Integer> getSlots2(List<Slot> list) {
        slotSpace = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).getSlotType().equals(slotType)) {
                if (list.get(j).getStatus().equals("unparked")) {
                    slotSpace.add(j);
                }
            }
        }
        return slotSpace;
    }

    @Override
    public String getTypeOfSpace() {
        return typeOfSpace;
    }

    @Override
    public String getSlotType() {
        return slotType.toString();
    }

}
