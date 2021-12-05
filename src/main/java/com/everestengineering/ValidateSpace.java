package com.everestengineering;

import java.util.List;

import static com.everestengineering.ParkingLot.floorSpace;

public class ValidateSpace {
    private SlotType slotType;
    private int[] position;
    private boolean isContains = false;
    private boolean checkFloor = false;

    ValidateSpace(SlotType slotType) {
        this.slotType = slotType;
        position = new int[2];
    }

    public boolean checkFloor() {
        for (int i = 0; i < floorSpace.size(); i++) {
            boolean checkSlot = checkSlot(floorSpace.get(i));
            checkFloor = checkSlot;
            if (checkSlot) {
                break;
            }
        }
        return checkFloor;
    }

    public boolean checkSlot(List<Slot> list) {
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).getSlotType().equals(slotType)) {
                if (list.get(j).getStatus().equals("unparked")) {
                    position[0] = floorSpace.indexOf(list);
                    position[1] = j;
                    isContains = true;
                    break;
                }
            }
        }
        return isContains;
    }

    public int[] getPosition() {
        return position;
    }
}
